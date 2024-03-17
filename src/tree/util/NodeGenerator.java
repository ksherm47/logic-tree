package tree.util;

import tree.node.AndNode;
import tree.node.LogicTreeNode;
import tree.node.NotNode;
import tree.node.OrNode;
import tree.node.TerminalNode;
import tree.node.XorNode;
import util.RandomUtil;

import java.util.Random;

import static util.Settings.DEFAULT_AND_PROB;
import static util.Settings.DEFAULT_NOT_PROB;
import static util.Settings.DEFAULT_OR_PROB;
import static util.Settings.DEFAULT_XOR_PROB;


public final class NodeGenerator {

    private static final Random RANDOM = RandomUtil.getRandomInstance();

    public static LogicTreeNode generateRandomNode() {
        return generateRandomNode(DEFAULT_AND_PROB, DEFAULT_OR_PROB, DEFAULT_XOR_PROB, DEFAULT_NOT_PROB);
    }

    public static LogicTreeNode generateRandomNode(double andProb, double orProb, double xorProb, double notProb) {
        if (andProb + orProb + xorProb + notProb > 1) {
            throw new RuntimeException("Sum of probabilities must not exceed 1");
        }
        if (andProb < 0 || orProb < 0 || xorProb < 0 || notProb < 0) {
            throw new RuntimeException("Probabilities must be be non-negative");
        }

        double roll = RANDOM.nextDouble();
        if (roll < andProb) {
            return new AndNode();
        }
        if (roll < andProb + orProb) {
            return new OrNode();
        }
        if (roll < andProb + orProb + xorProb) {
            return new XorNode();
        }
        if (roll < andProb + orProb + xorProb + notProb) {
            return new NotNode();
        }

        return new TerminalNode(RANDOM.nextBoolean());
    }
}
