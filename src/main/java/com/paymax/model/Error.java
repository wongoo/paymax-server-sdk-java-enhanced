package com.paymax.model;

/**
 * Created by wxw on 2016/12/28.
 */
public class Error extends PaymaxBase {

    /**
     * 错误发生的行 示例值: 1-100,200,205 描述: 代表1到100行和第200行以及第205行
     */
    private String line;

    /**
     * 错误信息
     */
    private String message;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
