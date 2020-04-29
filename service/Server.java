import java.io.*;
import java.net.*; 
import java.util.Date;

public class Server { 
    public static void main(String args[] ) throws IOException { 

        String path = "../UserInfo.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitby = ",";

        System.out.println("Help me!");

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
        System.out.println("Listening for connection on port 8080 ...."); 
        while (true) { 
            try (Socket socket = server.accept()) { 
                Date today = new Date(); 
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today; 
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8")); 
            } 
        }
    } 
}