package com.songjn.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WxworkMaterialType {

    /***
     * 普通文件
     */
    DEFAULT_FILE(".txt", "file", "application/octet-stream"),
    /***
     * jpg图片
     */
    JPG_FILE(".jpg", "image", "image/jpg"),
    /***
     * png图片
     */
    PNG_FILE(".png", "image", "image/png"),
    /***
     * bmp图片
     */
    BMP_FILE(".bmp", "image", "image/bmp"),
    /***
     * amr音频
     */
    AMR_FILE(".amr", "voice", "voice/amr"),
    /***
     * mp4视频
     */
    MP4_FILE(".mp4", "video", "video/mp4");
    /**
     * code编码
     */
    final private String suffix;
    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件（file）
     */
    final private String fileType;
    /**
     * 构造HTTP请求包时,Content-Type根据不同文件类型可以设置对应不同的值
     */
    final private String contentType;

    public static WxworkMaterialType getFileType(String suffixName) {
        WxworkMaterialType[] types = WxworkMaterialType.values();
        for (WxworkMaterialType t : types) {
            if (t.getSuffix().equals(suffixName)) {
                return t;
            }
        }
        return null;
    }

}