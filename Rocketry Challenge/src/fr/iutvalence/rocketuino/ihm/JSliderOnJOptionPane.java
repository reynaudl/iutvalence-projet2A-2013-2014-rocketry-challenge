package fr.iutvalence.rocketuino.ihm;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderOnJOptionPane
{
	private JOptionPane optionPane;
	private JFrame fenetre;

	public JSliderOnJOptionPane(JFrame fenetre)
	{
		this.fenetre = fenetre;
		this.optionPane = new JOptionPane();
		
		JSlider slider = this.getSlider(this.optionPane);
		
		this.optionPane.setMessage(new Object[] {"Temps d'affichage des mesures (en secondes) : ", slider});
		this.optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
		this.optionPane.setOptionType(JOptionPane.OK_OPTION);
		this.optionPane.setOptions(new Object[] {"Valider"});
	}

	private JSlider getSlider(final JOptionPane optionPane)
	{
		JSlider slider = new JSlider(10, 60);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		ChangeListener changeListener = new ChangeListener()
		{
			public void stateChanged(ChangeEvent changeEvent)
			{
				JSlider theSlider = (JSlider) changeEvent.getSource();
				if (!theSlider.getValueIsAdjusting())
				{
					optionPane.setInputValue(new Integer(theSlider.getValue()));
				}
			}
		};
		slider.addChangeListener(changeListener);
		return slider;
	}

	public int afficher()
	{
		JDialog dialog = this.optionPane.createDialog(this.fenetre, "Temps d'affichage des mesures");
		dialog.setVisible(true);
		if (this.optionPane.getInputValue().toString() != "uninitializedValue")
			return Integer.parseInt(this.optionPane.getInputValue().toString());
		return 35;
	}
}