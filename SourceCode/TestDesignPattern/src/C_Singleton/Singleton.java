package C_Singleton;
/**
 * 【简单单例类】
 * @author liyb
 * 单例模式缺陷版：
 * instance = new Singleton();语句是分两步执行的。但是JVM并不保证这两个操作的先后顺序导致出错
 */
public class Singleton {  
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */  
    private static Singleton instance = null;  
    
    /* 私有构造方法，防止被实例化 */  
    private Singleton() {  
    }  
  
    /* 静态工程方法，创建实例 */  
    public static Singleton getInstance() {    
        if (instance == null) {         //添加判断是因为只有第一次需要线程锁，优化性能
        	synchronized (instance) {      //synchronized防止多线程出错  
        		if (instance == null) {  
        			instance = new Singleton();  
        		}
        	}
        }  
        return instance;  
    }  
  
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return instance;  
    }  
}  