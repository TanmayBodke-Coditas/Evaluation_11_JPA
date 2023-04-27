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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int u_id;
    private String u_name;
    private String u_address;
    private int u_phone;

    @ManyToMany
    @JoinTable(name = "user_bank", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "bank_id"))
    private List<Bank> banks;

    @OneToMany(mappedBy = "user")
    private List<Accounts> accounts;


}
