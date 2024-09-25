/**
 * Clase Game que representa el flujo del juego.
 * Gestiona al jugador y los enemigos, y controla el ciclo de turnos durante el combate.
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private List<Enemy> enemies;

    /* Constructor que inicializa el jugador y una lista de enemigos */
    public Game(Player player, List<Enemy> enemies) {
        this.player = player;
        this.enemies = enemies;
    }

    /* Método para iniciar el juego */
    public void startGame() {
        JOptionPane.showMessageDialog(null, "¡El juego ha comenzado!\nJugador: " + player.getName() + "\n");

        for (Enemy enemy : enemies) {
            String enemyColorName = colorEnemyName(enemy.getName(), enemy.getType()); // Obtener el nombre con el color adecuado
            JOptionPane.showMessageDialog(null, "¡Un " + enemy.getType() + " aparece!\n" + enemyColorName);

            // Ciclo de combate contra cada enemigo
            while (player.isAlive() && enemy.isAlive()) {
                playerTurn(enemy);
                if (!enemy.isAlive()) {
                    JOptionPane.showMessageDialog(null, enemyColorName + " ha sido derrotado.");
                    break;
                }
                enemyTurn(enemy);
            }

            if (!player.isAlive()) {
                JOptionPane.showMessageDialog(null, player.getName() + " ha sido derrotado.");
                break;
            }
        }

        // Mostrar el resultado final
        if (player.isAlive()) {
            JOptionPane.showMessageDialog(null, player.getName() + " ha derrotado a todos los enemigos!");
        } else {
            JOptionPane.showMessageDialog(null, "¡Has perdido el juego!");
        }
    }

    /* Lógica del turno del jugador */
    private void playerTurn(Enemy enemy) {
        String[] options = {"Atacar", "Defenderse", "Mostrar estado"};
        int choice = JOptionPane.showOptionDialog(null, "Turno de " + player.getName(),
                "Selecciona una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        if (choice == 0) {
            player.attack(enemy);
        } else if (choice == 1) {
            player.defend();
        } else if (choice == 2) {
            player.displayInfo();
        } else {
            JOptionPane.showMessageDialog(null, "Opción no válida, pierdes tu turno.");
        }
    }

    /* Lógica del turno del enemigo */
    private void enemyTurn(Enemy enemy) {
        JOptionPane.showMessageDialog(null, "Turno de " + enemy.getName());
        enemy.attack(player);
    }

    /* Método para colorear el nombre del enemigo basado en su tipo */
    private String colorEnemyName(String name, String type) {
        switch (type.toLowerCase()) {
            case "dragón":
                return "<html><font color='red'>" + name + "</font></html>";  // Rojo para Dragón
            case "goblin":
                return "<html><font color='green'>" + name + "</font></html>"; // Verde para Goblin
            case "orco":
                return "<html><font color='gray'>" + name + "</font></html>";  // Gris para Orco
            default:
                return "<html><font color='black'>" + name + "</font></html>"; // Negro para otros
        }
    }
}

/* Lanzador del juego */
class GameLauncher {

    public static void main(String[] args) {
        // Configurar la fuente a Monospaced para todas las ventanas emergentes
        UIManager.put("OptionPane.messageFont", new Font("Monospaced", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Monospaced", Font.PLAIN, 14));

        // Crear un jugador usando una ventana emergente para obtener el nombre
        String playerName = JOptionPane.showInputDialog("Introduce el nombre del jugador:");
        if (playerName == null || playerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no válido. El juego se cerrará.");
            System.exit(0);
        }

        // Crear el jugador con nombre, salud inicial de 100, poder de ataque de 30, y defensa de 10
        Player player = new Player(playerName, 100, 30, 10);

        // Crear una lista de enemigos
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Goblin", "Goblin"));
        enemies.add(new Enemy("Orco", "Orco"));
        enemies.add(new Enemy("Dragón", "Dragón"));

        // Inicializar el juego con el jugador y la lista de enemigos
        Game game = new Game(player, enemies);

        // Iniciar el juego
        game.startGame();
    }
}