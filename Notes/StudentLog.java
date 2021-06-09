/*
 * Created by JFormDesigner on Fri May 21 16:16:10 CST 2021
 */

package ReadClockIn.www.Notes;

import ReadClockIn.www.Others.DBconnection;
import ReadClockIn.www.Student.Student;
import ReadClockIn.www.Student.StudentQuery;
import ReadClockIn.www.Student.StudentQueryDao;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class StudentLog extends JFrame {

    private DBconnection dbconnection = new DBconnection ();
    private StudentLogDao studentLogDao = new StudentLogDao ();

    //主函数
    public static void main(String[] args) {
        StudentLog studentLog = new StudentLog ();
        studentLog.setVisible(true);
    }

    public StudentLog() {

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


    //重置
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.resetValue ();
    }

    //模糊查询
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String querysno = this.StduentLogSnoTxt.getText ();
        Notes notes = new Notes ( );
        notes.setSno ( querysno );
        this.fillTable ( notes );
    }

    //初始化表格
    private void fillTable(Notes notes) {
        DefaultTableModel dtm = (DefaultTableModel) studentlogtable.getModel();
        dtm.setRowCount ( 0 ); //设置成0行
        Connection con = null;
        try {
            con = dbconnection.getConnection ();
            ResultSet rs = StudentLogDao.list(con, notes);
            while(rs.next()) {
                Vector v = new Vector();
                v.add( rs.getInt ( "id" ) );
                v.add( rs.getString ( "sno" ) );
                v.add( rs.getString ( "name" ) );
                v.add( rs.getString ( "time" ) );
                v.add( rs.getString ( "count" ) );
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

    private void resetValue(){
        this.StduentLogSnoTxt.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        StduentLogSnoTxt = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        studentlogtable = new JTable();
        label8 = new JLabel();

        //======== this ========
        setBackground(new Color(204, 204, 204));
        setTitle("\u67e5\u770b\u5b66\u751f\u6253\u5361\u65e5\u5fd7");
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setLayout(null);
            panel1.add(StduentLogSnoTxt);
            StduentLogSnoTxt.setBounds(145, 30, 120, 35);

            //---- button1 ----
            button1.setText("\u67e5\u8be2");
            button1.addActionListener(e -> {
			button1ActionPerformed(e);
			button1ActionPerformed(e);
		});
            panel1.add(button1);
            button1.setBounds(300, 35, 70, 30);

            //---- button2 ----
            button2.setText("\u91cd\u7f6e");
            button2.addActionListener(e -> {
			button2ActionPerformed(e);
			button2ActionPerformed(e);
			button2ActionPerformed(e);
			button2ActionPerformed(e);
			button2ActionPerformed(e);
		});
            panel1.add(button2);
            button2.setBounds(395, 35, 70, 30);

            //---- label1 ----
            label1.setText("\u5b66\u53f7\uff1a");
            panel1.add(label1);
            label1.setBounds(90, 35, 55, 25);

            //======== scrollPane1 ========
            {

                //---- studentlogtable ----
                studentlogtable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u7f16\u53f7", "\u5b66\u53f7", "\u59d3\u540d", "\u65f6\u95f4", "\u6253\u5361\u6b21\u6570"
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, false, false
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                scrollPane1.setViewportView(studentlogtable);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(40, 95, 490, 270);

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
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JTextField StduentLogSnoTxt;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable studentlogtable;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
