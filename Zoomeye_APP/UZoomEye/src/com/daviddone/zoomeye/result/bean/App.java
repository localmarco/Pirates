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
public class App {

    private int count;
    private String app;
    private List<Versions> versions;
    public void setCount(int count) {
         this.count = count;
     }
     public int getCount() {
         return count;
     }

    public void setApp(String app) {
         this.app = app;
     }
     public String getApp() {
         return app;
     }

    public void setVersions(List<Versions> versions) {
         this.versions = versions;
     }
     public List<Versions> getVersions() {
         return versions;
     }

}