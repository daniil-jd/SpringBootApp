package ru.kai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kai.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByLogin(String login);
}
