package kdo6301.DeliverySystem.domain;

import kdo6301.DeliverySystem.dto.member.MemberDTO;
import kdo6301.DeliverySystem.dto.member.MemberSignInDTO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;
    private String loginName;
    private String name;

    private String password;

    @OneToMany
    private List<Order> orders;

    public Member(){}

    public Member(String loginName, String name, String password) {
        this.loginName = loginName;
        this.name = name;
        this.password = password;
    }

    public boolean validateLogin(String password)
    {
        return this.password.equals(password);
    }

    public static Member toMember(MemberDTO memberDTO){
        return new Member(
                memberDTO.getName(),
                memberDTO.getLoginName(),
                memberDTO.getPassword());
    }
}
