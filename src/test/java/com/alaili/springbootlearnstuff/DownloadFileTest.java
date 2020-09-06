package com.alaili.springbootlearnstuff;

import com.alaili.springbootlearnstuff.utils.FileDownloadUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author Alaili Lee
 * @Date 2020/9/6 20:49
 * @Details:
 */
@SpringBootTest
public class DownloadFileTest extends BaseApplicationTests {

    @Test
    public void downSingleFileToBrowser() {
        String filePath =  "D:/testLand/filedownload/sourcePath/下载文件2.docx";
        FileDownloadUtils.exportToBrowser(filePath);
    }
}
