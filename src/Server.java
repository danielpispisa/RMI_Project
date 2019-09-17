import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.function.Predicate;

public class Server extends UnicastRemoteObject implements ServerInterface {

    private List<User> userList;


    public Server(List<User> list) throws RemoteException {
        super();
        this.userList = list;
    }

    @Override
    public String logIn(String a, String b) throws RemoteException {
        if(a.compareTo("pippo")==0 && b.compareTo("1234")==0)
            return "Accesso eseguito correttamente";
        else return "Accesso fallito";
    }

    @Override
    public List<User> allUsers() throws RemoteException {
        return userList;
    }

    private static List<User> initializeList() {
        List<User> list = new ArrayList<>();
        list.add(new User("Daniel", "Pispisa", "danielpispisa@gmail.com", "Opel Astra", "130"));
        list.add(new User("Pippo", "La China", "pippolachina@gmail.com", "Fiat Punto", "80"));
        list.add(new User("Pietro", "Pisacane", "pietropisacane@gmail.com", "Peugeot 206", "65"));
        return list;
    }


    public static void main(String args[]){

        try {
            //System.setProperty("java.rmi.server.hostname","localhost");

            // when testing on remote node, a registry previously located must be used
            Registry registry = LocateRegistry.getRegistry();

            ServerInterface server = new Server(initializeList());

            // when testing on remote node, a registry previously located must be used
            registry.bind("databaseservice",server);
            // when testing on local:
            //Naming.rebind("calculatorservice",server);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
        /*
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        */
    }
}