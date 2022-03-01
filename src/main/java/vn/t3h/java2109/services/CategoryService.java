package vn.t3h.java2109.services;

import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.CategoryDTO;
import vn.t3h.java2109.utils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    public List<CategoryDTO> getAllCategories() throws SQLException {

        List<CategoryDTO> list = new ArrayList<>();
        try(Connection connection = DbUtils.getConnection())
        {
            try (Statement statement = connection.createStatement()) {
              ResultSet resultSet = statement.executeQuery("Select * from category");
              while (resultSet.next())
              {
                  list.add(new CategoryDTO(resultSet.getInt(1), resultSet.getString(2)));
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

}
