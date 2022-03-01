package vn.t3h.java2109.utils;

import java.sql.*;

public class DbUtils {

    private static Connection conn = null;
    public static Connection getConnection(){
        String URL = "jdbc:mysql://localhost:3306/myshop";
        String USER_NAME = "root";
        String PASS_WORRD = "2306";
        try{
            return DriverManager.getConnection(URL,USER_NAME,PASS_WORRD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static boolean saveDb(String sql)
    {
        Connection conn = null;
        boolean result = false;
        try{
            conn = getConnection();
            Statement statement = conn.createStatement();
            statement.execute(sql);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null)
            {
                try{
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
