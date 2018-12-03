package org.roblybarger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPanel extends JPanel {

	protected JTextField textField;

	public TextPanel() {
		textField = new JTextField(20);
		textField.setEditable(false);
		Notifier.getInstance().addPropertyChangeListener(
				"sliderAdjusted", new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent e) {
						textField.setText("Slider Value = " + e.getNewValue());
					}
				});
		add(textField);
	}
}
