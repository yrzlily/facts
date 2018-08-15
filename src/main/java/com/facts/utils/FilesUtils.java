package com.facts.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * 上传通用
 * @author Administrator
 */
@Configuration
public class FilesUtils {

    public static String upload(MultipartFile file , HttpSession session) throws IOException {

        //文件储存路径
        String uploadDir = session.getServletContext().getRealPath("/") + "../../src/main/webapp/static/images/upload/";

        File path = new File(uploadDir);
        if(!path.exists()){
            path.mkdirs();
        }

        //重置文件名
        String finType = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        UUID uid = UUID.randomUUID();
        String fileName = uid + finType;

        File saveFile = new File(uploadDir + fileName);
        file.transferTo(saveFile);
        return "/static/images/upload/" + fileName;
    }

}
