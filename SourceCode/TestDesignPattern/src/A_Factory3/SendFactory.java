package A_Factory3;
/**
 * 【工厂类】方法置为静态的，不需要创建实例，直接调用即可。
 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 * @author liyb
 *
 */
public class SendFactory {  
	public static Sender produceMail(){  
	    return new MailSender();  
	}  
	public static Sender produceSms(){  
	    return new SmsSender();  
	}  
} 

