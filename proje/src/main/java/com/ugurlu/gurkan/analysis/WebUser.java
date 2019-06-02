package com.ugurlu.gurkan.analysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Component
@Entity
@Table(name="webuser")
public class WebUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long id;
    @Column(name = "dil")
    private String acceptLanguage;
    @Column(name = "cookies")
    private String cookie;
    @Column(name = "cache_control")
    private String cacheControl;
    @Column(name = "host_ip")
    private String hostIp;
    @Column(name = "upgrade_insecure_requests")
    private String upgradeInsecureRequests;
    @Column(name = "connection")
    private String connection;
    @Column(name = "coding_type")
    private String acceptEncoding;
    @Column(name = "accept_type")
    private String acceptType;
    @Column(name = "locale_name")
    private String localeName;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "local_port")
    private String localPort;
    @Column(name = "name")
    private String name;
    @Column(name="indexCount")
    private Integer indexCount;
    @Column(name="singleCount")
    private Integer singleCount;
    @Column(name="aboutCount")
    private Integer aboutCount;
    @Column(name="contactCount")
    private Integer contactCount;
    @Autowired
    @OneToOne
    @JoinColumn(name = "browser_id", referencedColumnName = "browser_id",nullable = false)
    private BrowserDetails browser_details;
    @Autowired
    @OneToOne
    @JoinColumn(name = "os_id", referencedColumnName = "os_id")
    private OSDetails os_details;
    @Autowired
    @OneToOne
    @JoinColumn(name="analysis_id",referencedColumnName = "analysis_id")
    private AnalysisSession analysis_session;

    private LocalDateTime setIndexTime=null;
    private LocalDateTime setContactTime=null;
    private LocalDateTime setAboutTime=null;
    private LocalDateTime setSingleTime=null;

    private Double totalIndexTime;
    private Double totalContactTime;
    private Double totalAboutTıme;
    private Double totalSingleTime;
    @Transient
    private LocalDateTime firstSingleDateTime=null;
    @Transient
    private LocalDateTime firstContactDateTime=null;
    @Transient
    private LocalDateTime firstIndexDateTime=null;
    @Transient
    private LocalDateTime firstAboutDateTime=null;




    public LocalDateTime getFirstSingleDateTime() {
        return firstSingleDateTime;
    }

    public LocalDateTime getFirstContactDateTime() {
        return firstContactDateTime;
    }

    public void setFirstContactDateTime(LocalDateTime firstContactDateTime) {
        this.firstContactDateTime = firstContactDateTime;
    }

    public LocalDateTime getFirstIndexDateTime() {
        return firstIndexDateTime;
    }

    public void setFirstIndexDateTime(LocalDateTime firstIndexDateTime) {
        this.firstIndexDateTime = firstIndexDateTime;
    }

    public LocalDateTime getFirstAboutDateTime() {
        return firstAboutDateTime;
    }

    public void setFirstAboutDateTime(LocalDateTime firstAboutDateTime) {
        this.firstAboutDateTime = firstAboutDateTime;
    }

    public void setFirstSingleDateTime(LocalDateTime firstSingleDateTime) {
        this.firstSingleDateTime = firstSingleDateTime;
    }

    public Double getTotalIndexTime() {
        return totalIndexTime;
    }

    public void setTotalIndexTime(Double totalIndexTime) {
        this.totalIndexTime = totalIndexTime;
    }

    public Double getTotalContactTime() {
        return totalContactTime;
    }

    public void setTotalContactTime(Double totalContactTime) {
        this.totalContactTime = totalContactTime;
    }

    public Double getTotalAboutTıme() {
        return totalAboutTıme;
    }

    public void setTotalAboutTıme(Double totalAboutTıme) {
        this.totalAboutTıme = totalAboutTıme;
    }

    public Double getTotalSingleTime() {
        return totalSingleTime;
    }

    public void setTotalSingleTime(Double totalSingleTime) {
        this.totalSingleTime = totalSingleTime;
    }

    public LocalDateTime getSetIndexTime() {
        return setIndexTime;
    }

    public void setSetIndexTime(LocalDateTime setIndexTime) {
        this.setIndexTime = setIndexTime;
    }

    public LocalDateTime getSetContactTime() {
        return setContactTime;
    }

    public void setSetContactTime(LocalDateTime setContactTime) {
        this.setContactTime = setContactTime;
    }

    public LocalDateTime getSetAboutTime() {
        return setAboutTime;
    }

    public void setSetAboutTime(LocalDateTime setAboutTime) {
        this.setAboutTime = setAboutTime;
    }

    public LocalDateTime getSetSingleTime() {
        return setSingleTime;
    }

    public void setSetSingleTime(LocalDateTime setSingleTime) {
        this.setSingleTime = setSingleTime;
    }

    public BrowserDetails getBrowserDetails() {
        return browser_details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrowserDetails(BrowserDetails browserDetails) {
        this.browser_details = browserDetails;
    }

    public OSDetails getOs_id() {
        return os_details;
    }

    public void setOs_id(OSDetails os_id) {
        this.os_details = os_id;
    }

    public BrowserDetails getBrowser_details() {
        return browser_details;
    }

    public void setBrowser_details(BrowserDetails browser_details) {
        this.browser_details = browser_details;
    }

    public OSDetails getOs_details() {
        return os_details;
    }

    public void setOs_details(OSDetails os_details) {
        this.os_details = os_details;
    }

    public String getLocaleName() {
        return localeName;
    }

    public void setLocaleName(String localeName) {
        this.localeName = localeName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLocalPort() {
        return localPort;
    }

    public void setLocalPort(String localPort) {
        this.localPort = localPort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public AnalysisSession getAnalysis_session() {
        return analysis_session;
    }

    public void setAnalysis_session(AnalysisSession analysis_session) {
        this.analysis_session = analysis_session;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getUpgradeInsecureRequests() {
        return upgradeInsecureRequests;
    }

    public void setUpgradeInsecureRequests(String upgradeInsecureRequests) {
        this.upgradeInsecureRequests = upgradeInsecureRequests;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public String getAcceptType() {
        return acceptType;
    }

    public void setAcceptType(String acceptType) {
        this.acceptType = acceptType;
    }

    public Integer getIndexCount() {
        return indexCount;
    }

    public void setIndexCount(Integer indexCount) {
        this.indexCount = indexCount;
    }

    public Integer getSingleCount() {
        return singleCount;
    }

    public void setSingleCount(Integer singleCount) {
        this.singleCount = singleCount;
    }

    public Integer getAboutCount() {
        return aboutCount;
    }

    public void setAboutCount(Integer aboutCount) {
        this.aboutCount = aboutCount;
    }

    public Integer getContactCount() {
        return contactCount;
    }

    public void setContactCount(Integer contactCount) {
        this.contactCount = contactCount;
    }

    @Override
    public String toString() {
       String cikti= "id = "+ this.id+ " coding-type = "+ this.acceptEncoding+ " dil = " + this.acceptLanguage+ " accept-type = "+ this.acceptType+
               " cookies = "+ this.cookie+ " host_ip = " + this.hostIp+ " client_ip_Address = "+ this.name+ " local_port = "+ this.localPort +
               " locale_name = "+ this.localeName;
       return cikti;
    }
}
