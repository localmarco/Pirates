#!/usr/bin/python
# -*- coding: UTF-8 -*-

import json
import httplib

""" Debug """
DEBUG = True
USER = None
PASSWORD = None
TOKEN = None


HTTP_URL = 'api.zoomeye.org'
URL_LOGIN = '/user/login'
URL_RESOURCES = '/resources-info'

__all__ = ["Zoomeye"]

class Zoomeye(object):
    token = None
    client = None

    def __init__(self, https = False):
        self.token = TOKEN
        if https is True:
            self.client = httplib.HTTPSConnection(HTTP_URL)
        else:
            self.client = httplib.HTTPConnection(HTTP_URL)

    def __del__(self):
        if self.client is not None:
            self.client.close()

    def login(self):
        """ return {http code,token} """
        if DEBUG is True:
            username = USER
            password = PASSWORD
        else:
            username = raw_input('Username: username:')
            password = raw_input('Password: password:')

        data = {
                'username':username,
                'password':password
                } 
        
        try:
            self.client.request('POST', URL_LOGIN, json.dumps(data))
            result = self.client.getresponse()
            if result.status == httplib.OK:
                self.token = json.loads(result.read())['access_token'] 
        except Exception as e:
            if DEBUG is True:
                print e
            self.token = None
        return result.status, self.token

    def __get(self, url):
        """ return {http code,{result}} """
        try:
            self.client.request('GET', url, 
                    headers = { 'Authorization' : "JWT "+self.token })
            result = self.client.getresponse()
            if result.status == httplib.OK:
                return result.status, result.read()
            else:
                return result.status, httplib.responses[result.status]
        except Exception as e:
            if DEBUG is True:
                print e

    def getResources(self):
        data = None
        if self.token is not None and self.client is not None:
            result = self.__get(URL_RESOURCES);
            if result[0] == httplib.OK:
                data = json.dumps(result[1])
        return data


    def hostSearch(self, query, page = None, facet = None):
        data = None
        url = "/host/search?query=%s" %(str(query))
        if page is not None:
            url = "%s&page=%d" %(str(url), int(page))
        if facet is not None:
            url = "%s&facet=%s" %(str(url), str(facet))

        if self.token is not None and self.client is not None:
            result = self.__get(url);
            if result[0] == httplib.OK:
                data = json.dumps(result[1])
        return data


    def webSearch(self, query, page = None, facet = None):
        data = None
        url = "/web/search?query=%s" %(str(query))
        if page is not None:
            url = "%s&page=%d" %(str(url), int(page))
        if facet is not None:
            url = "%s&facet=%s" %(str(url), str(facet))
        if self.token is not None and self.client is not None:
            result = self.__get(url);
            if result[0] == httplib.OK:
                data = json.dumps(result[1])
        return data

