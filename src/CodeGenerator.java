

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jdframe.sys.core.model.T_vo;
import com.jdframe.sys.core.util.FileUtils;
import com.jdframe.sys.core.util.ValidateUtils;

public class CodeGenerator   {
    public  void generator(String[] args) throws IOException{
    	
    	File f = new File(this.getClass().getResource("").getPath()); 
    	String $ = f.getAbsolutePath(); 
    	String thirdlibpath = "";

    	  System.out.println("start. \r\n operating system : "+(isWin()?"Windows":"Linux/Unix"));
    	  if(args.length==0){
    	      System.out.println("The program need  parameter:the third party libraries, for example: java CodeGenerator D:\\JDFrame_apps\\WebRoot\\WEB-INF\\lib\\ ");
    	      thirdlibpath = $+File.separator+".."+File.separator+"lib"+File.separator;
    	      System.out.println("The program Guessing the path of third party libraries at:"+thirdlibpath);
    	      if(!new File(thirdlibpath).exists()){
    	    	  System.out.println("The program Guessing the path of third party libraries at:"+thirdlibpath+" is not exsits! Please try again after reset the first parameter.");
    	    	  return;
    	      }
    	      
    	  }else{
    		  thirdlibpath = args[0];
    	  }
    	  ProcessBuilder pb = null;
    	 
    	  
    	  
    	  StringBuffer command = new StringBuffer("java ");  
    	  
    	  //setting classpath
    	  StringBuffer classpath = new StringBuffer("%CLASSPATH%;");
    	  File dir = new File(thirdlibpath);
    	  if(dir.isDirectory()){
    		  File[] libs = dir.listFiles();
    		  for (int i = 0; i < libs.length; i++) {
    			  classpath.append(libs[i].getAbsolutePath()).append(";");
			}
    	  }
    	  classpath.append($+";.");
    	  
    	  
    	  
    	  command.append(" -classpath "+classpath);
    	  command.append(" org.mybatis.generator.api.ShellRunner ");
    	  command.append(" -configfile ").append($+File.separator+"CodeGenerator.xml").append(" -overwrite ");
    	  
    	  System.out.println("The program will run shell command: "+command.toString());
    	  
    	  
    	  if(isWin()){
    		  pb = new ProcessBuilder("cmd","/c",command.toString());
    	  }else{
    		  pb = new ProcessBuilder(command.toString());
    	  }
    	  
    	  pb.directory(new File($)); 
    	  Process p = pb.start();

    	  byte[] b = new byte[1024];
          int readbytes = -1;
          StringBuffer sb = new StringBuffer();
          InputStream in = p.getInputStream();
          try {
              while ((readbytes = in.read(b)) != -1) {
                  sb.append(new String(b, 0, readbytes));
              }
           if("".equals(sb.toString().trim())){
        	   System.out.println("Error: Please ensure is right of the third party libraries  is right!");
            }
          System.out.println(sb);
          } catch (IOException e1) {
        	  e1.printStackTrace();
          } finally {
              try {
                  in.close();
              } catch (IOException e2) {
            	  e2.printStackTrace();
              }
          }
   
          System.out.println("end.");
    	   
    }
    public boolean isWin(){
    	  Properties prop = System.getProperties();
    	  String os = prop.getProperty("os.name");
    	  return (os.toLowerCase().startsWith("win"));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CodeGenerator cg = new CodeGenerator();
		try {
			cg.generator(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.exit(0);
	}
	 
}
