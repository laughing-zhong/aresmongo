package com.ares.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ares.framework.dao.json.transcoder.JsonObjectMapper;


@Controller
public class FileUploadController {
	
	@RequestMapping(value = "/upload",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
    public UpLoadRet doFileUpload(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        //获取并解析文件类型和支持最大值  
		//response.setContentType("text/html; charset=UTF-8");
		//response.addHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
        String functionId = request.getParameter("functionId");  
        String fileType = request.getParameter("fileType");  
        String maxSize = request.getParameter("maxSize");  
          
        UpLoadRet ret = new UpLoadRet();
        ret.setError(0);
        ret.setTitle("serverTitle");
        //ret.setUrl("http://10.88.230.61:8080/aa.txt");
        
        //临时目录名  
        String tempPath = "/Users/zhongwq/kingdee/resources/tmp";//fileUploadPro.getProperty("tempPath");  
        //真实目录名  
        String filePath = "/Users/zhongwq/webserver/apache-tomcat-7.0.53/webapps/ROOT/";//"fileUploadPro.getProperty("filePath");  
          
        //FileUtil.createFolder(tempPath);  
        //FileUtil.createFolder(filePath);  
          
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //最大缓存  
        factory.setSizeThreshold(5*1024);  
        //设置临时文件目录  
        factory.setRepository(new File(tempPath));  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        if(maxSize!=null && !"".equals(maxSize.trim())){  
            //文件最大上限  
            upload.setSizeMax(Integer.valueOf(maxSize)*1024*1024);  
        }  
          
        try {  
            //获取所有文件列表  
            List<FileItem> items = upload.parseRequest(request);  
            for (FileItem item : items) {  
                if(!item.isFormField()){  
                    //文件名  
                    String fileName = item.getName();  
                      
                    //检查文件后缀格式  
                    String fileEnd = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();  
                    if(fileType!=null && !"".equals(fileType.trim())){  
                        boolean isRealType = false;  
                        String[] arrType = fileType.split(",");  
                        for (String str : arrType) {  
                            if(fileEnd.equals(str.toLowerCase())){  
                                isRealType = true;  
                                break;  
                            }  
                        }  
                        if(!isRealType){  
                            //提示错误信息:文件格式不正确  
                          //  super.printJsMsgBack(response, "文件格式不正确!");  
                            return ret;  
                        }  
                    }               
                    //创建文件唯一名称  
                    String uuid = UUID.randomUUID().toString();  
                    //真实上传路径  
                    StringBuffer sbRealPath = new StringBuffer();  
                    sbRealPath.append(filePath).append(uuid).append(".").append(fileEnd);  
                    ret.setUrl("http://localhost:8070/" + uuid + "." + fileEnd);
                    //写入文件  
                    File file = new File(sbRealPath.toString());  
                    item.write(file);  
                    //上传成功，向父窗体返回数据:真实文件名,虚拟文件名,文件大小  
//                    StringBuffer sb = new StringBuffer();  
//                    sb.append("window.returnValue='").append(fileName).append(",").append(uuid).append(".").append(fileEnd).append(",").append(file.length()).append("';");  
//                    sb.append("window.close();");  
                 //   super.printJsMsg(response, sb.toString());  
                   // log.info("上传文件成功,JS信息："+sb.toString());  
                }//end of if  
            }//end of for  
              
        }catch (Exception e) {  
            //提示错误:比如文件大小  
            //super.printJsMsgBack(response, "上传失败,文件大小不能超过"+maxSize+"M!");  
          //  log.error("上传文件异常!",e);  
            return ret;  
        }      
       return  ret;  
    } 
	
	public static class UpLoadRet{
		private int error;
		public int getError() {
			return error;
		}
		public void setError(int error) {
			this.error = error;
		}
		private String url;
		private String  title;

		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}	
	}

}
