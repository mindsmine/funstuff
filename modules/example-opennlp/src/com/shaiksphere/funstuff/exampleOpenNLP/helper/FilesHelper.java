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

import com.shaiksphere.funstuff.exampleOpenNLP.holder.FileDetailsHolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

/**
 * A collection of useful static methods to deal with files.
 *
 * @since 1.0.0
 *
 */
public final class FilesHelper {
    private FilesHelper() {}

    /**
     * Retrieves the content of the passed in file.
     *
     * @param file From which to retrieve the content
     *
     * @return Content of the passed in file
     *
     * @throws IOException When an error occurs
     *
     * @since 1.0.0
     *
     */
    public static String readFileContent(File file) throws IOException {
        if (file == null || !file.isFile()) {
            throw new IllegalArgumentException("Only non-empty file is allowed.");
        }

        return new String(Files.readAllBytes(file.toPath()));
    }

    /**
     * Writes the content to the specified file.
     *
     * @param fileDetailsHolder Object containing file details
     * @param contentLines Contest to be written into the file
     *
     * @return Path of the file that was created
     *
     * @throws IOException When an error occurs
     *
     * @since 1.0.0
     *
     */
    public static String writeFileContent(FileDetailsHolder fileDetailsHolder, ArrayList<String> contentLines) throws IOException {
        if (fileDetailsHolder == null || contentLines == null || contentLines.isEmpty()) {
            throw new IllegalArgumentException("Only non-empty object(s) are allowed as arguments.");
        }

        final String filename = fileDetailsHolder.getFileName();

        Path outputFilepath = Paths.get(fileDetailsHolder.toString());

        int i = 1;
        while (outputFilepath.toFile().exists()) {
            // If file already exists, create a new one by appending a number
            fileDetailsHolder.setFileName(filename + (i++));

            outputFilepath = Paths.get(fileDetailsHolder.toString());
        }

        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = Files.newBufferedWriter(
                    outputFilepath,
                    Charset.forName("UTF-8")
            );

            for (String contentLine : contentLines) {
                bufferedWriter.write(contentLine);
                bufferedWriter.newLine();
            }
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    // do nothing at this stage
                }
            }
        }

        return outputFilepath.toFile().getCanonicalPath();
    }
}
