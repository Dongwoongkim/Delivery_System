package kdo6301.DeliverySystem.domain;


import kdo6301.DeliverySystem.repository.MemberRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="login_id")
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

    public static boolean validateLogin(Member member, String password)
    {
        return member.getPassword().equals(password);
    }
}
