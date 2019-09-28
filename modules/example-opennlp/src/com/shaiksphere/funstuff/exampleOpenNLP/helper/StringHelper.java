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

/**
 * A collection of useful static methods to deal with strings.
 *
 * NOTE: This file is inspired from my own open source project - https://github.com/mindsmine/mindsmine-jems
 * ====
 *
 * @see java.lang.String
 *
 * @since 1.0.0
 *
 */
public final class StringHelper {
    private StringHelper() {}

    /**
     * Retrieves the words from the provided sentence.
     * <br><br>
     * A word is a string within the sentence if it is bounded by a beginning/whitespace/end character on both sides.
     * <br><br>
     * Strings enclosed within quotes are normalised, i.e., 'hello' -> hello, "world" -> world, "hi' -> hi
     * <br><br>
     * Strings with an apostrophe (') or dot (.) as part of itself are left intact, e.g., isn't, i.e.
     *
     * @param sentence To be extracted from
     *
     * @return An array of words
     *
     * @since 1.0.0
     *
     */
    public static String[] getWords(String sentence) {
        if (isBlank(sentence)) {
            throw new IllegalArgumentException("Only non-empty string(s) are allowed as arguments.");
        }

        return sentence
                .replaceAll("(\\B['\"]\\b)|(\\b['\"]\\B)", "")
                .toLowerCase()
                .split("[\\s[\\p{P}&&[^'.]]]+");
    }

    /**
     * Returns <code>true</code> if the passed value is an empty string, false otherwise.
     * <br><br>
     * The value is deemed to be an empty string if it is either:
     * <ul>
     *     <li><code>null</code></li>
     *     <li>a zero-length string</li>
     *     <li>comprised of whitespaces as defined by {@link java.lang.Character#isWhitespace(char)}</li>
     * </ul>
     * <br>
     * Example usage:
     *
     * <pre>
     *     StringHelper.isBlank(null)          = true
     *     StringHelper.isBlank("")            = true
     *     StringHelper.isBlank(" ")           = true
     *     StringHelper.isBlank("something ")  = false
     * </pre>
     *
     * @param string The value to test.
     *
     * @return <code>true</code> if the passed value is an empty string, false otherwise.
     *
     * @since 1.0.0
     *
     */
    public static boolean isBlank(String string) {
        if (string == null || string.isEmpty()) {
            return true;
        }

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isWhitespace(string.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
