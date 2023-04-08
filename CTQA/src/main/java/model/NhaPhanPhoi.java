package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_trangphuc")
public class NhaPhanPhoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenNhaPhanPhoi;
    private String soDienThoai;
    private String diaChi;
    private double doanhThuTuNPP;
    private int soLuongDaNhap;

}
