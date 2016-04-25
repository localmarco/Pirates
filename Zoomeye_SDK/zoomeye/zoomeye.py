#!/usr/bin/python
# -*- coding: UTF-8 -*-

import json
import httplib

""" Debug """
DEBUG = True

HTTP_URL = 'api.zoomeye.org'

__all__ = ["ZoomEye", "Resource", "Host", "Web" ]

class ZoomEye(object):
    https = False
    token = None

    def __init__(self, https = False):
        self.https = https

    def login(self):
        """ return {http code,token} """
        username = raw_input('Username:')
        password = raw_input('Password:')
        data = {
                'username':username,
                'password':password
                } 
        try:
            if self.https is True:
                client = httplib.HTTPSConnection(HTTP_URL)
            else:
                client = httplib.HTTPConnection(HTTP_URL)
            client.request('POST', '/user/login', json.dumps(data))
            result = client.getresponse()
            if result.status == httplib.OK:
                self.token = json.loads(result.read())['access_token'] 
        except Exception as e:
            if DEBUG is True:
                print e
            self.token = None
        if client:
            client.close()
        return result.status, self.token

    def _get(self, url):
        """ return {http code,{result}} """
        code = None
        data = None
        try:
            if self.https is True:
                client = httplib.HTTPSConnection(HTTP_URL)
            else:
                client = httplib.HTTPConnection(HTTP_URL)
            client.request('GET', url, 
                    headers = { 'Authorization' : "JWT "+self.token })
            result = client.getresponse()
            code = result.status
            data = result.read()
        except Exception as e:
            if DEBUG is True:
                print e
        if client:
            client.close()

        if code == httplib.OK:
            return code, data
        else:
            return code, httplib.responses[code]

    def getResponse(self):
        data = None
        if self.token is not None:
            result = self._get('/resources-info')
            print "[--] getResponse ---"
            if result[0] == httplib.OK:
                data = result[1]
        return data


    def hostSearch(self, query, page = None, facet = None):
        data = None
        url = "/host/search?query=%s" %(str(query))
        if page is not None:
            url = "%s&page=%d" %(str(url), int(page))
        if facet is not None:
            url = "%s&facet=%s" %(str(url), str(facet))

        if self.token is not None:
            result = self._get(url)
            if result[0] == httplib.OK:
                data = result[1]
        return data


    def webSearch(self, query, page = None, facet = None):
        data = None
        url = "/web/search?query=%s" %(str(query))
        if page is not None:
            url = "%s&page=%d" %(str(url), int(page))
        if facet is not None:
            url = "%s&facet=%s" %(str(url), str(facet))
        if self.token is not None:
            result = self._get(url)
            if result[0] == httplib.OK:
                data = result[1]
        return data

class Response(object):
    def __init__(self, response):
        try:
            self.response = json.loads(response)
        except Exception as e:
            if DEBUG is True:
                print e
            self.response = None

    def getPlan(self):
        return self.response['plan']

    def getHostSearch(self):
        return self.response['resources']['host-search']

    def getWebSearch(self):
        return self.response['resources']['web-search']


class Names(object):
    def __init__(self, data):
        if 'zh-CN' in data:
            self.zh_cn = data['zh-CN']
        if 'en' in data:
            self.en = data['en']

class Geoinfo_base(object):
    def __init__(self, data):
        if 'geoname_id' in data:
            self.geoname_id = data['geoname_id']
        if 'code' in data:
            self.code = data['code']
        if 'names' in data:
            self.names = Names(data['names'])

class City(Geoinfo_base):
    def __init__(self, data):
        Geoinfo_base.__init__(self, data)

class Country(Geoinfo_base):
    def __init__(self, data):
        Geoinfo_base.__init__(self, data)

class Subdivisions(Geoinfo_base):
    def __init__(self, data):
        Geoinfo_base.__init__(self, data)

class Continent(Geoinfo_base):
    def __init__(self, data):
        Geoinfo_base.__init__(self, data)

class Location(object):
    def __init__(self, data):
        if 'lat' in data:
            self.latitude = data['lat']
        if 'lon' in data:
            self.longitude = data['lon']

class Geoinfo(object):
    def __init__(self, data):
        if 'city' in data:
            self.city = City(data['city'])
        if 'country' in data:
            self.country = Country(data['country'])
        if 'isp' in data:
            self.isp = data['isp']
        if 'asn' in data:
            self.asn = data['asn']
        if 'subdivisions' in data:
            self.subdivisions = Subdivisions(data['subdivisions'])
        if 'location' in data:
            self.location = Location(data['location'])
        if 'organization'in data:
            self.organization = data['organization']
        if 'aso' in data:
            self.aso = data['aso']
        if 'continent' in data:
            self.continent = Continent(data['continent'])

class Server(object):
    def __init__(self, data):
        if 'version' in data:
            self.version = data['version']
        if 'name' in data:
            self.name = data['name']
        if 'chinese' in data:
            self.chinese = data['chinese']

class Portinfo(object):
    def __init__(self, data):
        if 'product' in data:
            self.product = data['product']
        if 'hostname' in data:
            self.hostname = data['hostname']
        if 'service' in data:
            self.service = data['service']
        if 'banner' in data:
            self.banner = data['banner']
        if 'extrainfo' in data:
            self.extrainfo = data['extrainfo']
        if 'version' in data:
            self.version = data['version']
        if 'device' in data:
            self.device = data['device']
        if 'os' in data:
            self.os = data['os']
        if 'port' in data:
            self.port = data['port']

class HostDevice(object):
    def __init__(self, data):
        if 'ip' in data:
            self.ip = data['ip']
        if 'timestamp' in data:
            self.timestamp = data['timestamp']
        if 'geoinfo' in data:
            self.geoinfo = Geoinfo(data['geoinfo'])
        if 'portinfo' in data:
            self.portinfo = Portinfo(data['portinfo'])

class WebDevice(object):
    def __init__(self, data):
        if 'description' in data:
            self.description = data['description']
        if 'check_time' in data:
            self.check_time = data['check_time']
        if 'title' in data:
            self.title = data['title']
        if 'ip' in data:
            self.ip = data['ip']
        if 'site' in data:
            self.site = data['site']
        if 'headers' in data:
            self.headers = data['headers']
        if 'keywords' in data:
            self.keywords = data['keywords']
        if 'domains' in data:
            self.domains = data['domains']
        if 'geoinfo' in data:
            self.geoinfo = Geoinfo(data['geoinfo'])
        if 'server' in data:
            self.server = Server(data['server'])
            
class Host(object):
    devices = []
    def __init__(self, data):
        try:
            data = json.loads(data)
            if 'total' in data:
                self.total = data['total']
            if 'matches' in data:
                for i in data['matches']:
                    self.devices.append(HostDevice(i))
        except Exception as e:
            if DEBUG is True:
                print e

    def getResultLen(self):
        return len(self.devices)
    
    def getDevice(self, index):
        if index >= 0 and index < len(self.devices):
            return self.devices[index]
class Web(object):
    devices = []
    def __init__(self, data):
        try:
            data = json.loads(data)
            if 'total' in data:
                self.total = data['total']
            if 'matches' in data:
                for i in data['matches']:
                    self.devices.append(WebDevice(i))
        except Exception as e:
            if DEBUG is True:
                print e

    def getResultLen(self):
        return len(self.devices)
    
    def getDevice(self, index):
        if index >= 0 and index < len(self.devices):
            return self.devices[index]

if __name__ == '__main__':
    print "[-] Test ZoomEye..."
    c = ZoomEye()
    while(1):
        r = c.login()
        print r
        if r[0] == 200:
            break
        else:
            print "Login error..."
        
    print "[-] Test Response"
    r = Response(c.getResponse())
    print "HostSearch [%d]" %(r.getHostSearch())
    print "WebSearch [%d]" %(r.getWebSearch())
    hostSearch = raw_input('Host Search:')
    host = Host(c.hostSearch(hostSearch))
    print "Host Search Totle[%d] Len [%d]" %(host.total, host.getResultLen())
    for i in host.devices:
        print "[-][%s]\t [%s]" %(i.ip, i.portinfo.service)
    WebSearch = raw_input('Web Search:')
    web = Web(c.webSearch(hostSearch))
    print "Web Search Totle[%d] Len [%d]" %(web.total, web.getResultLen())
    for i in web.devices:
        print "[-][%s]\t [%s]" %(i.ip, i.site)

