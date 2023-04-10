package processor;

import dao.Impl.UserDAOImpl;
import model.User;

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
        userDAO.insertUser(new User("admin","Admin","1",0));
        userDAO.insertUser(new User("nv","NhanVien","1",1));
    }

    @Override
    public void cleanData() {
        UserDAOImpl.getInstance().deleteTbl();
    }
}
