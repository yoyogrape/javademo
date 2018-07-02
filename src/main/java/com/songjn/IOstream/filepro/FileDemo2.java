package com.songjn.IOstream.filepro;

import java.io.File;

/**
 * @author songjn
 * @create 2018-06-10 10:40
 * @desc 文件类File二：查找文件。
 * 注意：递归循环层深会内存溢出、
 **/
public class FileDemo2 {
    public static void main(String[] args) {
        findFile(new File("C:\\test"), "txt");
    }

    public static void findFile(File target, String ext) {
        if (target == null) return;
        if (target.isDirectory()) {
            File[] files = target.listFiles();
            if (files != null) {
                for (File f : files) {
                    findFile(f, ext);//递归调用
                }
            }
        } else {
            //file是文件
            String name = target.getName().toLowerCase();
            if (name.endsWith(ext)) {
                System.out.println(target.getAbsolutePath());
            }
        }
    }
}
