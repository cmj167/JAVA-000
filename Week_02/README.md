学习笔记
Week02 作业题目（周四）：

1.使用 GCLogAnalysis.java 自己演练一遍串行 / 并行 /CMS/G1 的案例。

日志详见gc_log，gc日志分析如下：
- 串行
> 当xms与xmx设置为512时，发生了17次gc，2次full gc；当xms与xmx设置为1024时，发生了12次gc，0次full gc；当xms与xmx设置为2048时，发生了5次gc，0次full gc；当xms与xmx设置为4096时，发生了2次gc，0次full gc；
- 并行
> 当xms与xmx设置为512时，发生了24次gc，11次full gc；当xms与xmx设置为1024时，发生了21次gc，1次full gc；当xms与xmx设置为2048时，发生了8次gc，0次full gc；当xms与xmx设置为4096时，发生了4次gc，0次full gc；
- CMS
> 当xms与xmx设置为512时，发生了21次gc，11次full gc；当xms与xmx设置为1024时，发生了14次gc，2次full gc；当xms与xmx设置为2048时，发生了6次gc，1次full gc；当xms与xmx设置为4096时，发生了5次gc，0次full gc；
- G1
> 当xms与xmx设置为512时，发生了34次gc，0次full gc；当xms与xmx设置为1024时，发生了14次gc，0次full gc；当xms与xmx设置为2048时，发生了10次gc，0次full gc；当xms与xmx设置为4096时，发生了14次gc，0次full gc；前四次均无出现full gc，将xmx与xms设为256，此时发生oom，查看日志，发现39次gc，16次full gc。==**比较疑惑的是为什么xms与xmx设置为4096时，运行结果与1024时是一样的，没有出现老师说的完全不一样的情况?**==


2.使用压测工具（wrk 或 sb），演练 gateway-server-0.0.1-SNAPSHOT.jar 示例。

3.（选做） 如果自己本地有可以运行的项目，可以按照 2 的方式进行演练。  
4.（必做） 根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 的总结，提交到 Github。  
[不同gc总结](http://note.youdao.com/s/VnNACFra)

Week02 作业题目（周六）：

1.（选做）运行课上的例子，以及 Netty 的例子，分析相关现象。  

2.（必做）写一段代码，使用 HttpClient 或 OkHttp 访问 http://localhost:8801 ，代码提交到 Github。

代码详见必做题2文件夹,笔记如下  
[http与okhttp调用说明](http://note.youdao.com/s/4uC8WRIo)