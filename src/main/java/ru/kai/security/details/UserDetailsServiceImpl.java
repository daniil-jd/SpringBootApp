package ru.kai.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kai.repositories.UsersRepository;

/**
 * Позволяет springframework.security загрузить User byUsername
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new
                UserDetailsImpl(usersRepository.findOneByLogin(s)
                .orElseThrow(IllegalArgumentException::new));
    }
}
