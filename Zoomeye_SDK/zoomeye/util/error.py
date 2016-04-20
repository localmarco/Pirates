#!/usr/bin/python
# -*- coding: UTF-8 -*-

"""
    function error code
"""
E_NO_TOEKN = -100
E_HTTP_ERROR = -101

"""
    zoomeye http error code
"""
HTTP_200 = 200
HTTP_200_MSG = {
    'login':'login successfully',
    'resource':'account credits has increased n credits',
    'host':'query request successfully',
    'web':'query request successfully',
    'status':'request succeeded'
}

HTTP_400 = 400
HTTP_400_MSG = {
    'login':'invalid parameters',
    'host':'invalid parameters',
    'web':'invalid parameters'
}

HTTP_401 = 401
HTTP_401_MSG = {
    'login':'login required',
    'resource':'unauthorized'
}

HTTP_422 = 422
HTTP_401_MSG = {
    'host':'invalid parameters,contains not supported parameters',
    'web':'invalid parameters,contains not supported parameters'
}

