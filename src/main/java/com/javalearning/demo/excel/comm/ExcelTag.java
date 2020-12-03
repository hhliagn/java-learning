package com.javalearning.demo.excel.comm;

import org.apache.poi.ss.usermodel.IndexedColors;

import java.lang.annotation.*;

/**
 * 参考 https://www.jianshu.com/p/ddcc193c9165
 * @Author: wang
 * @Date: 2020/1/6 9:51
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelTag {

    /**
     * 表头
     *
     * @return
     */
    String tag();

    /**
     * 字体颜色
     *
     * @return
     */
    IndexedColors fontColor() default IndexedColors.BLACK;

    /**
     * 是否需要合并, false 否
     * @return
     */
    boolean merge() default false;

    int columnIndex() default 0;
}
