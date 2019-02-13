package com.songjn.optimize_IfElse.sharedemo.for_duotai;

import com.songjn.optimize_IfElse.sharedemo.Constant;
import com.songjn.optimize_IfElse.sharedemo.ShareListener;
import org.springframework.util.StringUtils;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc
 */
public class Image extends ShareItem {
    String imagePath;

    public Image(String imagePath) {
        super(Constant.TYPE_IMAGE);
        this.imagePath = !StringUtils.isEmpty(imagePath) ? imagePath : "default";
    }

    @Override
    public void doShare(ShareListener listener) {
        // do share
    }
}
