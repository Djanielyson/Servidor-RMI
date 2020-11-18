
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//a classe que implementa os m�todos deve estender UnicastRemoteObject
//a classe deve tamb�m implementar a interface com os m�todos RMI remotos (Hello)
public class Calculador extends UnicastRemoteObject implements MetodosNumericos {
    @Override
    public double calcularRegraTrapezio(double inicial, double fim, int subIntervalos) {

        double tamanhoSubIntervalo;
        double xi;
        double areaAprox;
      

        tamanhoSubIntervalo = (fim  - inicial)/ subIntervalos;
        
        areaAprox = f(inicial) + f(fim);

	for (int i = 1; i < subIntervalos; i++) {

            xi = inicial + i * tamanhoSubIntervalo;

            areaAprox = areaAprox + 2 * f(xi);
        }

        return (tamanhoSubIntervalo / 2) * areaAprox;
    }

    public Calculador() throws RemoteException {
        super();
    }

    @Override
    public double calcularSomaRiemann(double inicio, double finale, int subintervalos) throws RemoteException {

        double tamanhoSubIntervalos;
        double xi;
        double valorAreaAprox = 0;

        tamanhoSubIntervalos = (finale - inicio) / subintervalos;

        for (int i = 0; i < subintervalos; i++) {

            xi = inicio + i * tamanhoSubIntervalos;
            valorAreaAprox += tamanhoSubIntervalos * f(xi);// soma a �rea de cada ret�ngulo com os demais ret�ngulos
        }

        return valorAreaAprox;

    }

    double f(double x) {
        return 2.971 * Math.exp(0.138 * x);
    }

 

}
