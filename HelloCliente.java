
import java.rmi.Naming;

public class HelloCliente {


	public static void main(String args[]) {
		double max = 0;
                double min = 0;
                double diferenca = 0;
                double total =0;
		double areaSobCurvaRieman = 0;
                double areaSobCurvaTrapezio = 0;
		try {
			
			//lookup pesquisa no registro RMI se h� algum nome "//localhost:2021/Hello". Caso haja, recupera o objeto
			MetodosNumericos obj = (MetodosNumericos) Naming.lookup("//" + "localhost:2021" + "/Calculador");
			
			//usamos o objeto como se sua implementa��o fosse local (dentro da classe HelloCliente)
			areaSobCurvaRieman = obj.calcularSomaRiemann(60, 80, 100);
                        areaSobCurvaTrapezio = obj.calcularRegraTrapezio(60, 80, 100);
			
			System.out.println("Mensagem no servidor RMI de: \"" + "Rieman = " + String.valueOf(areaSobCurvaRieman) + "\"");
			System.out.println("Mensagem no servidor RMI de: \"" + "Trapezio = " + String.valueOf(areaSobCurvaTrapezio) + "\"");
                        
                        
                        if (areaSobCurvaRieman > areaSobCurvaTrapezio){
                            max = areaSobCurvaRieman;
                            min = areaSobCurvaTrapezio;
                            diferenca = max - min;
                            total = (diferenca*100)/max;
                            System.out.println("A diferença é de : " + diferenca);
                        } else{
                            max = areaSobCurvaTrapezio;
                            min = areaSobCurvaRieman;
                            diferenca = max - min;
                            total = (diferenca*100)/max;
                            System.out.println("A diferença é de : " + diferenca);
                            System.out.println("A diferença em % é de : " + String.format("%.2f", total) + "%");
                            System.out.println(total);
                        }
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e.getMessage());
			e.printStackTrace();
		}

	}
}
