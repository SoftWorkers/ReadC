public class Student {
        Integer id;  //系的id
        Integer sno; 
        String name;
        String sex;
        String major;
        String grade;
        String loginAccount;
        String passwd;
        Integer count;

        public Integer getCount() {
           return count;
       }

        public void setCount(Integer count) {
          this.count = count;
        }



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

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }
        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getMajor() {
            return major;
        }
        public void setMajor(String major) {
            this.major = major;
        }

        public String getGrade() {
            return grade;
        }
        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getLoginAccount() {
            return loginAccount;
        }
        public void setLoginAccount(String loginAccount) {
            this.loginAccount = loginAccount;
        }

        public String getPasswd() {
            return passwd;
        }
        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }
        public Student() {
        }

        @Override
        public String toString() {
            return "{" +
                    " 学号='" + sno + '\'' +
                    ", 姓名='" + name + '\'' +
                    ", 性别='" + sex + '\'' +
                    ",专业='" + major + '\'' +
                    ", 年级='" + grade + '\'' +
                    ", 账号='" + loginAccount + '\'' +
                    ", 密码='" + passwd + '\'' +
                    ", 打卡次数='" + count + '\'' +
                    '}';
        }
    }
