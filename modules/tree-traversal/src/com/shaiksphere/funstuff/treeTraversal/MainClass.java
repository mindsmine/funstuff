/*
Copyright 2008-present Shaiksphere, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.shaiksphere.funstuff.treeTraversal;

import com.shaiksphere.funstuff.treeTraversal.holder.Node;

import java.util.*;

public final class MainClass {
    protected static final Node rootNode = new Node(
            1,
            new Node(
                    2,
                    new Node(
                            4,
                            new Node(
                                    8,
                                    null,
                                    null
                            ),
                            new Node(
                                    9,
                                    null,
                                    null
                            )
                    ),
                    new Node(
                            5,
                            new Node(
                                    10,
                                    null,
                                    null
                            ),
                            new Node(
                                    11,
                                    null,
                                    null
                            )
                    )
            ),
            new Node(
                    3,
                    new Node(
                            6,
                            null,
                            null
                    ),
                    new Node(
                            7,
                            new Node(
                                    12,
                                    null,
                                    null
                            ),
                            new Node(
                                    13,
                                    null,
                                    null
                            )
                    )
            )
    );

    protected static ArrayList<Node> breadthFirstSearch(Node node) {
        final HashSet<Node> visited = new HashSet<>();
        final ArrayList<Node> solution = new ArrayList<>();
        final Queue<Node> queue = new LinkedList<>();

        visited.add(node);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            solution.add(currentNode);

            if (currentNode.getLeftChild() != null && !visited.contains(currentNode.getLeftChild())) {
                visited.add(currentNode.getLeftChild());
                queue.add(currentNode.getLeftChild());
            }

            if (currentNode.getRightChild() != null && !visited.contains(currentNode.getRightChild())) {
                visited.add(currentNode.getRightChild());
                queue.add(currentNode.getRightChild());
            }
        }

        return solution;
    }

    protected static ArrayList<Node> depthFirstSearch(Node node) {
        final HashSet<Node> visited = new HashSet<>();
        final ArrayList<Node> solution = new ArrayList<>();
        final Stack<Node> stack = new Stack<>();

        visited.add(node);
        stack.push(node);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            solution.add(currentNode);

            if (currentNode.getRightChild() != null && !visited.contains(currentNode.getRightChild())) {
                visited.add(currentNode.getRightChild());
                stack.push(currentNode.getRightChild());
            }

            if (currentNode.getLeftChild() != null && !visited.contains(currentNode.getLeftChild())) {
                visited.add(currentNode.getLeftChild());
                stack.push(currentNode.getLeftChild());
            }
        }

        return solution;
    }

    public static void main(String args[]) {
        System.out.println();
        System.out.println("Performing Breadth First Search Traversal");
        System.out.println(breadthFirstSearch(rootNode));

        System.out.println();
        System.out.println("Performing Depth First Search Traversal");
        System.out.println(depthFirstSearch(rootNode));
    }
}
