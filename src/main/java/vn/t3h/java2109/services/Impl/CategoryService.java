package vn.t3h.java2109.services.Impl;

import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.CateogryDTO;
import vn.t3h.java2109.utils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    public List<CateogryDTO> getAllCategories() {

        List<CateogryDTO> list = new ArrayList<>();
        try(Connection connection = DbUtils.getConnection())
        {
            try (Statement statement = connection.createStatement()) {
              ResultSet resultSet = statement.executeQuery("Select * from category");
              while (resultSet.next())
              {
                  list.add(new CateogryDTO(resultSet.getInt(1), resultSet.getString(2)));
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

    public String getCategryName(Integer id) throws SQLException {
        String name = "";
        try(Connection connection = DbUtils.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select `name` from category where id = "+id);
            if(resultSet != null){
                while(resultSet.next()){
                    name = resultSet.getString(1);
                    break;
                }
            }
        }
        return  name;
    }

}
