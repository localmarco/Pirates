#!/usr/bin/python
# -*- coding: UTF-8 -*-

"""
 Zoomeye Host api interface.
 Created on 2016/04/19
 @author: marco
 @group : Priate 
 @contact: marco.tbls@gmail.com
"""
class Host():
    def __init__(self, client=None):
        """
            init client
        """
        if client is None:
            self.client = Client();
        else:
            self.client = client;

