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

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * An object to hold the concordance information.
 *
 * @since 1.0.0
 *
 */
public final class ConcordanceHolder {
    private TreeMap<String, String> concordanceMap;

    /**
     * Runs the concordance logic and extracts the necessary information.
     *
     * @param sentences To be applied the concordance logic
     *
     * @since 1.0.0
     *
     */
    public ConcordanceHolder(String [] sentences) {
        if (sentences == null || sentences.length == 0) {
            throw new IllegalArgumentException("Only non-empty array(s) are allowed as arguments.");
        }

        TreeMap<String, ArrayList<Integer>> frequencyMap = new TreeMap<>();

        for (int i = 0; i < sentences.length; i++) {
            String [] words = sentences[i]
                    .replaceAll("(\\B['\"]\\b)|(\\b['\"]\\B)", "")
                    .toLowerCase()
                    .split("[\\s[\\p{P}&&[^'.]]]+");

            for (String word : words) {
                ArrayList<Integer> lineNumberList = frequencyMap.get(word);

                if (lineNumberList == null) {
                    lineNumberList = new ArrayList<>();
                }

                lineNumberList.add(i + 1);

                frequencyMap.put(word, lineNumberList);
            }
        }

        if (frequencyMap.isEmpty()) {
            throw new RuntimeException("FATAL ERROR: Inconsistent state. No word frequencies!");
        }

        concordanceMap = new TreeMap<>();

        frequencyMap.forEach((key, value) -> {
            String frequencyString = String.format(
                    "{%d:%s}",
                    value.size(),
                    value.toString().replaceAll("(\\B\\[\\b)|(\\b]\\B)|(\\s+)", "")
            );

            concordanceMap.put(key, frequencyString);
        });
    }

    public TreeMap<String, String> getConcordanceMap() {
        return concordanceMap;
    }

    public ArrayList<String> toStringArrayList() {
        ArrayList<String> stringArrayList = new ArrayList<>();

        concordanceMap.forEach((key, value) -> {
            stringArrayList.add(String.format("%-25s%s", key, value));
        });

        return stringArrayList;
    }
}
