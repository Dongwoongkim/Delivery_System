package kdo6301.DeliverySystem.dto.member;

import kdo6301.DeliverySystem.domain.Member;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Data
@ToString
public class MemberDTO {
    @NotEmpty
    private String loginName;
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
    public MemberDTO(String loginName, String name, String password) {
        this.loginName = loginName;
        this.name = name;
        this.password = password;
    }

    public static Member toMember(MemberDTO memberDTO){
        return new Member(
                memberDTO.getName(),
                memberDTO.getLoginName(),
                memberDTO.getPassword());
    }
}
