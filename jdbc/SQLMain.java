package jdbc;

import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class SQLMain {
    public static void main(String[] args) {

        JDBCUtils.establishConnection();
        List<Map<String, Object>> employees = JDBCUtils.executeQuery("select * from employees");
        System.out.println(employees.get(5).get(("SALARY")));

        boolean checkOrder = true;

        for (int i = 0; i < employees.size()-1; i++) {

            System.out.println(employees.get(i).get("EMPLOYEE_ID"));

            int first_num = Integer.parseInt(employees.get(i).get("EMPLOYEE_ID").toString());
            int second_num = Integer.parseInt(employees.get(i+1).get("EMPLOYEE_ID").toString());

            if (first_num > second_num) {
                checkOrder = false;
            }

        }

        String firstRecordName = employees.get(0).get("FIRST_NAME").toString();

        Assert.assertEquals(firstRecordName, "JOHN", "ASSERTION FAILED!");

        Assert.assertTrue(checkOrder);

    }
}
