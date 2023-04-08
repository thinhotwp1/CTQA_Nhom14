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
public class TrangPhuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenTrangPhuc;
    private int loaiTrangPhuc;
    private String soDienThoai;
    private String diaChi;
    private double giaChoThue;
    private double doanhThuTuTrangPhuc;
}
