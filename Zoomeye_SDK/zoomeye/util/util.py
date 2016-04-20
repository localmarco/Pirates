#!/usr/bin/python
# -*- coding: UTF-8 -*-

try:
    from httplib import HTTPSConnection
    from httplib import HTTPConnection
except ImportError:
    from http.client import HTTPSConnection
    from http.client import HTTPConnection
import urllib,urllib2,cookielib
import json

from zoomeye.util import configs as zc
from zoomeye.util import error as ze

class Client():
    useHttps = False;
    token = None
    httpClient = None;
    httpCode = None
    def __init__(self, usehttps=None):
        self.token = zc.TOKEN

        self.useHttps = usehttps 
        if self.useHttps:
            self.httpClient = HTTPSConnection(zc.HTTP_URL, zc.HTTPS_PORT)
        else:
            self.httpClient = HTTPConnection(zc.HTTP_URL, zc.HTTP_PORT, timeout = zc.HTTP_TIMEOUT)

    def __del__(self):
        if self.httpClient is not None:
            self.httpClient.close()

    def initToken(self):
        if self.token is None:
            postdata = eval(zc.LOGIN_PARAM%(zc.USER, zc.PASSWORD))
            try:
                self.httpClient.request(zc.HTTP_POST,zc.URL_LOGIN,json.dumps(postdata),zc.HTTP_HEADERS_LOGIN)
                response = self.httpClient.getresponse()
                self.httpCode = response.status
                if response.status == ze.HTTP_200:
                    self.token = eval(response.read())[zc.HTTP_TOKEN_NAME]
            except Exception as e:
                self.token=None

    def setToken(self, token):
        self.token = token

    def getToken(self):
        return self.httpCode, self.token

    def getHttpCode(self):
        return self.httpCode
    
    def POST(self, url=None, params=None, header=None):
        result = None
        try:
            self.httpClient.request(method=zc.HTTP_POST, url = url, body = params, headers = header) 
            result = self.httpClient.getresponse()
            return result.status, result.read()
        except Exception as e:
            if zc.DEBUG is True:
                print e
        return -1, result
        
    def GET(self, url=None, header=None):
        result = None
        try:
            self.httpClient.request(method=zc.HTTP_GET, url = url, headers = header) 
            result = self.httpClient.getresponse()
            return result.status, result.read()
        except Exception as e:
            if zc.DEBUG is True:
                print e
        return -1, result
    
    def getResources(self):
        return self.GET(url = zc.URL_RESOURCES, header = { zc.HTTP_HEADERS_RESOURCE: "JWT "+self.token })
