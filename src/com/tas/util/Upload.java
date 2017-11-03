package com.tas.util;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload {
	String filename="";
	static final long seria=1l;
	static final String dir="up";
	static final int memory=1024*1024*20;
	static final int max_file_memory=1024*1024*30;
	static final int max_request_memory=1024*1024*20;
	
	
	public String uploadPic(HttpServletRequest arg0, HttpServletResponse arg1,ServletContext application) throws IOException{

		if(!ServletFileUpload.isMultipartContent(arg0)){
			PrintWriter out=arg1.getWriter();
			out.println("error is not file");
			out.flush();
			return "";
		}
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(memory);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload=new ServletFileUpload(factory);
		upload.setFileSizeMax(max_file_memory);
		
		upload.setSizeMax(max_request_memory);
		String uploadpath=application.getRealPath("./")+File.separator+dir;
		//System.out.println("uploadpath="+uploadpath);
		File upload_dir=new File(uploadpath); 
		if(!upload_dir.exists()){
			upload_dir.mkdir();
		}
		
		
		try {
			List<FileItem> formItems=upload.parseRequest(arg0);
			
			if(formItems!=null&&formItems.size()>0){
				for (FileItem fileItem : formItems) {
					if(!fileItem.isFormField()){
							filename=new File(fileItem.getName()).getName();
							String filepath=uploadpath+File.separator+filename;
							File storefileFile=new File(filepath);
							try {
								fileItem.write(storefileFile);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
	}
}
