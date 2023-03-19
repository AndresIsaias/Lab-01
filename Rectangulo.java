package s01;

public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;
    
    public Rectangulo (Coordenada esquina1, Coordenada esquina2){
        this.esquina1 = esquina1;
        this.esquina2 = esquina2;
    }
    public Rectangulo (){
        
    }

    public Coordenada getEsquina1() {
        return esquina1;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    public void setEsquina1(Coordenada esquina1) {
        this.esquina1 = esquina1;
    }

    public void setEsquina2(Coordenada esquina2) {
        this.esquina2 = esquina2;
    }
    
    public double calcularArea(){
        double base = Coordenada.distancia(esquina1, new Coordenada(esquina2.getX(),esquina1.getY()));
        double altura = Coordenada.distancia(esquina1, new Coordenada(esquina1.getX(),esquina2.getY()));
        return base * altura;
    }
     public double calcularAreaDeSobreposicion(Rectangulo otroRectangulo) {
        double xMin = Math.max(esquina1.getX(), otroRectangulo.getEsquina1().getX());
        double xMax = Math.min(esquina2.getX(), otroRectangulo.getEsquina2().getX());
        double yMin = Math.max(esquina2.getY(), otroRectangulo.getEsquina2().getY());
        double yMax = Math.min(esquina1.getY(), otroRectangulo.getEsquina1().getY());

        double base = xMax - xMin;
        double altura = yMax - yMin;

        if (base < 0 || altura < 0) {
            return 0.0;
        }

        return base * altura;
    }

    
    @Override
    public String toString(){
        return "[" + this.esquina1.toString() + ", " + this.esquina2.toString() + "]";
    }

}
