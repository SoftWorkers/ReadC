package ReadClockIn.www.Administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdministratorAddDao {
    public static int add(Connection con , Administrator administrator) throws Exception {
        String addsql = "insert into adminitrator values(null,?,?)";
        PreparedStatement pstmt = con.prepareStatement ( addsql );
        pstmt.setString ( 1, administrator.getAccount () );
        pstmt.setString ( 2, administrator.getPassword() );
        return pstmt.executeUpdate();
    }
}
