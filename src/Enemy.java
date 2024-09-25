/**
 * Clase Enemy que representa a un enemigo en el juego.
 * Gestiona las estadísticas del enemigo, su ataque, y el estado actual.
 */

public class Enemy<Player> {
    private String name;
    private int health;
    private int attackPower;
    private String type;
    private String description;
    /* Constructor para enemigos */
    public Enemy(String name, String type) {
        this.name = name;
        this.type = type;

        // Asignar salud y poder de ataque según el tipo de enemigo
        switch (type) {
            case "Goblin":
                this.health = 50; // Salud del Goblin
                this.attackPower = 20; // Poder de ataque del Goblin
                this.description = "Una criatura pequeña y débil, pero astuta.";
                break;
            case "Orco":
                this.health = 170; // Salud del Orco
                this.attackPower = 25; // Poder de ataque del Orco
                this.description = "Un guerrero fuerte y agresivo.";
                break;
            case "Dragón":
                this.health = 200; // Salud del Dragón
                this.attackPower = 100; // Poder de ataque del Dragón
                this.description = "Una bestia enorme y poderosa que respira fuego.";
                break;
            default:
                throw new IllegalArgumentException("Tipo de enemigo no válido");
        }
    }

    // Métodos
    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Player player) { // Cambiado para atacar al jugador
        player.equals(attackPower);
        System.out.println(name + " ataca a " + player.getClass() + " por " + attackPower + " de daño!");
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; // Evitar salud negativa
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }

    public void displayInfo() {
        System.out.println("Enemigo: " + name + " | Tipo: " + type + " | " + description + " | Salud: " + health + " | Poder de ataque: " + attackPower);
    }
}