package C_Singleton;
/**
 * 【简单单例类】
 * @author liyb
 * 单例模式    不理解，学习到了一半
 *
 */
public class Singleton2 {  
    
    /* 私有构造方法，防止被实例化 */  
    private Singleton2() {  
    }  
  

    /* 此处使用一个内部类来维护单例 */  
	private static class SingletonFactory {  
		private static Singleton2 instance = new Singleton2();  
	}  


    /* 静态工程方法，创建实例 */  
    public static Singleton2 getInstance() {    
    	return SingletonFactory.instance;  
    }  
  
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return getInstance();  
    }  
}  