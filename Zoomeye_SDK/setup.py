#!/usr/bin/python
# -*- coding: UTF-8 -*-

import os
import sys
from setuptools import setup

packages = [ 'zoomeye' ]
setup (
    name = 'zoomeye',
    version = '1.1',
    py_modules = ['zoomeye'],
    author = 'marco',
    author_email = 'marco.tbls@gmail.com',
    description = 'zoomeye api',
    packages = packages,
    License = 'LGPL',
    url = 'git@github.com:localmarco/Pirates.git/Zoomeye_SDK'
)
