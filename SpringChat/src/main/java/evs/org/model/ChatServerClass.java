package evs.org.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServerClass implements Serializable{

    private Integer port;

    public ChatServerClass(Integer port) {
        this.port = port;
        StartServer(port);
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void StartServer(Integer SrvrPort) {
        try {
            final ServerSocket server
                    = new ServerSocket(SrvrPort);
            System.out.println("---> Server is up and running ... ");

            ExecutorService service = Executors.newFixedThreadPool(2);

            while (true) {
                Socket client = server.accept();
                System.out.println("---> A new client :" + client);

                service.execute(
                        new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream clientIn
                                    = new BufferedInputStream(
                                            client.getInputStream()
                                    );
                            OutputStream clientOut
                                    = new BufferedOutputStream(
                                            client.getOutputStream()
                                    );
                            byte[] b = new byte[1024];
                            while (true) {
                                int readBytes = clientIn.read(b);
                                System.out.print("--(Client)-["
                                        + new Timestamp(System.currentTimeMillis())
                                        + "]->:" + new String(b, 0, readBytes));

                                clientOut.write(b, 0, readBytes);
                                clientOut.flush();

                            }
                        } catch (IOException ex) {
                            Logger.getLogger(ChatServerClass.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        } catch (Exception e) {
        }
    }
}
