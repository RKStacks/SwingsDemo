package org.roblybarger;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ColorPanel extends JPanel {
	
	public ColorPanel() {
		Dimension dim = new Dimension(100,20);
		setPreferredSize(dim);
		setBackground(new Color(0.5f, 0.5f, 0.5f));
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		Notifier.getInstance().addPropertyChangeListener(
				"sliderAdjusted", new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent e) {
						JSlider slider = (JSlider)(e.getSource());
						float frac = slider.getValue() /
							(float)(slider.getMaximum() - slider.getMinimum());
						setBackground(new Color(frac, frac, frac));
					}
				});

	}
}
