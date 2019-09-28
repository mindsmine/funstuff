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

package com.shaiksphere.funstuff.treeTraversal.holder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NodeTest {
    private Node node = new Node(1, null, null);

    @Test
    public void toStringTest() {
        assertEquals(node.toString(), " 1");
    }

    @Test
    public void getDataTest() {
        assertEquals(node.getData(), 1);
    }

    @Test
    public void getLeftChildTest() {
        assertNull(node.getLeftChild());
    }

    @Test
    public void getRightChildTest() {
        assertNull(node.getRightChild());
    }
}
