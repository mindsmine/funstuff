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

import java.io.File;

import static org.junit.Assert.assertEquals;

public final class FileDetailsHolderTest {
    private FileDetailsHolder fileDetailsHolder = new FileDetailsHolder(
            "local_folder",
            "local_file",
            "blah");

    @Test
    public void toStringTest() {
        final String toString = "local_folder" + File.separator + "local_file.blah";

        assertEquals(fileDetailsHolder.toString(), toString);
    }

    @Test
    public void setFilenameTest() {
        final String newFilename = fileDetailsHolder.getFileName() + "_NEW";
        final String toString = "local_folder" + File.separator + "local_file_NEW.blah";

        fileDetailsHolder.setFileName(newFilename);

        assertEquals(fileDetailsHolder.toString(), toString);
    }
}
