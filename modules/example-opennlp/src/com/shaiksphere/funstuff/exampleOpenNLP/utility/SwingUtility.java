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

package com.shaiksphere.funstuff.exampleOpenNLP.utility;

import com.shaiksphere.funstuff.exampleOpenNLP.helper.StringHelper;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.IOException;

/**
 * A collection of useful static methods to deal with Java Swing library.
 *
 * @see javax.swing
 *
 * @since 1.0.0
 *
 */
public final class SwingUtility {
    private SwingUtility() {}

    /**
     * Convenience file filter for binary files.
     *
     * @since 1.0.0
     *
     */
    public static final FileNameExtensionFilter BIN_EXTENSION_FILTER = new FileNameExtensionFilter(
            "Binary Files",
            "bin"
    );

    /**
     * Convenience file filter for text files.
     *
     * @since 1.0.0
     *
     */
    public static final FileNameExtensionFilter TXT_EXTENSION_FILTER = new FileNameExtensionFilter(
            "Text Files",
            "txt"
    );

    /**
     * Allows the user to pick a file using the file picker Swing UI.
     *
     * @param dialogTitle To be displayed in the file picker window
     * @param fileNameExtensionFilter To limit the types of acceptable files
     *
     * @return Selected file
     *
     * @throws IOException When an error occurs
     *
     * @since 1.0.0
     *
     */
    public static File getFile(String dialogTitle, FileNameExtensionFilter fileNameExtensionFilter) throws IOException {

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setMultiSelectionEnabled(false);
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.setAcceptAllFileFilterUsed(false);

        if (!StringHelper.isBlank(dialogTitle)) {
            jFileChooser.setDialogTitle(dialogTitle);
        }

        if (fileNameExtensionFilter != null) {
            jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);
        }

        int option = jFileChooser.showOpenDialog(null);

        if (option == JFileChooser.CANCEL_OPTION) {
            showExitDialog();
            System.exit(1);
        }

        if (fileNameExtensionFilter != null) {
            if (!fileNameExtensionFilter.accept(jFileChooser.getSelectedFile())) {
                String errorMessage = "Only " + fileNameExtensionFilter.getDescription() + " are allowed.";
                showErrorDialog("Illegal file selected!", errorMessage);
                return getFile(dialogTitle, fileNameExtensionFilter);
            }
        }

        return jFileChooser.getSelectedFile();
    }

    /**
     * Allows the user to pick a folder using the file picker Swing UI.
     *
     * @param dialogTitle To be displayed in the file picker window
     *
     * @return Selected folder path
     *
     * @throws IOException When an error occurs
     *
     * @since 1.0.0
     *
     */
    public static String getFolderPath(String dialogTitle) throws IOException {

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setMultiSelectionEnabled(false);
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.setAcceptAllFileFilterUsed(false);

        if (!StringHelper.isBlank(dialogTitle)) {
            jFileChooser.setDialogTitle(dialogTitle);
        }

        int option = jFileChooser.showOpenDialog(null);

        if (option == JFileChooser.CANCEL_OPTION) {
            showExitDialog();
            System.exit(1);
        }

        return jFileChooser.getSelectedFile().getCanonicalPath();
    }

    /**
     * Convenience method for displaying error messages.
     *
     * @param title For the window
     * @param message For the window
     *
     * @since 1.0.0
     *
     */
    public static void showErrorDialog(String title, String message) {
        showMessageDialog(title, message, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Convenience method for displaying plain messages.
     *
     * @param title For the window
     * @param message For the window
     *
     * @since 1.0.0
     *
     */
    public static void showPlainDialog(String title, String message) {
        showMessageDialog(title, message, JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Convenience method for displaying information messages.
     *
     * @param title For the window
     * @param message For the window
     *
     * @since 1.0.0
     *
     */
    public static void showInformationDialog(String title, String message) {
        showMessageDialog(title, message, JOptionPane.INFORMATION_MESSAGE);
    }

    private static void showMessageDialog(String title, String message, int dialogType) {
        JOptionPane.showMessageDialog(null, message, title, dialogType);
    }

    private static void showExitDialog() {
        showInformationDialog("Exiting the application!", "You chose to quit...");
    }
}
