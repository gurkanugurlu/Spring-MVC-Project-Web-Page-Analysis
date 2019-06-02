package com.ugurlu.gurkan.service;

import com.sun.istack.Nullable;
import com.ugurlu.gurkan.analysis.Admin;
import com.ugurlu.gurkan.analysis.BrowserDetails;
import com.ugurlu.gurkan.analysis.WebPage;
import com.ugurlu.gurkan.analysis.WebUser;
import com.ugurlu.gurkan.analysis.mydiffmodels.BrowserNames;
import com.ugurlu.gurkan.analysis.mydiffmodels.Counts;
import com.ugurlu.gurkan.analysis.mydiffmodels.OsNames;
import com.ugurlu.gurkan.analysis.mydiffmodels.PageSessionTimes;
import com.ugurlu.gurkan.dao.MainDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
public class MainService {
    @Autowired
    private MainDAO mainDAO;
    private Logger logger = LoggerFactory.getLogger(MainService.class);

    @Transactional
    public Boolean saveOrUpdateWebUser(WebUser webUser) {
        mainDAO.saveOrUpdateObject(webUser.getAnalysis_session());
        mainDAO.saveOrUpdateObject(webUser.getOs_details());
        mainDAO.saveOrUpdateObject(webUser.getBrowser_details());
        logger.info("Bilgi" + webUser.toString());
        return mainDAO.saveOrUpdateObject(webUser);
    }

    @Transactional
    public Boolean saveOrUpdateWebPage(WebPage webPage) {
        Long id = webPage.getId();
        WebPage myWebPage = (WebPage) mainDAO.loadObject(WebPage.class, id);
        myWebPage.setTotalCount(webPage.getTotalCount());
        return mainDAO.saveOrUpdateObject(myWebPage);
    }

    @Transactional
    public Boolean loadAdmin(HttpServletRequest request, String email, String password) {
        List<Admin> admins = mainDAO.loadAdmin();
        for (Admin admin1 : admins) {
            if (email.equals(admin1.getMail())) {
                if (password.equals(admin1.getPassword())) {
                    request.getSession().setAttribute("admin", admin1);
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @Transactional
    public Boolean  loadUsers(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<WebUser> webUsers = mainDAO.loadUsers();
        session.setAttribute("users", webUsers);
        return true;
    }

    @Transactional
    public void loadOsCount(Model model) {
        Map<String, Integer> keyValues = mainDAO.loadOsName();
        List<OsNames> osNamesList = new ArrayList<>();
        String biggestOsName = "";
        double biggestOsCount = 0d;
        double totalCount = 0d;
        for (String key : keyValues.keySet()) {
            if (keyValues.get(key) > biggestOsCount) {
                biggestOsCount = keyValues.get(key);
                biggestOsName = key;
            }
            osNamesList.add(new OsNames(key, keyValues.get(key)));

            totalCount += keyValues.get(key);
        }
        Double oran = ((double) biggestOsCount / totalCount) * 100;
        Double oran2 = 100 - oran;
        String oranSonuc = String.format("%.2f", oran);
        String oran2Sonuc = String.format("%.2f", oran2);
        String sonuc = "Most using Operating System is " + biggestOsName + " which is using by %" + oranSonuc + " percent";
        String sonuc2 = "Only %" + oran2Sonuc + " percent of web user using other Operating System";
        if (model != null) {
            model.addAttribute("mOs", sonuc);
            model.addAttribute("lOs", sonuc2);
            model.addAttribute("osCount", osNamesList.size());
        }
    }

    @Transactional
    public void loadUsersCount(Model model) {
        List<WebUser> webUsers = mainDAO.loadUsers();
        if (model != null) {
            model.addAttribute("usersCount", webUsers.size());
        }
    }

    @Transactional
    public boolean totalCounts(Model model) {
        List<WebUser> webUsers = mainDAO.loadUsers();
        Integer indexCount = 0;
        Integer aboutCount = 0;
        Integer singleCount = 0;
        Integer contactCount = 0;
        Double totalIndexTime = 0d;
        Double totalSingleTime = 0d;
        Double totalAboutTime = 0d;
        Double totalContactTime = 0d;
        for (WebUser user : webUsers) {
            indexCount += user.getIndexCount();
            aboutCount += user.getAboutCount();
            singleCount += user.getSingleCount();
            contactCount += user.getContactCount();
            if (user.getTotalIndexTime() != null) {
                totalIndexTime += user.getTotalIndexTime();
            }
            if (user.getTotalAboutTıme() != null) {
                totalAboutTime += user.getTotalAboutTıme();
            }
            if (user.getTotalContactTime() != null) {
                totalContactTime += user.getTotalContactTime();
            }
            if (user.getTotalSingleTime() != null) {
                totalSingleTime += user.getTotalSingleTime();
            }

        }
        List<Double> myList = new ArrayList<>();
        List<PageSessionTimes> pageSessionTimes = new ArrayList<>();
        myList.add(totalContactTime);
        myList.add(totalAboutTime);
        myList.add(totalSingleTime);
        myList.add(totalIndexTime);
        pageSessionTimes.add(new PageSessionTimes("indeks", totalIndexTime));
        pageSessionTimes.add(new PageSessionTimes("about", totalAboutTime));
        pageSessionTimes.add(new PageSessionTimes("single", totalSingleTime));
        pageSessionTimes.add(new PageSessionTimes("contact", totalContactTime));
        if (model != null) {
            model.addAttribute("pageSessionTimes", pageSessionTimes);
            Counts counts = new Counts(indexCount, aboutCount, singleCount, contactCount);
            model.addAttribute("counts", counts);
        }
        return true;
    }

    @Transactional
    public Map<String, Integer> totalBrowserCount(Model model) {
        List<BrowserDetails> browserDetails = mainDAO.loadBrowsers();
        Map<String, Integer> keyValues = new HashMap<>();
        String biggestBrowserName = "";
        double biggestBrowserCount = 0d;
        double totalCount = 0d;
        for (BrowserDetails b : browserDetails) {
            if (keyValues.containsKey(b.getBrowserName())) {
                Integer oldValue = keyValues.get(b.getBrowserName());
                Integer newValue = oldValue + 1;
                keyValues.replace(b.getBrowserName(), newValue);

            } else {
                keyValues.put(b.getBrowserName(), 1);
            }

        }
        for (String key : keyValues.keySet()) {
            if (keyValues.get(key) > biggestBrowserCount) {
                biggestBrowserCount = keyValues.get(key);
                biggestBrowserName = key;
            }
            totalCount += keyValues.get(key);
        }
        Double oran = ((double) biggestBrowserCount / totalCount) * 100;
        Double oran2 = 100 - oran;
        String oran2Sonuc = String.format("%.2f", oran2);
        String oranSonuc = String.format("%.2f", oran);
        String sonuc = "Most using Browser is " + biggestBrowserName + " which is using by %" + oranSonuc + " percent";
        String sonuc2 = "Only %" + oran2Sonuc + " percent of web user using other browser";
        if (model != null) {
            model.addAttribute("browserCount", keyValues.size());
            model.addAttribute("lBrw", sonuc2);
            model.addAttribute("mBrw", sonuc);
        }
        return keyValues;
    }

    @Transactional
    public Boolean loadOsName(Model model) {
        Map<String, Integer> keyValues = mainDAO.loadOsName();
        List<OsNames> osNamesList = new ArrayList<>();
        for (String key : keyValues.keySet()) {
            osNamesList.add(new OsNames(key, keyValues.get(key)));

        }
        if (model != null) {
            model.addAttribute("osNames", osNamesList);
        }
        return true;
    }

    @Transactional
    public Boolean loadBrowserName(Model model) {
        Map<String, Integer> keyValues = totalBrowserCount(model);
        List<BrowserNames> browserNameList = new ArrayList<>();
        for (String key : keyValues.keySet()) {
            browserNameList.add(new BrowserNames(key, keyValues.get(key)));

        }
        if (model != null) {
            model.addAttribute("browserNames", browserNameList);
        }
        return true;

    }

    @Transactional
    public void loadUser(Model model, Long id) {
        WebUser webUser = (WebUser) mainDAO.loadObject(WebUser.class, id);
        if (model != null) {
            model.addAttribute("webUser", webUser);
        }
    }

    @Transactional
    public List<WebPage> loadWebPages(@Nullable Model model) {
        List<WebPage> webPages = mainDAO.loadWebPages();
        if (model != null) {
            model.addAttribute("webpages", webPages);
        }
        return webPages;
    }

    @Transactional
    public boolean findBiggestSessionTime(Model model) {
        List<WebUser> webUsers = mainDAO.loadUsers();
        double enBuyuk = 0;
        for (WebUser webUser : webUsers) {
            if ((webUser.getTotalSingleTime() != null) || (webUser.getTotalContactTime() != null) || (webUser.getTotalAboutTıme() != null) || (webUser.getTotalIndexTime() != null)) {
                Double temp = webUser.getTotalSingleTime() + webUser.getTotalContactTime() + webUser.getTotalAboutTıme() + webUser.getTotalIndexTime();
                if (temp > enBuyuk) {
                    enBuyuk = temp;
                }
            }

        }
        String cikti = "The Biggest session time is " + enBuyuk + " seconds.";
        if (model != null) {
            model.addAttribute("bSes", cikti);
        }
        return true;
    }

    @Transactional
    public boolean findAverageSessionTime(@Nullable Model model) {
        List<WebUser> webUsers = mainDAO.loadUsers();
        double total = 0;
        double totalUserCount = webUsers.size();
        double average = 0;
        for (WebUser webUser : webUsers) {
            if ((webUser.getTotalSingleTime() != null) || (webUser.getTotalContactTime() != null) || (webUser.getTotalAboutTıme() != null) || (webUser.getTotalIndexTime() != null)) {
                total += webUser.getTotalSingleTime() + webUser.getTotalContactTime() + webUser.getTotalAboutTıme() + webUser.getTotalIndexTime();

            }

        }
        average = total / totalUserCount;
        String cikti = "The Average session time is " + average + " seconds. ";
        String cikti2 = "The Total session time is " + total + " seconds. ";
        if (model != null) {
            model.addAttribute("aSes", cikti);
            model.addAttribute("tSes", cikti2);
        }
        return true;
    }

    @Transactional
    public boolean findLastThirtyDayUsers(Model model) {
        List<WebUser> webUsers = mainDAO.loadUsers();
        LocalDateTime dateTime = LocalDateTime.now();
        Integer count = 0;
        for (WebUser webUser : webUsers) {
            LocalDateTime userTime = webUser.getAnalysis_session().getLastAccessedTime();
            Duration duration = Duration.between(dateTime, userTime);
            Long daysCount = duration.toDays();
            if (daysCount <= 30) {
                count++;
            }
        }

        String cikti = "Last 30 days " + count + " users connected. ";
        if (model != null) {
            model.addAttribute("lastthirty", cikti);
        }
        return true;
    }

}
