package domain.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/*
    TODO : Lombok 어노테이션을 활용한 코드 간소화 업데이트
 */
public class MemberEntity {
    private Long uid;
    private String name;
    private String password;
    private String nickName;
    private String email;
    private int age;
    private int sex;    // 1 남성, 2 여성
    private String phoneNumber;
    private boolean isDeleted;
    private Timestamp created_at;
    private Timestamp updated_at;
    // 비밀번호 암호화
    protected String salt;

    public MemberEntity(String name, String password, String nickName, String email, String phoneNumber, int age, int sex){
        this.name= name;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.sex = sex;
        this.isDeleted = false;
        this.created_at = Timestamp.valueOf(LocalDateTime.now());
        this.updated_at = Timestamp.valueOf(LocalDateTime.now());
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
    public void setPassword(String password) { this.password = password;}

    public String getPassword() { return password; }

    public Long getUid() {
        return uid;
    }

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

    public boolean isDeleted() {
        return isDeleted;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}
