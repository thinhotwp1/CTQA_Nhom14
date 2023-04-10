/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import model.KhachHang;

/**
 * @author Viet Do
 */
public class ExportDataUtils extends ExportBase {

    public static void exportExcelKhachHang(String filePath, List<KhachHang> listData) {
        String fileName = filePath + File.separator + "KHACH_HANG" + ".xlsx";
        FileOutputStream fos = null;
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Khach_hang");

            XSSFCellStyle style = workbook.createCellStyle();
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);

            createColumn(COLUMNS_KHACH_HANG, sheet, workbook);
            int rowNum = 1;
            int stt = 1;
            for (KhachHang bb : listData) {
                Row row = sheet.createRow(rowNum++);
                //set cell
                Cell cell = row.createCell(0);
                cell.setCellValue(stt++);
                cell.setCellStyle(style);
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(bb.getTenKhachHang());
                cell2.setCellStyle(style);
                Cell cell3 = row.createCell(2);
                cell3.setCellValue(bb.getSoDienThoai());
                cell3.setCellStyle(style);
                Cell cell4 = row.createCell(3);
                cell4.setCellValue(bb.getDiaChi());
                cell4.setCellStyle(style);
                Cell cell5 = row.createCell(4);
                cell5.setCellValue(bb.getDoanhThuTuKhachHang());
                cell5.setCellStyle(style);
            }
            autoResizeColumn(sheet, COLUMNS_KHACH_HANG.length);
            //xuat
            fos = new FileOutputStream(fileName);
            workbook.write(fos);
            workbook.close();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }

    }

    private static void createColumn(String[] listColumn, XSSFSheet sheet, Workbook workbook) {
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 11);
        style.setFont(font);

        Row row = sheet.createRow(0);
        int countColumn = 0;
        for (String s : listColumn) {
            Cell cell = row.createCell(countColumn++);
            cell.setCellValue(s);
            cell.setCellStyle(style);
            CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);
            CellUtil.setVerticalAlignment(cell, VerticalAlignment.CENTER);
        }
        autoResizeColumn(sheet, listColumn.length);
    }


    private static void autoResizeColumn(Sheet sheet, int lengthColumn) {
        for (int i = 0; i < lengthColumn; i++) {
            sheet.autoSizeColumn(i, true);
        }
    }
}
