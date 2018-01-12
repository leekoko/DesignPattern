package A_Factory1;
/**
 * 【普通工厂模式】
 * @author liyb
 *
 */
public class Test {  
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produce("msss");    //指定实例化的类
        sender.Send();    //调用实例化的类里面的方法
    }  
}  
