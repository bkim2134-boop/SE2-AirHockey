package main;


import java.io.*;  
import java.util.*;

import com.opencsv.*;

public class CSVScanner {
	
	
	public Boolean CSVScanner(String NewName) {
		String fileName = "UserInfo.csv";
		File file = new File(fileName);
		
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()){
				String data = inputStream.next();
				
				String[] values = data.split(",");
				
				if(NewName.equals(values[0])) {
					return true;
				}
				
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public static void CSVNewInput(String NewName,int time) {
								//dont need a input for wins because it will allwase be one more win
		String fileName = "UserInfo.csv";
		
		try {
		FileWriter file = new FileWriter(fileName,true);
		PrintWriter pw = new PrintWriter(file);//allows the user to use some thing like system.out for files 
		
		pw.println(NewName+",1,"+time);
		pw.flush();
		pw.close();
		
		System.out.println("New user added");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
    
	
}
	
