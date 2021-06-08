package ReadClockIn.www.Administrator;

import ReadClockIn.www.Others.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministratorQueryDao {
    //查询
    public static ResultSet list(Connection con , Administrator administrator) throws Exception {
        StringBuffer sb = new StringBuffer ( "select * from adminitrator" );
        if (StringUtil.isNotEmpty ( administrator.getAccount () )) {
            sb.append ( " and account like '%"+administrator.getAccount ()+"%'" );
        }
        PreparedStatement pstmt = con.prepareStatement ( sb.toString ().replaceFirst ( "and", "where" ) );
        return pstmt.executeQuery();
    }
}
