package B_AbstractFactory;
/**
 *【抽象工厂模式】
 * @author liyb
 * 拓展性较好，直接通过new类来选择对象，而该类继承于同一接口。
 * 一次继承是由于功能相似，一次继承由于都是返回实例对象
 */
public class Test {  
    public static void main(String[] args) {  
        Provider provider = new SendMailFactory();  
        Sender sender = provider.produce();  
        sender.Send();  
    }  
}  
