
package evs.org.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.Timestamp;

public class ChatClientClass implements Serializable{

    private String ServerAdd;
    private Integer port;

    public ChatClientClass(String ServerAdd, Integer port) {
        this.ServerAdd = ServerAdd;
        this.port = port;
        StartClient(ServerAdd, port);
    }

    public String getServerAdd() {
        return ServerAdd;
    }

    public void setServerAdd(String ServerAdd) {
        this.ServerAdd = ServerAdd;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void StartClient(String SrvrIP, Integer SrvrPort) {
        try {
            Socket server = new Socket(SrvrIP, SrvrPort);
            System.out.println("--> Connection with Server Establish : " + server);

            InputStream keyboard
                    = new BufferedInputStream(System.in);
            OutputStream serverOut
                    = new BufferedOutputStream(
                            server.getOutputStream());
            InputStream serverIn
                    = new BufferedInputStream(
                            server.getInputStream());
            byte[] b = new byte[1024];
            while (true) {
                System.out.print(">>");
                int readBytes = keyboard.read(b);

                serverOut.write(b, 0, readBytes);
                serverOut.flush();

                readBytes = serverIn.read(b);
                System.out.println("--(Server)-["
                        + new Timestamp(System.currentTimeMillis())
                        + "]->:" + new String(b, 0, readBytes));
            }
        } catch (Exception e) {
        }
    }
}
