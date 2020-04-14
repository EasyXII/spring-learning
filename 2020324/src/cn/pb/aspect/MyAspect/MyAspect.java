package cn.pb.aspect.MyAspect;
//切面类
public class MyAspect {
	public void before() {
    	System.out.println("主人在召唤！！");
    }
    public void next() {
    	System.out.println("主人离开！！");
    }
}
