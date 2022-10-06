package com.capacitybuilding.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("Added request attribute name:\t{"+event.getName()+",event value: \t"+event.getValue()+"}");
    }

    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("Removed request attribute name: \t{"+event.getName()+", event value: \t"+event.getValue()+"}");
    }

    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println("Replaced request attribute name: \t{"+event.getName()+", event value: \t"+event.getValue()+"}");
    }
}