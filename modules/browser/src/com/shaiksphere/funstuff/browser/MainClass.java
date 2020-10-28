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

package com.shaiksphere.funstuff.browser;

import java.awt.Dimension;

import java.io.IOException;

import java.util.Stack;
import java.util.prefs.Preferences;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.shaiksphere.funstuff.browser.listener.BackButtonActionListener;
import com.shaiksphere.funstuff.browser.listener.BrowserWindowListener;
import com.shaiksphere.funstuff.browser.listener.TextFieldActionListener;
import com.shaiksphere.funstuff.browser.listener.WebLinkListener;

import com.shaiksphere.funstuff.browser.helper.HeaderHelper;

import com.shaiksphere.mindsmine.jems.SwingHelper;

public class MainClass {
	private Preferences preferences = Preferences.userNodeForPackage(MainClass.class);
	
	public static void main(String args[]){
		new MainClass();
	}
	
	public MainClass() {
		String pageURL = preferences.get("pageURL", "https://www.shaiksphere.com");
		int frameWidth = preferences.getInt("frameWidth", 640);
		int frameHeight = preferences.getInt("frameHeight", 560);
		int frameX = preferences.getInt("frameX", 20);
		int frameY = preferences.getInt("frameY", 20);
		
		JFrame frame;
		JEditorPane headerPane, bodyPane;
		JScrollPane headerScrollPane, bodyScrollPane;
		JTextField textField;
		JLabel label;
		JButton button;
		JPanel panel,addressPanel;
		
		Stack<String> history = new Stack<String>();
		history.push(pageURL);
		
		headerPane = new JEditorPane();
		bodyPane = new JEditorPane();

		headerPane.setEditable(false);
		bodyPane.setEditable(false);
		
		try {
			headerPane.setText(HeaderHelper.getHeader(pageURL));
			bodyPane.setPage(pageURL);
		} catch (IOException e) {
			SwingHelper.showErrorDialog("IOException", e.getMessage());
		}
		
		headerScrollPane = new JScrollPane(headerPane);
		headerScrollPane.setMaximumSize(new Dimension(1800,100));
		bodyScrollPane = new JScrollPane(bodyPane);
		
		frame = new JFrame("Web Browser by Mohammed Shaik Hussain Ali");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		label = new JLabel("URL: ");
		textField = new JTextField(pageURL);
		textField.setMaximumSize(new Dimension(1800,50));

		button = new JButton("Back");
        button.setEnabled(false);
        button.addActionListener(new BackButtonActionListener(headerPane, bodyPane, textField, button, history));
		textField.addActionListener(new TextFieldActionListener(headerPane, bodyPane, textField, button, history));
		
		addressPanel = new JPanel();
		addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.LINE_AXIS));
		
		addressPanel.add(label);
		addressPanel.add(textField);
		addressPanel.add(button);
		
		bodyPane.addHyperlinkListener(new WebLinkListener(headerPane, bodyPane, textField, button, history));
		
		panel = (JPanel)frame.getContentPane();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setPreferredSize(new Dimension(400,100));
		panel.add(addressPanel);
		panel.add(headerScrollPane);
		panel.add(bodyScrollPane);
		
		frame.pack();
		frame.addWindowListener(new BrowserWindowListener(frame, textField, preferences));;
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(frameX, frameY);
		frame.setVisible(true);
	}
}
