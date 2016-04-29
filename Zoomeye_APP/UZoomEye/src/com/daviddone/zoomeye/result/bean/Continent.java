package com.daviddone.zoomeye.result.bean;
/**
 * 
* @ClassName: Continent 
* @Description: 本类作用 
* @author tangdongqing
* @date 2016-4-25 下午10:13:48 
*
 */
public class Continent {

    private int geonameId;
    private String code;
    private Names names;
    public void setGeonameId(int geonameId) {
         this.geonameId = geonameId;
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
	@Override
	public String toString() {
		return "Continent [geonameId=" + geonameId + ", code=" + code
				+ ", names=" + names + "]";
	}

}