# showText

## 1.index.js

​	该方式直接在index.js中构建即可正常引入

```
// 定义函数
function addText (args, content) {
  const text = args[0] || 'non'

  console.log("showText Plugin");
  return `<h1>${text}</h1>`;

}
// 注册插件
hexo.extend.tag.register('showText', addText, { ends: false })
```



## 2.Use

> 语法规则

```
{% showText [文本内容] %}
```



> 样例测试

```
{% showText hello %}
```

