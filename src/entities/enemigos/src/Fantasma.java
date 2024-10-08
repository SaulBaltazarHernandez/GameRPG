// Clase Fantasma, que extiende Enemigo
public class Fantasma extends Enemigo {
    public Fantasma() {
        super("Fantasma", 50, 30);
    }
    @Override
    public void atacar() {
        System.out.println(nombre + " atraviesa con su energía oscura, causando " + ataque + " de daño.");
    }
}