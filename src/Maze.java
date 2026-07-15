import java.util.ArrayList;
import java.util.List;

public class Maze {

    private int[][] maze;

    public Maze() {

        maze = new int[][]{
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0}
        };

        Celda inicio = new Celda(0, 0);
        Celda fin = new Celda(3, 3);

        List<Celda> camino = new ArrayList<>();

        System.out.println("LABERINTO ORIGINAL");
        imprimirLaberinto();

        boolean encontrado = findPath(maze, inicio, fin, camino);

        if (encontrado) {

            System.out.println("\nCAMINO:");

            for (int i = 0; i < camino.size(); i++) {
                Celda c = camino.get(i);

                System.out.print("(" + c.getX() + "," + c.getY() + ")");

                if (i < camino.size() - 1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println("\n");
            System.out.println("LABERINTO CON EL CAMINO");
            imprimirCamino(camino);

        } else {
            System.out.println("No existe un camino.");
        }
    }

    private boolean findPath(int[][] maze, Celda inicio, Celda fin, List<Celda> camino) {

        int fila = inicio.getX();
        int columna = inicio.getY();

        // Fuera del laberinto
        if (fila < 0 || fila >= maze.length ||
                columna < 0 || columna >= maze[0].length) {
            return false;
        }

        // Pared o visitada
        if (maze[fila][columna] == 1 || maze[fila][columna] == 2) {
            return false;
        }

        // Llegó al destino
        if (inicio.equals(fin)) {
            camino.add(0, inicio);
            return true;
        }

        // Marcar como visitada
        maze[fila][columna] = 2;

        // Derecha
        if (findPath(maze, new Celda(fila, columna + 1), fin, camino)) {
            camino.add(0, inicio);
            return true;
        }

        // Abajo
        if (findPath(maze, new Celda(fila + 1, columna), fin, camino)) {
            camino.add(0, inicio);
            return true;
        }

        // Izquierda
        if (findPath(maze, new Celda(fila, columna - 1), fin, camino)) {
            camino.add(0, inicio);
            return true;
        }

        // Arriba
        if (findPath(maze, new Celda(fila - 1, columna), fin, camino)) {
            camino.add(0, inicio);
            return true;
        }

        return false;
    }

    private void imprimirLaberinto() {

        for (int i = 0; i < maze.length; i++) {

            for (int j = 0; j < maze[i].length; j++) {

                if (maze[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }

            System.out.println();
        }
    }

    private void imprimirCamino(List<Celda> camino) {

        for (int i = 0; i < maze.length; i++) {

            for (int j = 0; j < maze[i].length; j++) {

                Celda actual = new Celda(i, j);

                if (camino.contains(actual)) {
                    System.out.print("* ");
                } else if (maze[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Maze();
    }
}