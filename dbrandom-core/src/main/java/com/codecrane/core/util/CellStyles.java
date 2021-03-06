package com.codecrane.core.util;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Excel样式定义接口
 * Created by crane on 16/6/21.
 */
public interface CellStyles {
    void setWorkBook(Workbook workbook);

    /**
     * 标题样式
     *
     * @return
     */
    CellStyle getHeaderStyle();

    /**
     * String样式
     *
     * @return
     */
    CellStyle getStringStyle();

    /**
     * 日期样式
     *
     * @return
     */
    CellStyle getDateStyle();

    /**
     * 数字样式
     *
     * @return
     */
    CellStyle getNumberStyle();

    /**
     * 合计列样式
     *
     * @return
     */
    CellStyle getFormulaStyle();
}
