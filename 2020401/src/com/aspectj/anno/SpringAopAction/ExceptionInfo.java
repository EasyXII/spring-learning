package com.aspectj.anno.SpringAopAction;

import java.util.Date;


public class ExceptionInfo {

    private String className;
    private String methodName;
    private Date logTime;
    private String message;

    public ExceptionInfo() {
    }

    public ExceptionInfo(String className, String methodName, Date logTime, String message) {
        this.className = className;
        this.methodName = methodName;
        this.logTime = logTime;
        this.message = message;
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

    @Override
    public String toString() {
        return "ExceptionInfo{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", logTime=" + logTime +
                ", message='" + message + '\'' +
                '}';
    }
}
