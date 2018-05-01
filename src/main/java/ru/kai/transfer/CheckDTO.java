package ru.kai.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.kai.models.Bill;
import ru.kai.models.Check;
import ru.kai.models.User;


@Data
@AllArgsConstructor
@Builder
/**
 * Объект для отображения
 */
public class CheckDTO {
    private double amount;
    private User user;
    private Bill bill;

    public static CheckDTO from (Check check){
        return CheckDTO.builder()
                .amount(check.getAmount())
                .bill(check.getBill())
                .user(check.getUser())
                .build();
    }
}
