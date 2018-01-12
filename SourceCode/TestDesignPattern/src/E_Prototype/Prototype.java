package E_Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 *【原型模式】
 * @author liyb
 * 将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。
 */
public class Prototype implements Cloneable,Serializable{
	private static final long serialVersionUID = 1L;
	private String string;
	private SerializableObject obj;  
	
	/*浅复制：引用原对象*/
	public Object clone() throws CloneNotSupportedException{
		Prototype proto = (Prototype)super.clone();
		return proto;
	}
	
	/*深复制：重新创建引用*/
	public Object deepClone() throws IOException, ClassNotFoundException{
		/* 写入当前对象的二进制流 */
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		/*读出二进制产生的新对象*/
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
	
    public String getString() {  
        return string;  
    }  
  
    public void setString(String string) {  
        this.string = string;  
    }  
  
    public SerializableObject getObj() {  
        return obj;  
    }  
  
    public void setObj(SerializableObject obj) {  
        this.obj = obj;  
    }  
}

class SerializableObject implements Serializable{
	private static final long serialVersionUID = 1L;
}
