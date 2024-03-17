package main;

import tree.LogicTree;
import util.RandomUtil;
import util.Settings;

public class Main {

    public static void main(String[] args) {
        Settings.init();
        RandomUtil.init(Settings.getSeed());

        LogicTree tree = new LogicTree(Settings.getDepth());
        System.out.println(tree);
        System.out.println(tree.evaluate());
    }
}
