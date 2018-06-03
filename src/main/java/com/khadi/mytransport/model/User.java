package com.khadi.mytransport.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    private String password;
    @Column(name = "first_name", unique = true)
    private String firstName;
    @Column(name = "last_name", unique = true)
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(name = "birth_day", unique = true)
    private LocalDate birthDay;
    private String address;
}
