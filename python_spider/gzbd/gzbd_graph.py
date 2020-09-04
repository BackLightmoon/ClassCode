#!/user/bin/env python3
# -*- coding: utf-8 -*-
__author__ ="BackLightmoon";

'''
graph test
'''

import plotly;
import gzbd.gzbd_storage;

def draw_line_graph():
    result = gzbd.gzbd_storage.get_gzbd_data();
    x = [];
    y_diagnosis = [];
    y_cure = [];
    y_death = [];
    for i in range(1,len(result)+1):
        if i < 8 :
            item = result[i];
            x.append(item[2]);
            y_diagnosis.append(item[3]);
            y_cure.append(item[5]);
            y_death.append(item[6]);

    #准备图轨数据
    trace_1=plotly.graph_objs.Scatter(
        x=x,
        y=y_cure,
        name="治愈数",
    );
    trace_2 = plotly.graph_objs.Scatter(
        x=x,
        y=y_diagnosis,
        name="确诊数",
    );
    trace_3 = plotly.graph_objs.Scatter(
        x=x,
        y=y_death,
        name="死亡数",
    );
    line_data = [trace_1,trace_2,trace_3];
    #设置画布布局
    layout = plotly.graph_objs.Layout(title="gzbd折线图",xaxis={"title":"时间"},yaxis={"title":"数量"});
    #融合图轨数据和布局
    figure = plotly.graph_objs.Figure(data=line_data,layout=layout);
    #输出
    plotly.offline.plot(figure,filename="/Java/Python/upload/line_graph.html");#,image="png"

def draw_bar_graph():
    # 准备图轨数据
    trace_1 = plotly.graph_objs.Bar(
        x=[1, 2, 3, 4],
        y=[32, 45, 50, 65],
        name="第一产业",
    );
    trace_2 = plotly.graph_objs.Bar(
        x=[1, 2, 3, 4],
        y=[36, 23, 18, 54],
        name="第二产业",
    );
    trace_3 = plotly.graph_objs.Bar(
        x=[1, 2, 3, 4],
        y=[54, 44, 11, 66],
        name="第三产业",
    );
    trace_4 = plotly.graph_objs.Bar(
        x=[1, 2, 3, 4],
        y=[54,34, 17, 33],
        name="第四产业",
    );
    bar_data = [trace_1, trace_2,trace_3,trace_4];
    # 设置画布布局
    layout = plotly.graph_objs.Layout(title="柱状图测试", xaxis={"title": "季度"}, yaxis={"title": "产值"});
    # 融合图轨数据和布局
    figure = plotly.graph_objs.Figure(data=bar_data, layout=layout);
    # 输出
    plotly.offline.plot(figure, filename="/Java/Python/upload/bar_graph.html", image="png");


def draw_pie_graph():
    # 准备图轨数据
    trace_1 = plotly.graph_objs.Pie(
        labels=["产品一","产品二","产品三","产品四","产品五"],
        values=[13.4,26.4,33.2,15.3,48.7]
    );
    pie_data = [trace_1];
    # 设置画布布局
    layout = plotly.graph_objs.Layout(title="饼图测试");
    # 融合图轨数据和布局
    figure = plotly.graph_objs.Figure(data=pie_data, layout=layout);
    # 输出
    plotly.offline.plot(figure, filename="/Java/Python/upload/pie_graph.html");#, image="png"


if __name__ =="__main__":
    draw_line_graph();
    #draw_bar_graph()
    #draw_pie_graph();


