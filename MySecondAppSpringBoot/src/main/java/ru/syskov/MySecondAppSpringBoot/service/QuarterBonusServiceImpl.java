package ru.syskov.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.syskov.MySecondAppSpringBoot.model.Request;

import java.time.LocalDate;
import java.time.YearMonth;

@Service
public class QuarterBonusServiceImpl implements QuarterBonusService {
    @Override
    public double calculate(Request request) {
        int daysInQuarter = getDaysInCurrentQuarter();
        if (!request.getPosition().isManager()) {
            return 0.0;
        } else {
            return daysInQuarter *
                    request.getBonus() *
                    request.getSalary() *
                    request.getPosition().getPositionCoefficient() / request.getWorkDaysInQuarter();
        }
    }

    private int getDaysInCurrentQuarter() {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();

        int quarter;
        if (month <= 3) {
            quarter = 1;
        } else if (month <= 6) {
            quarter = 2;
        } else if (month <= 9) {
            quarter = 3;
        } else {
            quarter = 4;
        }
        int startMonth = (quarter - 1) * 3 + 1;
        int days = 0;

        for (int i = startMonth; i < startMonth + 3; i++) {
            days += YearMonth.of(year, i).lengthOfMonth();
        }
        return days;
    }
}
