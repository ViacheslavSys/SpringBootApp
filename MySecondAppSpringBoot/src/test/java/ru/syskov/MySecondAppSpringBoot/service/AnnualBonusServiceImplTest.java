package ru.syskov.MySecondAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.syskov.MySecondAppSpringBoot.model.Positions;
import ru.syskov.MySecondAppSpringBoot.model.Request;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnnualBonusServiceImplTest {

    @Test
    void calculate() {
        Request request = new Request();
        request.setPosition(Positions.HR);
        request.setBonus(2.0);
        request.setWorkDaysInYear(243);
        request.setSalary(100000.00);


        double result = new AnnualBonusServiceImpl().calculate(request);

        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }
}