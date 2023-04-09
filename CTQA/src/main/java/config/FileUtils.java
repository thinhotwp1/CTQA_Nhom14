package config;


import org.apache.logging.log4j.LogManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FileUtils {

    private static final String BASED_PATH_DATA = "/config/data";
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(FileUtils.class);

    static {
        File f = new File(BASED_PATH_DATA);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    public static final String PATH_IMAGE_ICON = "./bin/image/CTDP_1.png";

    public static String getAbsolutePathApplication() {
        String dir = System.getProperty("user.dir");
        return dir;
    }

    public static String chooseFile() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter(
                "Excel file", "xls", "xlsx"
        ));
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile();
            System.out.println("File Selected :"
                    + file.getName());
            return file.getAbsolutePath();
        } else {
            System.out.println("Open command cancelled by user.");
            return null;
        }
    }

    public static String chooseFolder() {
        JFileChooser fc = new JFileChooser();
//        fc.setCurrentDirectory(new java.io.File("."));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        fc.setDialogTitle("Chọn thư mục để lưu xuống");
        int returnVal = fc.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile();
            return file.getAbsolutePath();
        } else {
            return null;
        }
    }

    public static JDialog createDialogLoading(String title, JPanel content) {
        JDialog dialog1 = new JDialog();
        dialog1.setTitle(title);
        dialog1.setSize(96, 37);
        dialog1.setResizable(false);
        dialog1.setLocationRelativeTo(null);
        dialog1.add(content);
        dialog1.setUndecorated(true);
        dialog1.setAlwaysOnTop(true);
        dialog1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        return dialog1;
    }

    public static JDialog createDialog(String title, JPanel content,int width,int height) {
        JDialog dialog1 = new JDialog();
        dialog1.setTitle(title);
        dialog1.setSize(width, height);
        dialog1.setResizable(false);
        dialog1.setLocationRelativeTo(null);
        dialog1.add(content);
        dialog1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        return dialog1;
    }

}
