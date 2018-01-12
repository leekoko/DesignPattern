package D_Builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {      
	private List<Sender> list = new ArrayList<Sender>();  
      
	public void produceMailSender(int count){  
		for(int i=0; i<count; i++){  //工厂模式关注的是创建单个产品，而建造者模式则关注创建符合对象，多个部分。
			list.add(new MailSender());  
		}
		for (Sender s : list) {
			s.Send();
		}
	}  
      
	public void produceSmsSender(int count){  
		for(int i=0; i<count; i++){  
			list.add(new SmsSender());  
		}
		for (Sender s : list) {
			s.Send();
		}
	}  
}  
