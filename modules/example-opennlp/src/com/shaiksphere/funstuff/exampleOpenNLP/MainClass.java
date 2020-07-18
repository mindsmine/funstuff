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

package com.shaiksphere.funstuff.exampleOpenNLP;

import com.shaiksphere.funstuff.exampleOpenNLP.helper.OpenNLPHelper;
import com.shaiksphere.funstuff.exampleOpenNLP.holder.ConcordanceHolder;
import com.shaiksphere.funstuff.exampleOpenNLP.holder.FileDetailsHolder;

import com.shaiksphere.mindsmine.jems.StringHelper;
import com.shaiksphere.mindsmine.jems.SwingHelper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Main class that handles the Concordance related tasks
 *
 * @since 1.0.0
 *
 */
public final class MainClass {
    private static final String exitScreenTitle = "Thank You!";
    private static final String exitScreenMessage = "Everything seems to have run smoothly.";

    public static void main(String [] args) {
        switch (args.length) {
            case 0 -> {
                swingImplementation();
            }
            case 2 -> {
                cliImplementation(args);
            }
            default -> {
                System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.err.println();
                System.err.println("FAILED Operation");
                System.err.println("----------------");
                System.err.println();
                System.err.println("Failure Type    = IllegalArgumentException");
                System.err.println("Failure Message = Invalid number of arguments");
                System.err.println();
                System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.err.println();
                System.err.println("USAGE: java -jar <JAR FILE> <path/to/<lang>-sent.bin/file> <path/to/input text/file>");
                System.err.println();
                System.exit(-1);
            }
        }
    }

    private static void quitSystem() {
        SwingHelper.showInformationDialog("Exiting the application!", "You chose to quit...");
        System.exit(1);
    }

    /**
     * Handles the GUI invocation of the application. Absorbs the failures accordingly.
     *
     * @since 1.0.0
     *
     */
    private static void swingImplementation() {
        try {
            File binaryFile = null, inputFile = null;

            try {
                binaryFile = SwingHelper.pickFile(
                        "Pick the language specific training file (e.g., en-sent.bin file)",
                        SwingHelper.BIN_EXTENSION_FILTER
                ).get();

                inputFile = SwingHelper.pickFile(
                        "Pick the content file (e.g., .txt file)",
                        SwingHelper.TXT_EXTENSION_FILTER
                ).get();
            } catch (NoSuchElementException e) {
                quitSystem();
            }

            ArrayList<String> outputLines = doActualWork(binaryFile, inputFile);

            if (outputLines.isEmpty()) {
                SwingHelper.showErrorDialog("Fatal Error", "There are no concordance lines.");
                System.exit(-1);
            }

            String outputFolderPath = null;
            try {
                outputFolderPath = SwingHelper.pickFolder("Pick the folder to store the result").get().getCanonicalPath();
            } catch (NoSuchElementException e) {
                quitSystem();
            }

            FileDetailsHolder fileDetailsHolder = new FileDetailsHolder(
                    outputFolderPath,
                    "ConcordanceOutput",
                    SwingHelper.TXT_EXTENSION_FILTER.getExtensions()[0]
            );

            Path outputFilePath = Paths.get(fileDetailsHolder.toString());

            int i = 1;
            while (outputFilePath.toFile().exists()) {
                // If the file already exists, create a new one by appending a number
                fileDetailsHolder.setFileName(fileDetailsHolder.getFileName() + (i++));

                outputFilePath = Paths.get(fileDetailsHolder.toString());
            }

            BufferedWriter bufferedWriter = Files.newBufferedWriter(
                    outputFilePath,
                    StandardCharsets.UTF_8
            );

            for (String outputLine : outputLines) {
                bufferedWriter.write(outputLine);
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
            bufferedWriter.close();

            SwingHelper.showPlainDialog(
                    "Successfully performed the operation",
                    "Output was stored to the file = " + outputFilePath.toFile().getCanonicalPath()
            );

        } catch (Exception e) {
            SwingHelper.showErrorDialog(e.getClass().getSimpleName(), e.getMessage());
            System.exit(-1);
        }
    }

    /**
     * Handles the command-line invocation of the application. Absorbs the failures accordingly.
     *
     * @param args Command-line arguments
     *
     * @since 1.0.0
     *
     */
    private static void cliImplementation(String [] args) {
        try {
            String binaryFilepath = args[0];
            String inputFilepath = args[1];

            File binaryFile = new File(binaryFilepath);
            File inputFile = new File(inputFilepath);

            if (!binaryFile.isFile() || !binaryFile.getName().endsWith("sent.bin")) {
                throw new IllegalArgumentException("Only non-empty <lang>-sent.bin file is allowed.");
            }

            if (!inputFile.isFile() || !inputFile.getName().endsWith(".txt")) {
                throw new IllegalArgumentException("Second argument must be a text (.txt) file.");
            }

            ArrayList<String> outputLines = doActualWork(binaryFile, inputFile);

            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println("Concordance Output:");
            System.out.println("------------------");
            System.out.println();
            outputLines.forEach(System.out::println);
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(exitScreenTitle);
            System.out.println();
            System.out.println(exitScreenMessage);
            System.out.println();
        } catch (Exception e) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.err.println();
            System.err.println("FAILED Operation");
            System.err.println("----------------");
            System.err.println();
            System.err.println("Failure Type    = " + e.getClass().getSimpleName());
            System.err.println("Failure Message = " + e.getMessage());
            System.exit(-1);
        }
    }

    /**
     * Extracts the sentences, then the words and finally runs the concordance operation.
     *
     * @param binaryFile Training file for the NLP machine
     * @param inputFile File with the content to be used for concordance
     *
     * @return Array of properly formatted concordance information
     *
     * @throws IOException When an error occurs
     *
     * @since 1.0.0
     *
     */
    private static ArrayList<String> doActualWork(File binaryFile, File inputFile) throws IOException {
        String inputFileContent = Files.readString(inputFile.toPath());

        if (StringHelper.isBlank(inputFileContent)) {
            throw new IOException("INVALID FILE: Input file is empty!");
        }

        ConcordanceHolder concordanceHolder = new ConcordanceHolder(OpenNLPHelper.getSentences(
                binaryFile,
                inputFileContent
        ));

        return concordanceHolder.toStringArrayList();
    }
}
