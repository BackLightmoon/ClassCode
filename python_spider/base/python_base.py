#!/user/bin/env python3
# -*- coding: utf-8 -*-
__author__ ="BackLightmoon";

"""
python base demo
"""

import re,math;
import mysql_util;
#===  输入输出 ====
#name = input();控制台输出
#print(name);
a=11;
b="hujiang";
print(a);
print("hello world");
print("hello","world","hyman");#自动拼接，并且自动在字符中间加空格
print("hello %s"%a);
print("hello %s"%(a,));
print("hello %s - %s"%(a,b));

#======数据类型======
a=11;
print("a=%s,数据类型: %s"%(a,type(a)));
a=11.11;
print("a=%s,数据类型: %s"%(a,type(a)));
a="adadadadassd";
print("a=%s,数据类型: %s"%(a,type(a)));
a=None;
print("a=%s,数据类型: %s"%(a,type(a)));
a=True or False;
print("a=%s,数据类型: %s"%(a,type(a)));
a=['aaa',123,12.3];
print("a=%s,数据类型: %s"%(a,type(a)));
a=("csdas",32,33.3);
print("a=%s,数据类型: %s"%(a,type(a)));
a={"name":"hujiang","age":"66"};
print("a=%s,数据类型: %s"%(a,type(a)));
a =set(["cds",True,None,212,22.3]);
print("a=%s,数据类型: %s"%(a,type(a)));

#==== 运算符 =====
print((2+44/12)*3);
print(15 // 2);#地板除，取整
print(12 % 5);#求余
print( 2 ** 3);#乘方

#==== 字符串 ====
print(u'中文');#后面是字符串是以Unicode编码
print(r'中文');#后面字符串是普通字符串
print(b'casda');#后面是bytes


#==== ASCII转换 ====
print("98 --> %s,a --> %s"%(chr(98),ord('a')));

#==== encode&decode =====
print("cascsad".encode("ascii"));
print("胡江".encode("utf-8"));
print(b'cascsad'.decode("ascii"));
print(b'\xe8\x83\xa1\xe6\xb1\x9f'.decode("utf-8"));

#==== function =====
print(len("dsadafasdasd"));#对str计算字符数
print(len("中文"));#对str计算字符数
print(len("dsadafasdasd".encode("utf-8")));#对bytes计算字符节数
print(len("中文".encode("utf-8")));#对bytes计算字符节数--可见utf-8中一个中文占3个字符

#=====replace & find & isspace=======
print("daffhhasdashhfasdahhsdashhdadhhas".replace("hh","--"));#替换
print("daffhhasdashhfasdahhsdashhdadhhas".find("hh"));#查看个数
print("daffhhasdashhfasdahhsdashhdadhhas".rfind("hh"));#查看最后一次出现的下标
print(" ".isspace());#查看字符串是否是空格
print("fasdcasda".isspace());
print("%s----%2d----%02d"%(11,4,3));#%2d ：前面补两个空格 %02d：占2位，前面补0
print("%f ----- %.2f"%(32.12512,15646.11654566));#%.2f保留两位小数
print("%x"%333);#格式化为十六进制
print("%s %% %s"%(5,3));#输出5%3，中间两个%相当于java里的转义字符
print(list("%s" % x for x in range(1,10)));#range给定一个范围,遍历它,然后加到list中
print("Hi {0},成绩提高了{1:.1f}%".format("小明",1.254));
print("Hi {0},成绩提高了{1}%".format("小明","%.1f"%1.254));
print("今年第一季度GDP提高了%.2f"%(22.234,));
print("=".join(["dasda","dadasd","gdgsfd"]));

#==== 正则表达式 =====
email_re = "^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$";
if re.match(email_re, "hujiangux@163.com"):    #查看是否匹配
    print("ok");
else:
    print("error")


#====  切分字符串  ========
print("a b c".split(" "))
print(re.split(r"\s+","a b c "));
print(re.split(r"[\s\,\;]+","a,b;; c   d"));

#==== 分组======
match=re.match(r'^(\d{3})-(\d{3,8})$',"020-123456");
print(match.group());
print(match.group(0));
print(match.group(1));
print(match.group(2));
news_line=r'截至9月2日0时，全省累计报告新型冠状病毒肺炎确诊病例653例(其中境外输入112例），' \
  r'累计治愈出院626例，死亡3例，目前在院隔离治疗24例，964人尚在接受医学观察';
news_line_re=r'^截至9月2日0时，全省累计报告新型冠状病毒肺炎确诊病例(\d+)例\(其中境外输入(\d+)例\），' \
  r'累计治愈出院(\d+)例，死亡(\d+)例，目前在院隔离治疗(\d+)例，(\d+)人尚在接受医学观察$';
news_line_match=re.match(news_line_re,news_line);
print(news_line_match.group(0));
print(news_line_match.group(1));
print(news_line_match.group(2));
print(news_line_match.group(3));
print(news_line_match.group(4));
print(news_line_match.group(5));
print(news_line_match.group(6));
news_line_compile=re.compile(news_line_re);
print(re.search(news_line_compile,news_line).group(1));
print(re.search(news_line_compile,news_line).group(2));
print(re.search(news_line_compile,news_line).group(3));
print(re.search(news_line_compile,news_line).group(4));
print(re.search(news_line_compile,news_line).group(5));
print(re.search(news_line_compile,news_line).group(6));

#====贪婪匹配=====
print(re.match(r"^(\d+?)(0*)$","102300").group());#('1023','00')

#===== list&tuple =====
l=["cdsa",32,32.3,None,True];
print(l);
l2 =list(range(1,10));
print(l2);
l.append("hujiang");#尾部添加元素
print(l);
l.insert(2,"hyman");#指定下标位置添加元素
print(l);
l.pop();#如果没写下标就从尾部开始删除
print(l);
l.pop(2);#指定下标为2的元素删除
print(l);
l+=l2;#两个list合并
print(l);
l.append(l2);#添加元素
print(l);
l[0]="qqqq";#设置指定位置的值
print(l);
t =("aaa",12,12.3,True,None);#元祖不可变除了下面这种情况
l=list(range(1,10));
t2=("aaa",12,12.3,True,None,l);#不能改变元祖里的元素，但是可以修改list里面的值
l[1]=22;#不能整体的修改对象l，但是可以修改对象里可变的值
print(t2);
t3=tuple(range(1,10));#也可以这样来定义元祖
print(t3);
print((0));#
print((0,));#定义只有一个元素的元祖，在元素后面加“,”，以免误解成数学意义上的括号


#==== dict & set =====
d = {"name":"hujiang","age":33};
print(d.get("name","aaaaa"));#取name对应的值，如果没有则返回为none，也可以自己定义返回值如aaaaa
d["name"]="hyman";#改值
d["aaa"]="111dase";#增加
print(d)
d.pop("aaa");#删值
print(d);
print(len(d));#长度

s =set(["cds",True,None,212,22.3]);
s2={"cds",212,22.22,"csdasfasd"};
s.add("hyman");#新增是无序的
print(s);
s.pop();#默认从首位开始删除
print(s);
#s.remove(1);
print(s);
print(s & s2);
print(s | s2);

#==== 判断语句 ======
a = 20;
if a < 10:
   print("aaa");
elif 10 <= a <= 20:
    print("bbb");
else:
    print("cccc");

#===== 三目运算符 ======
a, b, c =1, 2, 3;
print(a if b > c else c);

#=====循环语句=========
l=list(range(1,10));
for i in l:
    print(i);
i=0;
while(i < 10):
    print(i);
    i=i+1;

#=== 函数 =====
def test(a):#自定义的变量不能与函数名相同，括号内为参数
    a+=3;#函数体
    return a;#如果有返回值则return
f=test(3);
print(test(3));
print(f);

if __name__ =="__main__":
    print(test(5));

def test_2(x,y="hujiang"):
    print(x,y);

def test_3(*num):
    count=0;
    for i in num:
        count +=i;
    return count;

def test_4(name,**kv):
    if "city" in kv:
        print("name:%s,city:%s"%(name,kv.get("city")));
    else:
        print("name:%s,city:%s" % (name,"sichuang"));

def test_5(name,*,city):
    #if not isinstance(name,(str,)):
    #raise TypeError("Type error");#自定义异常
    print("name:%s,city:%s"%(name,city))

if __name__ =="__main__":
    test_2("hello","hyman");
    test_2("hello");
    print(test_3());
    print(test_3(1,2,3,4,5 ));
    test_4("hujiang",**{"age":33});
    test_4("hujiang", **{"age": 33,"city":"cd"});
    #test_5("hujiang",city="cd");


# ==== 内置函数 ====
print(int("22")); # 数据类型转换函数，注意，如果定义变量名和函数名一样，则不会调用该函数，会报错
print(float("22.2"));
print(str(22));
print(abs(-111)); # abs函数，求绝对值
print(max(12, 34, 123.4)); # max函数，求最大值
print(min(-21, -11, 0, 22.3)); # min函数，求最小值
print(" aa bb  cc  ".strip()); # 字符串去前后空格
print("['6K-8K']".strip('[\'\']')); # 移除字符串头尾指定的字符
print(hex(12)); # hex函数，将十进制数转十六进制
print(math.sqrt(3)); # 求平方根
print(sum(range(1, 101))); # 求和
print(sum(list(range(101))));
print("cdaDcdsa".capitalize()); # 将字符串第一个字符变成大写，其他小写

