package cycle;
import org.springframework.beans.factory.BeanNameAware;
public class Student implements BeanNameAware{
    private String name;
    public Student() {
	     super();
    }
    public void setName(String name) {
    	System.out.println("设置对象属性setName()..");
        this.name = name;
    }
    public void initStudent() {
    	System.out.println("Student这个Bean：初始化");
    }
    public void destroyStudent() {
    	System.out.println("Student这个Bean：销毁");
    }
    public void play() {
    	System.out.println("Student这个Bean：使用");
    }
    public String toString() {
    	return "Student [name = " + name + "]"; 
    }
    public void setBeanName(String name) {
    	System.out.println("调用BeanNameAware的setBeanName()...");
    }
}
