import java.rmi.Naming;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            BMIRemoto bmiServicio = (BMIRemoto) Naming.lookup("//localhost/BMIRemoto");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Menú:");
                System.out.println("1. Calcular BMI");
                System.out.println("2. Obtener categoría del BMI");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion;
                try {
                    opcion = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    scanner.nextLine(); 
                    continue;
                }
                if (opcion == 3) {
                    System.out.println("Saliendo de la aplicación...");
                    break;
                }
                double peso = 0;
                double altura = 0;
                while (true) {
                    System.out.print("Ingrese el peso (kg): ");
                    try {
                        peso = scanner.nextDouble();
                        if (peso <= 0) {
                            System.out.println("El peso debe ser un número positivo.");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingrese un número válido para el peso.");
                        scanner.nextLine(); 
                    }
                }
                while (true) {
                    System.out.print("Ingrese la altura (m): ");
                    try {
                        altura = scanner.nextDouble();
                        if (altura <= 0) {
                            System.out.println("La altura debe ser un número positivo.");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingrese un número válido para la altura.");
                        scanner.nextLine(); // Limpiar el buffer
                    }
                }
                if (opcion == 1) {
                    double bmi = bmiServicio.calcularBMI(peso, altura);
                    System.out.printf("Su BMI es: %.2f%n", bmi);
                } else if (opcion == 2) {
                    double bmi = bmiServicio.calcularBMI(peso, altura);
                    String categoria = bmiServicio.categoriaBMI(bmi);
                    System.out.printf("Su categoría de BMI es: %s%n", categoria);
                } else {
                    System.out.println("Opción no válida. Intente nuevamente.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}