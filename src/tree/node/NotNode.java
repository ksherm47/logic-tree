package tree.node;

import tree.util.NodeGenerator;
import util.RandomUtil;

import java.util.List;
import java.util.Random;

public class NotNode implements LogicTreeNode {

    private static final Random RANDOM = RandomUtil.getRandomInstance();

    private LogicTreeNode child;

    @Override
    public boolean evaluate() {
        return !child.evaluate();
    }

    @Override
    public void generateRandomChildren(int depth) {
        if (depth < 0) {
            return;
        }

        if (depth == 0) {
            child = new TerminalNode(RANDOM.nextBoolean());
            return;
        }

        child = NodeGenerator.generateRandomNode();
        child.generateRandomChildren(depth - 1);
    }

    @Override
    public List<LogicTreeNode> getChildren() {
        return List.of(child);
    }

    @Override
    public String toString() {
        return "(NOT " + child.toString() + ")";
    }
}
