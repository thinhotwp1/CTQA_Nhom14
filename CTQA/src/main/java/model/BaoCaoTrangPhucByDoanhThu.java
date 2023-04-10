/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import view.BaoCaoView;

/**
 *
 * @author Administrator
 */
public class BaoCaoTrangPhucByDoanhThu implements BaoCao{

    
    @Override
    public BaoCaoView taoBaoCao() {
        return (BaoCaoView) new view.BaoCaoTrangPhucByDoanhThu();
    }
    
}
