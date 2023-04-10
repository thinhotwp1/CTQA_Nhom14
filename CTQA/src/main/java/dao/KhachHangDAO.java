/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.KhachHang;

/**
 *
 * @author Administrator
 */
public interface KhachHangDAO {
    void createTableKhachHang();

    void deleteTbl();

    boolean insertKhachHang(KhachHang KhachHang);
    
    int updateInfor(String KhachHang, String fullname, String pass);

    boolean deleteKhachHang(String KhachHang);

    List<KhachHang> getListKhachHang();
    
    int countListKhachHang();

    KhachHang findOne(String KhachHang);
    
    boolean checkAccount(String soDienThoai);
}
