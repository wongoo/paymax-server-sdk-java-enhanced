package com.paymax.example;

import com.alibaba.fastjson.JSONObject;
import com.paymax.config.PaymaxConfig;
import com.paymax.exception.PaymaxException;
import com.paymax.model.Pay;
import com.paymax.model.PayFile;
import com.paymax.model.PayInfo;
import com.paymax.model.PayUpload;
import com.paymax.model.Paymax;
import com.paymax.model.Trade;

import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by wxw on 2016/12/27.
 */
public class PayExample {
    public static void main(String[] args) throws Exception {
        pay();
        payQuery();
        downloadPayFile();
        downloadReturnPayFile();
    }

    /**
     * 下载普通回盘文件
     */
    private static void downloadPayFile() throws Exception {
        PayFile payFile = Paymax.buildDownloadGetRequest(
                PaymaxConfig.API_BASE_URL + PaymaxConfig.PAY_DOWNLOAD + "?batch_no=" + _encode(
                        "0000029"));

        write2Local(payFile);

    }

    /**
     * 下载退票回盘文件
     */
    private static void downloadReturnPayFile() throws Exception {
        PayFile payFile = Paymax.buildDownloadGetRequest(
                PaymaxConfig.API_BASE_URL + PaymaxConfig.PAY_RETURN_DOWNLOAD + "?date=" + _encode(
                        "20170117"));

        write2Local(payFile);
    }

    /**
     * 批量代付
     */
    private static void pay() throws IOException, PaymaxException {
        Pay pay = new Pay();
        pay.setBatchNo(String.valueOf(System.currentTimeMillis()));
        pay.setCount(2);
        pay.setTotalAmount(new BigDecimal("99.01"));

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        pay.setDate(format.format(new Date()));
        List<Trade> list = new ArrayList<Trade>();
        Trade trade = new Trade();

        trade.setBankCode("03090000");
        trade.setAccountType("0");
        trade.setBankAccountProvince("11");
        trade.setBankBranchNo("309100003288");
        trade.setAmount(new BigDecimal("9.01"));
        trade.setBankAccountName("北京市神舟保险公司");
        trade.setBankAccountNo("321260100100017000");
        trade.setMerchantOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
        list.add(trade);

        Trade trade1 = new Trade();
        trade1.setBankCode("03090000");
        trade1.setAccountType("1");
        trade1.setAmount(new BigDecimal("90.00"));
        trade1.setBankAccountName("张三");
        trade1.setBankAccountNo("6225881002706960");
        trade1.setMerchantOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
        trade1.setIdCardNo("142732199909260000");
        trade1.setIdCardType("01");
        list.add(trade1);

        pay.setDetails(list);

        PayUpload payUpload = Paymax.request(PaymaxConfig.API_BASE_URL + PaymaxConfig.PAY,
                JSONObject.toJSONString(pay), PayUpload.class);

        System.out.println(JSONObject.toJSONString(payUpload));
    }

    /**
     * 根据批次号查询代付文件信息
     */
    private static void payQuery() throws IOException, PaymaxException {
        PayInfo payInfo = Paymax.request(
                PaymaxConfig.API_BASE_URL + PaymaxConfig.PAY_QUERY + "?batch_no=" + _encode(
                        "0000029"), null, PayInfo.class);
        System.out.println(JSONObject.toJSONString(payInfo));
    }

    private static void write2Local(PayFile fileData) throws Exception {
        if (fileData == null) {
            System.out.println("下载回盘文件失败。");
        }

        if (fileData.getFileData() == null) {
            System.out.println(JSONObject.toJSONString(fileData));
            return;
        }

        InputStream in = new ByteArrayInputStream(fileData.getFileData());
        /**
         * 在用户的根目录下创建 payfile 的文件夹
         */
        File file =
                new File(System.getProperty("user.home") + "/payfile/" + fileData.getFileName());
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        FileOutputStream fileout = null;
        try {
            fileout = new FileOutputStream(file);
            /**
             * 根据实际运行效果 设置缓冲区大小
             */
            byte[] buffer = new byte[1024];
            int ch = 0;
            while ((ch = in.read(buffer)) != -1) {
                fileout.write(buffer, 0, ch);
            }
            fileout.flush();
        } catch (Exception e) {
            throw new PaymaxException("下载回盘文件失败!原因是:" + e.getMessage(), e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (fileout != null) {
                    fileout.close();
                }
            } catch (IOException e) {
                throw new PaymaxException("关闭数据流时发生异常!错误信息是:" + e.getMessage(), e);
            }

        }

        System.out.println(
                "下载回盘文件成功!文件路径是:" + System.getProperty("user.home") + "/payfile/" + fileData
                        .getFileName());
    }

    /**
     * 将get方法的queryString做URLEncoding
     */
    private static String _encode(String param) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(param)) {
            return null;
        }
        return URLEncoder.encode(param, PaymaxConfig.CHARSET);
    }

}
