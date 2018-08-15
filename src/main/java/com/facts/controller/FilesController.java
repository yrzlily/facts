package com.facts.controller;

import com.facts.result.Result;
import com.facts.utils.FilesUtils;
import com.facts.utils.ResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 文件上传
 * @author Administrator
 */
@Controller
@RequestMapping("/file")
public class FilesController {

    /**
     * 文件上传
     * @param file
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public Result index(@RequestParam("file")MultipartFile file , HttpSession session) throws IOException {
        String url = FilesUtils.upload(file , session);
        return ResultUtils.success(url);
    }

}
