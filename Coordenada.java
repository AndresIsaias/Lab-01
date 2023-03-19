package s01;
public class Coordenada {
    
    private double x;
    private double y;
    
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double distancia(Coordenada c) {
        double diferenciaX = x - c.getX();
        double diferenciaY = y - c.getY();
        return Math.sqrt(Math.pow(diferenciaX, 2) + Math.pow(diferenciaY, 2));
    }
    
    public static double distancia(Coordenada c1, Coordenada c2) {
        double diferenciaX = c1.getX() - c2.getX();
        double diferenciaY = c1.getY() - c2.getY();
        return Math.sqrt(Math.pow(diferenciaX, 2) + Math.pow(diferenciaY, 2));
    }
    
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

