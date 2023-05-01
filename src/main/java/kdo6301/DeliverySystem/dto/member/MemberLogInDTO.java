package kdo6301.DeliverySystem.dto.member;

import kdo6301.DeliverySystem.domain.Member;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberLogInDTO {

    @NotEmpty
    private String loginName;

    private String name;

    @NotEmpty
    private String password;

    public MemberLogInDTO(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

}
