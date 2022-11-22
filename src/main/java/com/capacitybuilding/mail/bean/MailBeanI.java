package com.capacitybuilding.mail.bean;

import com.capacitybuilding.mail.model.MailWrapper;

public interface MailBeanI {


    void sendMail(MailWrapper mail) throws Exception;


}
