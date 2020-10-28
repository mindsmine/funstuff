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

package com.shaiksphere.funstuff.browser.helper;

import java.io.IOException;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class HeaderHelper {

    /**
     * Retrieves the header fields and their values.
     * 
     * @param urlPage The webpage whose headers are to be extracted.
     * 
     * @return String containing all the headers of the webpage.
     * 
     * @throws IOException
     * 
     */
    public static String getHeader(String urlPage) throws IOException {
        int i = 1;
        URL url = new URL(urlPage);
        URLConnection urlConnection = url.openConnection();
        ArrayList<String> headerList = new ArrayList<>();

        headerList.add(urlConnection.getHeaderField(0));
        
        do {
            headerList.add(String.format("%s: %s", urlConnection.getHeaderFieldKey(i), urlConnection.getHeaderField(i)));
            i++;
        } while(urlConnection.getHeaderField(i) != null);

        String header = String.join("\n", headerList);

		return header;
    }
}
