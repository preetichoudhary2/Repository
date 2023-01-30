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
	    if(!file.isDirectory()){
	    if(exists(dir,fileName)){
	      if (file.delete()) { 
	    	  System.out.println("Deleted the file: " + fileName);
	      	} else {
	    	  System.out.println("Failed to delete the file.");
	      	}
	    }else {
	   		System.out.println("File doesn't exist");
	   	}
	    }else{
			System.out.println("Failed to delete,Directory is not empty.");
			}
		}  
	
	    void searchFile(){
	    	File dir = new File(path+"//");
	    	File dirfile = new File(path+"//"+fileName);
	    	if(!dirfile.isDirectory()){
	    	if(exists(dir,fileName)){
				  	  System.out.println("File Exist: "+fileName);
				}else {
					System.out.println("File or Directory Not Found");
				}
	    		}else{
					System.out.println("Directory Exist "+dirfile);
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
	
	static void bubbleSort(String str[])
	{                                       
	String temp;
	for (int j = 0; j < str.length; j++) {
   	   for (int i = j + 1; i < str.length; i++) {
		// comparing adjacent strings
		if (str[i].compareTo(str[j]) < 0) {
			temp = str[j];
			str[j] = str[i];
			str[i] = temp;
		}
   	   	}
		}
		}
	
	
}