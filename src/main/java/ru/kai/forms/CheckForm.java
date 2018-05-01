package ru.kai.forms;

import lombok.Data;

@Data
public class CheckForm {
    private String userLogin;
    private String billerLogin;
    private String amount;
}
