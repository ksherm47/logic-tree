package tree.node;

import tree.util.NodeGenerator;
import util.RandomUtil;

import java.util.List;
import java.util.Random;

public abstract class BinaryNode implements LogicTreeNode {

    private static final Random RANDOM = RandomUtil.getRandomInstance();

    protected LogicTreeNode left;
    protected LogicTreeNode right;

    @Override
    public void generateRandomChildren(int depth) {
        if (depth < 0) {
            return;
        }

        if (depth == 0) {
            left = new TerminalNode(RANDOM.nextBoolean());
            right = new TerminalNode(RANDOM.nextBoolean());
            return;
        }

        left = NodeGenerator.generateRandomNode();
        left.generateRandomChildren(depth - 1);
        right = NodeGenerator.generateRandomNode();
        right.generateRandomChildren(depth - 1);
    }

    @Override
    public List<LogicTreeNode> getChildren() {
        return List.of(left, right);
    }
}
