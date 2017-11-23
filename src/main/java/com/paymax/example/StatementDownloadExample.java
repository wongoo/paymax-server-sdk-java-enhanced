package com.paymax.example;

import com.paymax.exception.PaymaxException;
import com.paymax.model.StatementDownload;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author shane
 * @Time 2016/10/20 21:47
 * @Email shanbaohua@lxfintech.com
 * @Desc 对账单下载接口调用示例
 */
public class StatementDownloadExample {

    public static void main(String[] args) throws PaymaxException {
        StatementDownloadExample sd = new StatementDownloadExample();
        sd.download();
    }

    private void download() throws PaymaxException {
        Map<String, Object> statementMap = new HashMap<String, Object>();
        statementMap.put("appointDay", "20161027");
        statementMap.put("channelCategory", "ALIPAY");
        statementMap.put("statementType", "SUCCESS");
        String result = StatementDownload.download(statementMap);
        System.out.println(result);

    }
}
