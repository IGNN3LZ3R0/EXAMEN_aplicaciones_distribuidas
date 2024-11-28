import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BMIRemotoImpl extends UnicastRemoteObject implements BMIRemoto {

    protected BMIRemotoImpl() throws RemoteException {
        super();
    }

    @Override
    public double calcularBMI(double peso, double altura) throws RemoteException {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que 0");
        }
        return peso / (altura * altura);
    }

    @Override
public String categoriaBMI(double bmi) throws RemoteException {
    if (bmi < 0) {
        return "Valor inválido"; 
    } else if (bmi < 18.5) {
        return "Bajo peso";
    } else if (bmi >= 18.5 && bmi < 24.9) {
        return "Normal";
    } else if (bmi >= 25 && bmi < 29.9) {
        return "Sobrepeso";
    } else { 
        return "Obesidad";
    }
}

}
