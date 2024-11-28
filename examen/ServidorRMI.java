import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(5000); 
            BMIRemotoImpl bmiServidor = new BMIRemotoImpl();
            Naming.rebind("rmi://localhost/BMIRemoto", bmiServidor);
            System.out.println("Servidor RMI listo y esperando conexiones...");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
