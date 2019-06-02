package com.ugurlu.gurkan.analysis;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Component
@Entity
@Table(name="analysis_session")
public class AnalysisSession implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "analysis_id", nullable = false)
    private Long analysis_id;
    @Column(name = "session_id")
    private String sessionId;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(name = "is_new")
    private Boolean isNew;
    @Column(name = "session_timeout")
    private int sessionTimeout;
    @Column(name = "is_valid")
    private Boolean isValid;
    @Column(name="last_accessed_time")
    private LocalDateTime lastAccessedTime;
    @Column(name="total_session_time")
    private Integer totalSessionTime;
    @OneToOne(mappedBy = "analysis_session",cascade = CascadeType.ALL)
    private WebUser webuser;
    public WebUser getWebuser() {
        return webuser;
    }

    public void setWebuser(WebUser webuser) {
        this.webuser = webuser;
    }

    public LocalDateTime getLastAccessedTime() {
        return lastAccessedTime;
    }

    public void setLastAccessedTime(LocalDateTime lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }

    public Boolean getValid() {
        return isValid;
    }

    public Integer getTotalSessionTime() {
        return totalSessionTime;
    }

    public void setTotalSessionTime(Integer totalSessionTime) {
        this.totalSessionTime = totalSessionTime;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Long getAnalysis_id() {
        return analysis_id;
    }

    public void setAnalysis_id(Long analysis_id) {
        this.analysis_id = analysis_id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    @Override
    public String toString() {
        String cikti="Analysis_id: "+ this.analysis_id+ "Session Id: "+ this.sessionId+ "Creation Time : "+ this.creationTime+  "isValid : "+ this.isValid+ "Timeout is: "+ this.sessionTimeout;
        return cikti;
    }
}
