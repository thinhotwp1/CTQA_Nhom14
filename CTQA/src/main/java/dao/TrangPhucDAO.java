/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.TrangPhuc;

/**
 *
 * @author DUY THINH
 */
public interface TrangPhucDAO {
    void createTableTrangPhuc();

    void deleteTbl();

    boolean insertTrangPhuc(TrangPhuc TrangPhuc);
    
    int updateInfor(String TrangPhuc, String fullname, String pass);

    boolean deleteTrangPhuc(String TrangPhuc);

    List<TrangPhuc> getListTrangPhuc();
    
    int countListTrangPhuc();

    TrangPhuc findOne(String tenTrangPhuc);
    
    boolean checkAccount(String soDienThoai);
}
