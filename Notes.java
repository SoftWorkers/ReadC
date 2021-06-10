package ReadClockIn.www.Notes;

import java.util.Date;

public class Notes {
    private int id;
    private String sno;
    private String name;
    private Date time;
    private int count;

    public Notes() {
        super();
    }

    public Notes(String sno) {
        super ();
        this.sno = sno;
    }

    public Notes(String sno, String name, Date time, int count) {
        super();
        this.sno = sno;
        this.name = name;
        this.time = time;
        this.count = count;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
