package src.main;
import src.sub.*;


public class RunServer {

    public static void main(String[] args) {
    
        Server ser = new Server();
        try {
              ser.setUpServer(6666);              
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}