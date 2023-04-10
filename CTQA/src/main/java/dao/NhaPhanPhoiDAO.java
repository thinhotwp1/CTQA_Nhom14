
package dao;

import java.util.List;
import model.NhaPhanPhoi;

/**
 *
 * @author Administrator
 */
public interface NhaPhanPhoiDAO {
    void createTableNhaPhanPhoi();

    void deleteTbl();

    boolean insertNhaPhanPhoi(NhaPhanPhoi NhaPhanPhoi);
    
    int updateInfor(String NhaPhanPhoi, String fullname, String pass);

    boolean deleteNhaPhanPhoi(String NhaPhanPhoi);

    List<NhaPhanPhoi> getListNhaPhanPhoi();
    
    int countListNhaPhanPhoi();

    NhaPhanPhoi findOne(String NhaPhanPhoi);
    
    boolean checkAccount(String soDienThoai);
}
