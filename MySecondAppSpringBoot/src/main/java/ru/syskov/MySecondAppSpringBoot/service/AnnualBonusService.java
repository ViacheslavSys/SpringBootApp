package ru.syskov.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.syskov.MySecondAppSpringBoot.model.Positions;
import ru.syskov.MySecondAppSpringBoot.model.Request;

@Service
public interface AnnualBonusService {

    double calculate(Request request);
}
