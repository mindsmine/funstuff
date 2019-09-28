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

package com.shaiksphere.funstuff.exampleOpenNLP.helper;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringHelperTest {

    @Test
    public void getWordsTest() {
        final String sentence = "Bonus: label each word with the sentence numbers in which each occurrence appeared";
        final String [] words = {
                "bonus", "label", "each", "word", "with", "the", "sentence", "numbers", "in", "which", "each", "occurrence", "appeared"
        };

        assertArrayEquals(StringHelper.getWords(sentence), words);
    }

    @Test
    public void isBlankTest() {
        assertTrue(StringHelper.isBlank(null));
        assertTrue(StringHelper.isBlank(""));
        assertTrue(StringHelper.isBlank(" "));

        assertFalse(StringHelper.isBlank("something"));
    }
}
