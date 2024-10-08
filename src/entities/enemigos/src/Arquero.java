// Clase Arquero, que extiende Enemigo
public class Arquero extends Enemigo {
    public Arquero() {
        super("Arquero", 80, 20);
    }
    @Override
    public void atacar() {
        System.out.println(nombre + " dispara una flecha, causando " + ataque + " de daño.");
    }
}
