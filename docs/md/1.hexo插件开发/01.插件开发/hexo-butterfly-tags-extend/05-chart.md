# highcharts

> 变更记录

| 开发 | 内容 |
| ---- | ---- |
|      |      |



## 1.构建思路

​	图表构建：[chart.js](https://www.chartjs.org/docs/latest/)，插件构建参考：[hexo-tag-chart](https://github.com/shen-yu/hexo-tag-chart)

​	Chartjs 是一款简单优雅的数据可视化工具，对比其他图表库如 ECharts、Highcharts、C3、Flot、amCharts 等，它的画面效果、动态效果都更精致，它的 文档首页 就透出一股小清新，基于 HTML5 Canvas，它拥有更好的性能且响应式，基本满足了一般数据展示的需要，包括折线图，条形图，饼图，散点图，雷达图，极地图，甜甜圈图等。

​	参考[chart.js官方说明](https://www.chartjs.org/docs/latest/)，其最主要的引用思路说明如下所示

```js
<1>html：视图控制
- 定义存放chart图表的容器（通过在html中引入即可:相关css、js嵌入）
<div>
  <canvas id="myChart"></canvas>
</div>

<2>JS控制：功能控制
// 引入chart.js
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
// 封装数据至option参数配置，封装完成最后调用highcharts提供的方法装载图表信息
<script>
  const config = {
    type: 'line',
    data: data,
    options: {}
  };
  const myChart = new Chart(document.getElementById('myChart'),config);
</script>
```



## 2.构建说明

```properties
|-- lib/scripts/chart
		|_ chart.js
|-- lib/assets/template
		|_ template_chart.html
|-- index.js
|-- package.json
```

- 依赖："lodash": "^4.17.19"



## 3.使用说明

> 语法说明
>
> {% chart [相对宽度],[高度] %}属性配置JSON{% endchart %}

```markdown
{% chart 90%,300 %}
	// config参数
	{
    type: 'line',
    data: data,
    options: {}
  }
{% endchart %}
```

> 样例测试

```markdown
{% chart 90%,300 %}
{
    type: 'bar',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
}
{% endchart %}
```

