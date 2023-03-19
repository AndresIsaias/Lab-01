package s01;
public class Verificador {
    
    // Verifica si los dos rectángulos se sobreponen
    public static boolean seSobreponen(Rectangulo A, Rectangulo B) {
        Coordenada esq1RA = A.getEsquina1();
        Coordenada esq2RA = A.getEsquina2();
        Coordenada esq1RB = B.getEsquina1();
        Coordenada esq2RB = B.getEsquina2();
        
        // Verificar si los dos rectangulos no se sobreponen
        if (esq1RA.getX() >= esq2RB.getX() || esq2RA.getX() <= esq1RB.getX()) {
            return false;
        }
        if (esq1RA.getY() <= esq2RB.getY() || esq2RB.getY() >= esq1RB.getY()) {
            return false;
        }
        return true;
    }

    // Verificando si los dos rectángulos son disjuntos
    public static boolean sonDisjuntos(Rectangulo A, Rectangulo B) {
        return !seSobreponen(A, B) && !estanJuntos(A, B);
    }

    // Verificando si los dos rectángulos están juntos
    public static boolean estanJuntos(Rectangulo A, Rectangulo B) {
        Coordenada esq1RA = A.getEsquina1();
        Coordenada esq2RA = A.getEsquina2();
        Coordenada esq1RB = B.getEsquina1();
        Coordenada esq2RB = B.getEsquina2();
        boolean ladosVerticalesJuntos = (esq1RA.getX() == esq2RB.getX()) || (esq2RA.getX() == esq1RB.getX());
        boolean ladosHorizontalesJuntos = (esq1RA.getY() == esq2RB.getY()) || (esq2RA.getY() == esq1RB.getY());
        if (ladosVerticalesJuntos || ladosHorizontalesJuntos) {
            return !seSobreponen(A, B);
        }
        return false;
    }
}
