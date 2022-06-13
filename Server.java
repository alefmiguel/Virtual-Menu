// IMPORTAÇÃO DAS EXCEÇÕES E DO PACOTE SERVERSOCKET
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    // MÉTODOS GETTERS E SETTERS
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    // TRATAR O PROBLEMA NA CRIAÇÃO DA CONEXÃO
    public void createServerSocket(int i) throws IOException {
        serverSocket = new ServerSocket(8000);
    }

    public Socket waitConnection() throws IOException {
        Socket socket = serverSocket.accept();
        return socket;
    }

    public void closeSocket(Socket s) throws IOException {
        s.close(); // fechamento de um socket qualquer

        // quando eu quiser desconectar um cliente do server
        // terminar comunicação com o cliente
        // conversa do protocolo etc (xauzinho)
    }

    public void catchConnection (Socket socket) throws IOException {
        // protocolo da aplicação (de cada uma)
        // enviar e receber mensagem por gosto
        // criação de stream in e stream out

        try {
            // primeiro o output
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            // depois o input
            ObjectInputStream input = new ObjectInputStream (socket.getInputStream());

            // protocolo simples (HELLO WORLD // HELLO WORLD)
            String msg = input.readUTF();
            System.out.println("Mensagem recebida: " + msg);
            output.writeUTF("HELLO WORLD");

            input.close();
            output.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            // erro naquela comunicação em específico
        }
        finally { 
            // tudo que abre fecha
            // isso independete do erro ou não

            closeSocket(socket);
        }
    }

     public static void main(String[] args) {
        try {
            Server server = new Server();
            System.out.println("Aguardando conexão...");

            server.createServerSocket(8000);
            Socket socket = server.waitConnection(); // protocolo
            System.out.println("Cliente conectado!");

            // só vai conectar quando o cliente bater na porta
            socket = server.waitConnection();
            server.catchConnection(socket);
            System.out.println("Cliente finalizado!");
        }
        catch (IOException e) {
            
        }
    }
}