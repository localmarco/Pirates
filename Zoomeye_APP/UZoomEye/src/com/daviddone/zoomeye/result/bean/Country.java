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
public class Country {

    /**
     * 
     */
    private int geonameId;
    private String code;
    private Names names;
    public void setGeonameId(int geonameId) {
         this.geonameId = geonameId;
     }
     @Override
	public String toString() {
		return "Country [geonameId=" + geonameId + ", code=" + code
				+ ", names=" + names + "]";
	}
	public int getGeonameId() {
         return geonameId;
     }

    public void setCode(String code) {
         this.code = code;
     }
     public String getCode() {
         return code;
     }

    public void setNames(Names names) {
         this.names = names;
     }
     public Names getNames() {
         return names;
     }

}