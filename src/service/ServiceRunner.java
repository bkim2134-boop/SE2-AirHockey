package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;
import com.sun.net.httpserver.HttpServer;

public class ServiceRunner {
	
	static BufferedReader br;
	static String data = "";
	
    public static void main(String[] args) throws IOException {
    	
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(ServiceRunner::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        printRequestInfo(exchange);
        data = "";
        
        if("".equals(requestURI.getPath()) || "/".equals(requestURI.getPath())) {
        	data += "Here are the available services:\r\n - /users\r\n - /wins";
        } else if("/users".equals(requestURI.getPath())) {
        	try {
        		br = new BufferedReader(new FileReader("UserInfo.csv"));
                
        		data += "Users:\r\n\r\n";
        		
                String line;
                while ((line = br.readLine()) != null) {
                    String[] user = line.split(",");
                    data += user[0] + "\r\n";
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
                }
            }
        } else if("/wins".equals(requestURI.getPath())) {
        	try {
        		br = new BufferedReader(new FileReader("UserInfo.csv"));
                
        		data += "Users:\tWins:\r\n\r\n";
        		
                String line;
                while ((line = br.readLine()) != null) {
                    String[] user = line.split(",");
                    data += user[0] + "\t" + user[1] + "\r\n";
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
                }
            }
        } else {
        	data += "That service was not found. Here are the available services:\r\n - /users\r\n - /wins";
        }
        
        exchange.sendResponseHeaders(200, data.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(data.getBytes());
        os.close();
    }

    private static void printRequestInfo(HttpExchange exchange) {
        System.out.println("-- headers --");
        Headers requestHeaders = exchange.getRequestHeaders();
        requestHeaders.entrySet().forEach(System.out::println);

        System.out.println("-- principle --");
        HttpPrincipal principal = exchange.getPrincipal();
        System.out.println(principal);

        System.out.println("-- HTTP method --");
        String requestMethod = exchange.getRequestMethod();
        System.out.println(requestMethod);

        System.out.println("-- query --");
        URI requestURI = exchange.getRequestURI();
        String query = requestURI.getQuery();
        System.out.println(query);
    }

}
