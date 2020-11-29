package com.fs.smartTown.modules.dataRegister.entity;

import com.fs.smartTown.modules.dataRegister.utils.ExcelColumn;
import lombok.Data;

@Data
public class ConvenientServiceExcel {

    @ExcelColumn(value = "姓名", col = 1)
    private String name;
    @ExcelColumn(value = "联系方式", col = 2)
    private String phone;
    // 1、个人诉求', '2、民意诉求', '3、业务诉求', '4、政策咨询', '5、业务办理
    @ExcelColumn(value = "诉求类型", col = 3)
    private String type;
    @ExcelColumn(value = "诉求内容", col = 4)
    private String content;
    // 1、正在办理 2、已解决
    @ExcelColumn(value = "诉求状态", col = 5)
    private String state;
    @ExcelColumn(value = "回复内容", col = 6)
    private String returnContent;
    @ExcelColumn(value = "诉求时间", col = 7)
    private String createTime;
    @ExcelColumn(value = "完成时间", col = 8)
    private String finishTime;

    @Override
    public String toString() {
        return "BusClick [name=" + name + ", phone=" + phone + ", type=" + type + ", content=" + content
                + ", state=" + state + ", returnContent=" + returnContent + ", createTime=" + createTime + ", finishTime=" + finishTime + " ]";
    }
}
