package view;

import model.User;
import adapter.MenuTreeCellRenderer;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends javax.swing.JPanel{
    
    public static final String MENU_1 = "Cho thuê trang phục";
    public static final String MENU_1_1 = "Cho thuê trang phục offline";
    public static final String MENU_1_2 = "Cho thuê trang phục online";
    public static final String MENU_2 = "Nhập hàng";
    public static final String MENU_3 = "Trả trang phục và thanh toán";
    public static final String MENU_4 = "Báo cáo";
    public static final String MENU_4_1 = "Báo cáo doanh thu theo trang phục";
    public static final String MENU_4_2 = "Báo cáo doanh thu theo khách hàng";
    public static final String MENU_5 = "Quản lý tài khoản";

    MenuSelectListener event;
    User currentUser;
    DefaultMutableTreeNode rootMenu;
    MenuTreeCellRenderer menuItem;
    public MenuPanel(User user, MenuSelectListener event) {
        this.event = event;
        this.currentUser = user;
        //create the root node
        rootMenu = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode choThueNode = new DefaultMutableTreeNode(MENU_1);
        choThueNode.add(new DefaultMutableTreeNode(MENU_1_1));
        choThueNode.add(new DefaultMutableTreeNode(MENU_1_2));

        DefaultMutableTreeNode nhapHangNode = new DefaultMutableTreeNode(MENU_2);
//        nhapHangNode.add(new DefaultMutableTreeNode(MENU_2));

        DefaultMutableTreeNode traVaThanhToan = new DefaultMutableTreeNode(MENU_3);
//        traVaThanhToan.add(new DefaultMutableTreeNode(MENU_3));

        DefaultMutableTreeNode baoCao = new DefaultMutableTreeNode(MENU_4);
        baoCao.add(new DefaultMutableTreeNode(MENU_4_1));
        baoCao.add(new DefaultMutableTreeNode(MENU_4_2));

        DefaultMutableTreeNode quanLyTaiKhoan = new DefaultMutableTreeNode(MENU_5);
        //create the child nodes
        switch (user.getRole()) {
            case User.ROLE_ADMIN:
                rootMenu.add(choThueNode);
                rootMenu.add(nhapHangNode);
                rootMenu.add(traVaThanhToan);
                rootMenu.add(baoCao);
                rootMenu.add(quanLyTaiKhoan);
                break;
            case User.ROLE_NHAN_VIEN:
                rootMenu.add(choThueNode);
                rootMenu.add(nhapHangNode);
                rootMenu.add(traVaThanhToan);
                break;

        }

        //add the child nodes to the root node
        menuItem = new MenuTreeCellRenderer();

        initComponents();
//        treeMenu.addTreeSelectionListener(new TreeSelectionListener() {
//            @Override
//            public void valueChanged(TreeSelectionEvent e) {
//                DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeMenu.getLastSelectedPathComponent();
//                event.onMenuSelected(node.getUserObject().toString());
//            }
//        });
        treeMenu.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeMenu.getLastSelectedPathComponent();
//                event.onMenuSelected(node.getUserObject().toString());
//            }

            @Override
            public void mousePressed(MouseEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeMenu.getLastSelectedPathComponent();
                event.onMenuSelected(node.getUserObject().toString());
            }
        });
    }
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        treeMenu = new javax.swing.JTree(rootMenu);

        treeMenu.setCellRenderer(menuItem);
        treeMenu.setRootVisible(false);
        treeMenu.setRowHeight(25);
        treeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(treeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );
    }
    public static interface MenuSelectListener {

        void onMenuSelected(String value);
    }
    private void treeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeMenuMouseClicked
        // TODO add your handling code here:
//        int selRow = treeMenu.getRowForLocation(evt.getX(), evt.getY());

    }//GEN-LAST:event_treeMenuMouseClicked
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree treeMenu;
}
