import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        String address = args[0];
        String servicename = args[1];

        if(args.length!=2){
            System.out.println("Usage: java Client <address> <servicename>");
        }
        try {
            ServerInterface si = (ServerInterface) Naming.lookup("rmi://"+address+"/"+servicename);
            Scanner log = new Scanner(System.in);

            System.out.printf("User ID:");
            String id = log.nextLine();
            System.out.printf("Password:");
            String psw = log.nextLine();
            System.out.println(si.logIn(id, psw));
            List<User> list = si.allUsers();
            StringBuilder message = new StringBuilder();
            list.forEach(x -> {
                message.append(x.toString() + "\n");
            });
            JOptionPane.showMessageDialog(null, new String(message));


        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
