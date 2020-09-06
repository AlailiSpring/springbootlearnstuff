package com.alaili.springbootlearnstuff.controller;

import com.alaili.springbootlearnstuff.Vo.FilePropVo;
import com.alaili.springbootlearnstuff.utils.FileDownloadUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author Alaili Lee
 * @Date 2020/9/6 20:41
 * @Details:
 */
@RestController
public class DownloadFileController {
    /***
     * @Description 浏览器下载单个文件
     * @Details
     * @Author Alaili Lee
     * @Date 22:00 2020/9/6
     * @param path
     * @return {{@link ResponseEntity< FileSystemResource>}}
     */
    @GetMapping("/downloadFile")
    public ResponseEntity<FileSystemResource> downloadFile(String path) {
        path = "D:/testLand/filedownload/sourcePath/下载文件2.docx";
        return FileDownloadUtils.exportToBrowser(path);
    }

    /***
     * @Description 浏览器下载zip文件
     * @Details
     * @Author Alaili Lee
     * @Date 22:00 2020/9/6
     * @param response
     * @return {}
     */
    @GetMapping("/downloadZipFile")
    public void downloadZipFile(HttpServletResponse response) {
        List<FilePropVo> filePropVoList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            FilePropVo vo = new FilePropVo();
            vo.setFilePath("D:/testLand/filedownload/sourcePath/下载文件"+i+".docx");
            vo.setFileName("下载文件"+i+".docx");
            filePropVoList.add(vo);
        }
        String zipFileTmpPath = FileDownloadUtils.downloadZipFiles(response, filePropVoList);

        File file = new File(zipFileTmpPath);
        file.deleteOnExit();
    }

}
