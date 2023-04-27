package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int b_id;
    private String b_name;
    private String b_address;

    @ManyToMany(mappedBy = "banks")
    private List<User> users;

    @OneToMany(mappedBy = "bank")
    private List<Accounts> accounts;
}
