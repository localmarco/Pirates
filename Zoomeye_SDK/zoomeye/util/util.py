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
                if response.status == ze.HTTP_200:
                    self.token = eval(response.read())[zc.HTTP_TOKEN_NAME]
            except Exception as e:
                self.token=None

    def setToken(self, token):
        self.token = token

    def getToken(self):
        return self.token

    def getResourcesInfo(self):
        return None

