package vn.t3h.java2109.services;

import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.AccountDTO;
import vn.t3h.java2109.utils.DbUtils;

import java.sql.*;

@Service
public class AccountService {



    public Boolean saveAccount(AccountDTO dto)
    {
        String username = dto.getUsername();
        String password = dto.getPassword();
        String phone = dto.getPhone();
        String email = dto.getEmail();
        String role = dto.getRole();
        String description = dto.getDescription();
        StringBuilder sql = new StringBuilder();
        sql.append("Insert into account (username, password, phone, email, role, description) value ('")
                .append(username).append("', '")
                .append(password).append("', '")
                .append(phone).append("', '")
                .append(email).append("', '")
                .append(role).append("', '")
                .append(description).append("')");
        return DbUtils.saveDb(sql.toString());
    }

    public Boolean updateAccount(AccountDTO dto)
    {
        StringBuilder sql = new StringBuilder();
        Integer id = dto.getId();
        sql.append("Update  account set username = '").append(dto.getUsername())
                .append("', phone = '").append(dto.getPhone()).append("', email = '")
                .append(dto.getEmail()).append("', role = '")
                .append(dto.getRole()).append("', description= '")
                .append(dto.getDescription()).append("' where (id = ")
                .append(dto.getId()).append(" )");
        return DbUtils.saveDb(sql.toString());
    }
    public AccountDTO getAccountById(Integer id) throws SQLException {
        AccountDTO dto = null;
        String sql = "Select * from account where id = "+id;
        try (Connection connection = DbUtils.getConnection()) {
          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery(sql);
          while(resultSet.next())
          {
              String username = resultSet.getString(2);
              String password = resultSet.getString(3);
              String phone = resultSet.getString(4);
              String email = resultSet.getString(5);
              String role = resultSet.getString(6);
              String description = resultSet.getString(7);
              dto = new AccountDTO(id,username,password,phone,email,role,description);
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

}
