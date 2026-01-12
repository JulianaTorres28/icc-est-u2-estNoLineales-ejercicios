
package main.Ejercicio_01_insert;

import main.Materia.Models.Node;

public class InsertBST {

    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        Node current = root;
        while (true) {
            if (value < current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(new Node(value));
                    break;
                }
                current = current.getLeft();
            } else if (value > current.getValue()) {
                if (current.getRight() == null) {
                    current.setRight(new Node(value));
                    break;
                }
                current = current.getRight();
            } else {
                break;
            }
        }
        return root;
    }
}
