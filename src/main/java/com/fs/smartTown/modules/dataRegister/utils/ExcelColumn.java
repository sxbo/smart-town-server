package com.fs.smartTown.modules.dataRegister.utils;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {
    String value() default "";
    /**
     * Excel从左往右排列位置
     *
     * @return
     * @author songxiaobo
     */
    int col() default 0;
}
