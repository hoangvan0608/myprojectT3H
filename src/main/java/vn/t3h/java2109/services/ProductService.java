package vn.t3h.java2109.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.ProductDTO;
import vn.t3h.java2109.dto.TableDataDTO;
import vn.t3h.java2109.utils.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ITableService<ProductDTO> {


    public Boolean deleteProduct(Integer id)
    {
        String sql = "DELETE FROM `myshop`.`product` WHERE (`id` = ?)";
        return DbUtils.saveDb(sql);
    }

    public Boolean saveProduct(ProductDTO dto)
    {
        String img ="/frontend/images/home/"+ dto.getImg();
        Double price = dto.getPrice();
        String des = dto.getDes();
        String name = dto.getName();
        Integer category = dto.getCategory();
        StringBuilder sql = new StringBuilder();
        sql.append("Insert into product (img, price, des, name, category) value ('")
                .append(img).append("', ")
                .append(price).append(", '")
                .append(des).append("', '")
                .append(name).append("', '")
                .append(category).append("')");
        return DbUtils.saveDb(sql.toString());
    }


    public ProductDTO detail(Integer id) throws SQLException {
        ProductDTO productDto = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM product ");
        sql.append(" where id = ").append(id);
        Connection connection = null;
        try {
            connection = DbUtils.getConnection();
            Statement statement = connection.createStatement();// có tham số
            ResultSet resultSet =statement.executeQuery(sql.toString());
            if (resultSet != null) {
                while (resultSet.next()) {
                    String img = resultSet.getString(2);
                    Double price = resultSet.getDouble(3);
                    String des = resultSet.getString(4);
                    String name = resultSet.getString(5);
                    Integer category = resultSet.getInt(6);
                    productDto = new ProductDTO(id,img,price,des,name,category);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            // bước 6 đóng connecttion
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return productDto;
    }

    public TableDataDTO<ProductDTO> findAll(Integer page, Integer perPage, String searchString)  {
        List<ProductDTO> listProducts = new ArrayList<ProductDTO>();
        TableDataDTO result = new TableDataDTO();
        StringBuilder sqlSelect = new StringBuilder();
        sqlSelect.append("Select * from product limit ")
                .append((page - 1) * perPage)
                .append(", ").append(perPage);
        String totalItems = "Select count(*) from product";
        TableDataDTO resultTable = new TableDataDTO();
        try(Connection conn = DbUtils.getConnection())
        {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect.toString());
            if(resultSet != null) {
                while(resultSet.next())
                {
                    Integer id = resultSet.getInt(1);
                    String img = resultSet.getString(2);
                    Double price = resultSet.getDouble(3);
                    String description = resultSet.getString(4);
                    String name = resultSet.getString(5);
                    Integer category = resultSet.getInt(6);
                    listProducts.add(new ProductDTO(id, img, price, description,name,category));
                }
            }

            Statement statement2 = conn.createStatement();
            ResultSet resultTotal = statement.executeQuery(totalItems);

            if(resultTotal != null){
                while(resultTotal.next()){

                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
