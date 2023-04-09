package model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User implements Serializable{
    
    public static final int ROLE_ADMIN = 0;
    public static final int ROLE_NHAN_VIEN = 1;
    private String tenTaiKhoan;
    private String tenNhanVien;
    private String matKhau;
    private int role; // 0:admin hoac 1:nhan vien

    public User(String tenTaiKhoan, String tenNhanVien, String matKhau, int role) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.tenNhanVien = tenNhanVien;
        this.matKhau = matKhau;
        this.role = role;
    }
}
