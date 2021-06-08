package Eighth.pwd;

import Eighth.login.DBconnection;
import Eighth.login.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class pwdDao {
    public List<String> RankingList(){
        List<String> std = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<String> rank = new ArrayList<>();
        Connection connection = DBconnection.getConnection();
        Statement statement = null;
        ResultSet set = null;
        try {
            statement = connection.createStatement();
            String selectStr = " ";
            selectStr = "select * from student";
            set = statement.executeQuery(selectStr);
            while (set.next()) {
                User bs = new User();
                std.add(bs.setUserName(set.getString("name")));
                list.add(bs.setCount(set.getInt("count")));
            }
            for(int i=0;i<list.size()-1;i++) {
                for(int j=0;j<list.size()-1-i;j++) {
                    if(list.get(j)<list.get(j+1)) {
                        int temp=list.get(j);
                        String  temp1 = std.get(j);
                        list.set(j, list.get(j+1));
                        std.set(j,std.get(j+1));
                        list.set(j+1,temp);
                        std.set(j+1,temp1);
                    }
                }
            }
            for(int i = 0 ;i<10 ;i++){
                if(list.get(i)== 0){
                    break;
                }
                rank.add(std.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更新失败");
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rank;
    }
}
