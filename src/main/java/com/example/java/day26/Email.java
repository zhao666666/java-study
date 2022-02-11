package com.example.java.day26;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Author: zhaojie
 * @Date: 2022/1/25 10:16
 * @Version: 1.0
 * @Description:
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/mail")
public class Email {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send")
    private void send(String from, String substring, String text, String... to) throws MessagingException {

        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人
        message.setFrom(from);
        // 收件人
        message.setTo(to);
        // 邮件标题
        message.setSubject(substring);
        // 邮件内容
        message.setText(text);
        // 抄送人
        // message.setCc("760314970@qq.com");
        mailSender.send(message);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setFrom("760314970@qq.com");
        messageHelper.setTo("760314970@qq.com");
        messageHelper.setSubject("Happy New Year");
        messageHelper.setText("新年快乐！");
        messageHelper.addInline("doge.gif", new File("xx/xx/doge.gif"));
        messageHelper.addAttachment("work.docx", new File("xx/xx/work.docx"));
        mailSender.send(mimeMessage);
    }
}
