package com.example.server_ctqa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
    private String tenKhachHang;
    private String soDienThoai;
    private String diaChi;
    private double doanhThuTuKhachHang;
}
