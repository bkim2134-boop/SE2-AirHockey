package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServiceRunner {

	public static void main(String args[]) throws IOException { 

        String path = "UserInfo.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitby = ",";

        try {

            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] user = line.split(csvSplitby);

                System.out.println(user[0] + " " + user[1] + " " + user[2]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Help!");
            }
        }

        ServerSocket server = new ServerSocket(8080); 
        System.out.println("Listening for connection on port 8080...");
        while (true) { 
            try (Socket socket = server.accept()) { 
                Date today = new Date(); 
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today; 
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8")); 
            } 
        }
    } 
	
}
