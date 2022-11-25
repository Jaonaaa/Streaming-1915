package src.runner;

import src.Infrastructure.Window;
import src.sub.Client;

public class Connection implements Runnable {

    Window window;
    String nom;
    String ipAddress;
    int port;

    public Connection(Window wind, String nom, String ipAddress, int port) {
        this.window = wind;
        this.nom = nom;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public void run() {
        while (true) {
            window.setClient(new Client(nom, this.window));
            try {
                window.getClient().setUpClient(ipAddress, port);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (window.getConnected() == false) {
                System.out.println("Out");
                break;
            } else {
                System.out.println("Im connected");
            }
        }
    }

}
