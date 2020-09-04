#!/user/bin/env python3
# -*- coding: utf-8 -*-
__author__ ="BackLightmoon";

'''
mysql util
'''



import pymysql;



def get_connect_cursor():
    coon = pymysql.connect(host='localhost', user='root', password='123456', db='sboot', charset='utf8');
    return coon,coon.cursor();


def exute_insert_update_delete(cursor,sql):
    result = cursor.execute(sql);
    return result;

def execute_query(cur,sql):
    cur.execute(sql);
    return cur.fetchall();

def commit_(coon):
    coon.commit();

def close_connect_cursor(conn,cur):
    cur.close();
    conn.close();


