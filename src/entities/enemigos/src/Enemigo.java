// Clase base Enemigo
public abstract class Enemigo {
    protected String nombre;
    protected int salud;
    protected int ataque;
    public Enemigo(String nombre, int salud, int ataque) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
    }
    // Método común a todos los enemigos
    public void recibirDaño(int daño) {
        this.salud -= daño;
        System.out.println(nombre + " ha recibido " + daño + " de daño. Salud restante: " + salud);
    }
    // Método abstracto que se implementará de manera diferente en cada subclase
    public abstract void atacar();
}