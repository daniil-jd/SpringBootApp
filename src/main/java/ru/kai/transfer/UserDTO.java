package ru.kai.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.kai.models.*;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
/**
 * Объект для отображения
 */
public class UserDTO {
    private String firstName;
    private String lastName;
    private String login;
    private State state;
    private Role role;
    private Bill bill;

    public static UserDTO from(User user) {
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .state(user.getState())
                .role(user.getRole())
                .bill(user.getBill())
                .build();
    }

}
