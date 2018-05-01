package ru.kai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kai.forms.CheckForm;
import ru.kai.models.Bill;
import ru.kai.models.Check;
import ru.kai.models.User;
import ru.kai.repositories.ChecksRepository;
import ru.kai.repositories.UsersRepository;
import ru.kai.transfer.CheckDTO;
import ru.kai.transfer.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private ChecksRepository checksRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<CheckDTO> getChecks(UserDTO user) {

        Optional<User> us = usersRepository.findOneByLogin(user.getLogin());
        Optional<Bill> bill = Optional.ofNullable(us.get().getBill());
        List<Check> checks = checksRepository.findAllByUser(us.get());

        if (bill.isPresent())
            checks.addAll(checksRepository.findAllByBill_Id(bill.get().getId()));

        List<CheckDTO> list = new ArrayList<CheckDTO>();
        for (Check check : checks) {
            list.add(CheckDTO.from(check));
        }
        return list;
    }

    @Override
    public List<CheckDTO> getChecks() {
        List<Check> checks = checksRepository.findAll();

        List<CheckDTO> list = new ArrayList<CheckDTO>();
        for (Check check : checks) {
            list.add(CheckDTO.from(check));
        }
        return list;
    }

    @Override
    public void saveCheck(CheckForm form) {
        Optional<User> user = usersRepository.findOneByLogin(form.getUserLogin());
        double amount = Double.parseDouble(form.getAmount());
        Optional<User> biller =usersRepository.findOneByLogin(form.getBillerLogin());
        Bill bill = biller.get().getBill();

        if (user.get().getBill().getMoney() >= amount) {
            Check check = Check.builder()
                    .amount(amount)
                    .user(user.get())
                    .bill(bill)
                    .build();
            checksRepository.save(check);
            user.get().getBill().setMoney(user.get().getBill().getMoney() - amount);
            biller.get().getBill().setMoney(biller.get().getBill().getMoney() + amount);
            usersRepository.save(user.get());
            usersRepository.save(biller.get());
        }
    }


}
