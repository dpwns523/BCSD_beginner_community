package domain.dto;

import annotation.ValidationGroups;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MemberDto {

    @NotNull(groups={ValidationGroups.join.class}, message = "이름을 입력하세요.")
    @Size(min = 2, max = 10, groups={ValidationGroups.join.class}, message = "이름은 2글자 이상 8글자 이하입니다.")
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]{2,10}$", groups = {ValidationGroups.join.class}, message = "이름에 특수문자 혹은 올바르지 않은 형태입니다.")
    private String name;

    @NotNull(groups = {ValidationGroups.join.class}, message = "비밀번호를 입력하세요")
    @Size(min = 8, max = 20, groups = {ValidationGroups.join.class}, message = "비밀번호는은 8글자 이상 20글자 이하입니다.")
    private String password;

    @NotNull(groups={ValidationGroups.join.class}, message = "별명을 입력하세요.")
    @Size(min = 1, max = 10, groups={ValidationGroups.join.class}, message = "별명은 1글자 이상 8글자 이하입니다.")
    private String nickName;

    @NotNull(groups = {ValidationGroups.join.class}, message = "이메일은 공백일 수 없습니다.")
    @Email(groups = {ValidationGroups.join.class}, message = "올바른 이메일 형식이 아니거나 유효하지 않은 이메일입니다.")
    private String email;

    @NotNull(groups = {ValidationGroups.join.class}, message = "나이를 입력해주세요.")
    @Size(min=1, max=3, groups = {ValidationGroups.join.class}, message ="나이는 3자리 까지입니다.")
    @Pattern(regexp = "[0-9]{1,3}$", groups = {ValidationGroups.join.class},message = "나이는 숫자만 입력 가능합니다.")
    private int age;

    @NotNull(groups={ValidationGroups.join.class}, message = "성별을 선택하세요. 1: 남, 2:여")
    private int sex;    // 1 남성, 2 여성

    @NotNull(groups={ValidationGroups.join.class}, message = "별명을 입력하세요.")
    @Size(min = 1, max = 10, groups={ValidationGroups.join.class}, message = "별명은 1글자 이상 8글자 이하입니다.")
    @Pattern(regexp = "^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$",groups = {ValidationGroups.join.class},message = "휴대폰 번호 형식이 아닙니다")
    private String phoneNumber;

    public void setName(String name) { this.name = name; }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(int sex) { this.sex = sex; }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) { this.password = password;}

    public String getPassword() { return password; }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
