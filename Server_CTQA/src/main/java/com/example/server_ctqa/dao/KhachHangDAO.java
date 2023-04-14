package com.example.server_ctqa.dao;


import com.example.server_ctqa.model.KhachHang;

import java.util.List;

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