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

import com.shaiksphere.mindsmine.jems.StringHelper;

import java.io.File;

/**
 * An object to hold the file information.
 *
 * @since 1.0.0
 *
 */
public final class FileDetailsHolder {
    private final String fileFolder;
    private String fileName;
    private final String fileExtension;

    public FileDetailsHolder(String fileFolder, String fileName, String fileExtension) {
        if (
                StringHelper.isBlank(fileFolder) ||
                StringHelper.isBlank(fileName) ||
                StringHelper.isBlank(fileExtension)
        ) {
            throw new IllegalArgumentException("Only non-empty string(s) are allowed as arguments.");
        }

        this.fileFolder = fileFolder;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileFolder() {
        return fileFolder;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    @Override
    public String toString() {
        return fileFolder + File.separator + fileName + "." + fileExtension;
    }
}
