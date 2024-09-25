/**
 * Clase Player que representa al jugador en el juego.
 * Gestiona las estadísticas del jugador, ataques, defensa y el estado actual.
 */
import java.util.EnumMap;
import javax.swing.JOptionPane;

public class Player {

    private String name;
    private EnumMap<Stats, Integer> stats;
    private boolean defending;

    /* Constructor que inicializa el jugador con su nombre, salud, ataque y defensa */
    public Player(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.stats = new EnumMap<>(Stats.class);
        this.stats.put(Stats.HP, health);
        this.stats.put(Stats.ATTACK, attackPower);
        this.stats.put(Stats.DEFENSE, defense);
        this.defending = false;
    }

    /* Método getter para obtener el nombre */
    public String getName() {
        return name;
    }

    /* Verificar si el jugador está vivo (salud > 0) */
    public boolean isAlive() {
        return getStat(Stats.HP) > 0;
    }

    /* Método para atacar a un enemigo */
    public void attack(Enemy enemy) {
        int attackPower = getStat(Stats.ATTACK);
        JOptionPane.showMessageDialog(null, name + " ataca a " + enemy.getName() + " por " + attackPower + " de daño!");
        enemy.takeDamage(attackPower);
    }

    /* Método para defenderse */
    public void defend() {
        defending = true;
        JOptionPane.showMessageDialog(null, name + " se está defendiendo, reduciendo el daño recibido en el próximo turno.");
    }

    /* Método para recibir daño de un enemigo */
    public void takeDamage(int damage) {
        int defense = defending ? getStat(Stats.DEFENSE) : 0;
        int currentHealth = getStat(Stats.HP);
        int finalDamage = damage - defense;
        if (finalDamage < 0) finalDamage = 0;

        currentHealth -= finalDamage;
        if (currentHealth < 0) {
            currentHealth = 0; // Evitar salud negativa
        }
        putStat(Stats.HP, currentHealth);
        defending = false;

        JOptionPane.showMessageDialog(null, name + " recibe " + finalDamage + " de daño. Salud restante: " + currentHealth);
    }

    /* Obtener el valor de una estadística específica */
    public int getStat(Stats stat) {
        return stats.get(stat);
    }

    /* Establecer el valor de una estadística específica */
    public void putStat(Stats stat, int value) {
        stats.put(stat, value);
    }

    /* Mostrar la información del jugador */
    public void displayInfo() {
        String info = "Jugador: " + name + "\nSalud: " + getStat(Stats.HP) + "\nPoder de ataque: " + getStat(Stats.ATTACK) + "\nDefensa: " + getStat(Stats.DEFENSE);
        JOptionPane.showMessageDialog(null, info, "Estadísticas del jugador", JOptionPane.INFORMATION_MESSAGE);
    }
}

/* Enum que define las estadísticas del jugador */
enum Stats {
    ATTACK,  // Poder de ataque
    HP,      // Salud
    DEFENSE  // Defensa
}