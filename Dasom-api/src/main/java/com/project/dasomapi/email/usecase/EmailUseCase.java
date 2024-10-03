package com.project.dasomapi.email.usecase;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.email.handler.req.SendEmailReq;
import com.project.dasomapi.email.handler.req.VerifyEmailReq;
import com.project.dasomcore.mail.application.EmailService;
import com.project.dasomcore.mail.domain.exception.InvalidEmailCodeException;
import com.project.dasomcore.mail.domain.exception.SendEmailException;
import com.project.dasomcore.member.application.MemberService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component
@RequiredArgsConstructor
public class EmailUseCase {

    private static final String MAIL_TITLE_CERTIFICATION = "안녕하세요~ 다솜입니다.다솜의 회원이 돼주셔서 감사합니다! 인증번호를 확인해주세요 ";
    private final JavaMailSender mailSender;
    private final MemberService memberService;
    private final EmailService emailService;

    public Response sendEmail(SendEmailReq req) {
        memberService.checkEmailExists(req.email());

        try{
            String code = createCode();
            String contentToSend = String.format("반가워요,다솜입니다:D \n 이메일 인증번호 : %s" , code);
            String email = req.email();

            emailService.save(email,code);
            sendMail(email,contentToSend);
            return Response.created("이메일 전송 성공");
        } catch(Exception e){
            throw new SendEmailException();
        }
    }

    public Response verifyEmail(VerifyEmailReq req) {
        if (!emailService.verifyEmailByCode(req.email(), req.code()))
            throw new InvalidEmailCodeException();

        emailService.removeCode(req.email());

        return Response.ok("이메일 인증 성공");
    }

    private String createCode() throws NoSuchAlgorithmException {
        String code;

        do {
            int num = SecureRandom.getInstanceStrong().nextInt(999999);
            code = String.valueOf(num);
        } while (code.length() != 4);

        return code;
    }

    private void sendMail(String email, String content) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setTo(email);
        helper.setSubject(MAIL_TITLE_CERTIFICATION);
        helper.setText(content);
        mailSender.send(mimeMessage);
    }

}
