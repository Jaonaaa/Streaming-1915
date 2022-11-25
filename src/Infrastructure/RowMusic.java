package src.Infrastructure;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.Listener.ButtonMusicListener;

public class RowMusic extends JPanel {
    
    String content ;
    JButton button ;
    JLabel label ;
    Window wind ;
    public RowMusic(int x,int y,JPanel panel,String music,Window wind)
    {
        this.wind = wind ;
        this.setBounds(x, y, panel.getWidth(),50);
        this.content = music;
        this.setLayout(null);
        String[] tabWay = music.replace("\\","#--#").split("#--#");
        this.label = new JLabel(tabWay[tabWay.length-1]);
        this.button = new JButton("Read");
        this.label.setBounds(panel.getWidth()/4, 0,panel.getWidth()-70 , 50);
        this.button.setBounds(panel.getWidth()-75, 0, 70, 40);
        this.button.addActionListener(new ButtonMusicListener(this));
        this.add(button);
        this.add(label);
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public JButton getButton() {
        return button;
    }
    public void setButton(JButton button) {
        this.button = button;
    }
    public JLabel getLabel() {
        return label;
    }
    public void setLabel(JLabel label) {
        this.label = label;
    }
    public Window getWind() {
        return wind;
    }
    public void setWind(Window wind) {
        this.wind = wind;
    }
    
}
