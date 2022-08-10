package jdbc;

import org.codehaus.groovy.util.ListHashMap;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCPractice {
        public static void main(String[] args) throws SQLException {
            /*
             Connection -> it helps us to provide DB credentials and connect to the DB
             Statement -> we define our conditions to get the result from database
             ResultSet -> we store the data from the query result set as Java Object
             */

            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@mehmet.cyzfempy8xpj.us-east-2.rds.amazonaws.com:1521/ORCL",
                    "Mehmet",
                    "Mayis032008."
            );
            Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet=statement.executeQuery("select* from employees");
            resultSet.next();//return boolean -true if there is next row false if there is no rows after //return the entire row
            System.out.println(resultSet.getString("first_name"));
            resultSet.last();//it will go to the last row
            System.out.println(resultSet.getString("last_name"));
            resultSet.first();//it will go to the first row
            System.out.println(resultSet.getString(5));
            resultSet.beforeFirst();//it will go to column names
            System.out.println(resultSet.getRow());
            resultSet.next();
            System.out.println(resultSet.getRow());
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            //metadata-> information about the column rows etc in your table.
            //it is a set of data tahat describes and gives information about other data.
            System.out.println(resultSetMetaData.getColumnCount());
            for(int i=1;i<=resultSetMetaData.getColumnCount();i++){
                System.out.println(resultSetMetaData.getColumnName(i));
            }
            List<Map<String,Object>> employees=new ArrayList<>();
            while(resultSet.next()){
                Map<String,Object> employee=new ListHashMap<>();
                for (int i = 1; i <=resultSetMetaData.getColumnCount(); i++) {
                    employee.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));
                }
                employees.add(employee);
            }
            System.out.println(employees.size());
            System.out.println(employees.get(0).get("FIRST_NAME"));

        }
    }
