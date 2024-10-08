// Clase Bestia, que extiende Enemigo
public class Bestia extends Enemigo {
    public Bestia() {
        super("Bestia", 150, 10);
    }
    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con una mordida feroz, causando " + ataque + " de daño.");
    }
}