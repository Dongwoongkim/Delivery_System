package kdo6301.DeliverySystem.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name="loginid")
    private String loginId;
    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    public Member(){}

    public Member(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }
}
