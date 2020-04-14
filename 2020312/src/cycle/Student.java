package cycle;
import org.springframework.beans.factory.BeanNameAware;
public class Student implements BeanNameAware{
    private String name;
    public Student() {
	     super();
    }
    public void setName(String name) {
    	System.out.println("���ö�������setName()..");
        this.name = name;
    }
    public void initStudent() {
    	System.out.println("Student���Bean����ʼ��");
    }
    public void destroyStudent() {
    	System.out.println("Student���Bean������");
    }
    public void play() {
    	System.out.println("Student���Bean��ʹ��");
    }
    public String toString() {
    	return "Student [name = " + name + "]"; 
    }
    public void setBeanName(String name) {
    	System.out.println("����BeanNameAware��setBeanName()...");
    }
}
