package com.niit.anno1;

public class Max {
     private int a;
     private int b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
     public int getMax() {
		if(a>b) {
			return a;
		}else {
			return b;
		}
     }
}
