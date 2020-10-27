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

package com.shaiksphere.funstuff.browser.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextField;

import com.shaiksphere.mindsmine.jems.SwingHelper;

import com.shaiksphere.funstuff.browser.helper.HeaderHelper;

public class TextFieldActionListener implements ActionListener{
	private JEditorPane headerPane, bodyPane;
	private JTextField textField;
	private JButton button;
	private Stack<String> history;
	
	/**
	 * ActionListener for the Text Field Pointer
	 * @param headerPane Header Part Panel
	 * @param bodyPane Body Part Panel
	 * @param textField Text Field Pointer
	 * @param button Back Button Reference
	 * @param history Stack for the History
	 */
	public TextFieldActionListener(
        JEditorPane headerPane,
        JEditorPane bodyPane,
        JTextField textField,
        JButton button,
        Stack<String> history
    ) {
        this.headerPane = headerPane;
		this.bodyPane = bodyPane;
		this.textField = textField;
		this.button = button;
		this.history = history;
	}

	public void actionPerformed(ActionEvent actionEvent) {
        try {
            String prevURL = this.bodyPane.getPage().toString();
            String nextURL = actionEvent.getActionCommand();

            this.history.push(prevURL);
            this.button.setEnabled(true);
            this.headerPane.setText(HeaderHelper.getHeader(nextURL));
            this.bodyPane.setPage(nextURL);
            this.textField.setText(nextURL);
        } catch (IOException e) {
            SwingHelper.showErrorDialog("IOException", e.getMessage());
        }
	}
}
