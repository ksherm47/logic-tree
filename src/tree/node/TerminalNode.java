package tree.node;

import java.util.Collections;
import java.util.List;

public class TerminalNode implements LogicTreeNode {
    private final boolean value;

    public TerminalNode(boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate() {
        return value;
    }

    @Override
    public void generateRandomChildren(int depth) {}

    @Override
    public List<LogicTreeNode> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
