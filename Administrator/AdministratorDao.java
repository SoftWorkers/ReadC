package ReadClockIn.www.Administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministratorDao {
    public Administrator login(Connection con, Administrator administrator) throws Exception {
        Administrator resultAdministrator = null;
        String sql = "select * from adminitrator where account=? and password=?";
        PreparedStatement pstmt = con.prepareStatement ( sql );
        pstmt.setString ( 1 , administrator.getAccount () );
        pstmt.setString ( 2 , administrator.getPassword () );
        ResultSet rs = pstmt.executeQuery ();
        if (rs.next ()) {
            resultAdministrator = new Administrator ();
            resultAdministrator.setId ( rs.getInt ( "id" ) );
            resultAdministrator.setAccount ( rs.getString ( "account" ) );
            resultAdministrator.setPassword ( rs.getString ( "password" ) );
        }
        return resultAdministrator;
    }
}
