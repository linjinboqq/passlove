package cn.edu.cqupt.nmid.passloveserver.v1.service.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @author MrWangx
 * @time 2018-10-26
 * */
@Service
public class MailService {

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送邮件
     * @param to 收件人邮箱列表
     * @param title 邮箱主题
     * @param content 邮箱内容
     * */
    public void sendMail(String[] to, String title, String content) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
    }
}
