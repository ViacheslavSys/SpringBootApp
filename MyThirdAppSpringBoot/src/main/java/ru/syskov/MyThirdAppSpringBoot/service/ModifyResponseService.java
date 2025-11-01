package ru.syskov.MyThirdAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.syskov.MyThirdAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
