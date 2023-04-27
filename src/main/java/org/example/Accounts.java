package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int a_no;
    private String type;


    private int gst_no;

    private String firm_name;
    private LocalDate opening_date;

    private long balance;
    private String status;

    @ManyToOne
    private User user;
    @ManyToOne
    private Bank bank;

}
