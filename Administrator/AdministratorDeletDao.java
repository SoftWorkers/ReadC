package ReadClockIn.www.Administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdministratorDeletDao {
    public static int delet(Connection con , Administrator administrator) throws Exception {
        String deletsql = "delete from adminitrator where account=?";
        PreparedStatement pstmt = con.prepareStatement ( deletsql );
        pstmt.setString ( 1, administrator.getAccount () );
        return pstmt.executeUpdate();
    }
}
