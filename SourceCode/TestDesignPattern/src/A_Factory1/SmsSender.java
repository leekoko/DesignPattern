package A_Factory1;
/**
 * 短信服务类
 * @author liyb
 *
 */
public class SmsSender implements Sender {  //继承于共同的功能接口
    @Override  
    public void Send() {  
        System.out.println("这是短信服务!");     
    }  
    
}  