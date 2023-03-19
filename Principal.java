package s01;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;
        int contadorPares = 0;
        int maxPares = 10;
        ContainerRect container = new ContainerRect(maxPares * 2);
        
        do {
            System.out.println("Ingrese la esquina y esquina opuesta del 1er rectangulo:");
            Rectangulo A = leerRectangulo(scanner);
            System.out.println("Ingrese la esquina y esquina opuesta del 2do rectangulo:");
            Rectangulo B = leerRectangulo(scanner);
            verificarRelaciones(A, B);
            container.addRectangulo(A);
            container.addRectangulo(B);
            contadorPares++;

            if (contadorPares < maxPares) {
                System.out.println("Desea seguir verificando otros rectangulos? (s/n)");
                opcion = scanner.next();
            } else {
                System.out.println("Se alcanzo el límite máximo de pares de rectángulos.");
                opcion = "n";
            }

        } while (opcion.equalsIgnoreCase("s"));
        
        
        System.out.println(container.toString());
        scanner.close();
    }
    //Almacena los datos ingresados dentro de las coordenadas
    public static Rectangulo leerRectangulo(Scanner scanner) {
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        Coordenada c1 = new Coordenada(x1, y1);
        Coordenada c2 = new Coordenada(x2, y2);
        return new Rectangulo(c1, c2);
    }

    public static void verificarRelaciones(Rectangulo A, Rectangulo B) {
        
        if (Verificador.seSobreponen(A, B)) {
            System.out.println("Los rectángulos A y B se sobreponen.");
            double areaSobreposicion = rectanguloSobre(A, B).calcularArea();
            System.out.println("El área de sobreposición es: " + areaSobreposicion);
        } else if (Verificador.estanJuntos(A, B)) {
            System.out.println("Los rectángulos A y B se juntan.");
        } else if (Verificador.sonDisjuntos(A, B)) {
            System.out.println("Los rectángulos A y B son disjuntos.");
        }
    }
    public static Rectangulo rectanguloSobre(Rectangulo A, Rectangulo B) {
        
        // Verificando si los rectangulos se sobreponen
        if (!Verificador.seSobreponen(A, B)) {
            return new Rectangulo();
        }
        double x1 = Math.max(A.getEsquina1().getX(), B.getEsquina1().getX());
        double y1 = Math.max(A.getEsquina2().getY(), B.getEsquina2().getY());
        Coordenada esquina1 = new Coordenada(x1, y1);

        double x2 = Math.min(A.getEsquina2().getX(), B.getEsquina2().getX());
        double y2 = Math.min(A.getEsquina1().getY(), B.getEsquina1().getY());
        Coordenada esquina2 = new Coordenada(x2, y2);

        return new Rectangulo(esquina1, esquina2);
    }
}



