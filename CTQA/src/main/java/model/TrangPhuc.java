package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrangPhuc {
    private int id;
    private String tenTrangPhuc;
    private int loaiTrangPhuc;
    private String soDienThoai;
    private String diaChi;
    private double giaChoThue;
    private double doanhThuTuTrangPhuc;
}
