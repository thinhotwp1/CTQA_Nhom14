/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.BaoCaoFactory;

import model.User;

/**
 *
 * @author Administrator
 */
public class Main extends javax.swing.JFrame implements MenuPanel.MenuSelectListener {

    private User user;
    private JPanel contentPanel;
    private Toolbar toolbarPanel;

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
        toolbarPanel = new Toolbar(user, this);

//        overviewSubjectsPanel = new OverviewSubjectsPanel();
//        permutationPanelOne = new PermutationPanel();
//        permutationPanelTwo = new PermutationPanel();
//        referenceInfoPanel = new ReferenceInfoPanel();
//        bagBeatAutoPanel = new BagBeatAutoPanel(this);
//        setContentLayout(overviewSubjectsPanel);
        this.add(menuPanel, BorderLayout.WEST);
        this.add(contentPanel, BorderLayout.CENTER);
        this.add(toolbarPanel, BorderLayout.NORTH);
        this.pack();
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
                return;
            case MenuPanel.MENU_2:
                return;
            case MenuPanel.MENU_3:
                return;
            case MenuPanel.MENU_4:
                return;
            case MenuPanel.MENU_4_1:
              setContentLayout((JPanel) BaoCaoFactory.taoBaoCao(BaoCaoFactory.BAO_CAO_DOANH_THU_TU_TRANG_PHUC).taoBaoCao());
                return;
            case MenuPanel.MENU_4_2:
              setContentLayout((JPanel) BaoCaoFactory.taoBaoCao(BaoCaoFactory.BAO_CAO_DOANH_THU_TU_KHACH_HANG).taoBaoCao());
                return;
            case MenuPanel.MENU_4_3:
              setContentLayout((JPanel) BaoCaoFactory.taoBaoCao(BaoCaoFactory.BAO_CAO_DOANH_THU_THEO_NHA_PHAN_PHOI).taoBaoCao());
                return;
            case MenuPanel.MENU_5:
                setContentLayout(new QuanLyUser());
                return;
            default:
                return;
        }
    }
    private MenuPanel menuPanel;
}
