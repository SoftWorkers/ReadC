import java.sql.Date;
import java.time.DateTimeException;

public class Notes {
        Integer id;
        Integer sno;
        String name;
        Date time;
        Integer count;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getSno() {
        return sno;
    }
        public void setSno(Integer sno) {
        this.sno = sno;
    }

        public String getName() { return name; }
        public void setName(String name) {
            this.name = name;
        }

        public Date getTime() {
            return time;
        }
        public void setTime(Date time) {
            this.time = time;
        }

        public Integer getCount() {
        return count;
    }
        public void setCount(Integer count) {
        this.count = count;
    }
        public Notes() {
        }

    @Override
    public String toString() {
        return "{" +
                " 学号=" + sno +
                ", 姓名='" + name + '\'' +
                ", 时间=" + time +
                ", 打卡总次数=" + count +
                '}';
    }
}
