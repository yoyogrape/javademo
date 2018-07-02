package com.songjn.IOstream.files;


import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * @author songjn
 * @create 2018-06-14 21:34
 * @desc Files类的使用。
 **/
public class FilesDemo {
    public static void main(String[] args) {
        //得到path的三个方法
        //1.通过new file（）
        File file = new File("c:\\test\\filetest.txt");
        Path path1 = file.toPath();
        System.out.println(path1);
        //2.通过files。getpath
        Path path2 = Paths.get("c:\\test\\filetest.txt");
        System.out.println(path2);
        //3.通过FileSystems
        Path path3 = FileSystems.getDefault().getPath("c:\\test\\filetest.txt");
        System.out.println(path3);

        //Files工具类
        //文件的写入
        Path path4 = Paths.get("c:\\test\\filetest.txt");
        try {
            Files.write(path4, "小河流水哗啦啦".getBytes("utf-8")
                    , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文件的读取
        try {
            byte[] bytes = Files.readAllBytes(path4);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //复制文件
        try {
            Files.copy(path4, Paths.get("c:\\filetest.txt")
                    , StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //移动文件
        try {
            Files.move(path4, Paths.get("c:\\filetest.txt")
                    , StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //删除文件
        try {
            Files.delete(path4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //删除文件2
        try {
            Files.deleteIfExists(path4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建新目录
        try {
            Files.createDirectory(Paths.get("c:\\BBBB"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建文件
        try {
            Files.createFile(Paths.get("c:\\b.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
