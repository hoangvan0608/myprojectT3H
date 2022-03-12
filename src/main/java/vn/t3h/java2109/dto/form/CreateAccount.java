package vn.t3h.java2109.dto.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccount {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String role;
    private String des;
}
