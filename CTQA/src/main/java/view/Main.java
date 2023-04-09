/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.*;
import java.util.List;
import javax.swing.*;

import model.User;

/**
 *
 * @author Administrator
 */
public class Main extends javax.swing.JFrame implements MenuPanel.MenuSelectListener {

    private User user;
    private JPanel contentPanel;

    public Main() {
//        initComponents();
    }

    public Main(User user) {
        this.user = user;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        initLayout();
    }

    private void initLayout() {
        menuPanel = new MenuPanel(user, this);
        contentPanel = new JPanel();

//        overviewSubjectsPanel = new OverviewSubjectsPanel();
//        permutationPanelOne = new PermutationPanel();
//        permutationPanelTwo = new PermutationPanel();
//        referenceInfoPanel = new ReferenceInfoPanel();
//        bagBeatAutoPanel = new BagBeatAutoPanel(this);
//        setContentLayout(overviewSubjectsPanel);
        this.add(menuPanel, BorderLayout.WEST);
        this.add(contentPanel, BorderLayout.CENTER);
    }

    public void setContentLayout(JPanel newContent) {
        contentPanel.removeAll();
        GroupLayout contentLayout = new GroupLayout(contentPanel);
        contentPanel.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
                contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newContent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
        );
        contentLayout.setVerticalGroup(
                contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newContent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
        );
        revalidate();
    }

    @Override
    public void onMenuSelected(String value) {
        switch (value) {
            case MenuPanel.MENU_1:
//                ImportFileDauVaoNew importFileDauVao = new ImportFileDauVaoNew(contentPanel, menuPanel);
//                createDialog("Import dữ liệu đầu vào", importFileDauVao, 332, 169).setVisible(true);
                return;
            case MenuPanel.MENU_2:
//                setContentLayout(new ExamRoomPanel());
                return;
            case MenuPanel.MENU_3:
//                setContentLayout(new ViolationPanel(this));
                return;
            case MenuPanel.MENU_4:
                return;
            case MenuPanel.MENU_5:
                JFrame newFrame = new QuanLyTaiKhoan();
                newFrame.setVisible(true);
                getContentPane().add(newFrame);
                revalidate();
                repaint();
                return;
            default:
                return;
        }
    }
    private MenuPanel menuPanel;
}
