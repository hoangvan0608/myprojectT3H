package vn.t3h.java2109.services;

import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.RoleDTO;
import vn.t3h.java2109.utils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    public List<RoleDTO> getAllRoles() throws SQLException {
        List<RoleDTO> roles = new ArrayList<RoleDTO>();
        String sql = "Select * from role";
        try(Connection connection = DbUtils.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet != null){
                while(resultSet.next()){
                    roles.add(new RoleDTO(resultSet.getInt(1), resultSet.getString(2)));
                }
            }
        }
        return roles;
    }
}
