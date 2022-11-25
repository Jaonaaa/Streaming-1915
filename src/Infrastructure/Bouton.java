package src.Infrastructure;

import javax.swing.JButton;

public class Bouton extends JButton {

    Window window;

    public Bouton(int x, int y, Window wind, String name) {
        super(name);
        this.window = wind;
        this.setBounds(x, y, 100, 60);
    }

    /**
     * @return the window
     */
    public Window getWindow() {
        return window;
    }

    /**
     * @param window the window to set
     */
    public void setWindow(Window window) {
        this.window = window;
    }

}
