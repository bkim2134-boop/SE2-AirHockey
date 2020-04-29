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

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080...");

        br = new BufferedReader(new FileReader(path));
        String httpResponse = new String();

        try {
            while (true) {
                try (Socket socket = server.accept()) {
                    while ((line = br.readLine()) != null) {
                        String[] user = line.split(csvSplitby);
                        httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + user[0] + " " + user[1] + " " + user[2];
                        socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                    }
                }
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

    }

}
