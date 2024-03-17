package tree;

import tree.node.LogicTreeNode;
import tree.util.NodeGenerator;

public class LogicTree {
    private final LogicTreeNode root;

    public LogicTree(int depth) {
        if (depth < 0) {
            throw new RuntimeException("LogicTree depth must be > 0");
        }
        root = NodeGenerator.generateRandomNode();
        root.generateRandomChildren(depth - 1);
    }

    public boolean evaluate() {
        return root.evaluate();
    }

    public String toString() {
        return root.toString();
    }
}
