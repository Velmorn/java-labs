import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {

        String serverAddress = "localhost";
        int port = 12345;
        String filePath = "file.txt";

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Підключено до сервера");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            File file = new File(filePath);

            dos.writeUTF(file.getName());

            FileInputStream fis = new FileInputStream(file);

            byte[] buffer = new byte[4096];
            int bytes;

            while ((bytes = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytes);
            }

            fis.close();
            dos.close();

            System.out.println("Файл відправлено!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}