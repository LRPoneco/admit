package com.example.admit.poneco.com.config;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import com.example.admit.poneco.com.ConfigPath;
import java.io.*;

public class ReadConfigData implements ConfigPath {
    private String ConfigPath = config;//数据库配置文件
    /**
     * 获取配置文件数据
     * @param ConfigName 配置文件中数据的名称
     * @return 返回配置数据
     */
    public String getConfigData(String ConfigName){
        String ConfigData = null;
        try {
            Configuration config = new PropertiesConfiguration(ConfigPath);
            ConfigData = config.getString(ConfigName);
        } catch (ConfigurationException e) {
            ConfigData = getConfigData(ConfigName);
            e.printStackTrace();
        }
        return ConfigData;
    }

    /**
     * 创建不存在的数据文件
     */
    private void setFile(){
        File file = new File(ConfigPath);
        if(!file.exists()){
            OutputStream out = null;
            BufferedWriter bw = null;
            try {
                out = new FileOutputStream(file);
                bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
                bw.write("");
                bw.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}