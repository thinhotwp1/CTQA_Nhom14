package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrangPhuc {
    
    static public final int QUAN_AO_DA_HOI =0;
    static public final int QUAN_AO_SU_KIEN =1;
    
    
    private int id;
    private String tenTrangPhuc;
    private int loaiTrangPhuc;
    private double giaChoThue;
    private double doanhThuTuTrangPhuc;
    private String moTa;

    public TrangPhuc(String tenTrangPhuc, int loaiTrangPhuc, double giaChoThue, double doanhThuTuTrangPhuc, String moTa) {
        this.tenTrangPhuc = tenTrangPhuc;
        this.loaiTrangPhuc = loaiTrangPhuc;
        this.giaChoThue = giaChoThue;
        this.doanhThuTuTrangPhuc = doanhThuTuTrangPhuc;
        this.moTa = moTa;
    }


    
    
}
