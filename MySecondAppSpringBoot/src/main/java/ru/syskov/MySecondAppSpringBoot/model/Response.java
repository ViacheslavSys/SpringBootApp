package ru.syskov.MySecondAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    /***
     * Уникальный идентификатор сообщение
     */
    private String uid;

    /***
     * Уникальный идентификатор операции
     */
    private String operationUid;

    /***
     * Время создания сообщения
     */
    private String systemTime;

    /***
     * Код
     */
    private Codes code;

    /***
     * Годовая премия
     */
    private double annualBonus;

    /***
     * Квартальная премия
     */
    private double quarterBonus;

    /***
     * Код ошибки
     */
    private ErrorCodes errorCode;

    /***
     * Сообщение ошибки
     */
    private ErrorMessages errorMessage;
}
