# echarts

> 变更记录

| 开发 | 内容 |
| ---- | ---- |
|      |      |



## 1.构建思路

​	图表构建：[echarts](https://echarts.apache.org/zh/index.html)

​	Apache ECharts，一个基于 JavaScript 的开源可视化图表库，[快速入门](https://echarts.apache.org/handbook/zh/get-started)、[所有示例](https://echarts.apache.org/examples/zh/index.html)

​	其最主要的引用思路说明如下所示

```js
<1>html：视图控制
- 定义存放echarts图表的容器（通过在html中引入即可:相关css、js嵌入）
<div>
    <div id="main" style="width: 600px;height:400px;"></div>
</div>

<2>JS控制：功能控制
// 引入echarts.js
<script src="https://cdn.bootcss.com/echarts/5.3.0/echarts.min.js"></script>
// 封装数据至option参数配置，封装完成最后调用highcharts提供的方法装载图表信息
<script>
  // 基于准备好的dom，初始化echarts实例并装载图表
  var myChart = echarts.init(document.getElementById('main'));
  const option = {...};
  myChart.setOption(option);
</script>
```



## 2.构建说明

```properties
|-- lib/scripts/chart
		|_ echarts.js
|-- lib/assets/template
		|_ template_echarts.html
|-- index.js
|-- package.json
```

- 依赖："underscore": "^1.8.3"



## 3.使用说明

> 语法说明
>
> {% chart [相对宽度],[高度] %}属性配置JSON{% endchart %}

```markdown
{% echarts 90%,300 %}
	// 参数配置
{% endecharts %}
```

> 样例测试

```markdown
{% echarts 400,'90%' %}
{
    tooltip: {
        trigger: 'axis'
    },
    xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: [820, 932, 901, 934, 1290, 1330, 1320],
        type: 'line'
    }]
};
{% endecharts %}
```

