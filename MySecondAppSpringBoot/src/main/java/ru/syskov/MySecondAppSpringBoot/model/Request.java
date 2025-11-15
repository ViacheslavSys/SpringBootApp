package ru.syskov.MySecondAppSpringBoot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    /***
     * Уникальный идентификатор сообщения
     */
    @NotBlank
    @Size(max = 32)
    private String uid;

    /***
     * Уникальный идентификатор операции
     */
    @NotBlank
    @Size(max = 32)
    private String operationUid;

    /***
     * Имя системы отправителя
     */
    private String systemName;

    /***
     * Время создания сообщения
     */
    @NotBlank
    private String systemTime;

    /***
     * Наименование ресурса
     */
    private String source;

    /***
     * Позиция
     */
    private Positions position;

    /***
     * Зарплата
     */
    private Double salary;

    /***
     * Бонус
     */
    private Double bonus;

    /***
     * Рабочие дни в году
     */
    private Integer workDaysInYear;

    /***
     * Рабочие дни в квартал
     */
    private Integer workDaysInQuarter;

    /***
     * Уникальный идентификатор коммуникации
     */
    @Min(value = 1)
    @Max(value = 100000)
    private int communicationId;

    /***
     * Уникальный идентификатор шаблона
     */
    private int templateId;

    /***
     * Код продукта
     */
    private int productCode;

    /***
     * Смс код
     */
    private int smsCode;

    @Override
    public String toString(){
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId='" + communicationId + '\'' +
                ", templateId='" + templateId +  '\'' +
                ", productCode='" + productCode +  '\'' +
                ", smsCode='" + smsCode +
                '}';
    }
}
