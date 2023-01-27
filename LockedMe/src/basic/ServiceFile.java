package basic;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ServiceFile 
{
	//static File root_dir = new File("C:\\Users\\ChoudharyP7\\workspace\\FileDir\\");
	protected static final String path= System.getProperty("user.dir");
	String fileName=null;

	public ServiceFile() {
			
	}
	public ServiceFile(String fileName) {
		this.fileName=fileName;
	}
		// TODO Auto-generated constructor stub
	


	


	/**
	 * 
	 */
	  final long serialVersionUID = 1L;

	void addFile(){
	
    try {
   
      File file = new File(path+"//S" +fileName);
      if (file.createNewFile()) {
    	 
        System.out.println("File created: " + file.getName());
      	} else {
        System.out.println("File already exists.");
      	}
    	} catch (IOException e) {
    		e.printStackTrace();
    }
	}
	
	void deleteFile(){
		
	    File dir = new File(path+"//");
	    File file=new File(path+"//" +fileName);
	    if(exists(dir,fileName)){
	      if (file.delete()) { 
	    	  System.out.println("Deleted the file: " + fileName);
	      	} else {
	    	  System.out.println("Failed to delete the file.");
	      	}
	   	}else {
	   		System.out.println("File doesn't exist");
	   	}
	    
		}  
	    void searchFile(){
			
	    	File dir = new File(path+"//");
		 	if(exists(dir,fileName)){
				  	  System.out.println("File Exist: "+fileName);
				}else {
					System.out.println("File doesn't exist");
				}
			
	    }
	    
	    public boolean exists(File dir, String filename){
	        String[] files = dir.list();
	        for(String file : files)
	            if(file.equals(filename))
	                return true;
	        return false;
	    }
	    
	    
	void displayFile(){
		 String[] fileLists;
		 File f = new File(path+"//");
		 fileLists = f.list();
		 List<String> fileArrayLists = new ArrayList<String>(Arrays.asList(fileLists));
		 Collections.sort(fileArrayLists);
	      for (String fileList : fileArrayLists) {
	            // Print the names of files and directories
	    	 
	            System.out.println(fileList);
	        }
	      
	    }
	
}