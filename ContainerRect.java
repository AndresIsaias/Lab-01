package s01;

public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;
    private int numRec;

    public ContainerRect(int n) {
        this.n = n;
        this.rectangulos = new Rectangulo[n];
        this.distancias = new double[n]; 
        this.areas = new double[n];
        this.numRec = 0;
    }

    public int getNumRec() {
        return numRec;
    }

    public boolean addRectangulo(Rectangulo r) {
        if (numRec == n) {
            System.out.println("No es posible agregar más rectángulos, capacidad máxima alcanzada.");
            return false;
        }

        // Agrega el rectangulo al arreglo
        rectangulos[numRec] = r;
        
        // Calcula la distancia euclidiana
        double distancia = r.getEsquina1().distancia(r.getEsquina2());
        distancias[numRec] = distancia;
        
        // Calcula el area del rectangulo
        double area = r.calcularArea();
        areas[numRec] = area;

        // Incrementa un rectangulo a el contador
        numRec++;

        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Rectangulo\t   Coordenada\t         Distancia\t        Area");
        for (int i = 0; i < numRec; i++) {
            sb.append("   "+(i+1) + "       " + rectangulos[i].toString() + "   " + distancias[i] + "       " + areas[i] + "\n");
        }
        return sb.toString();
    }
}
