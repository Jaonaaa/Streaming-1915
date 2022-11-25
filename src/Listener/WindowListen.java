package src.Listener;

import src.Infrastructure.*;
import java.awt.event.*;

public class WindowListen implements ActionListener {

    Window window;
    Bouton btn;

    public WindowListen(Window wind, Bouton btn) {
        this.window = wind;
        this.btn = btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (btn == window.getConnectBtn()) {
                System.out.println("Go connect");
                goConnect();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void goConnect() throws Exception {

        String ipAddress = window.getTextFieldIp().getTextField().getText();
        int port = Integer.valueOf(window.getTextFieldPort().getTextField().getText());
        String clientName = window.getClientName().getTextField().getText();
        Boolean connected = this.window.setUpConnection(clientName, ipAddress, port);
    }
}
