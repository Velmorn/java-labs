import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущено...");

            Socket socket = serverSocket.accept();
            System.out.println("Клієнт підключився");

            DataInputStream dis = new DataInputStream(socket.getInputStream());

            String fileName = dis.readUTF();

            FileOutputStream fos = new FileOutputStream("received_" + fileName);

            byte[] buffer = new byte[4096];
            int bytes;

            while ((bytes = dis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytes);
            }

            fos.close();
            dis.close();
            socket.close();

            System.out.println("Файл отримано!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}