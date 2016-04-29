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
public class City {

    @Override
	public String toString() {
		return "City [geonameId=" + geonameId + ", names=" + names + "]";
	}
	private int geonameId;
    private Names names;
    public void setGeonameId(int geonameId) {
         this.geonameId = geonameId;
     }
     public int getGeonameId() {
         return geonameId;
     }

    public void setNames(Names names) {
         this.names = names;
     }
     public Names getNames() {
         return names;
     }

}