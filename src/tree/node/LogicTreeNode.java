package tree.node;

import java.util.List;

public interface LogicTreeNode {
    boolean evaluate();
    void generateRandomChildren(int depth);
    List<LogicTreeNode> getChildren();

    default boolean isTerminal() {
        return false;
    }
}
