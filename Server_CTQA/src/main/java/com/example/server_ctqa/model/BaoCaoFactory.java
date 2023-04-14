//package com.example.server_ctqa.model;
//
//
//public class BaoCaoFactory {
//    public static final int BAO_CAO_DOANH_THU_TU_KHACH_HANG = 1;
//    public static final int BAO_CAO_DOANH_THU_TU_TRANG_PHUC = 2;
//    public static final int BAO_CAO_DOANH_THU_THEO_NHA_PHAN_PHOI = 3;
//
//    public static BaoCao taoBaoCao(int loaiBaoCao) {
//        switch (loaiBaoCao) {
//            case BAO_CAO_DOANH_THU_TU_KHACH_HANG:
//                return new BaoCaoKhachHangByDoanhThu();
//            case BAO_CAO_DOANH_THU_TU_TRANG_PHUC:
//                return new BaoCaoTrangPhucByDoanhThu();
//            case BAO_CAO_DOANH_THU_THEO_NHA_PHAN_PHOI:
//                return new BaoCaoNPPByDoanhThu();
//            default:
//                throw new IllegalArgumentException("Loại báo cáo không hợp lệ");
//        }
//    }
//}
