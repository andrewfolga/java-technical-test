package com.solidstategroup.candidate.question2;

import java.util.List;

/**
 *  Interface to represent a single node in a tree structure
 */
public interface Node {

    /**
     * @return int value of the node
     */
    int getValue();

    /**
     * Add new node
     */
    void addNode(final Node node);

    /**
     * @return list of children this node has
     */
    List<Node> getChildren();
}
