# [JAVA]-互联网进阶



## 1.互联网技术

### <1>linux相关

#### linux基础

##### 1>有没有用过linux?你都用它来做什么？

​	Linux是一个长时间运行比较稳定的操作系统，所有我们一般会拿它作为服务器(web,db,app等)

​	Linux本身具有C的编译环境、我们的一些软件是没有软件包(redis、nginx等)的，需要在Linux的C编译环境编译得到软件包



##### 2>说一下linux下面的一下常用命令？

| 指令   | 说明          |
| ------ | ------------- |
| cd     | cd 跳转到目录 |
| su -u  | 切换到管理员  |
| ls     | ls 列举目录   |
| tail   | 查看          |
| rm -rf | 删除          |
| vi     | 编辑          |
| mkdir  |               |
|        |               |



##### 3>使用什么来连接远程的Linux服务器的？

​	需要依赖于Linux服务器安装ssh服务端，一般这个ssh服务的端口22

​	需要依赖于Linux服务器安装sftp服务端，一般这个sftp服务的端口25

 

​	使用ssh客户端连接linux服务器，就有点儿像windows下面的远程连接。但是linux通过ssh连接上以后是没有图形界面，全是命令行

​	Putty、Xshell

​	使用sftp客户端来连接sftp服务端，来上传和下载文件(上传安装包，修改了配置文件上传)

​	Winscp、xftp

 

企业中常用的两种组合:

   putty+winscp 

   Xshell+xftp=xmanager

​	使用xshell、putty等ssh客户端来连接服务器，使用xftp、winscp等sftp客户端来上传和现在文件。连接和上传、下载必须依赖于服务器的ssh、sftp服务，也就是linux服务器需要启动这两个服务



##### 4>



### <2>redis相关

#### redis基础

##### 1>redis基础概念

​	Redis是一个key-value的nosql数据库.先存到内存中，会根据一定的策略持久化到磁盘,即使断电也不会丢失数据。支持的数据类型比较多。

​	主要用来做缓存数据库的数据和web集群时当做中央缓存存放seesion



##### 2>mysql、redis与memcache的区别

|          | mysql  | redis      | memcache |
| -------- | ------ | ---------- | -------- |
| 类型     | 关系型 | 非关系型   | 非关系型 |
| 存储位置 | 磁盘   | 磁盘和内存 | 内存     |
| 存储过期 | 不支持 | 支持       | 支持     |
| 读写性能 | 低     | 非常高     | 非常高   |

​	redis和memcache都是将数据存放在内存中，都是内存数据库。不过memcache还可用于缓存其他东西，例如图片、视频等

​	redis不仅仅支持简单的k/v类型的数据，同时还提供list，set，hash等数据结构的存储

​	虚拟内存：redis当物理内存用完时，可以将一些很久没用到的value 交换到磁盘



##### 3>redis的应用场景

> <font color=red>缓存：</font>

​	把经常需要查询的、很少修改数据，放到读速度很快的空间(内存)，以便下次访问减少时间。减轻压力，减少访问时间

> <font color=red>计数器：</font>

​	redis中的计数器是原子性的内存操作	

​    可以解决库存溢出问题.进销存系统库存溢出

> <font color=red>session缓存服务器：</font>

​	web集群时作为session缓存服务器

><font color=red>缓存队列</font>



##### 4>redis对象保存方式

> <font color=red>json字符串</font>

需要把对象转换为json字符串，当做字符串处理。直接使用set、get来设置

优点：设置和获取比较简单

缺点：没有提供专门的方法，需要把对象转换为json(jsonlib)

> <font color=red>字节</font>

需要做序列号，就是把对象序列化为字节保存

如果是担心JSON转对象会消耗资源的情况，这个问题需要考量几个地方，

​	第一点：就是使用的JSON转换lib是否就会存在性能问题。

​	第二点：就是数据的数据量级别，如果是存储百万级的大数据对象，建议采用存储序列化对象方式。如果是少量的数据级对象，或者是数据对象字段不多，还是建议采用JSON转换成String方式

毕竟redis对存储字符类型这部分优化的非常好。具体采用的方式与方法，还要看你所使用的场景



##### 5>redis数据淘汰机制

​	在 redis 中，允许用户设置最大使用内存大小 server.maxmemory，在内存限定的情况下是很有用的。譬如，在一台 8G 机子上部署了 4 个 redis 服务点，每一个服务点分配 1.5G 的内存大小，减少内存紧张的情况，由此获取更为稳健的服务。

> 内存大小有限，需要保存有效的数据?

redis 内存数据集大小上升到一定大小的时候，就会施行数据淘汰策略

redis 提供 6种数据淘汰策略：

| 淘汰策略                   | 说明                                                         |
| -------------------------- | ------------------------------------------------------------ |
| volatile-lru               | 从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用的数据淘汰 |
| volatile-ttl               | 从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数据淘汰 |
| volatile-random            | 从已设置过期时间的数据集（server.db[i].expires）中任意选择数据淘汰 |
| allkeys-lru                | 从数据集（server.db[i].dict）中挑选最近最少使用的数据淘汰    |
| allkeys-random             | 从数据集（server.db[i].dict）中任意选择数据淘汰              |
| no-enviction<br />（驱逐） | 禁止驱逐数据                                                 |



##### 6>java访问redis

​	使用jedis java客户端来访问redis服务器，类似通过jdbc访问mysql概念

​	如果是spring进行集成时，可以使用spring data来访问redis,spring data只是对jedis的二次封装

​	jdbcTemplate、jdbc关系一样



##### 7>redis集群

​	当一台数据无法满足要求，可以使用reids集群来处理，类似于mysql的读写分离



##### 8>redis 为什么是单线程的？



##### 9>edis 和 redisson 有哪些区别？



##### 10>怎么保证缓存和数据库数据的一致性？



##### 11>redis 持久化有几种方式？



##### 12>redis 怎么实现分布式锁？



##### 13>redis 分布式锁有什么缺陷？



##### 14>redis 如何做内存优化？



### <3>中间件

#### RabbitMQ

1>rabbitmq 的使用场景有哪些？

2>rabbitmq 有哪些重要的角色？

3>rabbitmq 有哪些重要的组件？

4>rabbitmq 中 vhost 的作用是什么？

5>rabbitmq 的消息是怎么发送的？

6>rabbitmq 怎么保证消息的稳定性？

7>rabbitmq 怎么避免消息丢失？

8>要保证消息持久化成功的条件有哪些？

9>rabbitmq 持久化有什么缺点？

10>rabbitmq 怎么实现延迟消息队列？

11>rabbitmq 对集群节点停止顺序有要求吗？



#### Kafka

##### 1>kafka 可以脱离 zookeeper 单独使用吗？为什么？



##### 2>kafka 有几种数据保留的策略？



##### 3>kafka 同时设置了 7 天和 10G 清除数据，到第五天的时候消息达到了 10G，这个时候 kafka 将如何处理？



##### 4>什么情况会导致 kafka 运行变慢？



##### 5>使用 kafka 集群需要注意什么？



#### Zookeeper

##### 1>zookeeper 是什么？



##### 2>zookeeper 都有哪些功能？



##### 3>zookeeper 有几种部署模式？



##### 4>zookeeper 怎么保证主从节点的状态同步？



##### 5>集群中为什么要有主节点？



##### 6>集群中有 3 台服务器，其中一个节点宕机，这个时候 zookeeper 还可以使用吗？



##### 7>说一下 zookeeper 的通知机制？



## 2.应用服务器

### <1>weblogic

#### weblogic基础概念



##### 如何给weblogic指定大小的内存? 

　在启动Weblogic的脚本中（位于所在Domian对应服务器目录下的startServerName），增加set MEM_ARGS=-Xms32m -Xmx200m，可以调整最小内存为32M，最大200M



##### 如何设定的weblogic的热启动模式(开发模式)与产品发布模式?

可以在管理控制台中修改对应服务器的启动模式为开发或产品模式之一。或者修改服务的启动文件或者commenv文件，增加set PRODUCTION_MODE=true。



##### 如何启动时不需输入用户名与密码?

　修改服务启动文件，增加 WLS_USER和WLS_PW项。也可在boot.properties文件中增加加密过的用户名和密码



##### 在weblogic管理制台中对一个应用域(或者说是一个网站,Domain)进行jms及ejb或连接池等相关信息进行配置后,实际保存在什么文件中?

　保存在此Domain的config.xml文件中，它是服务器的核心配置文件。



##### 说说weblogic中一个Domain的缺省目录结构?比如要将一个简单的helloWorld.jsp放入何目录下,然的在浏览器上就可打入 http://主机:端口号//helloword.jsp就可以看到运行结果了? 又比如这其中用到了一个自己写的javaBean该如何办?

　Domain 目录服务器目录applications，将应用目录放在此目录下将可以作为应用访问，如果是Web应用，应用目录需要满足Web应用目录要求，jsp文件可以直接放在应用目录中，Javabean需要放在应用目录的WEB-INF目录的classes目录中，设置服务器的缺省应用将可以实现在浏览器上无需输入应用名。



##### 在weblogic中发布ejb需涉及到哪些配置文件

　不同类型的EJB涉及的配置文件不同，都涉及到的配置文件包括ejb-jar.xml,weblogic-ejb-jar.xmlCMP实体Bean一般还需要weblogic-cmp-rdbms-jar.xml 



##### 如何在weblogic中进行ssl配置与客户端的认证配置或说说j2ee(标准)进行ssl的配置

　缺省安装中使用DemoIdentity.jks和DemoTrust.jks  KeyStore实现SSL，需要配置服务器使用Enable SSL，配置其端口，在产品模式下需要从CA获取私有密钥和数字证书，创建identity和trust keystore，装载获得的密钥和数字证书。可以配置此SSL连接是单向还是双向的。



##### 如何查看在weblogic中已经发布的EJB?

可以使用管理控制台，在它的Deployment中可以查看所有已发布的EJB



##### 说说在weblogic中开发消息Bean时的persistent与non-persisten的差别

　persistent方式的MDB可以保证消息传递的可靠性,也就是如果EJB容器出现问题而JMS服务器依然会将消息在此MDB可用的时候发送过来，而non－persistent方式的消息将被丢弃。













