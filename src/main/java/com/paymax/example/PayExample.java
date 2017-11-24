package com.paymax.example;

import com.paymax.exception.PaymaxException;
import com.paymax.model.Pay;
import com.paymax.model.PayFile;
import com.paymax.model.PayInfo;
import com.paymax.model.PayUpload;
import com.paymax.model.Trade;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by wxw on 2016/12/27.
 */
public class PayExample {

    private static String batchNo = "1000000";

    public static void main(String[] args) throws Exception {
        pay();
        downloadReturnPayFile();
        payQuery();
        downloadPayFile();
    }

    /**
     * 下载普通回盘文件
     */
    private static void downloadPayFile() throws Exception {
        PayFile payFile = PayFile.retrievePayFile(batchNo);
        write2Local(payFile);

    }

    /**
     * 下载退票回盘文件
     */
    private static void downloadReturnPayFile() throws Exception {
        PayFile payFile = PayFile.retrieveReturnFile("20171030");
        write2Local(payFile);
    }

    /**
     * 批量代付
     */
    private static void pay() throws PaymaxException {
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

        PayUpload payUpload = PayUpload.create(pay);

        System.out.println(payUpload);
    }

    /**
     * 根据批次号查询代付文件信息
     */
    private static void payQuery() throws PaymaxException {
        PayInfo payInfo = PayInfo.retrive(batchNo);
        System.out.println(payInfo);
    }

    private static void write2Local(PayFile payFile) throws Exception {
        System.out.println(payFile);
        if (payFile == null || payFile.getReqSuccessFlag() == null || !payFile
                .getReqSuccessFlag()) {
            System.out.println("下载回盘文件失败。");
        } else {
            String path = System.getProperty("user.home") + "/payfile/" + payFile.getFileName();
            File file = new File(path);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            FileOutputStream os = new FileOutputStream(file);
            writeToOutputStream(payFile.getFileData(), os);
            System.out.println("下载回盘文件成功!文件路径是:" + path);
        }
    }

    public static void writeToOutputStream(byte[] fileData, OutputStream os)
            throws PaymaxException {
        if (fileData == null) {
            throw new PaymaxException("no file data!");
        }
        try {
            os.write(fileData);
            os.flush();
        } catch (Exception e) {
            throw new PaymaxException(e.getMessage(), e);
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
