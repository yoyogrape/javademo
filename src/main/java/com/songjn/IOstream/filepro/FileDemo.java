package com.songjn.IOstream.filepro;

import java.io.File;
import java.io.IOException;

/**
 * @author songjn
 * @create 2018-06-10 10:20
 * @desc File类的使用一，创建文件和常用方法
 *
 *canRead()
测试应用程序是否可以读取此抽象路径名表示的文件。
 *
 *delete()
删除此抽象路径名表示的文件或目录。
 *
 *exists()
测试此抽象路径名表示的文件或目录是否存在。
 *
 *getAbsolutePath()
返回此抽象路径名的绝对路径名字符串。
 *
 *getName()
返回由此抽象路径名表示的文件或目录的名称。
 *
 *isDirectory()
测试此抽象路径名表示的文件是否是一个目录。
 *
 *length()
返回由此抽象路径名表示的文件的长度。
 *
 *list()
返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
 *
 *listFiles()
返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
 *
 *toString()
返回此抽象路径名的路径名字符串。
 *
 **/
public class FileDemo {
    public static void main(String[] args) {

        //File file = new File("C:\\test\\filetest.txt");
        File file = new File("C:"+File.separator+"test"+File.separator+"filetest.txt");
        if (file.exists()) {//判断是否存在
            try {
                file.createNewFile();
                System.out.println("创建文件成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("是否是文件："+file.isFile());
        System.out.println("是否是文件夹："+file.isDirectory());
    }
}
