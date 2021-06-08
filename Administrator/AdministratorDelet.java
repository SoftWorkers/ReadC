/*
 * Created by JFormDesigner on Fri May 21 23:35:10 CST 2021
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
public class AdministratorDelet extends JFrame {

    private DBconnection dbconnection = new DBconnection ();
    private AdministratorDeletDao administratorDeletDao = new AdministratorDeletDao ();

    //主函数
    public static void main(String[] args) {
        AdministratorDelet administratorDelet = new AdministratorDelet ();
        administratorDelet.setVisible(true);
    }

    public AdministratorDelet() {

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
        this.AdministratorDeletAccontTxt.setText("");
    }

    //解除管理员
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String delAccout = this.AdministratorDeletAccontTxt.getText ();
        if (StringUtil.isEmpty ( delAccout )) {
            JOptionPane.showMessageDialog ( null,"账号不能为空！" );
            return;
        }
        Administrator administrator = new Administrator ( delAccout );
        Connection con = null;
        try {
            con = dbconnection.getConnection ();
            int n = AdministratorDeletDao.delet(con, administrator);
            if(n == 1) {
                JOptionPane.showMessageDialog ( null,"管理员解除成功！" );
                resetValue();
            } else {
                JOptionPane.showMessageDialog ( null , "管理员解除失败！" );
            }
        } catch (Exception et) {
            et.printStackTrace();
            JOptionPane.showMessageDialog ( null , "管理员解除失败！" );
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        AdministratorDeletAccontTxt = new JTextField();
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label8 = new JLabel();

        //======== this ========
        setTitle("\u89e3\u9664\u7ba1\u7406\u5458");
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setLayout(null);
            panel1.add(AdministratorDeletAccontTxt);
            AdministratorDeletAccontTxt.setBounds(235, 110, 120, 35);

            //---- label5 ----
            label5.setText("\u8d26\u53f7\uff1a");
            panel1.add(label5);
            label5.setBounds(165, 115, 55, 20);

            //---- button1 ----
            button1.setText("\u89e3\u9664");
            button1.addActionListener(e -> button1ActionPerformed(e));
            panel1.add(button1);
            button1.setBounds(160, 250, 70, 30);

            //---- button2 ----
            button2.setText("\u91cd\u7f6e");
            button2.addActionListener(e -> {
			button2ActionPerformed(e);
			button2ActionPerformed(e);
			button2ActionPerformed(e);
		});
            panel1.add(button2);
            button2.setBounds(300, 250, 70, 30);

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
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JTextField AdministratorDeletAccontTxt;
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
