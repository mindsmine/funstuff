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

package com.shaiksphere.funstuff.exampleOpenNLP.holder;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public final class ConcordanceHolderTest {

    @Test
    public void holderTest() {
        final String [] sentences = {
                "Bonus: label each word with the sentence numbers in which each occurrence appeared"
        };

        ConcordanceHolder concordanceHolder = new ConcordanceHolder(sentences);

        TreeMap<String, String> treeMap = concordanceHolder.getConcordanceMap();

        assertEquals(treeMap.get("appeared"), "{1:1}");
        assertEquals(treeMap.get("bonus"), "{1:1}");
        assertEquals(treeMap.get("each"), "{2:1,1}");
        /*
        in             {1:1}
        label          {1:1}
        numbers        {1:1}
        occurrence     {1:1}
        sentence       {1:1}
        the            {1:1}
        which          {1:1}
        with           {1:1}
        word           {1:1}
         */
    }
}
