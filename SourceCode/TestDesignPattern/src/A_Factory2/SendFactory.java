package A_Factory2;
/**
 * 【工厂类】提供多个工厂方法，分别创建对象。
 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 * @author liyb
 *
 */
public class SendFactory {  
	public Sender produceMail(){  
	    return new MailSender();  
	}  
	public Sender produceSms(){  
	    return new SmsSender();  
	}  
} 

