package com.ugurlu.gurkan;

import com.ugurlu.gurkan.analysis.Runner;
import com.ugurlu.gurkan.service.MainService;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @Autowired
    private MainService mainService;
    @Autowired
    @Qualifier("threads")
    private List<Runner> threads;

    private static Logger logger= LoggerFactory.getLogger(HomeController.class);

    private void threadIndex(HttpServletRequest request) {

        String sessionId = request.getSession().getId();
        for (Runner thread : threads) {
            if (sessionId.equals(thread.getSessionId())) {
                Integer count = thread.getApplication().getWebUser().getIndexCount() + 1;
                logger.info("Total index Count is: "+ count);
                thread.getApplication().getWebUser().setIndexCount(count);
                if(thread.getApplication().getWebUser().getFirstIndexDateTime()==null){
                    thread.getApplication().getWebUser().setFirstIndexDateTime(LocalDateTime.now());
                    logger.info("FirstIndexTime : " + LocalDateTime.now().toString());
                }
                if (thread.getApplication().getWebUser().getSetIndexTime() == null) {
                    thread.getApplication().getWebUser().setSetIndexTime(LocalDateTime.now());
                    logger.info("New setIndex Time is: "+ LocalDateTime.now().toString());
                }
                break;
            }
        }
    }

    private void threadAbout(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        for (Runner thread : threads) {
            if (sessionId.equals(thread.getSessionId())) {
                Integer count = thread.getApplication().getWebUser().getAboutCount() + 1;
                logger.info("Total About Count is: "+ count);
                thread.getApplication().getWebUser().setAboutCount(count);
                if(thread.getApplication().getWebUser().getFirstAboutDateTime()==null){
                    thread.getApplication().getWebUser().setFirstAboutDateTime(LocalDateTime.now());
                    logger.info("First About Time is : " + LocalDateTime.now().toString());
                }
                if (thread.getApplication().getWebUser().getSetAboutTime() == null) {
                    thread.getApplication().getWebUser().setSetAboutTime(LocalDateTime.now());
                    logger.info("Set About Time is : " + LocalDateTime.now().toString());
                }
                break;
            }
        }
    }

    private void threadContact(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        for (Runner thread : threads) {
            if (sessionId.equals(thread.getSessionId())) {
                Integer count = thread.getApplication().getWebUser().getContactCount() + 1;
                logger.info("Total Contact Count is: "+ count);
                thread.getApplication().getWebUser().setContactCount(count);
                if(thread.getApplication().getWebUser().getFirstContactDateTime()==null){
                    thread.getApplication().getWebUser().setFirstContactDateTime(LocalDateTime.now());
                    logger.info("First Contact Time is : " + LocalDateTime.now().toString());
                }
                if (thread.getApplication().getWebUser().getSetContactTime() == null) {
                    thread.getApplication().getWebUser().setSetContactTime(LocalDateTime.now());
                    logger.info("Set Contact Time is : " + LocalDateTime.now().toString());
                }
                break;
            }
        }

    }

    private void threadSingle(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        for (Runner thread : threads) {
            if (sessionId.equals(thread.getSessionId())) {
                Integer count = thread.getApplication().getWebUser().getSingleCount() + 1;
                logger.info("Total Single Count is: "+ count);
                thread.getApplication().getWebUser().setSingleCount(count);
                if(thread.getApplication().getWebUser().getFirstSingleDateTime()==null){
                    thread.getApplication().getWebUser().setFirstSingleDateTime(LocalDateTime.now());
                    logger.info("First Single Time is : " + LocalDateTime.now().toString());
                }
                if (thread.getApplication().getWebUser().getSetSingleTime() == null) {
                    thread.getApplication().getWebUser().setSetSingleTime(LocalDateTime.now());
                    logger.info("Set Single Time is : " + LocalDateTime.now().toString());

                }
                break;
            }
        }
        }




    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        for (Runner r : threads) {
            if (r.isUsing() == false) {
                HttpSession session = request.getSession();
                UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
                logger.info("UserAgent informations: "+ userAgent.toString());
                threadsOn(session, request, userAgent, r);
                logger.info("Thread is starting.");
                r.getApplication().getWebUser().setFirstIndexDateTime(LocalDateTime.now());
                logger.info("First Index Time is: "+ LocalDateTime.now().toString());
                r.getApplication().getWebUser().setSetIndexTime(LocalDateTime.now());
                logger.info("Set Index Time is : "+ LocalDateTime.now().toString() );
                Integer count = r.getApplication().getWebUser().getIndexCount() + 1;
                logger.info("Total index Count is: "+ count);
                r.getApplication().getWebUser().setIndexCount(count);
                break;
            } else {
                threadIndex(request);
                break;
            }

        }
        logger.info("Requested page is /home/index");

        return "index";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(HttpServletRequest request, HttpServletResponse response, Model model) {
        for (Runner r : threads) {
            if (r.isUsing() == false) {
                HttpSession session = request.getSession();
                UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
                logger.info("UserAgent informations: "+ userAgent.toString());
                threadsOn(session, request, userAgent, r);
                logger.info("Thread is starting.");
                r.getApplication().getWebUser().setFirstAboutDateTime(LocalDateTime.now());
                logger.info("First About Time is: "+ LocalDateTime.now().toString());
                r.getApplication().getWebUser().setSetAboutTime(LocalDateTime.now());
                logger.info("Set About Time is: "+ LocalDateTime.now().toString());
                Integer count = r.getApplication().getWebUser().getAboutCount() + 1;
                logger.info("Total About Count is: "+ count);
                r.getApplication().getWebUser().setAboutCount(count);

                break;
            } else {
                threadAbout(request);
                break;
            }

        }
        logger.info("Requested page is /home/about");
        return "about";

    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(HttpServletRequest request, HttpServletResponse response, Model model)    {
        for (Runner r : threads) {
            if (r.isUsing() == false) {
                HttpSession session = request.getSession();
                UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
                logger.info("UserAgent informations: " + userAgent.toString());
                threadsOn(session, request, userAgent, r);
                logger.info("Thread is starting.");
                r.getApplication().getWebUser().setFirstContactDateTime(LocalDateTime.now());
                logger.info("Set First Contact Time is: " + LocalDateTime.now().toString());
                r.getApplication().getWebUser().setSetContactTime(LocalDateTime.now());
                logger.info("Set Contact Time is: " + LocalDateTime.now().toString());
                Integer count = r.getApplication().getWebUser().getContactCount() + 1;
                logger.info("Total Contact Count is: " + count);
                r.getApplication().getWebUser().setContactCount(count);
                break;
            } else {
                threadContact(request);
                break;
            }

        }
        //application.fillWebPage(request);
        logger.info("Requested page is /home/contact");
        return "contact";
    }

    @RequestMapping(value = "/single", method = RequestMethod.GET)
    public String single(HttpServletRequest request, HttpServletResponse response, Model model) {
        for (Runner r : threads) {
            if (r.isUsing() == false) {
                HttpSession session = request.getSession();
                UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
                logger.info("UserAgent informations: "+ userAgent.toString());
                threadsOn(session, request, userAgent, r);
                logger.info("Thread is starting.");
                r.getApplication().getWebUser().setFirstSingleDateTime(LocalDateTime.now());
                logger.info("Set First Single Time is: "+ LocalDateTime.now().toString());
                r.getApplication().getWebUser().setSetSingleTime(LocalDateTime.now());
                logger.info("Set  Single Time is: "+ LocalDateTime.now().toString());
                Integer count = r.getApplication().getWebUser().getSingleCount() + 1;
                r.getApplication().getWebUser().setSingleCount(count);
                logger.info("Total Single Count is: "+ count);
                break;
            } else {
                threadSingle(request);
                break;
            }

        }
        logger.info("Requested page is /home/single");
        return "single";

    }

    private void threadsOn(HttpSession session, HttpServletRequest request, UserAgent userAgent, Runner r) {
        r.getApplication().doTheJob(request, session, userAgent);
        logger.info("Application loaded.");
        r.setSessionId(session.getId());
        r.setUsing(true);
        r.start();
        logger.info("Thread has started.");
        logger.info(r.getApplication().toString());
    }

    @PostMapping(value = "/singleTime")
    public @ResponseBody
    void singleTime(@ModelAttribute(value = "date") String date, HttpServletRequest request) {
        for (Runner thread : threads) {
            if (thread.isUsing()==true && thread.getSessionId().equals(request.getSession().getId()))  {
                logger.info("Async Single Time sessionId is: "+ request.getSession().getId());
                try {
                    Double v = timeCalculator(4, date, thread);
                    logger.info("The differences between old and now : "+ v.toString());
                    Double value = (double) thread.getApplication().getWebUser().getTotalSingleTime() + v;
                    logger.info("New total single time is "+ value.toString());
                    thread.getApplication().getWebUser().setTotalSingleTime(value);
                    thread.getApplication().getWebUser().setSetSingleTime(null);
                }
                catch (Exception e){
                    logger.error("Error : "+ e.getMessage());
                }
                break;

            }
        }
    }

    @PostMapping(value = "/indexTime")
    public @ResponseBody
    void indexTime(@ModelAttribute(value = "date2") String date, HttpServletRequest request) {
        for (Runner thread : threads) {
            if (thread.isUsing()==true && thread.getSessionId().equals(request.getSession().getId())) {
                try {
                    logger.info("Async Index Time sessionId is: "+ request.getSession().getId());
                    Double  v = timeCalculator(1, date, thread);
                    logger.info("The differences between old and now : "+ v.toString());
                    Double value = (double) thread.getApplication().getWebUser().getTotalIndexTime() + v;
                    logger.info("New total index time is "+ value.toString());
                    thread.getApplication().getWebUser().setTotalIndexTime(value);
                    thread.getApplication().getWebUser().setSetIndexTime(null);
                }
                catch (Exception e){
                    logger.error("Error : "+ e.getMessage());
                }

                break;
            }
        }
    }

    @PostMapping(value = "/aboutTime")
    public @ResponseBody
    void aboutTime(@ModelAttribute(value = "date3") String date, HttpServletRequest request) {
        for (Runner thread : threads) {
            if ( thread.isUsing()==true && thread.getSessionId().equals(request.getSession().getId())) {
                try {
                    logger.info("Async About Time sessionId is: "+ request.getSession().getId());
                    Double v = timeCalculator(3, date, thread);
                    logger.info("The differences between old and now : "+ v.toString());
                    Double value = (double) thread.getApplication().getWebUser().getTotalAboutTıme() + v;
                    logger.info("New about about time is "+ value.toString());
                    thread.getApplication().getWebUser().setTotalAboutTıme(value);
                    thread.getApplication().getWebUser().setSetAboutTime(null);
                }
                catch (Exception e){
                    logger.error("Error : "+ e.getMessage());
                }

                break;

            }
        }
    }

    @PostMapping(value = "/contactTime")
    public @ResponseBody
    void contactTime(@ModelAttribute(value = "date4") String date, HttpServletRequest request) {
        for (Runner thread : threads) {
           if(thread.isUsing()==true && thread.getSessionId().equals(request.getSession().getId()))
           {
                  try {
                      Double  v = timeCalculator(2, date, thread);
                      logger.info("The differences between old and now : "+ v.toString());
                      Double value = (double) thread.getApplication().getWebUser().getTotalContactTime() + v;
                      logger.info("New total contact time is "+ value.toString());
                      thread.getApplication().getWebUser().setTotalContactTime(value);
                      thread.getApplication().getWebUser().setSetContactTime(null);
                  }
                  catch (Exception e){
                      logger.error("Error : "+ e.getMessage());
                  }

                break;

            }
        }
    }

        private Double  timeCalculator(int flag,String date,Runner thread ){
        Long test_timestamp = Long.parseLong(date);
        logger.info("TimeStamps is : "+ test_timestamp);
        LocalDateTime to = LocalDateTime.ofInstant(Instant.ofEpochMilli(test_timestamp), TimeZone.getDefault().toZoneId());
        logger.info("LocalDate time is "+ to.toString());
        Duration duration;
        Double v;
        String nanoSeconds;
        LocalDateTime from;
        switch (flag){
            case 4:
                from = thread.getApplication().getWebUser().getSetSingleTime();
                duration = Duration.between(from, to);
                logger.info("Durationg Single Time is "+ duration.toString());
                 nanoSeconds = "0." + duration.getNano();
                 v = (double) duration.getSeconds() + Double.parseDouble(nanoSeconds);

                return v;
            case 3:
                from = thread.getApplication().getWebUser().getSetAboutTime();
                duration = Duration.between(from, to);
                logger.info("Durationg About Time is "+ duration.toString());
                nanoSeconds = "0." + duration.getNano();
                v = (double) duration.getSeconds() + Double.parseDouble(nanoSeconds);
                return v;
            case 2:
                from = thread.getApplication().getWebUser().getSetContactTime();
                duration = Duration.between(from, to);
                logger.info("Durationg Contact Time is "+ duration.toString());
                nanoSeconds = "0." + duration.getNano();
                v = (double) duration.getSeconds() + Double.parseDouble(nanoSeconds);
                return v;
            case 1:
                from = thread.getApplication().getWebUser().getSetIndexTime();
                if(from!=null) {
                    duration = Duration.between(from, to);
                    logger.info("Durationg Index Time is "+ duration.toString());
                    nanoSeconds = "0." + duration.getNano();
                    v = (double) duration.getSeconds() + Double.parseDouble(nanoSeconds);
                    return v;
                }




        }
        return 1d;
        }
    }


