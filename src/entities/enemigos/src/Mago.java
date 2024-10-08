// Clase Mago, que extiende Enemigo
public class Mago extends Enemigo {
    public Mago() {
        super("Mago", 70, 25);
    }
    @Override
    public void atacar() {
        System.out.println(nombre + " lanza un hechizo de fuego, causando " + ataque + " de daño.");
    }
}