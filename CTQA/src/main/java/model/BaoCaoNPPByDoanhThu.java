/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class BaoCaoNPPByDoanhThu implements BaoCao{
    private String tenBaoCao;
    private int loaiBaoCao;
    private double tongDoanhThu;
    private String moTa;
    private List<NhaPhanPhoi> listNPP;
    
    @Override
    public void taoBaoCao() {
        System.out.println("BaoCaoNPPByDoanhThu");
    }
    
}