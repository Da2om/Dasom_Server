package com.project.dasomcore.mail.application;

import com.project.dasomcore.mail.domain.exception.EmailNotFoundException;
import com.project.dasomcore.mail.repo.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final MailRepository mailRepository;

    public void save(String email,String code){
        mailRepository.saveCode(email,code);
    }

    public boolean verifyEmailByCode(String email, String code) {
        boolean validatedEmail = checkEmailExists(email);
        if (!checkEmailExists(email))
            throw new EmailNotFoundException();

        return (validatedEmail &&
                mailRepository.getCode(email).equals(code));
    }

    public void removeCode(String email) {
        mailRepository.removeCode(email);
    }

    private boolean checkEmailExists(String email) {
        return mailRepository.hasKey(email);
    }
}
