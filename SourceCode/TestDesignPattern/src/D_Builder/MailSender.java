package D_Builder;

/**
 * 邮箱类
 * @author liyb
 *
 */
public class MailSender implements Sender {    //继承于共同的功能接口  
    @Override  
    public void Send() {  
        System.out.println("这是邮箱服务!");  
    }  
    
}  
