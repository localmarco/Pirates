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
public class Geoinfo {

    private City city;
    private Country country;
    private String isp;
    private Continent continent;
    private Subdivisions subdivisions;
    private Location location;
    private String organization;
    private String aso;
    private int asn;
    public void setCity(City city) {
         this.city = city;
     }
     public City getCity() {
         return city;
     }

    public void setCountry(Country country) {
         this.country = country;
     }
     public Country getCountry() {
         return country;
     }

    public void setIsp(String isp) {
         this.isp = isp;
     }
     public String getIsp() {
         return isp;
     }

    public void setContinent(Continent continent) {
         this.continent = continent;
     }
     public Continent getContinent() {
         return continent;
     }

    public void setSubdivisions(Subdivisions subdivisions) {
         this.subdivisions = subdivisions;
     }
     public Subdivisions getSubdivisions() {
         return subdivisions;
     }

    public void setLocation(Location location) {
         this.location = location;
     }
     public Location getLocation() {
         return location;
     }

    public void setOrganization(String organization) {
         this.organization = organization;
     }
     public String getOrganization() {
         return organization;
     }

    public void setAso(String aso) {
         this.aso = aso;
     }
     public String getAso() {
         return aso;
     }

    public void setAsn(int asn) {
         this.asn = asn;
     }
     public int getAsn() {
         return asn;
     }
	@Override
	public String toString() {
		return "Geoinfo [city=" + city + ", country=" + country + ", isp="
				+ isp + ", continent=" + continent + ", subdivisions="
				+ subdivisions + ", location=" + location + ", organization="
				+ organization + ", aso=" + aso + ", asn=" + asn + "]";
	}

}