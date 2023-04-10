package processor.Imp;

import dao.Impl.KhachHangDAOImp;
import dao.Impl.TrangPhucDAOImp;
import dao.Impl.UserDAOImpl;
import model.KhachHang;
import model.TrangPhuc;
import model.User;
import processor.InitDataProcess;

public class InitDataProcessImp implements InitDataProcess {

    private static InitDataProcessImp sInstance;

    public static InitDataProcessImp getInstance() {
        if (sInstance == null) {
            sInstance = new InitDataProcessImp();
        }
        return sInstance;
    }

    @Override
    public void initData() {
        UserDAOImpl userDAO = UserDAOImpl.getInstance();
        userDAO.createTableUser();
        userDAO.insertUser(new User("admin", "Admin", "1", 0));
        userDAO.insertUser(new User("nv", "NhanVien", "1", 1));

        KhachHangDAOImp khachHangDAOImp = new KhachHangDAOImp();
        khachHangDAOImp.createTableKhachHang();
        khachHangDAOImp.insertKhachHang(new KhachHang("Chou Beo", "0923001270", "Hà Đông", 150000));
        khachHangDAOImp.insertKhachHang(new KhachHang("Thinh Beo", "0923001271", "Cổ Nhuế 2", 120000));
        khachHangDAOImp.insertKhachHang(new KhachHang("Beo Beo", "0923001273", "Hà Đông", 200000));

        TrangPhucDAOImp trangPhucDAOImp = new TrangPhucDAOImp();
        trangPhucDAOImp.createTableTrangPhuc();
        trangPhucDAOImp.insertTrangPhuc(new TrangPhuc("Quần Jean", TrangPhuc.QUAN_AO_DA_HOI, 150000, 11100000, "Quần jean dễ dàng phối đồ"));
        trangPhucDAOImp.insertTrangPhuc(new TrangPhuc("Áo da", TrangPhuc.QUAN_AO_SU_KIEN, 150000, 12500000, "Áo da phong cách"));
        trangPhucDAOImp.insertTrangPhuc(new TrangPhuc("Áo khoác", TrangPhuc.QUAN_AO_SU_KIEN, 250000, 22500000, "Áo khoác chuẩn men"));
    }

    @Override
    public void cleanData() {
//        UserDAOImpl.getInstance().deleteTbl();
//        KhachHangDAOImp khachHangDAOImp = new KhachHangDAOImp();
//        TrangPhucDAOImp TrangPhucDAOImp = new TrangPhucDAOImp();
//        TrangPhucDAOImp.deleteTbl();
//        KhachHangDAOImp khachHangDAOImp = new KhachHangDAOImp();
//        khachHangDAOImp.deleteTbl();
    }
}
