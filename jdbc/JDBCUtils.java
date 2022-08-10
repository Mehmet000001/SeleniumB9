package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {


    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    public  static ResultSetMetaData resultSetMetaData;
    public static void establishConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@mehmet.cyzfempy8xpj.us-east-2.rds.amazonaws.com:1521/ORCL",
                    "Mehmet",
                    "Mayis032008."
            );
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> executeQuery (String query) {

        List<Map<String, Object>> queryResult = new ArrayList<>();

        try {

            resultSet = statement.executeQuery(query);

            resultSetMetaData = resultSet.getMetaData();

            resultSet.beforeFirst();

            while (resultSet.next()) {
                Map<String, Object> record = new LinkedHashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    record.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
                }
                queryResult.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return queryResult;
    }
    public  static  int getRowsCount(){
        int totalRowsCount=-1;
        try {
            resultSet.last();
           totalRowsCount= resultSet.getRow();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return totalRowsCount;
    }
    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();

            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}