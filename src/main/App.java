
package main;

import java.util.List;

import main.Ejercicio_01_insert.InsertBST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Models.Node;

public class App {
    public static void main(String[] args) {
        // Ejercicio 01: Insertar en BST
        System.out.println("=== Ejercicio 01: Insertar en BST ===");
        InsertBST bstInsertion = new InsertBST();

        Node rootBST = null;
        int[] inputBST = { 5, 3, 7, 2, 4, 6, 8 };
        for (int v : inputBST) {
            rootBST = bstInsertion.insert(rootBST, v);
        }

        ListLevels visualizer = new ListLevels();
        List<List<Node>> bstLevels = visualizer.listLevels(rootBST);
        printLevelsAsValues(bstLevels);

        // Ejercicio 02: Invertir Árbol Binario
        System.out.println("\n=== Ejercicio 02: Invertir Árbol Binario ===");
  
        Node rootInvert = new Node(4);
        rootInvert.setLeft(new Node(2));
        rootInvert.setRight(new Node(7));
        rootInvert.getLeft().setLeft(new Node(1));
        rootInvert.getLeft().setRight(new Node(3));
        rootInvert.getRight().setLeft(new Node(6));
        rootInvert.getRight().setRight(new Node(9));

        InvertBinaryTree inverter = new InvertBinaryTree();
        Node inverted = inverter.invertTree(rootInvert);

        List<List<Node>> invertLevels = visualizer.listLevels(inverted);
        printLevelsAsValues(invertLevels);

        // Ejercicio 03: Listar Niveles en Listas
        System.out.println("\n=== Ejercicio 03: Listar Niveles en Listas ===");

        Node rootLists = new Node(4);
        rootLists.setLeft(new Node(2));
        rootLists.setRight(new Node(7));
        rootLists.getLeft().setLeft(new Node(1));
        rootLists.getLeft().setRight(new Node(3));
        rootLists.getRight().setLeft(new Node(6));
        rootLists.getRight().setRight(new Node(9));

        List<List<Node>> levelsForLists = visualizer.listLevels(rootLists);

        for (int k = 0; k < levelsForLists.size(); k++) {
            List<Node> lvl = levelsForLists.get(k);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lvl.size(); i++) {
                if (i > 0)
                    sb.append(k == 0 ? " " : " -> ");
                sb.append(lvl.get(i).getValue());
            }
            System.out.println(sb.toString());
        }

        // Ejercicio 04: Profundidad Máxima
        System.out.println("\n=== Ejercicio 04: Profundidad Máxima ===");
  
        Node rootDepth = new Node(4);
        rootDepth.setLeft(new Node(2));
        rootDepth.setRight(new Node(7));
        rootDepth.getLeft().setLeft(new Node(1));
        rootDepth.getLeft().setRight(new Node(3));
        rootDepth.getLeft().getLeft().setLeft(new Node(8));

        Depth depthCalc = new Depth();
        int depth = depthCalc.maxDepth(rootDepth);
        System.out.println(depth); 
    }

    private static void printLevelsAsValues(List<List<Node>> levels) {
        for (List<Node> lvl : levels) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lvl.size(); i++) {
                if (i > 0)
                    sb.append(" ");
                sb.append(lvl.get(i).getValue());
            }
            System.out.println(sb.toString());
        }
    }
}
