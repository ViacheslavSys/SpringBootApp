package ru.syskov.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.syskov.MySecondAppSpringBoot.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}
