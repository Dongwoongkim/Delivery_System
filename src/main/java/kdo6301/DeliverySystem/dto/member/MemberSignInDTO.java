package kdo6301.DeliverySystem.dto.member;

import kdo6301.DeliverySystem.domain.Member;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberSignInDTO {
    @NotEmpty
    private String loginName;
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;

    public MemberSignInDTO(String loginName, String name, String password) {
        this.loginName = loginName;
        this.name = name;
        this.password = password;
    }

}
