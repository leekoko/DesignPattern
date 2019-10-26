# 享元模式

前提摘要：当系统中有大量对象时，会消耗内存。而许多对象其实是共用的，为了重复利用这些对象，引入的享元模式。

特点：使用HashMap将对象存储起来，在new对象之前检查是否可复用。

















## 源码解析

Integer/Long  --  valueOf

tomcat的GenericKeyObjectPoolConfig -- borrowObject