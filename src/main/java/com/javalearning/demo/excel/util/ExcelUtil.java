package com.javalearning.demo.excel.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javalearning.demo.excel.comm.ExcelTag;
import com.javalearning.demo.excel.comm.WbType;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xujie
 * @date2019/11/22 14:49
 */
public class ExcelUtil {

    private static SimpleDateFormat DATEFORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static int sheetsize = 10000;//每一页10000条数据


    public static <T> void listToExecl(List<T> data, Map<String, String> fields) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 如果导入数据为空，则抛出异常
        if (CollectionUtils.isEmpty(data)) {
            workbook.close();
            throw new Exception("导入的数据为空");
        }
        // 计算有多少页sheet
        int pages = getSheetPages(sheetsize, data.size());
        // 提取表格的字段名（英文字段名是为了对照中文字段名的）
        String[] egtitles = new String[fields.size()];
        String[] cntitles = new String[fields.size()];
        Iterator<String> it = fields.keySet().iterator();
        int count = 0;
        while (it.hasNext()) {
            String egtitle = (String) it.next();
            String cntitle = fields.get(egtitle);
            egtitles[count] = egtitle;
            cntitles[count] = cntitle;
            count++;
        }
        // 添加数据
        for (int i = 0; i < pages; i++) {
            int rownum = 0;
            // 计算每页的起始数据和结束数据
            int startIndex = i * sheetsize;
            int endIndex = getSheetEndIndex(sheetsize, i, data.size());
            // 创建每页，并创建第一行
            XSSFSheet sheet = workbook.createSheet();
            XSSFRow row = sheet.createRow(rownum);

            // 在每页sheet的第一行中，添加字段名
            for (int f = 0; f < cntitles.length; f++) {
                XSSFCell cell = row.createCell(f);
                cell.setCellValue(cntitles[f]);
            }
            rownum++;
            // 将数据添加进表格
            for (int j = startIndex; j < endIndex; j++) {
                row = sheet.createRow(rownum);
                T item = data.get(j);
                for (int h = 0; h < cntitles.length; h++) {
                    Field fd = item.getClass().getDeclaredField(egtitles[h]);
                    fd.setAccessible(true);
                    Object o = fd.get(item);
                    String value = o == null ? "" : o.toString();
                    XSSFCell cell = row.createCell(h);
                    cell.setCellValue(value);
                }
                rownum++;
            }
        }
        String localFilePath = getFileName();
        FileOutputStream out = new FileOutputStream(localFilePath);
        // 将创建好的数据写入输出流
        workbook.write(out);
        // 关闭workbook
        out.close();
        workbook.close();
    }

    /***
     *
     * @param <T>
     * @param data        数据源
     * @param fields    字段-title映射
     * @return
     * @throws Exception
     */
    public static <T> XSSFWorkbook listToExecl(List<T> data, Map<String, String> fields, int sheetsize) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 如果导入数据为空，则抛出异常
        if (CollectionUtils.isEmpty(data)) {
            workbook.close();
            throw new Exception("导入的数据为空");
        }
        if (sheetsize <= 0) {
            sheetsize = data.size();
        }
        // 计算有多少页sheet
        int pages = getSheetPages(sheetsize, data.size());
        // 提取表格的字段名（英文字段名是为了对照中文字段名的）
        String[] egtitles = new String[fields.size()];
        String[] cntitles = new String[fields.size()];
        Iterator<String> it = fields.keySet().iterator();
        int count = 0;
        while (it.hasNext()) {
            String egtitle = (String) it.next();
            String cntitle = fields.get(egtitle);
            egtitles[count] = egtitle;
            cntitles[count] = cntitle;
            count++;
        }
        // 添加数据
        for (int i = 0; i < pages; i++) {
            int rownum = 0;
            // 计算每页的起始数据和结束数据
            int startIndex = i * sheetsize;
            int endIndex = getSheetEndIndex(sheetsize, i, data.size());
            // 创建每页，并创建第一行
            XSSFSheet sheet = workbook.createSheet();
            XSSFRow row = sheet.createRow(rownum);

            // 在每页sheet的第一行中，添加字段名
            for (int f = 0; f < cntitles.length; f++) {
                XSSFCell cell = row.createCell(f);
                cell.setCellValue(cntitles[f]);
            }
            rownum++;
            // 将数据添加进表格
            for (int j = startIndex; j < endIndex; j++) {
                row = sheet.createRow(rownum);
                T item = data.get(j);
                //为了适应Map类型使用json转换T类型
                JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(item));
                for (int h = 0; h < cntitles.length; h++) {
                    String value = jsonObject.get(egtitles[h]) == null ? "" : jsonObject.get(egtitles[h]).toString();
                    XSSFCell cell = row.createCell(h);
                    cell.setCellValue(value);
                }
                rownum++;
            }
        }
        return workbook;
    }

    /***
     *
     * @param <T>
     * @param data        数据源
     * @param fields    字段-title映射
     * @return
     * @throws Exception
     */
    public static <T> SXSSFWorkbook listToExcel(List<T> data, Map<String, String> fields, int sheetsize) throws Exception {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        // 如果导入数据为空，则抛出异常
        if (CollectionUtils.isEmpty(data)) {
            workbook.close();
            throw new Exception("导入的数据为空");
        }
        if (sheetsize <= 0) {
            sheetsize = data.size();
        }
        // 计算有多少页sheet
        int pages = getSheetPages(sheetsize, data.size());
        // 提取表格的字段名（英文字段名是为了对照中文字段名的）
        String[] egtitles = new String[fields.size()];
        String[] cntitles = new String[fields.size()];
        Iterator<String> it = fields.keySet().iterator();
        int count = 0;
        while (it.hasNext()) {
            String egtitle = (String) it.next();
            String cntitle = fields.get(egtitle);
            egtitles[count] = egtitle;
            cntitles[count] = cntitle;
            count++;
        }
        // 添加数据
        for (int i = 0; i < pages; i++) {
            int rownum = 0;
            // 计算每页的起始数据和结束数据
            int startIndex = i * sheetsize;
            int endIndex = getSheetEndIndex(sheetsize, i, data.size());
            // 创建每页，并创建第一行
            SXSSFSheet sheet = workbook.createSheet();
            SXSSFRow row = sheet.createRow(rownum);

            // 在每页sheet的第一行中，添加字段名
            for (int f = 0; f < cntitles.length; f++) {
                SXSSFCell cell = row.createCell(f);
                cell.setCellValue(cntitles[f]);
            }
            rownum++;
            // 将数据添加进表格
            for (int j = startIndex; j < endIndex; j++) {
                row = sheet.createRow(rownum);
                T item = data.get(j);
                //为了适应Map类型使用json转换T类型
                JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(item));
                for (int h = 0; h < cntitles.length; h++) {
                    String value = jsonObject.get(egtitles[h]) == null ? "" : jsonObject.get(egtitles[h]).toString();
                    SXSSFCell cell = row.createCell(h);
                    cell.setCellValue(value);
                }
                rownum++;
            }
        }
        return workbook;
    }

    private static int getSheetEndIndex(int sheetsize, int i, int size) {
        return (i + 1) * sheetsize - 1 > size ? size : (i + 1) * sheetsize - 1;
    }

    private static int getSheetPages(int sheetsize, int size) {
        return size / sheetsize + (size % sheetsize == 0 ? 0 : 1);
    }

    /***
     * 将数据源转换成String格式方便导出为txt，每行按照fields的列顺序。
     * @param <T>
     * @param data 数据源，此处T会被fastjson转换为json对象而不是直接反射属性值，以适配容器类
     * @param fields 字段-中文映射，若希望字段按照顺序排列 应使用LinkedHashMap
     * @return
     * @throws Exception
     */
    public static <T> String listToText(List<T> data, Map<String, String> fields) throws Exception {
        StringBuilder outputString = new StringBuilder();
        // 如果导入数据为空，则抛出异常
        if (CollectionUtils.isEmpty(data)) {
            throw new Exception("导入的数据为空");
        }
        // 计算有多少页sheet
        int pages = getSheetPages(sheetsize, data.size());
        // 提取表格的字段名（英文字段名是为了对照中文字段名的）
        String[] egtitles = new String[fields.size()];
        String[] cntitles = new String[fields.size()];
        Iterator<String> it = fields.keySet().iterator();
        int count = 0;
        while (it.hasNext()) {
            String egtitle = (String) it.next();
            String cntitle = fields.get(egtitle);
            egtitles[count] = egtitle;
            cntitles[count] = cntitle;
            count++;
        }
        // 添加数据
        for (int i = 0; i < pages; i++) {
            // 计算每页的起始数据和结束数据
            int startIndex = i * sheetsize;
            int endIndex = getSheetEndIndex(sheetsize, i, data.size());
            //取数
            for (int j = startIndex; j < endIndex; j++) {
                T item = data.get(j);
                JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(item));
                for (int h = 0; h < cntitles.length; h++) {
//					//空值跳过先
//					if(jsonObject.get(egtitles[h]) == null || jsonObject.get(egtitles[h]).toString().isEmpty())
//						continue;
                    String value = jsonObject.get(egtitles[h]) == null ? "" : jsonObject.get(egtitles[h]).toString();
                    outputString.append(value + ",");
                }
                outputString.deleteCharAt(outputString.length() - 1);
                outputString.append("\r\n");
            }
        }
        return outputString.toString();
    }

    /**
     * 导出Excel到本地
     *
     * @param wb
     * @param filePath
     */
    public static void exportToLocal(Workbook wb, String filePath) throws IOException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            wb.write(out);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (wb != null) {
                    wb.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 导出Excel到浏览器
     *
     * @param wb
     * @param fileName
     */
    public static void exportToWebSite(Workbook wb, String fileName, HttpServletResponse response) throws IOException {
        //设置下载的文件名
        response.setHeader("Content-disposition", "attachment; filename="
                + new String((fileName).getBytes(), "utf-8"));

        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            wb.write(outputStream);
        } finally {
            if (null != wb) {
                try {
                    wb.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static String getFileName() {
        return "订单导出" + DateUtils.formatDate(new Date()) + ".xlsx";
    }


    /**
     * 基于注解导出到excel
     *
     * @param dataList
     * @param clazz
     * @param merge
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T, D extends Workbook> D export(List<T> dataList, Class<T> clazz, boolean merge, int sheetsize) throws Exception {

        return export(dataList, clazz, merge, sheetsize, WbType.XSSF);
    }

    public static <T, D extends Workbook> D export(List<T> dataList, Class<T> clazz, boolean merge, int sheetsize, WbType type) throws Exception {
        D wb;
        switch (type) {
            case HSSF:
                wb = (D) new HSSFWorkbook();
                break;
            case SXSSF:
                wb = (D) new SXSSFWorkbook();
                break;
            case XSSF:
            default:
                wb = (D) new XSSFWorkbook();
                break;
        }
        int sheetPages = getSheetPages(sheetsize, dataList.size());
        for (int sheetIndex = 0; sheetIndex < sheetPages; sheetIndex++) {
            // 计算每页的起始数据和结束数据
            int startIndex = sheetIndex * sheetsize;
            int endIndex = getSheetEndIndex(sheetsize, sheetIndex, dataList.size());
            execute(dataList, clazz, merge, wb, sheetIndex, startIndex, endIndex);
        }
        return wb;
    }

    public static <T, D extends Workbook> D export(List<T> dataList, Class<T> clazz, boolean merge) throws Exception {

        return export(dataList, clazz, merge, 50000);
    }

    public static <T, D extends Workbook> D export(List<T> dataList, Class<T> clazz, boolean merge, WbType type) throws Exception {

        return export(dataList, clazz, merge, 50000, type);
    }


    private static <T> void execute(List<T> dataList, Class<T> clazz, boolean merge, Workbook wb, int sheetIndex, int startIndex, int endIndex) {
        ExcelTag annotation = clazz.getAnnotation(ExcelTag.class);
        String tag = annotation.tag();
        // 工作簿
        Sheet sheet = wb.createSheet(tag + sheetIndex);
        Field[] fields = FieldUtils.getFieldsWithAnnotation(clazz, ExcelTag.class);
        if (fields != null && fields.length > 0) {
            List<Field> list = CollectionUtils.arrayToList(fields);
            if (list != null && list.size() > 1) {
                list.sort((f1, f2) -> {
                    ExcelTag tag1 = ((Field) f1).getAnnotation(ExcelTag.class);
                    ExcelTag tag2 = ((Field) f2).getAnnotation(ExcelTag.class);
                    if (tag1.columnIndex() < tag2.columnIndex()) {
                        return -1;
                    }
                    return 0;
                });
                fields = (Field[]) list.toArray();
            }
        }
        List<Integer> mergeList = new ArrayList<>();
        // 表头 The maximum number of Cell Styles was exceeded. You can define up to 64000 style in A .xlsx Workbook
        Row headers = sheet.createRow(0);
        Font font = wb.createFont();
        CellStyle style = wb.createCellStyle();
        for (int index = 0; index < fields.length; index++) {
            Field field = fields[index];
            CellType type = CellType.BLANK;
            if (String.class.equals(field.getType())) {
                type = CellType.STRING;
            }

            ExcelTag excelTag = field.getAnnotation(ExcelTag.class);
            Cell cell = headers.createCell(index, type);
            font.setColor(excelTag.fontColor().getIndex());
            style.setFont(font);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            cell.setCellStyle(style);
            tag = excelTag.tag();
            cell.setCellValue(tag);
            boolean isMerge = excelTag.merge();
            if (isMerge) {
                mergeList.add(index);
            }
        }
        //插入数据
        Row row;
        Field field;
        int[] mergeIndex = new int[mergeList.size()];
        for (int j = 0; j < mergeList.size(); j++) {
            mergeIndex[j] = mergeList.get(j);
        }
        // 从指定的第2行开始
        int rowIndex = 1;
        CellType type = CellType.BLANK;
        CellStyle xssfCellStyle = wb.createCellStyle();
        for (int i = startIndex; i < endIndex; i++) {
            T datum = dataList.get(i);

            row = sheet.createRow(rowIndex);
            //
            for (int cellInd = 0; cellInd < fields.length; cellInd++) {
                field = fields[cellInd];

                Cell cell = row.createCell(cellInd, type);
                cell.setCellStyle(xssfCellStyle);
                Object property = getValueByFieldName(datum, field);
                setCell(cell, property);
            }
            rowIndex++;
        }
        if (merge) {
            mergeCell(mergeIndex, null, sheet);
        }
    }


    /**
     * 合并单元格
     *
     * @param mergeIndex      合并列数组
     * @param benchmarkColumn 基准列
     * @param sheet
     */
    private static void mergeCell(int[] mergeIndex, Integer benchmarkColumn, Sheet sheet) {
        Object str = null;
        int strBeginIndex;
        int strEndIndex;
        int j;
        int start;
        int end = 0;
        Map<Integer, Integer> benchmarkMap = new LinkedHashMap<>();
        for (int i = 0; i < mergeIndex.length; i++) {
            j = 0;
            start = 0;
            strBeginIndex = 0;
            for (Row row : sheet) {
                if (j == 0) {
                    j++;
                    continue;
                }
                Cell cell = row.getCell(mergeIndex[i]);
                Object tmp = getCellValue(cell);
                if (null == str) {
                    if (null != cell) {
                        str = getCellValue(cell);
                    }
                    if (str.equals(sheet.getRow(2).getCell(1).getStringCellValue())) {
                        strBeginIndex = row.getRowNum();
                    }
                } else if (str.equals(tmp)) {
                    if (strBeginIndex == 0) {
                        strBeginIndex = sheet.getRow(j - 1).getRowNum();
                    }
                    strEndIndex = sheet.getLastRowNum();
                    end = strEndIndex;
                    if (sheet.getLastRowNum() == j) {
                        //末尾合并
                        doConsolidateCol(mergeIndex, benchmarkColumn, sheet, strBeginIndex, strEndIndex, end, benchmarkMap, i);
                        if (mergeIndex[i] == 1) {
                            benchmarkMap.put(strEndIndex, strBeginIndex);
                        }
                    }
                } else if (!str.equals(tmp)) {
                    strEndIndex = row.getRowNum();
                    if (start == 0 && strBeginIndex > 0 && strEndIndex > 0) {
                        //首行合并
                        strEndIndex = strEndIndex - 1;
                        end = strEndIndex;
                        doConsolidateCol(mergeIndex, benchmarkColumn, sheet, strBeginIndex, strEndIndex, end, benchmarkMap, i);
                        strBeginIndex = 0;
                        start = 1;
                        if (mergeIndex[i] == 1) {
                            benchmarkMap.put(strEndIndex, strBeginIndex);
                        }
                    } else if (strBeginIndex > 0 && strEndIndex > 0) {
                        //中间行合并
                        strEndIndex = strEndIndex - 1;
                        end = strEndIndex;
                        doConsolidateCol(mergeIndex, benchmarkColumn, sheet, strBeginIndex, strEndIndex, end, benchmarkMap, i);

                        strBeginIndex = 0;
                        if (mergeIndex[i] == 1) {
                            benchmarkMap.put(strEndIndex, strBeginIndex);
                        }
                    }
                    str = getCellValue(cell);
                }
                j++;
            }
        }
    }

    private static void doConsolidateCol(int[] mergeIndex, Integer benchmarkColumn, Sheet sheet, int strBeginIndex, int strEndIndex, int end, Map<Integer, Integer> benchmarkMap, int i) {
        if (!benchmarkMap.isEmpty() && null != benchmarkColumn && mergeIndex[i] > benchmarkColumn) {
            consolidatedColumn(benchmarkMap, strBeginIndex, strEndIndex, mergeIndex[i], end, sheet);
        } else {
            CellRangeAddress region = new CellRangeAddress(strBeginIndex, strEndIndex, mergeIndex[i], mergeIndex[i]);
            sheet.addMergedRegion(region);
        }
    }

    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellType();

        switch (cellType) {
            default:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
        }
    }

    private static void consolidatedColumn(Map<Integer, Integer> benchmarkMap, Integer strBeginIndex, Integer strEndIndex, Integer mergeIndex, Integer end, Sheet sheet) {
        for (Integer endIndex : benchmarkMap.keySet()) {
            if (strBeginIndex >= benchmarkMap.get(endIndex) && strEndIndex >= endIndex && strBeginIndex < endIndex) {
                strEndIndex = endIndex;
                if (strBeginIndex < strEndIndex) {
                    CellRangeAddress region = new CellRangeAddress(strBeginIndex, strEndIndex, mergeIndex, mergeIndex);
                    sheet.addMergedRegion(region);
                }
                strBeginIndex = strEndIndex + 1;
                strEndIndex = end;
            } else if (strBeginIndex >= benchmarkMap.get(endIndex) && strEndIndex <= endIndex && strBeginIndex < endIndex) {
                if (strBeginIndex < strEndIndex) {
                    CellRangeAddress region = new CellRangeAddress(strBeginIndex, strEndIndex, mergeIndex, mergeIndex);
                    sheet.addMergedRegion(region);
                }
                strBeginIndex = strEndIndex + 1;
                strEndIndex = end;
            } else if (strBeginIndex < benchmarkMap.get(endIndex) && strEndIndex >= endIndex && strBeginIndex < endIndex) {
                strBeginIndex = benchmarkMap.get(endIndex);
                strEndIndex = endIndex;
                if (strBeginIndex < strEndIndex) {
                    CellRangeAddress region = new CellRangeAddress(strBeginIndex, strEndIndex, mergeIndex, mergeIndex);
                    sheet.addMergedRegion(region);
                }
                strBeginIndex = strEndIndex + 1;
                strEndIndex = end;
            } else if (strBeginIndex <= benchmarkMap.get(endIndex) && strEndIndex <= endIndex && strBeginIndex < endIndex) {
                if (!isSection(benchmarkMap, strBeginIndex)) {
                    strBeginIndex = benchmarkMap.get(endIndex);
                    if (strBeginIndex < strEndIndex) {
                        CellRangeAddress region = new CellRangeAddress(strBeginIndex, strEndIndex, mergeIndex, mergeIndex);
                        sheet.addMergedRegion(region);

                    }
                    strBeginIndex = strEndIndex + 1;
                    strEndIndex = end;
                }

            }
        }
    }

    private static boolean isSection(Map<Integer, Integer> benchmarkMap, Integer value) {
        for (Integer integer : benchmarkMap.keySet()) {
            if (value >= benchmarkMap.get(integer) && value <= integer) {
                return true;
            }
        }
        return false;
    }


    private static void setFirstHead(XSSFWorkbook workbook, XSSFSheet sheet, String firstTitle) {
        // 设置字体
        XSSFFont font = workbook.createFont();
        // 字体高度
        font.setFontHeightInPoints((short) 20);
        // 字体颜色
        font.setColor(XSSFFont.COLOR_NORMAL);
        // 字体
        font.setFontName("黑体");
        // 是否使用斜体
        font.setItalic(false);
        // 设置单元格类型
        XSSFCellStyle cellStyle0 = workbook.createCellStyle();
        cellStyle0.setFont(font);
        // 水平布局：居中
        cellStyle0.setAlignment(HorizontalAlignment.CENTER);
        // 自动换行
        cellStyle0.setWrapText(true);
        // 创建第一行
        XSSFRow row0 = sheet.createRow(0);
        XSSFCell cell_0 = row0.createCell(0, CellType.STRING);
        // 标题名称
        cell_0.setCellValue(firstTitle);
        cell_0.setCellStyle(cellStyle0);
        // 合并单元格（起始行，截止行，起始列，截止列）
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 15));
    }

    private static Object getValueByFieldName(Object o, Field field) {
        try {
            return ReflectionUtil.getValueByGetter(o, field.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    private static void setCell(Cell cell, Object property) {
        if (property == null) {
            cell.setCellValue("");
        } else if (property instanceof String) {
            cell.setCellValue((String) property);
        } else if (property instanceof Boolean) {
            Boolean booleanValue = (Boolean) property;
            cell.setCellValue(booleanValue);
        } else if (property instanceof Integer) {
            cell.setCellValue((Integer) property);
        } else if (property instanceof Long) {
            cell.setCellValue((Long) property);
        } else if (property instanceof Double) {
            cell.setCellValue((Double) property);
        } else if (property instanceof Float) {
            cell.setCellValue((Float) property);
        } else if (property instanceof BigDecimal) {
            cell.setCellValue(((BigDecimal) property).doubleValue());
        } else if (property instanceof Date) {
            String dateValue = DATEFORMATTER.format(property);
            cell.setCellValue(dateValue);
        } else {
            cell.setCellValue(property.toString());
        }
    }

}
