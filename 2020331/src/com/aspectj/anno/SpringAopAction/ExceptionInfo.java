package com.aspectj.anno.SpringAopAction;

import java.util.Date;
/**
 * ��װ�쳣��Ϣ����
 */
public class ExceptionInfo {
    private String className;
    private String methodName;
    private Date logTime;//�쳣��¼ʱ��
    private String message;//�쳣��Ϣ
    
    public ExceptionInfo() {
    	
    }

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
