package ru.syskov.MyThirdAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.syskov.MyThirdAppSpringBoot.exception.ValidationFailedException;

@Slf4j
@Service
public class RequestValidationService implements ValidationService{

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException{
        if(bindingResult.hasErrors()){
            String message = bindingResult.getFieldError().toString();
            String errorMessage = "Ошибка валидации полей: " + message;
            log.error(errorMessage);
            throw new ValidationFailedException(message);
        }
        log.info("Валидация прошла успешно, ошибок не найдено");
    }

}
