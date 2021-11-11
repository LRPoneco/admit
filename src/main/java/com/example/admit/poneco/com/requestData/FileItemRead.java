package com.example.admit.poneco.com.requestData;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前段数据获取层
 * @author 杨鹏飞
 *
 */
public class FileItemRead {
    /**
     * 取出所有传输的数据
     * @param request 请求数据
     * @return
     */
    private Map map = new HashMap();
    private List<FileItem> FileItemList ;
    public List<FileItem> getFileItemData(HttpServletRequest request){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<FileItem> list = null;
        //使用Apache文件上传组件处理文件上传步骤：
        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码
        upload.setHeaderEncoding("UTF-8");
        if(!ServletFileUpload.isMultipartContent(request)){
            //按照传统方式获取数据
            System.out.println("该方法不支持！");
        }else {
            try{
                //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
                list = upload.parseRequest(request);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /***
     * 存储文件数据
     * @param item 需要保存的文件
     * @param SavePath 保存位置
     * @return
     */
    public boolean SaveFileItem(FileItem item,String SavePath){
        boolean alex=false;
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

    /**
     * 解析文件数据转string避免乱码现象
     * @param item
     * @return
     */
    public String getCoreString(FileItem item){
        try {
            return new String(item.getString().getBytes("ISO8859_1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
