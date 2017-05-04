package com.solidstategroup.candidate.question2;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by andrzejfolga on 04/05/2017.
 */
public class TreeAverageValueTest {

    private TreeAverageValue treeAverageValue = new TreeAverageValue();

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionIfNoValue() throws Exception {
        treeAverageValue.getAverage(null);
    }

    @Test
    public void shouldReturnAverageForOneNodeTree() throws Exception {

        Node root = new TreeNode(4);

        double average = treeAverageValue.getAverage(root);

        assertThat(average, equalTo(4d));
    }

    @Test
    public void shouldReturnAverageForComplexTree() throws Exception {

        Node leaf3 = new TreeNode(3);
        Node leaf2 = new TreeNode(2);
        Node leaf1 = new TreeNode(3);
        Node midNode = new TreeNode(4);
        midNode.addNode(leaf3);
        midNode.addNode(leaf2);
        midNode.addNode(leaf1);
        Node root = new TreeNode(4);
        root.addNode(midNode);
        root.addNode(new TreeNode(5));

        double average = treeAverageValue.getAverage(root);

        assertThat(average, equalTo(3.5d));
    }
    
}
