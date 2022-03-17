# asciinema

> 变更记录

| 开发 | 内容 |
| ---- | ---- |
|      |      |



## 1.构建思路

​	asciinema是Linux系统下一款终端会话记录和回放的神器, 它是一个在终端下录制分享软件，基于文本的录屏工具，对终端输入输出进行捕捉， 然后以文本的形式来记录和回放，且在观看过程中可随时暂停视频并执行复制代码或者其他操作。

> 原理分析

​	asciinema 项目由几个互补部分构成：

- 基于命令行的终端会话记录器asciinema
- 具有asciinema.org API的网站
- javascript播放器

​	将终端的操作记录成 JSON 格式，然后使用 JavaScript 解析，配合CSS展示，从而模拟视频播放器。但实际上对应的文件就是文本信息，且相比GIF和视频文件体积非常小，无需缓冲播放，便于分享、嵌入到个人网站中



## 2.构建说明

```properties
|-- lib/scripts/tags  
		|_ asciinema.js
|-- index.js
```

​	而针对已有的asciinema资源的嵌入可有图片、视频、gif等方式嵌入



## 3.使用说明

> 语法规则

```properties
{% asciinema [config] [video_id] %}
- config:1-图片形式嵌入；2-视频形式嵌入
- video_id:对应视频编号
```

> 样例测试（注意区分逗号和空格的区别）

```markdown
{% asciinema 1 veDYZYfs2L2lNnEPBbFoLkrq7 %}
{% asciinema 2 veDYZYfs2L2lNnEPBbFoLkrq7 %}
```

