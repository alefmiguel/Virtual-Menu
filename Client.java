import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

class Cliente {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // receber e mandar mensagem
        
        Socket socket = new Socket("localhost", 8000);
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        System.out.println("Enviando mensagem...");

        String msg = "Hello World!";
        output.writeUTF(msg);
        output.flush();
        msg = input.readUTF();
        System.out.println("Resposta: " + msg);
        
        // fechamento das STREAMS e do SOCKET
        input.close();
        output.close();
        socket.close();
    }
}