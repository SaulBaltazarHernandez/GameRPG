// Clase principal para probar el polimorfismo
public class Juego {
    public static void main(String[] args) {
        // Crear un arreglo de enemigos
        Enemigo[] enemigos = new Enemigo[5];
        enemigos[0] = new Guerrero();
        enemigos[1] = new Mago();
        enemigos[2] = new Arquero();
        enemigos[3] = new Bestia();
        enemigos[4] = new Fantasma();
        // Polimorfismo: llamar al método atacar en cada enemigo
        for (Enemigo enemigo : enemigos) {
            enemigo.atacar();
        }
    }
}