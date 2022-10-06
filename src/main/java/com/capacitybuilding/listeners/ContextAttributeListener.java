package com.capacitybuilding.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ContextAttributeListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("Added Event name:\t{"+event.getName()+",event value: \t"+event.getValue()+"}");
    }
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("Removed Event name: \t{"+event.getName()+", event value: \t"+event.getValue()+"}");
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("Replaced Event name: \t{"+event.getName()+", event value: \t"+event.getValue()+"}");
    }
}
