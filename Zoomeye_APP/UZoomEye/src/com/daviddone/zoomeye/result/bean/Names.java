/**
  * Copyright 2016 aTool.org 
  */
package com.daviddone.zoomeye.result.bean;
/**
 * 
* @ClassName: Names 
* @Description: 本类作用 
* @author tangdongqing
* @date 2016-4-24 下午12:46:29 
*
 */
public class Names {
    @Override
	public String toString() {
		return "Names [zh=" + zh + ", en=" + en + "]";
	}
	private String zh;
    private String en;
    public void setZh(String zh) {
         this.zh = zh;
     }
     public String getZh() {
         return zh;
     }

    public void setEn(String en) {
         this.en = en;
     }
     public String getEn() {
         return en;
     }

}