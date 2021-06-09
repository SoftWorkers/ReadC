/*
 * Created by JFormDesigner on Thu May 20 11:23:09 CST 2021
 */

package ReadClockIn.www.Others;

import ReadClockIn.www.Administrator.AdministratorAdd;
import ReadClockIn.www.Administrator.AdministratorDelet;
import ReadClockIn.www.Administrator.AdministratorQuery;
import ReadClockIn.www.Notes.StudentLog;
import ReadClockIn.www.Student.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class MainFrm extends JFrame {

    //private  JDesktopPane table = null;

    //主函数
    public static void main(String[] args) {
        MainFrm wmwTest=new MainFrm ();
        wmwTest.setVisible(true);
    }


    public MainFrm() {

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


    //增加学生信息
    private void menuItem6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        StudentAdd studentAdd = new StudentAdd ();
        studentAdd.setVisible ( true );
        table.add(studentAdd);

    }

    //学生信息删除
    private void menuItem5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        StudentDelet studentDelet = new StudentDelet ();
        studentDelet.setVisible ( true );
        table.add(studentDelet);

    }

//    //学生信息修改
//    private void menuItem4ActionPerformed(ActionEvent e) {
//        // TODO add your code here
//        StudentUpdate studentRevise = new StudentUpdate ();
//        studentRevise.setVisible ( true );
//        table.add(studentRevise);
//
//    }

    //学生信息查询
    private void menuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        StudentQuery studentQuery = new StudentQuery ();
        studentQuery.setVisible ( true );
        table.add(studentQuery);

    }

    //打卡日志查看
    private void menuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        StudentLog studentLog = new StudentLog ();
        studentLog.setVisible ( true );
        table.add(studentLog);
    }

    //管理员信息增加
    private void menuItem9ActionPerformed(ActionEvent e) {
        // TODO add your code here
        AdministratorAdd administratorAdd = new AdministratorAdd ();
        administratorAdd.setVisible ( true );
        table.add(administratorAdd);
    }

    //管理员信息删除
    private void menuItem8ActionPerformed(ActionEvent e) {
        // TODO add your code here
        AdministratorDelet administratorDelet = new AdministratorDelet ();
        administratorDelet.setVisible ( true );
        table.add(administratorDelet);
    }

    //管理员信息查看
    private void menuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        AdministratorQuery administratorQuery = new AdministratorQuery ();
        administratorQuery.setVisible ( true );
        table.add(administratorQuery);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menuBar2 = new JMenuBar();
        menu1 = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem1 = new JMenuItem();
        menuBar3 = new JMenuBar();
        menu4 = new JMenu();
        menuItem2 = new JMenuItem();
        menuBar4 = new JMenuBar();
        menu7 = new JMenu();
        menuItem9 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menuItem3 = new JMenuItem();
        panel1 = new JPanel();
        table = new JDesktopPane();
        label5 = new JLabel();

        //======== this ========
        setTitle("\u60a6\u8bfb\u6253\u5361\u7ba1\u7406\u7aef-\u4e3b\u754c\u9762");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menuBar2 ========
            {
                menuBar2.setMinimumSize(new Dimension(10, 2));

                //======== menu1 ========
                {
                    menu1.setText("\u5b66\u751f\u4fe1\u606f");
                    menu1.setPreferredSize(new Dimension(130, 30));
                    menu1.setFont(menu1.getFont().deriveFont(menu1.getFont().getSize() + 3f));
                    menu1.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/student.png")));

                    //---- menuItem6 ----
                    menuItem6.setText("\u589e\u52a0");
                    menuItem6.setPreferredSize(new Dimension(130, 30));
                    menuItem6.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/plus.png")));
                    menuItem6.addActionListener(e -> {
			menuItem6ActionPerformed(e);
			menuItem6ActionPerformed(e);
		});
                    menu1.add(menuItem6);

                    //---- menuItem5 ----
                    menuItem5.setText("\u5220\u9664");
                    menuItem5.setPreferredSize(new Dimension(130, 30));
                    menuItem5.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/minus.png")));
                    menuItem5.setIconTextGap(5);
                    menuItem5.addActionListener(e -> menuItem5ActionPerformed(e));
                    menu1.add(menuItem5);

                    //---- menuItem1 ----
                    menuItem1.setText("\u67e5\u8be2\u3001\u4fee\u6539");
                    menuItem1.setPreferredSize(new Dimension(130, 30));
                    menuItem1.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/look.png")));
                    menuItem1.setIconTextGap(1);
                    menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
                    menu1.add(menuItem1);
                }
                menuBar2.add(menu1);
            }
            menuBar1.add(menuBar2);

            //======== menuBar3 ========
            {

                //======== menu4 ========
                {
                    menu4.setText("\u6253\u5361\u65e5\u5fd7");
                    menu4.setPreferredSize(new Dimension(130, 30));
                    menu4.setFont(menu4.getFont().deriveFont(menu4.getFont().getSize() + 3f));
                    menu4.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/file.png")));

                    //---- menuItem2 ----
                    menuItem2.setText("\u67e5\u770b");
                    menuItem2.setPreferredSize(new Dimension(130, 30));
                    menuItem2.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/look.png")));
                    menuItem2.setIconTextGap(1);
                    menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
                    menu4.add(menuItem2);
                }
                menuBar3.add(menu4);
            }
            menuBar1.add(menuBar3);

            //======== menuBar4 ========
            {

                //======== menu7 ========
                {
                    menu7.setText("\u7ba1\u7406\u5458\u4fe1\u606f");
                    menu7.setPreferredSize(new Dimension(130, 30));
                    menu7.setFont(menu7.getFont().deriveFont(menu7.getFont().getSize() + 3f));
                    menu7.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/administor.png")));

                    //---- menuItem9 ----
                    menuItem9.setText("\u589e\u52a0");
                    menuItem9.setPreferredSize(new Dimension(130, 30));
                    menuItem9.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/plus.png")));
                    menuItem9.addActionListener(e -> menuItem9ActionPerformed(e));
                    menu7.add(menuItem9);

                    //---- menuItem8 ----
                    menuItem8.setText("\u5220\u9664");
                    menuItem8.setPreferredSize(new Dimension(130, 30));
                    menuItem8.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/minus.png")));
                    menuItem8.setIconTextGap(5);
                    menuItem8.addActionListener(e -> menuItem8ActionPerformed(e));
                    menu7.add(menuItem8);

                    //---- menuItem3 ----
                    menuItem3.setText("\u67e5\u8be2");
                    menuItem3.setPreferredSize(new Dimension(130, 30));
                    menuItem3.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/look.png")));
                    menuItem3.setIconTextGap(1);
                    menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
                    menu7.add(menuItem3);
                }
                menuBar4.add(menu7);
            }
            menuBar1.add(menuBar4);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setMinimumSize(null);
            panel1.setLayout(new BorderLayout());

            //======== table ========
            {
                table.setBackground(new Color(204, 204, 204));

                //---- label5 ----
                label5.setIcon(new ImageIcon(getClass().getResource("/ReadClockIn/picture/blackground.jpg")));
                table.add(label5, JLayeredPane.DEFAULT_LAYER);
                label5.setBounds(0, 0, 585, 480);
            }
            panel1.add(table, BorderLayout.CENTER);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 573, 475);

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
    private JMenuBar menuBar1;
    private JMenuBar menuBar2;
    private JMenu menu1;
    private JMenuItem menuItem6;
    private JMenuItem menuItem5;
    private JMenuItem menuItem1;
    private JMenuBar menuBar3;
    private JMenu menu4;
    private JMenuItem menuItem2;
    private JMenuBar menuBar4;
    private JMenu menu7;
    private JMenuItem menuItem9;
    private JMenuItem menuItem8;
    private JMenuItem menuItem3;
    private JPanel panel1;
    private JDesktopPane table;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
