package ru.kai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kai.forms.UserForm;
import ru.kai.models.Role;
import ru.kai.models.State;
import ru.kai.models.User;
import ru.kai.repositories.UsersRepository;
import ru.kai.transfer.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        usersRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = usersRepository.findAll();
        List<UserDTO> list = new ArrayList<>();
        for(User user : users){
            list.add(UserDTO.from(user));
        }
        return list;
    }
}
