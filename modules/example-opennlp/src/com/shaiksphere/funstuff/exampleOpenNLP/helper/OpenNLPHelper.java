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

import com.shaiksphere.mindsmine.jems.StringHelper;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

/**
 * A collection of useful static methods to deal with the Apache OpenNLP library.
 *
 * @since 1.0.0
 *
 */
public final class OpenNLPHelper {
    private OpenNLPHelper() {}

    /**
     * Retrieves the sentences from the provided paragraph, using the language it is trained on.
     *
     * @param binaryFile Training file for the NLP machine
     * @param paragraph From which sentences are to be retrieved
     *
     * @return An array of sentences
     *
     * @throws IOException When an error occurs
     *
     * @since 1.0.0
     *
     */
    public static String[] getSentences(File binaryFile, String paragraph) throws IOException {
        if (binaryFile == null || !binaryFile.isFile() || !binaryFile.getName().endsWith("sent.bin")) {
            throw new IllegalArgumentException("Only non-empty <lang>-sent.bin file is allowed.");
        }

        if (StringHelper.isBlank(paragraph)) {
            throw new IllegalArgumentException("Only non-empty string(s) are allowed as arguments.");
        }

        ArrayList<String> sentences = new ArrayList<>();

        SentenceDetectorME sentenceDetectorME = new SentenceDetectorME(new SentenceModel(binaryFile));

        for (String sentence : sentenceDetectorME.sentDetect(paragraph)) {
            // Remove the sentence end punctuation mark to help in easier word extraction later
            //
            sentences.add(sentence.replaceAll("\\p{P}$", ""));
        }

        return sentences.toArray(new String[sentences.size()]);
    }
}
