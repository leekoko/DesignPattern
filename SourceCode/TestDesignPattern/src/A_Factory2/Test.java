package A_Factory2;
/**
 * 【多个工厂模式】
 * @author liyb
 *
 */
public class Test {  
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produceSms();   //通过调用不同的方法创建不同的类
        sender.Send();    //执行创建类的方法
    }  
}  
