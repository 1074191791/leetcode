package com.zhou.demo;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author zhous
 * @version 1.0
 * @date 2020/10/21 13:10
 */
public class Demo10086 {


    public static String Utf8MD2(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Digester digester = new Digester(DigestAlgorithm.MD2);

        str = new String(str.getBytes(), StandardCharsets.UTF_8);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("startTime:" + simpleDateFormat.format(new Date()));
        long s = System.currentTimeMillis();

        for (int i = 0; i < 100000000; i++) {
            str = digester.digestHex(str);
        }
        System.out.println("endTime:" + simpleDateFormat.format(new Date()));
        System.out.println("耗时：" + (System.currentTimeMillis() - s) / 1000 + "s");
        return "utf8md2加密亿次:" + str;
    }


    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //对我等众猿而言中央C所在位置数优剃爱肤杠吧爱慕帝贰亿次的值是？


        System.out.println(Utf8MD2("39"));;
    }
}
