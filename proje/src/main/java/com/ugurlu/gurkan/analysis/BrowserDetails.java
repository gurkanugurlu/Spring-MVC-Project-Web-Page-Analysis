package com.ugurlu.gurkan.analysis;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Component
@Table(name="browser_details")
public class BrowserDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "browser_id", nullable = false)
    private Long id;
    @Column(name = "code")
    private Integer code;
    @Column(name = "browser_name")
    private String browserName;
    @Column(name = "browser_group")
    private String browserGroup;
    @Column(name = "browser_type")
    private String browserType;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "engine")
    private String engine;
    @OneToOne(mappedBy = "browser_details",cascade = CascadeType.ALL)
    private WebUser webuser;

    public WebUser getWebuser() {
        return webuser;
    }

    public void setWebuser(WebUser webuser) {
        this.webuser = webuser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserGroup() {
        return browserGroup;
    }

    public void setBrowserGroup(String browserGroup) {
        this.browserGroup = browserGroup;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        String cikti="BrowserDetails id: "+ this.id+ " BrowserCode : "+ this.code+ "Browser Engine: "+ this.engine+ "Browser Name: "+ this.browserName +
                "Browser Group: " + this.browserGroup+ " Manufacturer: "+ this.manufacturer;
        return cikti;
    }
}
