package com.instagram.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LocalizationResolver {
    private final ApplicationContext applicationContext;

    @Autowired
    public LocalizationResolver(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public String resolve(Enum key) {
        return key == null ? "" : this.applicationContext.getMessage(key.getClass().getName() + "." + key.name(), (Object[]) null, LocaleContextHolder.getLocale());
    }

    public String resolve(String key) {
        return key == null ? "" : this.applicationContext.getMessage(key, (Object[]) null, LocaleContextHolder.getLocale());
    }
}