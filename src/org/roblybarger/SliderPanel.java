package org.roblybarger;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderPanel extends JPanel {

	protected JSlider slider;

	public SliderPanel() {
		slider = new JSlider(0,100);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider src = (JSlider)e.getSource();
				// show as a tip...
				if (src.getValueIsAdjusting()) {
					return;
				}
				Integer newValue = new Integer(src.getValue());
				Notifier.getInstance().firePropertyChange(src,"sliderAdjusted",newValue);
			}
		});
		add(slider);
	}
}
