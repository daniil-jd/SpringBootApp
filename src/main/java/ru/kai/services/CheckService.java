package ru.kai.services;

import ru.kai.forms.CheckForm;
import ru.kai.models.User;
import ru.kai.transfer.CheckDTO;
import ru.kai.transfer.UserDTO;

import java.util.List;

public interface CheckService {
    List<CheckDTO> getChecks (UserDTO user);
    List<CheckDTO> getChecks ();
    void saveCheck (CheckForm form);
}
