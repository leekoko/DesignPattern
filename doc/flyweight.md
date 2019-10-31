# 享元模式

前提摘要：当系统中有大量对象时，会消耗内存。而许多对象其实是共用的，为了重复利用这些对象，引入的享元模式。

特点：使用HashMap将对象存储起来，在new对象之前检查是否可复用。

缺点：提高系统复杂度，需要区分外部状态和内部状态，否则会造成线程安全问题。

核心代码如下：

对象获取工厂

```java
public class EmployeeFactory {
    private static final Map<String, Employee> EMPLOYEE_MAP = new HashMap<String, Employee>();

    public static Employee getManager(String department){
        Manager manager = (Manager) EMPLOYEE_MAP.get(department);
        if (manager == null) {
            manager = new Manager(department);
            
            System.out.print("创建部门经理："+department);
            String reportContent = department + "部门汇报：此处报告主要内容是...";
            manager.setReportContent(reportContent);
            System.out.println(" 创建报告："+reportContent);
            
            EMPLOYEE_MAP.put(department, manager);
        }
        return manager;
    }

}
```

















[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\structural\facade)    



## 源码解析

Integer/Long  --  valueOf

tomcat的GenericKeyObjectPoolConfig -- borrowObject