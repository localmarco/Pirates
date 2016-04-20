#!/usr/bin/python
# -*- coding: UTF-8 -*-

import sys

DEBUG=False

USER=None
PASSWORD=None

#debug token
TOKEN=None

HTTP_URL='api.zoomeye.org'
HTTP_PORT = 80 
HTTPS_PORT = 443
HTTP_POST='POST'
HTTP_GET='GET'
HTTP_TIMEOUT=200

HTTP_TOKEN_NAME='access_token'

URL_LOGIN='/user/login'
LOGIN_PARAM="{'username':'%s', 'password':'%s'}"
HTTP_HEADERS_LOGIN = {"Content-type":"application/x-www-form-urlencoded"}

URL_RESOURCES ='/resources-info'
HTTP_HEADERS_RESOURCE ="Authorization" 


