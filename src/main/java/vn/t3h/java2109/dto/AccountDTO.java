package vn.t3h.java2109.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private Integer id;
    private String username;
    private  String password;
    private String phone;
    private String email;
    private String role;
    private String description;

    public AccountDTO(Integer id, String username, String password, String phone, String email, String role, String description) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.description = description;
    }

    public AccountDTO(String username, String password, String phone, String email, String role, String description) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.description = description;
    }
    public AccountDTO(){}
}
