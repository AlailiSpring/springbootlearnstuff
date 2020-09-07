package com.alaili.springbootlearnstuff.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2020-09-07 19:43
 */
@Data
@Component
@ConfigurationProperties(prefix = "downloadfilepath")
public class FilePathConfig {
    private String sourcePath;
    private String destinationPath;
}
