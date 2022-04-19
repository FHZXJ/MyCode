package com.fan.java;

import org.junit.Test;

import java.io.*;

/**
 * @author AIZXJ
 * @create 2022-04-19 9:37
 */
public class file2buf {
    // 将文件转换为byte数组
    public static byte[] file2buf(File fobj) throws Exception {
       if (!fobj.exists()) {
           throw new IOException("文件不存在");
       }
        FileInputStream fileInputStream = new FileInputStream(fobj);
        ByteArrayOutputStream byteArray= new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len=0;
        while ((len=fileInputStream.read(buffer))!=-1){
            byteArray.write(buffer,0,len);
        }
        byte[] bytes = byteArray.toByteArray();
        fileInputStream.close();
        byteArray.close();
        return bytes;

    }


    public static void main(String[] args) throws Exception {
        File fobj = new File("C:\\Users\\fan\\OneDrive\\桌面\\test.txt");
        byte[] bytes = file2buf(fobj);
        System.out.println(bytes);
        System.out.println(new String(bytes));

    }

    }

