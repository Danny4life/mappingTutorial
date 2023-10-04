package com.osiki.demojpa.model;

import com.osiki.demojpa.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "userProfile_tbl")
public class UserProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date dob;

    private String address;

    private String street;

    private String city;

    private String state;

    private String country;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserProfile() {
    }

    public UserProfile(String phoneNumber, Gender gender, Date dob, String address, String street, String city, String state, String country, User user) {

        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.user = user;
    }

   public UserProfile(String number, Gender gender, Date time, String number1, String s, String benin, String edo, String nigeria) {
    }
}
