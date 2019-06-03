package com.socibby.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Aspect
@Component
public class LoggingOperations {

    private static final Logger logger = Logger.getLogger(LoggingOperations.class);

    @After("execution(* com.socibby.service.UserService.insertUser(..))")
    public void registerUser() {
        logger.info("Kullanıcı sisteme kayıt oldu.");
    }

    @After("execution(* com.socibby.service.UserService.updateUser(..))")
    public void updateUserInformation() {
        logger.info("Kullanıcı bilgilerini güncelledi.");
    }

    @After("execution(* com.socibby.service.OrganizationService.insertOrganization(..))")
    public void registerOrganization() {
        logger.info("Organizasyon sisteme kayıt oldu.");
    }

    @After("execution(* com.socibby.service.OrganizationService.updateOrganization(..))")
    public void updateOrganizationInformation() {
        logger.info("Organizasyon bilgilerini güncelledi.");
    }
}
