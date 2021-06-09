package ReadClockIn.www.Notes;

import ReadClockIn.www.Others.StringUtil;
import ReadClockIn.www.Student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentLogDao {
    //查询
    public static ResultSet list(Connection con , Notes notes) throws Exception {
        StringBuffer sb = new StringBuffer ( "select * from notes" );
        if (StringUtil.isNotEmpty ( String.valueOf ( notes.getSno() ) )) {
            sb.append ( " and sno like '%"+notes.getSno ()+"%'" );
        }
        PreparedStatement pstmt = con.prepareStatement ( sb.toString ().replaceFirst ( "and", "where" ) );
        return pstmt.executeQuery();
    }
}
