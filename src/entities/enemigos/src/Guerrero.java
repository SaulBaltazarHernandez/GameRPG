// Clase Guerrero, que extiende Enemigo
public class Guerrero extends Enemigo {
    public Guerrero() {
        super("Guerrero", 100, 15);
    }
    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con una espada, causando " + ataque + " de daño.");
    }
}