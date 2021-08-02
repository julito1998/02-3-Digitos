import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String resultado = "";
        double dblResultado;
        Integer valorAnalizar;

        DecimalFormat formatoSinDecimal = new DecimalFormat("000");
        System.out.println("Ingrese la cantidad de valores a analizar : (0 para Cerrar el programa)");
        Scanner entrada=new Scanner(System.in);
        Integer cantAnalizar=entrada.nextInt();

        for (int i=0; i<=cantAnalizar;i++){
            System.out.println("Ingrese el valor a analizar : ");
            valorAnalizar=entrada.nextInt();
            dblResultado = Math.round(Math.pow(3+Math.sqrt(5),valorAnalizar)*100.0) /100.0;
            System.out.println("Resultado de: (3 +sqrt(5))^"+ valorAnalizar + "= " + dblResultado);
            //si es un numero con decimales
            if (String.valueOf(dblResultado).contains(".")){
                //recorro desde que encuentro el punto (.) solo 3 posiciones
                int contador=0;
                for (int j=String.valueOf(dblResultado).indexOf(".")-1; j>=0 ; j--){
                    if (contador==3){
                        break;
                    }
                    resultado = String.valueOf(dblResultado).charAt(j) + resultado;
                    contador+=1;
                }
            }else {
                for (int j=0; j<=String.valueOf(dblResultado).length()  && j<=2; j++){
                    resultado = resultado+String.valueOf(dblResultado).charAt(j);
                }
            }
            try {
                resultado = formatoSinDecimal.format(Double.valueOf(resultado));
            }
            catch (Exception e){
                System.out.println("Error : " + e.getMessage());
            }
            System.out.println("La respuesta es : " + resultado);
            resultado="";
        }
    }
}
