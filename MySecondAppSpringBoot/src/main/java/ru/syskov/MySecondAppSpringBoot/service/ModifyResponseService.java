package ru.syskov.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.syskov.MySecondAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
