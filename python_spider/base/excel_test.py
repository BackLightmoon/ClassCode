#!/user/bin/env python3
# -*- coding: utf-8 -*-
__author__ ="BackLightmoon";

'''
excel test
'''


import excel_util;
import random;

def write_excel():
    header=["第一季度","第二季度","第三季度","第四季度"];
    file_path="/Java/Python/upload/excel_test.xlsx";
    body=list();
    for item in range(1,10):
        line = list();
        for i in range(1,len(header)+1):
            line.append(i*random.randint(1,10));
        body.append(line);
    excel_util.create_excel(header,body,file_path);
    # workbook=openpyxl.Workbook();#创建一个workbook对象
    # #sheet_1 = workbook.create_sheet(index=0,title="aa");#创建一个sheet对象
    # #sheet_2 = workbook.create_sheet(index=1, title="bb");  # 再创建一个sheet对象
    # active_sheet = workbook.active;#获取活动的sheet,active即使get_active_sheet
    # #active_sheet.sheet_properties.tabColor = "205EB2";#设置活动表颜色
    # active_sheet.append(["第一季度","第二季度","第三季度","第四季度"]);
    # for i in range(1,10):
    #     active_sheet.append([i*random.randint(1,10),i*random.randint(1,10),
    #                          i*random.randint(1,10),i*random.randint(1,10)])
    # workbook.save(filename="/Java/Python/upload/excel_test.xlsx");#文件保存


if __name__ == "__main__":
    write_excel();


