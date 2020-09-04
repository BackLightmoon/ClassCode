#!/user/bin/env python3
# -*- coding: utf-8 -*-
__author__ ="BackLightmoon";

'''
mysql test
'''

#import  pymysql;
import mysql_util;



def insert_resource():
    conn,cur = mysql_util.get_connect_cursor();
    sql ="insert into resource (resource_uri,resource_name,permission) value ('aa','bb','cc')";
    mysql_util.exute_insert_update_delete(cur,sql);
    mysql_util.commit_(conn);
    mysql_util.close_connect_cursor(conn,cur);
    # coon = pymysql.connect(host='localhost',user='root',password='123456',db='sboot',charset='utf8');
    # cur=coon.cursor();
    # result = cur.execute("insert into resource (resource_uri,resource_name,permission) value ('aa','bb','cc')")
    # print(result);
    # coon.commit();
    # cur.close();
    # coon.close();


def query_resource():
    conn, cur = mysql_util.get_connect_cursor();
    sql = "select * from resource";
    result = mysql_util.execute_query(cur, sql);
    print(result);
    mysql_util.commit_(conn);
    mysql_util.close_connect_cursor(conn, cur);
    # coon = pymysql.connect(host='localhost',user='root',password='123456',db='sboot',charset='utf8');
    # cur=coon.cursor();
    # result = cur.execute("select * from resource");
    # print(result);
    # print(cur.fetchall());
    # coon.commit();
    # cur.close();
    # coon.close();


if __name__ == "__main__":
    #insert_resource();
     query_resource()

