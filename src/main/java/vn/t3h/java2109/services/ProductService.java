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
        String sql = "DELETE FROM `product` WHERE (`id` = "+id+")";
        return DbUtils.saveDb(sql);
    }

    public Boolean saveProduct(ProductDTO dto)
    {
        Integer id = dto.getId();
        String img =dto.getImg();
        Double price = dto.getPrice();
        String des = dto.getDes();
        String name = dto.getName();
        Integer category = dto.getCategory();
        StringBuilder sql = new StringBuilder();
        if(dto.getId() == null)
        {
            sql.append("Insert into product (img, price, des, name, category) value ('")
                    .append(img).append("', ")
                    .append(price).append(", '")
                    .append(des).append("', '")
                    .append(name).append("', '")
                    .append(category).append("')");
            return DbUtils.saveDb(sql.toString());
        }
        else {
            return editProduct(dto);
        }

    }

    public Boolean editProduct(ProductDTO dto)
    {
        StringBuilder beans = new StringBuilder();
        beans.append("UPDATE PRODUCT SET img = '")
                .append(dto.getImg()).append("' , price = ")
                .append(dto.getPrice()).append(", des = '")
                .append(dto.getDes()).append("', name = '")
                .append(dto.getName()).append("', category = ")
                .append(dto.getCategory()).append(" where (id =")
                .append(dto.getId()).append(")");

        return DbUtils.saveDb(beans.toString());
    }

    public ProductDTO detail(Integer id) throws SQLException {
        ProductDTO productDto = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM product");
        sql.append(" where product.id = ").append(id);
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
                    Integer total = resultTotal.getInt(1);
                    Integer totalPages = total % perPage == 0 ? total / perPage : total / perPage + 1;
                    result.setTotalPages(totalPages);
                    result.setTotalItems(total);
                    break;
                }
            }
            result.setData(listProducts);
            result.setPage(page);
            result.setPerPage(listProducts.size());
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

}
