package tree.node;

public class OrNode extends BinaryNode {
    @Override
    public boolean evaluate() {
        return left.evaluate() || right.evaluate();
    }

    @Override
    public String toString() {
        return "(OR " + left.toString() + " " + right.toString() +")";
    }
}
