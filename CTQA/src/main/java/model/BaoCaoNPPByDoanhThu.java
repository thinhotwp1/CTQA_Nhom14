/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import view.BaoCaoView;

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
    public BaoCaoView taoBaoCao() {
        return (BaoCaoView) new view.BaoCaoNPPByDoanhThu();
    }
    
}