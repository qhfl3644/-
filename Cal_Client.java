package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class Cal_Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9999);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.println("서버에 연결되었습니다. (종료하려면 bye 입력)");
            while (true) {
                System.out.print("수식 입력 (예: 10 + 5) >> ");
                String msg = sc.nextLine();
                out.write(msg + "\n");
                out.flush();
                if (msg.equalsIgnoreCase("bye"))
                    break;
                String resp = in.readLine();
                System.out.println("서버 응답: " + resp);
            }
        } catch (IOException e) {
            System.out.println("클라이언트 오류: " + e.getMessage());
        }
    }
}
