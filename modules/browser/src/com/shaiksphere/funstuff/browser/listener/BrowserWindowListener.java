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

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.util.prefs.Preferences;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class BrowserWindowListener implements WindowListener {
	private JFrame jFrame;
	private JTextField jTextField;
	private Preferences preferences;
	
	public BrowserWindowListener (JFrame jFrame, JTextField jTextField, Preferences preferences) {
		this.jFrame = jFrame;
		this.jTextField = jTextField;
		this.preferences = preferences;
	}
	
	public void windowClosing (WindowEvent windowEvent) {
        this.preferences.put("pageURL", this.jTextField.getText());
        
        this.preferences.putInt("frameWidth", this.jFrame.getWidth());
        this.preferences.putInt("frameHeight", this.jFrame.getHeight());
        this.preferences.putInt("frameX", this.jFrame.getX());
        this.preferences.putInt("frameY", this.jFrame.getY());

        System.out.println(windowEvent);
	}

	public void windowActivated (WindowEvent windowEvent) {
		System.out.println(windowEvent);
	}

	public void windowClosed (WindowEvent windowEvent) {
		System.out.println(windowEvent);
	}

	public void windowDeactivated (WindowEvent windowEvent) {
		System.out.println(windowEvent);
	}

	public void windowDeiconified (WindowEvent windowEvent) {
		System.out.println(windowEvent);
	}

	public void windowIconified (WindowEvent windowEvent) {
		System.out.println(windowEvent);
	}

	public void windowOpened (WindowEvent windowEvent) {
		System.out.println(windowEvent);
	}
}
