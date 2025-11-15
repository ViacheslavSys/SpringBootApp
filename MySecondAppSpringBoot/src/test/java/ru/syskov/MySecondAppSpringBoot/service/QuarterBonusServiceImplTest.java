package ru.syskov.MySecondAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.syskov.MySecondAppSpringBoot.model.Positions;
import ru.syskov.MySecondAppSpringBoot.model.Request;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class QuarterBonusServiceImplTest {

    @Test
    void calculateNoManager() {
        Request request = new Request();
        request.setPosition(Positions.HR);
        request.setBonus(0.2);
        request.setWorkDaysInQuarter(64);
        request.setSalary(100000.00);

        double result = new QuarterBonusServiceImpl().calculate(request);
        double expected = 0.0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateManager() {
        Request request = new Request();
        request.setPosition(Positions.TL);
        request.setBonus(0.12);
        request.setWorkDaysInQuarter(64);
        request.setSalary(200000.00);

        double result = new QuarterBonusServiceImpl().calculate(request);
        double expected = 89700.0;
        assertThat(result).isEqualTo(expected);
    }
}