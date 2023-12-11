package exam01;

import java.sql.*;
import java.time.LocalDateTime;

public class Ex05 {
    public static void main(String[] args) throws ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userName = "SPRING6";
        String password = "_aA123456";

        String sql = "SELECT * FROM MEMBER";

        try (Connection conn = DriverManager.getConnection(url, userName, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) { // 결과 셋, 커서가 담겨있는, 커서를 이동하면서 하나씩 가져온다.

            while(rs.next()) {
                long userNo = rs.getLong("USER_NO");
                String userId = rs.getString("USER_ID");
                String userNm = rs.getString("USER_NM");
                LocalDateTime regDt = rs.getTimestamp("REG_DT").toLocalDateTime();

                System.out.printf("userNo=%d, userId=%s, userNm=%s, regDt=%s%n", userNo, userId, userNm, regDt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
