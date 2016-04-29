/**
  * Copyright 2016 aTool.org 
  */
package com.daviddone.zoomeye.result.bean;
import java.util.List;

/**
 * Auto-generated: 2016-04-24 12:43:1
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
public class BugInfo {

    private List<Matches> matches;
    private Facets facets;
    private int total;
    public void setMatches(List<Matches> matches) {
         this.matches = matches;
     }
     public List<Matches> getMatches() {
         return matches;
     }

    public void setFacets(Facets facets) {
         this.facets = facets;
     }
     public Facets getFacets() {
         return facets;
     }

    public void setTotal(int total) {
         this.total = total;
     }
     public int getTotal() {
         return total;
     }

}