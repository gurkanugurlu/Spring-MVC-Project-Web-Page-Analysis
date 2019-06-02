package com.ugurlu.gurkan.analysis;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name="webpage")
public class WebPage implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "webpage_id", nullable = false)
 private Long id;
 @Column(name = "page_ip")
 private String pageIp;
 @Column(name = "page_server_name")
 private String pageServerName;
 @Column(name = "page_full_path")
 private String pageFullPath;
 @Column(name = "page_servlet_path")
 private String pageServletPath;
 @Column(name = "page_protocol")
 private String pageProtocol;
 @Column(name = "port")
 private String port;
 @Column(name="total_count")
 private Long totalCount;

 public Long getTotalCount() {
  return totalCount;
 }

 public void setTotalCount(Long totalCount) {
  this.totalCount = totalCount;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getPageIp() {
  return pageIp;
 }

 public void setPageIp(String pageIp) {
  this.pageIp = pageIp;
 }

 public String getPageServerName() {
  return pageServerName;
 }

 public void setPageServerName(String pageServerName) {
  this.pageServerName = pageServerName;
 }

 public String getPageFullPath() {
  return pageFullPath;
 }

 public void setPageFullPath(String pageFullPath) {
  this.pageFullPath = pageFullPath;
 }

 public String getPageServletPath() {
  return pageServletPath;
 }

 public void setPageServletPath(String pageServletPath) {
  this.pageServletPath = pageServletPath;
 }

 public String getPageProtocol() {
  return pageProtocol;
 }

 public void setPageProtocol(String pageProtocol) {
  this.pageProtocol = pageProtocol;
 }

 public String getPort() {
  return port;
 }

 public void setPort(String port) {
  this.port = port;
 }


}
