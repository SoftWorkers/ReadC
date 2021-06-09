/*
 * Created by JFormDesigner on Wed May 19 20:30:48 CST 2021
 */

package ReadClockIn.www.Others;

import ReadClockIn.www.Administrator.Administrator;
import ReadClockIn.www.Administrator.AdministratorDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class LogOnFrm extends JFrame {

    private DBconnection dbconnection = new DBconnection ();
    private AdministratorDao administratorDao = new AdministratorDao ();

    //主函数
    public static void main(String[] args) {
        LogOnFrm wmwTest = new LogOnFrm ();
        wmwTest.setVisible(true);
    }

    public LogOnFrm() {
        //改变系统默认字体
        Font font = new Font("Dialog", Font.PLAIN, 12);
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()){
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, font);
            }
        }

        //设置窗窗体居中
        this.setLocationRelativeTo ( null );

        initComponents();
    }


    //账号密码重置清空
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.accountTxt.setText("");
        this.passwordTxt.setText("");
    }

    //登录
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String account = this.accountTxt.getText ();
        String password = this.passwordTxt.getText ();
        if (StringUtil.isEmpty ( account )) {
            JOptionPane.showMessageDialog ( null , "账号不能为空！" );
            return;
        }
        if (StringUtil.isEmpty ( password )) {
            JOptionPane.showMessageDialog ( null , "密码不能为空！" );
            return;
        }
        Administrator administrator = new Administrator ( account , password );
        Connection con = null;
        try {
            con = dbconnection.getConnection();
            Administrator currentAdministrator = administratorDao.login ( con, administrator );
            if (currentAdministrator != null) {
                dispose ();
                new MainFrm ().setVisible ( true );
                //JOptionPane.showMessageDialog ( null , "登录成功！" );
            } else {
                JOptionPane.showMessageDialog ( null , "账号密码错误！" );
            }
        } catch (Exception et) {
            et.printStackTrace ();
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        accountTxt = new JTextField();
        passwordTxt = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        setTitle("\u60a6\u8bfb\u6253\u5361\u7ba1\u7406\u7aef-login");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("\u7528\u6237\u540d:");
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
            panel1.add(label2);
            label2.setBounds(175, 170, 65, 22);

            //---- label3 ----
            label3.setText("\u5bc6   \u7801:");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
            panel1.add(label3);
            label3.setBounds(175, 220, 65, 22);
            panel1.add(accountTxt);
            accountTxt.setBounds(260, 168, 135, 25);
            panel1.add(passwordTxt);
            passwordTxt.setBounds(260, 220, 135, 25);

            //---- button1 ----
            button1.setText("\u767b\u5f55");
            button1.addActionListener(e -> button1ActionPerformed(e));
            panel1.add(button1);
            button1.setBounds(320, 295, 75, 30);

            //---- button2 ----
            button2.setText("\u91cd\u7f6e");
            button2.addActionListener(e -> {
			button2ActionPerformed(e);
			button2ActionPerformed(e);
		});
            panel1.add(button2);
            button2.setBounds(175, 295, 75, 30);

            //---- label1 ----
            label1.setText("\u60a6\u8bfb\u6253\u5361\u7ba1\u7406\u7aef");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() & ~Font.BOLD, label1.getFont().getSize() + 17f));
            panel1.add(label1);
            label1.setBounds(215, 65, 230, 75);

            //---- label4 ----
            label4.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/logo.png")));
            panel1.add(label4);
            label4.setBounds(125, 60, 80, 90);

            //---- label5 ----
            label5.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/blackground.jpg")));
            panel1.add(label5);
            label5.setBounds(0, 0, 575, 420);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 575, 420);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label2;
    private JLabel label3;
    private JTextField accountTxt;
    private JTextField passwordTxt;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
