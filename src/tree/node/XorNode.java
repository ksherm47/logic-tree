package tree.node;

public class XorNode extends BinaryNode {
    @Override
    public boolean evaluate() {
        return left.evaluate() ^ right.evaluate();
    }

    @Override
    public String toString() {
        return "(XOR " + left.toString() + " " + right.toString() +")";
    }
}
