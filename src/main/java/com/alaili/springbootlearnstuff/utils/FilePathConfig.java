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
    private String profile;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSourceFilePath(){
        return getProfile() + "/source";
    }

    public String getDownloadFilePath(){
        return getProfile() + "/download";
    }
}
