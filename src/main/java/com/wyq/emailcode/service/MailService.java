package com.wyq.emailcode.service;

/**
 * @ClassName MailService
 * @Description: //TODO
 * @Author wyq
 * @Date 2022/4/18 21:50
 */
public interface MailService {
    //发送邮件
    boolean sendMail(String email, String text);
}


