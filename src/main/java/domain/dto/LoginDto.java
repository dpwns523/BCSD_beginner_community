package domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    @ApiModelProperty(example = "dpwns523@koreatech.ac.kr")
    private String email;

    @ApiModelProperty(example = "password")
    private String password;
}
