/*
 * Created by JFormDesigner on Sat May 22 19:20:49 CST 2021
 */

package ReadClockIn.www.Administrator;

import ReadClockIn.www.Others.DBconnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author Brainrain
 */
public class AdministratorQuery extends JFrame {

    private DBconnection dbconnection = new DBconnection ();
    private AdministratorQueryDao administratorQueryDao = new AdministratorQueryDao ();

    //主函数
    public static void main(String[] args) {
        AdministratorQuery administratorQuery = new AdministratorQuery ();
        administratorQuery.setVisible(true);
    }

    public AdministratorQuery() {

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
        this.AdministratorQueryAccontTxt.setText("");
    }

    //模糊查询
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String queryAccount = this.AdministratorQueryAccontTxt.getText ();
        Administrator administrator = new Administrator ( );
        administrator.setAccount ( queryAccount );
        this.fillTable ( administrator );
    }

    //初始化表格
    private void fillTable(Administrator administrator) {
        DefaultTableModel dtm = (DefaultTableModel) administratortable.getModel();
        dtm.setRowCount ( 0 ); //设置成0行
        Connection con = null;
        try {
            con = dbconnection.getConnection ();
            ResultSet rs = AdministratorQueryDao.list(con, administrator);
            while(rs.next()) {
                Vector v = new Vector();
                v.add( rs.getInt ( "id" ) );
                v.add( rs.getString ( "account" ) );
                v.add( rs.getString ( "password" ) );
                dtm.addRow( v );
            }
        }catch (Exception et) {
            et.printStackTrace();
        }

//        finally {
//            try {
//                dbconnection.closeCon ( con );
//            } catch (Exception et) {
//                et.printStackTrace();
//            }
//        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        AdministratorQueryAccontTxt = new JTextField();
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        administratortable = new JTable();
        label8 = new JLabel();

        //======== this ========
        setTitle("\u67e5\u8be2\u7ba1\u7406\u5458");
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setLayout(null);
            panel1.add(AdministratorQueryAccontTxt);
            AdministratorQueryAccontTxt.setBounds(165, 50, 120, 35);

            //---- label5 ----
            label5.setText("\u8d26\u53f7\uff1a");
            panel1.add(label5);
            label5.setBounds(105, 55, 55, 20);

            //---- button1 ----
            button1.setText("\u67e5\u8be2");
            button1.addActionListener(e -> {
			button1ActionPerformed(e);
			button1ActionPerformed(e);
			button1ActionPerformed(e);
		});
            panel1.add(button1);
            button1.setBounds(325, 50, 70, 30);

            //---- button2 ----
            button2.setText("\u91cd\u7f6e");
            button2.addActionListener(e -> {
			button2ActionPerformed(e);
			button2ActionPerformed(e);
			button2ActionPerformed(e);
		});
            panel1.add(button2);
            button2.setBounds(415, 50, 70, 30);

            //======== scrollPane1 ========
            {

                //---- administratortable ----
                administratortable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u7f16\u53f7", "\u8d26\u53f7", "\u5bc6\u7801"
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        false, false, true
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                scrollPane1.setViewportView(administratortable);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(80, 120, 388, 240);

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
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        this.fillTable ( new Administrator ( ) );
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JTextField AdministratorQueryAccontTxt;
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable administratortable;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
