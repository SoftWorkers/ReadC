/*
 * Created by JFormDesigner on Fri May 21 23:34:41 CST 2021
 */

package ReadClockIn.www.Administrator;

import ReadClockIn.www.Others.DBconnection;
import ReadClockIn.www.Others.StringUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class AdministratorAdd extends JFrame {

    private DBconnection dbconnection = new DBconnection ();
    private AdministratorAddDao administratorAddDao = new AdministratorAddDao ();

    //主函数
    public static void main(String[] args) {
        AdministratorAdd administratorAdd = new AdministratorAdd ();
        administratorAdd.setVisible(true);
    }

    public AdministratorAdd() {

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

        initComponents();
    }

    //重置表单
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.resetValue ();
    }

    private void resetValue(){
        this.AdministratorAddAccontTxt.setText("");
        this.AdministratorAddPasswdTxt.setText("");
    }

    //添加管理员
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String newAccout = this.AdministratorAddAccontTxt.getText ();
        String newPasswd = this.AdministratorAddPasswdTxt.getText ();
        if (StringUtil.isEmpty ( newAccout )) {
            JOptionPane.showMessageDialog ( null,"账号不能为空！" );
            return;
        }
        if (StringUtil.isEmpty ( newPasswd )) {
            JOptionPane.showMessageDialog ( null,"密码不能为空！" );
            return;
        }
        Administrator administrator = new Administrator ( newAccout, newPasswd );
        Connection con = null;
        try {
            con = dbconnection.getConnection ();
            int n = AdministratorAddDao.add(con, administrator);
            if(n == 1) {
                JOptionPane.showMessageDialog ( null,"管理员添加成功！" );
                resetValue();
            } else {
                JOptionPane.showMessageDialog ( null , "管理员添加失败！" );
            }
        } catch (Exception et) {
            et.printStackTrace();
            JOptionPane.showMessageDialog ( null , "管理员添加失败！" );
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        AdministratorAddAccontTxt = new JTextField();
        label5 = new JLabel();
        AdministratorAddPasswdTxt = new JTextField();
        label6 = new JLabel();
        button2 = new JButton();
        button1 = new JButton();
        label8 = new JLabel();

        //======== this ========
        setTitle("\u6dfb\u52a0\u7ba1\u7406\u5458");
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setLayout(null);
            panel1.add(AdministratorAddAccontTxt);
            AdministratorAddAccontTxt.setBounds(220, 75, 120, 35);

            //---- label5 ----
            label5.setText("\u8d26\u53f7\uff1a");
            panel1.add(label5);
            label5.setBounds(155, 85, 55, 20);
            panel1.add(AdministratorAddPasswdTxt);
            AdministratorAddPasswdTxt.setBounds(220, 150, 120, 35);

            //---- label6 ----
            label6.setText("\u5bc6\u7801\uff1a");
            panel1.add(label6);
            label6.setBounds(155, 155, 55, 25);

            //---- button2 ----
            button2.setText("\u91cd\u7f6e");
            button2.addActionListener(e -> {
			button2ActionPerformed(e);
			button2ActionPerformed(e);
		});
            panel1.add(button2);
            button2.setBounds(295, 265, 70, 30);

            //---- button1 ----
            button1.setText("\u6dfb\u52a0");
            button1.addActionListener(e -> button1ActionPerformed(e));
            panel1.add(button1);
            button1.setBounds(145, 265, 70, 30);

            //---- label8 ----
            label8.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/blackground.jpg")));
            panel1.add(label8);
            label8.setBounds(0, 0, 600, 480);

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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JTextField AdministratorAddAccontTxt;
    private JLabel label5;
    private JTextField AdministratorAddPasswdTxt;
    private JLabel label6;
    private JButton button2;
    private JButton button1;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
