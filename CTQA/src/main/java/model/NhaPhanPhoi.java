package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhaPhanPhoi {
    private String tenNhaPhanPhoi;
    private String soDienThoai;
    private String diaChi;
    private double doanhThuTuNhaPhanPhoi;

}
