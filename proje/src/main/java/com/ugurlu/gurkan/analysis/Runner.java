package com.ugurlu.gurkan.analysis;

import com.ugurlu.gurkan.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class Runner extends Thread {
    @Autowired
    @Qualifier("app")
    private Application application;
    private volatile boolean sessionisNew = true;
    private boolean isUsing = false;
    private String sessionId;
    @Autowired
    private MainService mainService;

    private static Logger logger = LoggerFactory.getLogger(Runner.class);

    @Override
    public void run() {

        while (sessionisNew) {
            LocalDateTime from = application.getWebUser().getAnalysis_session().getCreationTime();
            Integer interval = application.getWebUser().getAnalysis_session().getSessionTimeout();
            LocalDateTime to = LocalDateTime.now();
            Duration duration = Duration.between(from, to);
            long durationSeconds = duration.getSeconds();
            if (durationSeconds >= interval || application.getWebUser().getAnalysis_session().getNew() == false) {
                shutdown();
            }
        }
        logger.info("Last Accessed Time is " + LocalDateTime.now().toString());
        application.getWebUser().getAnalysis_session().setLastAccessedTime(LocalDateTime.now());
        if (application.getWebUser().getFirstSingleDateTime() != null) {
            application.getWebUser().setSetSingleTime(application.getWebUser().getFirstSingleDateTime());
        }
        if (application.getWebUser().getFirstContactDateTime() != null) {
            application.getWebUser().setSetContactTime(application.getWebUser().getFirstContactDateTime());
        }
        if (application.getWebUser().getFirstAboutDateTime() != null) {
            application.getWebUser().setSetAboutTime(application.getWebUser().getFirstAboutDateTime());
        }
        if (application.getWebUser().getFirstIndexDateTime() != null) {
            application.getWebUser().setSetIndexTime(application.getWebUser().getFirstIndexDateTime());
        }
        Double sonuc = application.getWebUser().getTotalAboutTıme() + application.getWebUser().getTotalIndexTime() + application.getWebUser().getTotalContactTime() + application.getWebUser().getTotalSingleTime();
        logger.info("Total user time is " + sonuc.toString());
        List<WebPage> webPages = mainService.loadWebPages(null);
        for (WebPage webPage : webPages) {
            switch (webPage.getPageServletPath()) {
                case "/home/index":
                    Long oldCount = webPage.getTotalCount();
                    Double temp = application.getWebUser().getTotalIndexTime() + oldCount;
                    webPage.setTotalCount(temp.longValue());
                    mainService.saveOrUpdateWebPage(webPage);
                    break;
                case "/home/contact":
                    Long oldCount2 = webPage.getTotalCount();
                    Double temp2 = application.getWebUser().getTotalContactTime() + oldCount2;
                    webPage.setTotalCount(temp2.longValue());
                    mainService.saveOrUpdateWebPage(webPage);
                    break;
                case "/home/about":
                    Long oldCount3 = webPage.getTotalCount();
                    Double temp3 = application.getWebUser().getTotalAboutTıme() + oldCount3;
                    webPage.setTotalCount(temp3.longValue());
                    mainService.saveOrUpdateWebPage(webPage);
                    break;
                case "/home/single":
                    Long oldCount4 = webPage.getTotalCount();
                    Double temp4 = application.getWebUser().getTotalSingleTime() + oldCount4;
                    webPage.setTotalCount(temp4.longValue());
                    mainService.saveOrUpdateWebPage(webPage);
                    break;

            }
        }
        try {
            mainService.saveOrUpdateWebUser(application.getWebUser());
            logger.info("Session is over. User is saved at : " + LocalDateTime.now().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.run();

    }

    public boolean isSessionisNew() {
        return sessionisNew;
    }

    public MainService getMainService() {
        return mainService;
    }

    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }

    public void setSessionisNew(boolean sessionisNew) {
        this.sessionisNew = sessionisNew;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public boolean isUsing() {
        return isUsing;
    }

    public void setUsing(boolean using) {
        isUsing = using;
    }

    public void fillWebPageRequest(HttpServletRequest request) {
        application.fillWebPage(request);
    }

    public Application getApplication() {
        return application;
    }

    public void shutdown() {
        sessionisNew = false;
    }

    public void setApplication(Application application) {
        this.application = application;
    }


    public static List<Runner> produceThreads() {
        List<Runner> runners = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Runner r = new Runner();
            runners.add(r);

        }
        return runners;
    }
}
