/* ====================
	FileManager.java
==================== */
package com.test.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

public class FileManager
{
	//파일 다운로드
	   //saveFileName : 서버에 저장된 파일 이름
	   //originalFileName : 클라이언트가 업로드한 파일 이름
	   //path : 서버에 저장된 경로
	   //response : HttpServletResponse
	   public static boolean doFileDownload(String saveFileName, String originalFileName, String path
	                    , HttpServletResponse response)
	   {
	      String loadDir = path + File.separator + saveFileName;
	      
	      // 확인
	      System.out.println(loadDir);
	      
	      try
	      {
	         if (originalFileName == null || originalFileName.contentEquals(""))
	         {
	            originalFileName = saveFileName;
	         }
	         
	         originalFileName = new String(originalFileName.getBytes("EUC-KR"), "8859_1");
	         
	         
	      } catch (UnsupportedEncodingException e)
	      {
	         System.out.println(e.toString());
	      }
	      
	      
	      try
	      {
	    	 
	         File file = new File(loadDir);
	         
	         if (file.exists())
	         {
	            byte[] readByte = new byte[4096];   // 4096 b == 4 kb
	            
	            response.setContentType("application/octet-stream");
	            response.setHeader("Content-disposition", "attachment;filename=" + originalFileName);
	            
	            //BufferedInputStream 으로 감싼 FileInputStream 객체
	            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
	            
	            OutputStream os = response.getOutputStream();
	            
	            int read;
	            while ( (read = fis.read(readByte, 0, 4096)) != -1)
	            {
	               os.write(readByte, 0, read);
	               
	            }
	            
	            os.flush();
	            os.close();
	            fis.close();
	            
	            //파일이 존재할 경우 true 반환
	            return true;
	            
	         }
	         
	      } catch (Exception e)
	      {
	         System.out.println(e.toString());
	      }
	      
	      //파일이 존재하지 않아 정상적인 처리가 이루어지지 않을 경우 false 반환
	      return false;
	   
	   }//end doFileDownload
	   
	   
	   
	   //실제 파일 삭제(제거)
	   public static void doFileDelete(String fileName, String path)
	   {
	      try
	      {
	         File file = null;
	         
	         String fullFileName = path + File.separator + fileName;
	         file = new File(fullFileName);
	         
	         if (file.exists())
	            file.delete();
	            
	      } catch (Exception e)
	      {
	         System.out.println(e.toString());
	      }
	   }
}
