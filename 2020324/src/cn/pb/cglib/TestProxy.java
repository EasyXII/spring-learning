package cn.pb.cglib;

public class TestProxy {

	public static void main(String[] args) {
		//创建代理对象
		AnimalCglibDynamicProxy animalCglibDynamicProxy = new AnimalCglibDynamicProxy();
		//创建目标对象
		Dog dog = new Dog();
		//获取增强后的目标对象
		Dog dog1 = (Dog)animalCglibDynamicProxy.createProxy(dog);
		dog1.eat();
		System.out.println("***************************");
		dog1.sleep();
	}

}
