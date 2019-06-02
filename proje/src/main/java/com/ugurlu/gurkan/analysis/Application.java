package com.ugurlu.gurkan.analysis;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Component
public class Application {
    @Autowired
    private WebUser webUser;
    @Autowired
    private List<WebPage> webPages=new ArrayList<>();
    private Map<String, String> headerKV=new HashMap<>();

    public void fillUser() {
        webUser.setAcceptLanguage(headerKV.get("accept-language"));
        webUser.setCookie(headerKV.get("cookie"));
        webUser.setHostIp(headerKV.get("host"));
        webUser.setUpgradeInsecureRequests(headerKV.get("upgrade-insecure-requests"));
        webUser.setConnection(headerKV.get("connection"));
        webUser.setAcceptEncoding(headerKV.get("accept-encoding"));
        webUser.setAcceptType(headerKV.get("accept"));
        webUser.setCacheControl(headerKV.get("cache-control"));
        webUser.setIndexCount(0);
        webUser.setAboutCount(0);
        webUser.setSingleCount(0);
        webUser.setContactCount(0);
        webUser.setTotalAboutTıme(0d);
        webUser.setTotalContactTime(0d);
        webUser.setTotalIndexTime(0d);
        webUser.setTotalSingleTime(0d);


    }
    public void fillAnalysisSession(HttpSession session,HttpServletRequest request){
        LocalDateTime dateTime= LocalDateTime.ofInstant(Instant.ofEpochMilli(session.getCreationTime()), ZoneId.systemDefault());
        webUser.getAnalysis_session().setCreationTime(dateTime);
        webUser.getAnalysis_session().setNew(session.isNew());
        webUser.getAnalysis_session().setValid(request.isRequestedSessionIdValid());
        webUser.getAnalysis_session().setSessionId(session.getId());
        webUser.getAnalysis_session().setSessionTimeout(50);
        webUser.setLocaleName(request.getLocalName());
        webUser.setIpAddress(request.getLocalAddr());
        webUser.setLocalPort(String.valueOf(request.getRemotePort()));
        webUser.setName(request.getRemoteHost());

    }
    public void fillWebPage(HttpServletRequest request){
        for(WebPage webPage:webPages){
            if(request.getRequestURI().equals(webPage.getPageServletPath())|| webPage.getPageServletPath()==null){
                return;
            }
        }
        WebPage webPage=new WebPage();
        webPage.setPageIp(request.getLocalAddr());
        webPage.setPageServerName(request.getLocalName());
        webPage.setPageServletPath(request.getServletPath());
        webPage.setPageFullPath(request.getRequestURL().toString());
        webPage.setPageProtocol(request.getProtocol());
        webPage.setPort(String.valueOf(request.getServerPort()));
        webPages.add(webPage);
    }

    public void fillHeaderKV(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            headerKV.put(header, value);
        }
    }

    public void fillBrowserAndOS(UserAgent userAgent){
        OSDetails osDetails=new OSDetails();
        BrowserDetails browserDetails=new BrowserDetails();
        osDetails.setName( userAgent.getOperatingSystem().getName());
        osDetails.setManufacturer(userAgent.getOperatingSystem().getManufacturer().toString());
         osDetails.setCode((int)(userAgent.getOperatingSystem().getId()));
        osDetails.setGroupName(userAgent.getOperatingSystem().getGroup().toString());
        osDetails.setDeviceType( userAgent.getOperatingSystem().getDeviceType().toString());
        browserDetails.setBrowserName(userAgent.getBrowser().getName());
        browserDetails.setBrowserType( userAgent.getBrowser().getBrowserType().toString());
        browserDetails.setBrowserGroup(userAgent.getBrowser().getGroup().toString());
        browserDetails.setCode((int) userAgent.getBrowser().getId());
        browserDetails.setEngine(userAgent.getBrowser().getRenderingEngine().toString());
        browserDetails.setManufacturer( userAgent.getBrowser().getManufacturer().toString());
        webUser.setOs_id(osDetails);
        webUser.setBrowserDetails(browserDetails);
    }
    public WebUser getWebUser() {
        return webUser;
    }

    public List<WebPage> getWebPages() {
        return webPages;
    }

    public void setWebPages(List<WebPage> webPages) {
        this.webPages = webPages;
    }
    public void doTheJob(HttpServletRequest request,HttpSession session,UserAgent userAgent){
        fillHeaderKV(request);
        fillBrowserAndOS(userAgent);
        fillAnalysisSession(session,request);
        fillUser();
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public Map<String, String> getHeaderKV() {
        return headerKV;
    }

    public void setHeaderKV(Map<String, String> headerKV) {
        this.headerKV = headerKV;
    }

    @Override
    public String toString() {
        String cikti="Web User Details: "+ webUser.toString() +" \n\n"+ "Analysis Session Details : "+ webUser.getAnalysis_session().toString()+
        "\n\n"+ "Os Details: "+ webUser.getOs_details().toString()+"\n\n " + " Browser Details : "  +webUser.getBrowser_details().toString()+"\n";
        return cikti;
    }
}