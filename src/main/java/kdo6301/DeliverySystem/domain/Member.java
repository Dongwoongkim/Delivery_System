package kdo6301.DeliverySystem.domain;

import kdo6301.DeliverySystem.dto.member.MemberDTO;
import kdo6301.DeliverySystem.dto.member.MemberSignInDTO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEMBER_ID")
    private Long id;
    private String loginName;
    private String name;

    private String password;

    @OneToMany(mappedBy = "member")
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

    public MemberDTO toDto(){
        return new MemberDTO(this.loginName,this.name,this.password);
    }
}
