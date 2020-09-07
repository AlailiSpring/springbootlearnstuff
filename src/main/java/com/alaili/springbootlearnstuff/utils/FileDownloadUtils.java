package com.alaili.springbootlearnstuff.utils;

import com.alaili.springbootlearnstuff.Vo.FilePropVo;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description:
 * @Author Alaili Lee
 * @Date 2020/9/6 20:55
 * @Details:
 */
public class FileDownloadUtils {
    /***
     * @Description 下载单个文件到浏览器
     * @Details
     * @Author Alaili Lee
     * @Date 20:56 2020/9/6
     * @param filePath 完整路径+文件名
     * @return {{@link ResponseEntity< FileSystemResource>}}
     */
    public static ResponseEntity<FileSystemResource> exportToBrowser(String filePath) {
        File file = new File(filePath);
        if (file == null) {
            return null;
        }
        HttpHeaders headers = null;
        try {
            headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            //这一块加入了对中文文件名，乱码的处理
            headers.add("Content-Disposition", "attachment; filename=" + new String(file.getName().getBytes("gb2312"), "ISO8859-1"));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            headers.add("Last-Modified", new Date().toString());
            headers.add("ETag", String.valueOf(System.currentTimeMillis()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (headers != null) {
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new FileSystemResource(file));
        }
        return null;
    }

    /***
     * @Description  浏览器下载zip包
     * @Details
     * @Author Alaili Lee
     * @Date 21:42 2020/9/6
     * @param response
     * @param filePropVoList
     * @return {}
     */
    public static String downloadZipFiles(HttpServletResponse response, List<FilePropVo> filePropVoList,String downloadTmpPath) {
        long nowTime = new Date().getTime();
        String zipFileName = "attachment_" + nowTime + ".zip";
        String zipFileTempPah = zipFiles(filePropVoList, zipFileName,downloadTmpPath);
        OutputStream out = null;
        BufferedInputStream br = null;

        try {
            String fileName = URLEncoder.encode(zipFileName, "UTF-8");
            br = new BufferedInputStream(new FileInputStream(zipFileTempPah));
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset(); // 非常重要
            // 纯下载方式
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            out = response.getOutputStream();
            while ((len = br.read(buf)) > 0){
                out.write(buf, 0, len);
                out.flush();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (null != br) br.close();
                if (null != out) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return zipFileTempPah;
    }

    /***
     * @Description 文件打包到zip包
     * @Details
     * @Author Alaili Lee
     * @Date 21:47 2020/9/6
     * @param filePropVoList
     * @param zipFileName
     * @return {{@link String}}
     */
    private static String zipFiles(List<FilePropVo> filePropVoList, String zipFileName,String downloadTmpPath) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        File download = new File(downloadTmpPath);
        if (!download.exists()) {
            download.mkdirs();
        }
        String tempZipFilePath = downloadTmpPath + zipFileName;
        try {
            File zipFile = new File(tempZipFilePath);
            // 如果存在该zip文件，则删除
            zipFile.deleteOnExit();

            // 创建一个新文件
            zipFile.createNewFile();

            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(new BufferedOutputStream(fos));
            byte[] bufs = new byte[1024 * 10];
            for (FilePropVo item : filePropVoList) {
                File subFile = new File(item.getFilePath());
                //如果文件不存在，则不添加到zip包中
                if (!subFile.exists()) {
                    continue;
                }
                // 文件名增加时间戳避免重复
                String subFileName = new Date().getTime() + "_" + item.getFileName();
                //创建ZIP实体，并添加进压缩包
                ZipEntry zipEntry = new ZipEntry(subFileName);
                zos.putNextEntry(zipEntry);
                //读取待压缩的文件并写进压缩包里
                fis = new FileInputStream(subFile);
                bis = new BufferedInputStream(fis, 1024 * 10);
                int read = 0;
                while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                    zos.write(bufs, 0, read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (null != bis) bis.close();
                if (null != zos) zos.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return tempZipFilePath;
    }
}
