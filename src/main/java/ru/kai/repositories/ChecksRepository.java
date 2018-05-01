package ru.kai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kai.models.Check;
import ru.kai.models.User;
import ru.kai.transfer.UserDTO;

import java.util.List;
import java.util.Optional;

public interface ChecksRepository extends JpaRepository<Check, Long> {
    List<Check> findAllByUser(User user);
    List<Check> findAllByBill_Id(Long id);
}
