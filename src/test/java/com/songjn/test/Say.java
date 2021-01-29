package com.songjn.test;

import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.util.Optional;

/**
 * @auther songjn1
 * @create 2018-12-23
 * @desc 获取类名和方法名
 */
public class Say {
    @Test
    void haha() {
        //String s = this.getClass().getName().toString();
//        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
//        System.out.println(method);
        String contentType = WxworkMaterialType.getFileType(".aaa").getContentType();
        System.out.println(contentType);

        switch (contentType){
            case "aa":
                System.out.println("aa");
                break;
            default:
                System.out.println("def");
                break;
        }





/*        String httpHeadInfo="\r\n---------------------------acebdf13572468\r\n" +
                "Content-Disposition: form-data; name=\"file\";filename=\"%s\"; filelength=%s\r\n" +
                "Content-Type: %s\r\n";

        String format = String.format(httpHeadInfo, "aaaaa", 66, "BBB");
        System.out.println(format);*/

/*        String s = null;

        try {
            Optional<String> s1 = Optional.ofNullable(s.trim());
            boolean present = s1.isPresent();
            System.out.println("001");
        } catch (Exception e) {
            System.out.println("002");
            throw new RuntimeException();
        }
        System.out.println("-------004");*/

    }
}
