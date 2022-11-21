package com.capacitybuilding.mail.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote
@Named("mailBean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MailBean implements MailBeanI{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void sendMail() {
        System.out.println("Sending mail");
    }
}
