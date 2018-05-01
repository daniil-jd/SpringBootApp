package ru.kai.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = {"accountHolder"})
@Table(name = "fix_bill")
/**
 * Сущность "Счет" вида "Номер счета (id) - Деньги"
 */
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double money;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "bill")
    private User accountHolder;

    @OneToMany(mappedBy = "bill", fetch = FetchType.EAGER)
    private List<Check> checks;
}
