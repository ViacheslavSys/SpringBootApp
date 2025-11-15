package ru.syskov.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.syskov.MySecondAppSpringBoot.model.Positions;
import ru.syskov.MySecondAppSpringBoot.model.Request;

import java.time.Year;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{
    @Override
    public double calculate(Request request) {
        int daysInYear = getDaysInCurrentYear();
        return request.getSalary() *
                request.getBonus() *
                daysInYear *
                request.getPosition().getPositionCoefficient() / request.getWorkDaysInYear();
    };

    private int getDaysInCurrentYear(){
        return Year.now().length();
    }
}
