package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02 {
    public static void main(String[] args) throws ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userName = "SPRING6";
        String password = "_aA123456";

        try (Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stmt = conn.createStatement()) {
            String userId = "USER01";
            String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) " +
                    "VALUES (SEQ_MEMBER.nextval, '" + userId + "', '123456', '사용자01', 'user01@test.org')";

            int result = stmt.executeUpdate(sql);
            System.out.println(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
