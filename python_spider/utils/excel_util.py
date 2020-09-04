#!/user/bin/env python3
# -*- coding: utf-8 -*-
__author__ ="BackLightmoon";

'''
excel util
'''

import openpyxl;

def create_excel(header,body,file_path):
    workbook=openpyxl.Workbook();#创建一个workbook对象
    active_sheet = workbook.active;  # 获取活动的sheet,active即使get_active_sheet
    active_sheet.append(header);
    for item in body:
        active_sheet.append(item);
    # 文件保存
    workbook.save(filename=file_path);

if __name__ =="__main__":
    pass;

