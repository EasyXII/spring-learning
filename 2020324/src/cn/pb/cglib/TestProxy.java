package cn.pb.cglib;

public class TestProxy {

	public static void main(String[] args) {
		//�����������
		AnimalCglibDynamicProxy animalCglibDynamicProxy = new AnimalCglibDynamicProxy();
		//����Ŀ�����
		Dog dog = new Dog();
		//��ȡ��ǿ���Ŀ�����
		Dog dog1 = (Dog)animalCglibDynamicProxy.createProxy(dog);
		dog1.eat();
		System.out.println("***************************");
		dog1.sleep();
	}

}
