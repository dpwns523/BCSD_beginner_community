package domain.dto;

import annotation.ValidationGroups;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"password","deleted","updated_at"})
public class MemberDto {
    @NotNull(groups={ValidationGroups.join.class}, message = "이름을 입력하세요.")
    @Size(min = 2, max = 10, groups={ValidationGroups.join.class}, message = "이름은 2글자 이상 8글자 이하입니다.")
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]{2,10}$", groups = {ValidationGroups.join.class}, message = "이름에 특수문자 혹은 올바르지 않은 형태입니다.")
    @ApiModelProperty(example = "홍길동")
    private String name;

    @NotNull(groups = {ValidationGroups.join.class}, message = "비밀번호를 입력하세요")
    @Size(min = 8, max = 20, groups = {ValidationGroups.join.class}, message = "비밀번호는은 8글자 이상 20글자 이하입니다.")
    @ApiModelProperty(example = "password")
    private String password;

    @NotNull(groups={ValidationGroups.join.class}, message = "별명을 입력하세요.")
    @Size(min = 1, max = 10, groups={ValidationGroups.join.class}, message = "별명은 1글자 이상 8글자 이하입니다.")
    @ApiModelProperty(example = "창조")
    private String nickName;

    @NotNull(groups = {ValidationGroups.join.class}, message = "이메일은 공백일 수 없습니다.")
    @Email(groups = {ValidationGroups.join.class}, message = "올바른 이메일 형식이 아니거나 유효하지 않은 이메일입니다.")
    @ApiModelProperty(example = "dpwns523@naver.com")
    private String email;

    @NotNull(groups = {ValidationGroups.join.class}, message = "나이를 입력해주세요.")
    @Positive
    @ApiModelProperty(example = "25")
    private int age;

    @NotNull(groups={ValidationGroups.join.class}, message = "성별을 선택하세요. 1: 남, 2:여")
    @ApiModelProperty(example = "1")
    private int sex;    // 1 남성, 2 여성

    @NotNull(groups={ValidationGroups.join.class}, message = "핸드폰 번호를 입력하세요.")
//    @Pattern(regexp = "^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$",groups = {ValidationGroups.join.class},message = "휴대폰 번호 형식이 아닙니다")
    @ApiModelProperty(example = "010-6604-0868")
    private String phoneNumber;

    @ApiModelProperty(hidden = true)
    private Long id;
    @ApiModelProperty(hidden = true)
    private Timestamp createdAt;
    @ApiModelProperty(hidden = true)
    private Timestamp updatedAt;

    public MemberDto(String name, String password, String nickName, String email, String phoneNumber, int age, int sex){
        this.name= name;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.sex = sex;
    }

}
