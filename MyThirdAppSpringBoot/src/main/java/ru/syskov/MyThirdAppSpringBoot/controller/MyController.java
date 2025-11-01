package ru.syskov.MyThirdAppSpringBoot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.syskov.MyThirdAppSpringBoot.exception.UnsupportedCodeException;
import ru.syskov.MyThirdAppSpringBoot.exception.ValidationFailedException;
import ru.syskov.MyThirdAppSpringBoot.model.*;
import ru.syskov.MyThirdAppSpringBoot.service.ModifyResponseService;
import ru.syskov.MyThirdAppSpringBoot.service.ValidationService;
import ru.syskov.MyThirdAppSpringBoot.util.DateTimeUtil;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        log.info("response: {}", response);

        try {
            Instant requestServiceTime1 = DateTimeUtil.getCustomFormat().parse(request.getSystemTime()).toInstant();
            Instant requestServiceTime2 = Instant.now();
            Duration duration = Duration.between(requestServiceTime1, requestServiceTime2);

            log.info("Время Send в Postman до вывода в лог Сервисом 2: {} мс",
                    duration.toMillis());

            validationService.isValid(bindingResult);
            if ("123".equals(request.getUid())) {
                log.error("UID = 123. Генерация исключения UnsupportedCodeException");
                throw new UnsupportedCodeException("Ошибка: uid = 123 не поддерживается");
            }
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error("response error: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.error("response error: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.error("response error: {}", response);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        modifyResponseService.modify(response);
        log.info("response: {}", modifyResponseService.modify(response));

        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }
}
