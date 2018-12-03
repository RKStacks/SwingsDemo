package org.roblybarger;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

public class Main extends JFrame {

	public static void main(String[] args) {
		JFrame f = new Main();
		f.setVisible(true);
		// warn if applying threadlocal to the notificationcontroller
		// that "new Main()" does not run in the event dispatch thread
		// where the rest of the event processing takes place, so
		// notifications go no-where
	}

	protected SliderPanel sliderPanel;
	protected TextPanel textPanel;
	protected ColorPanel colorPanel;
	
	public Main() {
		super("Notification Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sliderPanel = new SliderPanel();
		textPanel = new TextPanel();
		colorPanel = new ColorPanel();
		Container cp = getContentPane();
		
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		cp.setLayout(gbl);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets = new Insets(5,5,0,5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx=1.0;

		gbl.setConstraints(sliderPanel, gbc);
		cp.add(sliderPanel);
		
		gbc.gridy++;
		
		gbl.setConstraints(textPanel, gbc);
		cp.add(textPanel);
		
		gbc.gridy++;
		gbc.insets = new Insets(5,5,15,5);

		gbl.setConstraints(colorPanel, gbc);
		cp.add(colorPanel);
		pack();
		
	}
}
