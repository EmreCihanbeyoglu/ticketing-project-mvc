package com.cydeo.model;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class User extends BaseModel{

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private boolean enabled;
    private String phone;
    private Role role;
    private Gender gender;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, String firstname, Gender gender, Role role, String phone, boolean enabled, String password, String username, String lastname) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstname = firstname;
        this.gender = gender;
        this.role = role;
        this.phone = phone;
        this.enabled = enabled;
        this.password = password;
        this.username = username;
        this.lastname = lastname;
    }
}
