import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Maze {

    private int[][] maze;
    private Set<Celda> recorrido = new LinkedHashSet<>();

    public Maze() {

        this.maze = new int[][]{
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
        };

        Celda inicio = new Celda(0, 0);
        Celda fin = new Celda(2, 0);

        List<Celda> camino = new ArrayList<>();

        boolean encontrado = findPath(maze, inicio, fin, camino);

        if (encontrado) {
            System.out.println("Camino encontrado");
            printMazeWithPath(camino);
            
            System.out.println("\nCamino:");
            System.out.println(camino);

            System.out.println("\nRecorrido:");
            System.out.println(recorrido);
        } else {
            System.out.println("No existe un camino");
        }
    }

    private void printMazeWithPath(List<Celda> camino) {

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Celda actual = new Celda(i, j);
                if (camino.contains(actual)) {
                    System.out.print(" * ");
                } else if (maze[i][j] == 1) {
                    System.out.print(" # ");
                } else {
                    System.out.print(" 0 ");
                }
            }

            System.out.println();
        }
    }

    private boolean findPath(int[][] maze, Celda inicio, Celda fin, List<Celda> camino) {

        int fila = inicio.getX();
        int columna = inicio.getY();

        // Fuera del mapa
        if (fila < 0 || fila >= maze.length ||
                columna < 0 || columna >= maze[0].length) {
            return false;
        }

        // Pared
        if (maze[fila][columna] == 1) {
            return false;
        }

        // Ya visitada
        if (recorrido.contains(inicio)) {
            return false;
        }

        // Marcar como visitada
        recorrido.add(inicio);

        // Agregar al camino actual
        camino.add(inicio);

        // Llegó al destino
        if (inicio.equals(fin)) {
            return true;
        }

        // Derecha
        if (findPath(maze, new Celda(fila, columna + 1), fin, camino))
            return true;

        // Abajo
        if (findPath(maze, new Celda(fila + 1, columna), fin, camino))
            return true;

        // Izquierda
        if (findPath(maze, new Celda(fila, columna - 1), fin, camino))
            return true;

        // Arriba
        if (findPath(maze, new Celda(fila - 1, columna), fin, camino))
            return true;

        // Backtracking
        camino.remove(camino.size() - 1);

        return false;
    }
}