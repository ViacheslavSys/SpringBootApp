package ru.syskov.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.syskov.MySecondAppSpringBoot.exception.UnsupportedCodeException;
import ru.syskov.MySecondAppSpringBoot.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
