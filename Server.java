// IMPORTAÇÃO DAS EXCEÇÕES E DO PACOTE SERVERSOCKET
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // INICIALIZAÇÃO DA VARIÁVEL SOCKET DO SERVIDOR
    private ServerSocket serverSocket;

    // MÉTODOS GETTERS E SETTERS
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    // TRATAR O PROBLEMA NA CRIAÇÃO DA CONEXÃO
    public void createServerSocket() throws IOException {
        serverSocket = new ServerSocket(8000);
    }

    public Socket waitConnection() throws IOException {
        Socket socket = serverSocket.accept();
        return socket;
    }

    public void catchException (Socket socket) {
        // protocolo da aplicação (de cada uma)
        
    }

     public static void main(String[] args) {
        try {
            Server server = new Server();
            server.createServerSocket();
            Socket socket = server.waitConnection();
        }
        catch (IOException e) {
            
        }
    }
}