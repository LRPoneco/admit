package com.example.admit.poneco.com.File;


import org.apache.commons.fileupload.FileItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 菜品介绍图片删除
 */
public class FileOperate {
    private boolean alex = false;
    /**
     *
     * @param path 要删除的所有图片的物理路径值模拟数据
     */
    public boolean delete(String path){
        File file = new File(path);
        if (file.delete()){
            alex = true;
        }else {
            alex = false;
        }
        return alex;
    }

    /**
     *
     * @param item  上传的文件
     * @param SavePath 上传文件储存的绝对路径
     * @return
     */
    public boolean Save(FileItem item, String SavePath){
        File file = new File(SavePath.substring(0,SavePath.lastIndexOf("/")));
        if(file.mkdirs()){
            System.out.println("创建文件夹成功.............");
        }
        try{
            InputStream in = item.getInputStream();//创建一个输入流
            FileOutputStream out = new FileOutputStream(SavePath);//创建一个文件输出流
            byte buffer[] = new byte[1024];//创建一个缓冲区
            int len = 0;//判断输入流中的数据是否已经读完的标识
            //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
            while((len=in.read(buffer))>0){
                out.write(buffer, 0, len);//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
            }
            in.close();//关闭输入流
            out.close();//关闭输出流
            item.delete();//删除处理文件上传时生成的临时文件
            alex = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return alex;
    }
}