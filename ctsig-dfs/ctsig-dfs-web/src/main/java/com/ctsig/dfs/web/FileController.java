package com.ctsig.dfs.web;

import com.ctsig.common.exception.PageException;
import com.ctsig.common.utils.IDUtils;
import com.ctsig.dfs.service.AttachmentService;
import com.ctsig.dfs.utils.JsonUtils;
import com.ctsig.dfs.utils.ResponseMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: V1.0
 * @des:
 * @author: Shen
 * @email: shenzhaoxiang@gmail.com
 * @date: 2016-11-11 11:31
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    AttachmentService attachmentService;


    @RequestMapping("/upload")
    @ResponseBody
    public void articlePicUpload(@RequestParam(value = "fileupload") MultipartFile fileUpload,
                                 HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> retMap = new HashMap<>();
        try {
            String path=attachmentService.upload(fileUpload);
            retMap.put("file_id", IDUtils.getUuid());
            retMap.put("file_name",path);
            retMap.put("file_path",path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new PageException("文件上传错误！");
        }
        ResponseMessageUtils.textPlainResponse(response, JsonUtils.objectToJson(retMap));
    }
}
