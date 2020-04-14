package com.huodong3;

public class Student extends Phone{
  private String name;
  private int age;
  private Phone phone;
  public Student(String name,int age,Phone phone) {
	  this.phone = phone;
	  this.name = name;
	  this.age = age;
  }
  public Student() {
	  super();
  }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String toString() {
	return "Student [name = " + name + "  age = " + age + " phone = "+ phone.getBrand() +"]";
}
}
