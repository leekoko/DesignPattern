package D_Builder;
/**
 *【建造者模式】
 * @author liyb
 * 将各种产品集中起来进行管理，用来创建具有不同的属性的类
 */
public class Test {  
    public static void main(String[] args) {  
    	Builder builder = new Builder();
    	builder.produceMailSender(10);
    }  
}  
