package com.songjn.IOstream.bytestream;

import java.io.*;

/**
 * @author songjn
 * @create 2018-06-10 12:51
 * @desc 字节流的输入输出。
 **/
public class ByteStreamDemo {
    public static void main(String[] args) {
        outStream();
        inStream();
    }

    private static void outStream() {
        File file = new File("C:\\test\\filetest.txt");
        try {
            //注意：FileOutputStream中的参数true：是否追加
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write("haha\r\n".getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inStream() {
        File file = new File("C:\\test\\filetest.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            int len = 0;//表示每次读取的字节长度
            while ((len = fileInputStream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes,0,len));
                //注意：在读取数据的时候要添加0，len。要不然会多度。
            }
            fileInputStream.close();
            System.out.println(stringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
        }
    }

}
