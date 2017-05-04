package com.solidstategroup.candidate.question2;

import java.util.ArrayList;
import java.util.List;

public class TreeNode implements Node {

    private final List<Node> children = new ArrayList<Node>();
    private final int value;

    public TreeNode(final int value) {
        this.value = value;
    }

    @Override
    public void addNode(final Node node) {
        children.add(node);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public List<Node> getChildren() {
        List<Node> newList = new ArrayList<Node>();
        if (children.isEmpty()) {
            newList.add(this);
            return newList;
        }
        for (Node node : children) {
            newList.addAll(node.getChildren());
        }
        newList.add(this);
        return newList;
    }

}