package vn.t3h.java2109.services;

import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.AccountDTO;
import vn.t3h.java2109.utils.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {


    public List<AccountDTO> getAllAccounts() {

        List<AccountDTO> list = new ArrayList<>();
        try(Connection connection = DbUtils.getConnection())
        {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("Select * from account");
                while (resultSet.next())
                {
                    Integer id = resultSet.getInt(1);
                    String username = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    String phone = resultSet.getString(4);
                    String email = resultSet.getString(5);
                    String role = resultSet.getString(6);
                    String description = resultSet.getString(7);
                    list.add(new AccountDTO(id,username,password,phone,email,role,description));
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Boolean saveAccount(AccountDTO dto)
    {
        Integer id = dto.getId();
        String username = dto.getUsername();
        String password = dto.getPassword();
        String phone = dto.getPhone();
        String email = dto.getEmail();
        String role = dto.getRole();
        String description = dto.getDescription();
        if(id == null)
        {
            StringBuilder sql = new StringBuilder();
            sql.append("Insert into account (username, password, phone, email, role, des) value ('")
                    .append(username).append("', '")
                    .append(password).append("', '")
                    .append(phone).append("', '")
                    .append(email).append("', '")
                    .append(role).append("', '")
                    .append(description).append("')");
            return DbUtils.saveDb(sql.toString());
        }
        else {
            return updateAccount(dto);
        }

    }

    public Boolean updateAccount(AccountDTO dto)
    {
        StringBuilder sql = new StringBuilder();
        Integer id = dto.getId();
        sql.append("Update  account set username = '").append(dto.getUsername())
                .append("', phone = '").append(dto.getPhone()).append("', email = '")
                .append(dto.getEmail()).append("', role = '")
                .append(dto.getRole()).append("', des= '")
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

    public Boolean deleteAccountById(Integer id)
    {
        String sql = "DELETE FROM `account` WHERE (`id` = "+id+")";
        return DbUtils.saveDb(sql);
    }

}
