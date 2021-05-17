package br.com.petz.upp.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    @Autowired
    private MessageSource messageSource;

    public String getMessageBundle(String key, String ...values) {
        return messageSource.getMessage(key, values, LocaleContextHolder.getLocale());
    }

}
