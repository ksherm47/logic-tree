package tree.node;

public class AndNode extends BinaryNode {
    @Override
    public boolean evaluate() {
        return left.evaluate() && right.evaluate();
    }

    @Override
    public String toString() {
        return "(AND " + left.toString() + " " + right.toString() +")";
    }
}
