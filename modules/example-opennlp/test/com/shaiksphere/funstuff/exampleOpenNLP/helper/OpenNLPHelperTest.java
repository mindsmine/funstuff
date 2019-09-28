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

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OpenNLPHelperTest {

    @Test
    public void getSentencesTest() throws IOException {
        final String paragraph = "Given an arbitrary text document written in English, write a program that will " +
                "generate a concordance, i.e. an alphabetical list of all word occurrences, labeled with word " +
                "frequencies. Bonus: label each word with the sentence numbers in which each occurrence appeared.";

        final String sentence = "Bonus: label each word with the sentence numbers in which each occurrence appeared";

        final String binaryFilepath = OpenNLPHelperTest.class.getResource("en-sent.bin").getPath();

        final File binaryFile = new File(binaryFilepath);

        final String [] sentences = OpenNLPHelper.getSentences(binaryFile, paragraph);

        assertEquals(sentences[1], sentence);
    }
}
