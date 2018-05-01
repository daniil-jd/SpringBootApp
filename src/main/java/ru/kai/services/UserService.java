package ru.kai.services;

import ru.kai.forms.UserForm;
import ru.kai.transfer.UserDTO;

import java.util.List;

public interface UserService {
    void signUp (UserForm form);
    List<UserDTO> getAllUsers();
}
