package com.example.java.day23;

/**
 * @Author: zhaojie
 * @Date: 2022/1/18 14:00
 * @Version: 1.0
 * @Description:
 */
public class AppResources {

    private Object resourcePrinter = new Object();

    private Object resourceInput = new Object();

    public Object getResourcePrinter() {
        return resourcePrinter;
    }

    public void setResourcePrinter(Object resourcePrinter) {
        this.resourcePrinter = resourcePrinter;
    }

    public Object getResourceInput() {
        return resourceInput;
    }

    public void setResourceInput(Object resourceInput) {
        this.resourceInput = resourceInput;
    }
}
