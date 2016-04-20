#!/usr/bin/python
# -*- coding: UTF-8 -*-

import sys

sys.path.append('../')

from zoomeye.util.util import Client as tc

if __name__ == '__main__':
    print "test Client"
    t = tc()
    t.initToken()
    print t.getToken()
    r =  t.getResources()
    print r

