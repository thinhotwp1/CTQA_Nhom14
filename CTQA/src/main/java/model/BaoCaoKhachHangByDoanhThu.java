/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import view.BaoCaoView;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaoCaoKhachHangByDoanhThu implements BaoCao{
    private String tenBaoCao;
    private int loaiBaoCao;
    private double tongDoanhThu;
    private String moTa;
    private List<KhachHang> listKH;

    
    @Override
    public BaoCaoView taoBaoCao() {
        return (BaoCaoView) new view.BaoCaoKhachHangByDoanhThu();
    }
    
}
