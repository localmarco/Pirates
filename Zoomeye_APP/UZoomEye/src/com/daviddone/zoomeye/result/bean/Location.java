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
public class Location {

    @Override
	public String toString() {
		return "Location [lat=" + lat + ", lon=" + lon + "]";
	}
	private int lat;
    private int lon;
    public void setLat(int lat) {
         this.lat = lat;
     }
     public int getLat() {
         return lat;
     }

    public void setLon(int lon) {
         this.lon = lon;
     }
     public int getLon() {
         return lon;
     }

}