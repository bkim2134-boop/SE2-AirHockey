package main;


import java.io.*;  
import java.util.*;


public class CSVScanner {
	
	
	public Boolean CSVScanner(String NewName) {
		String fileName = "UserInfo.csv";
		File file = new File(fileName);
		int temp;
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()){
				String data = inputStream.next();
				
				String[] values = data.split(",");
				
				if(NewName.equals(values[0])) {
						
					
					
					inputStream.close();
					return true;
				}
			}
		inputStream.close();
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
		file.close();
		System.out.println("New user added");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void CSVedit(String NewName,int time) {
		String fileName = "UserInfo.csv";
		File oldfile = new File(fileName);
		String BufferFile="BufferFile.csv";
		File newerfile = new File(BufferFile);
		String User ="";
		String Wins="";
		String Time="";
		int temp;
		try {
			FileWriter file = new FileWriter(BufferFile,true);
			PrintWriter pw = new PrintWriter(file);//allows the user to use some thing like system.out for files 
			Scanner inputStream = new Scanner(oldfile);
			inputStream.useDelimiter("[,\n]");
			
			while(inputStream.hasNext()) {
				User=inputStream.next();
				Wins = inputStream.next();
				Time = inputStream.next();
				if(User.equals(NewName)) {
					
					temp = Integer.parseInt(Wins);
					temp++;
					Wins = String.valueOf(temp);
					pw.println(User +","+Wins+","+time);
				}
				else {
					pw.println(User +","+Wins+","+time);
				}
				
				
			}
			inputStream.close();
			pw.flush();
			pw.close();
			oldfile.delete();
			File dump = new File(fileName);
			newerfile.renameTo(dump);
			System.out.println("User information edited");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
}