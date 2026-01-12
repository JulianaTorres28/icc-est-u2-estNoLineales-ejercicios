
package main.Ejercicio_03_listLeves;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import main.Materia.Models.Node;

public class ListLevels {

    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                level.add(curr);

                if (curr.getLeft() != null)
                    queue.add(curr.getLeft());
                if (curr.getRight() != null)
                    queue.add(curr.getRight());
            }
            result.add(level);
        }

        return result;
    }
}
