package com.nju.edu.njueat.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static String saveOrCoverImage(String parentPath, MultipartFile image, String name){


        StringBuilder realPath = new StringBuilder(parentPath);
        realPath.append(File.separator);
        realPath.append(name).append(".jpg");

        File file = new File(realPath.toString());
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try {
            image.transferTo(file);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return null;
        }

        return realPath.toString();

    }
}
