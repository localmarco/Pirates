/**
  * Copyright 2016 aTool.org 
  */
package com.daviddone.zoomeye.result.bean;

/**
 * Auto-generated: 2016-04-24 12:43:1
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
public class Portinfo {

    private String product;
    private String hostname;
    private String service;
    private String os;
    private String extrainfo;
    private String version;
    private String device;
    private String banner;
    private int port;
    public void setProduct(String product) {
         this.product = product;
     }
     public String getProduct() {
         return product;
     }

    @Override
	public String toString() {
		return "Portinfo [product=" + product + ", hostname=" + hostname
				+ ", service=" + service + ", os=" + os + ", extrainfo="
				+ extrainfo + ", version=" + version + ", device=" + device
				+ ", banner=" + banner + ", port=" + port + "]";
	}
	public void setHostname(String hostname) {
         this.hostname = hostname;
     }
     public String getHostname() {
         return hostname;
     }

    public void setService(String service) {
         this.service = service;
     }
     public String getService() {
         return service;
     }

    public void setOs(String os) {
         this.os = os;
     }
     public String getOs() {
         return os;
     }

    public void setExtrainfo(String extrainfo) {
         this.extrainfo = extrainfo;
     }
     public String getExtrainfo() {
         return extrainfo;
     }

    public void setVersion(String version) {
         this.version = version;
     }
     public String getVersion() {
         return version;
     }

    public void setDevice(String device) {
         this.device = device;
     }
     public String getDevice() {
         return device;
     }

    public void setBanner(String banner) {
         this.banner = banner;
     }
     public String getBanner() {
         return banner;
     }

    public void setPort(int port) {
         this.port = port;
     }
     public int getPort() {
         return port;
     }

}