/**
  * Copyright 2016 aTool.org 
  */
package com.daviddone.zoomeye.result.bean;
import java.util.Date;

/**
 * Auto-generated: 2016-04-24 12:43:1
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
public class Matches {

    private Geoinfo geoinfo;
    private String ip;
    private Portinfo portinfo;
    private String timestamp;
    public void setGeoinfo(Geoinfo geoinfo) {
         this.geoinfo = geoinfo;
     }
     public Geoinfo getGeoinfo() {
         return geoinfo;
     }

    public void setIp(String ip) {
         this.ip = ip;
     }
     public String getIp() {
         return ip;
     }

    public void setPortinfo(Portinfo portinfo) {
         this.portinfo = portinfo;
     }
     public Portinfo getPortinfo() {
         return portinfo;
     }

    public void setTimestamp(String timestamp) {
         this.timestamp = timestamp;
     }
     public String getTimestamp() {
         return timestamp;
     }
	@Override
	public String toString() {
		return "Matches [geoinfo=" + geoinfo + ", ip=" + ip + ", portinfo="
				+ portinfo + ", timestamp=" + timestamp + "]";
	}

}