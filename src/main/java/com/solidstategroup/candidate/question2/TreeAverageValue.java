package com.solidstategroup.candidate.question2;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class to calculate the average value of the nodes in a tree
 */
public class TreeAverageValue {

    /**
     * Please implement this method to
     * return the average of all node values (Node.getValue()) in the tree.

     * @param root the root node of a tree from which to determine the average value
     * @return the average of all node values in the tree
     */
    public double getAverage(Node root) {
        if (root == null) throw new NullPointerException("Node has to be a value!");

        int total = 0;

        List<Node> children = root.getChildren();

        for (Node child : children) {
            total += child.getValue();
        }

        return (double)total / children.size();
    }
}
