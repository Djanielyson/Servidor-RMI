import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServidor {
	

	public static void main(String args[]) { 
		try { 
			
			//servidor se registra em uma determinada porta
			LocateRegistry.createRegistry(2021);
			
			//crio uma inst�ncia do objeto que implementar� as a��es
			Calculador objeto = new Calculador(); 
			
			//rebind vincula o objeto que implementa as a��es (obj) ao registro RMI com o nome "//localhost:2021/Hello"
			Naming.rebind("//localhost:2021/Calculador", objeto);
			
			System.out.println("Servidor no AR!"); 
		} 
		catch (Exception ex) { 
			ex.printStackTrace(); 
		} 
	}


}
