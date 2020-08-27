package application;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import audio.Microphone;
import display.SentencesAnimator;
import fan.WindWave;

@SuppressWarnings("serial")
public class UserInterface extends JFrame {

	private SentencesAnimator sentencesAnimator; 
	private WindWave windWave;
	private Microphone microphone;
	
	private JLabel microphoneLevelLBL, microphoneStatutLBL, breathForceLBL, chaosIntensityLBL;
	
	/**
	 * 
	 */
	public UserInterface() {
		
		super();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4,2));
		
		microphoneStatutLBL = addJLabel("Record from: ");
		microphoneLevelLBL = addJLabel("Input level (dB): ");
		breathForceLBL = addJLabel("Breath force: ");
		chaosIntensityLBL = addJLabel("Chaos intensity: ");
		//addJSpinner("x", null);
		
		//addJToggleButton("windwave", e -> System.out.println(((JToggleButton)e.getSource()).isSelected()));
		//addJButton("new sentence", "load", e -> System.out.println("push"));
		
		this.pack();
		//this.setSize(800,400);
		this.setVisible(true);
		
	}
	
	public void setWindWave(WindWave windWave) {
		this.windWave = windWave;
	}

	public void setMicrophone(Microphone microphone) {
		this.microphone = microphone;
	}

	public void setSentencesAnimator(SentencesAnimator sentencesAnimator) {
		this.sentencesAnimator = sentencesAnimator;
	}

	private JLabel addJLabel(String lbl) {
		
		JLabel l1 = new JLabel(lbl);
		l1.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel l2 = new JLabel("                                                                   ");
		add(l1);
		add(l2);
		return l2;
	}
	
	private JSpinner addJSpinner(String lbl, ChangeListener listener) {
		
		JSpinner s = new JSpinner();
		JLabel l = new JLabel(lbl);
		l.setHorizontalAlignment(SwingConstants.RIGHT);
		//Box b = new Box(BoxLayout.X_AXIS);
		add(l);
		add(s);
		//this.getContentPane().add(b);
		//s.addChangeListener(e -> System.out.println(lbl+"="+s.getValue()));
		if (listener != null) s.addChangeListener(listener);
		return s;
	}
	
	private JButton addJButton(String lbl, String buttonLbl, ActionListener listener) {
		
		JLabel l = new JLabel(lbl);
		l.setHorizontalAlignment(SwingConstants.RIGHT);
		JButton b = new JButton(buttonLbl);
		add(l);
		add(b);
		b.addActionListener(listener);
		return b;
	}
	
	private JToggleButton addJToggleButton(String lbl, ActionListener listener) {
		
		JLabel l = new JLabel(lbl);
		l.setHorizontalAlignment(SwingConstants.RIGHT);
		JToggleButton b = new JToggleButton("on/off");
		add(l);
		add(b);
		b.addActionListener(listener);
		return b;
	}
	
	// --------------
	
	public void setMicrophoneStatut(String s) {
		SwingUtilities.invokeLater(() ->  microphoneStatutLBL.setText(s));
	}

	public void setMicrophoneLevel(double lvl) {
		SwingUtilities.invokeLater(() ->  microphoneLevelLBL.setText(Double.toString(lvl)));
	}

	public void setBreathForce(double lvl) {
		SwingUtilities.invokeLater(() ->  breathForceLBL.setText(Double.toString(lvl)));
	}

	public void setChaosIntensity(double lvl) {
		SwingUtilities.invokeLater(() ->  chaosIntensityLBL.setText(Double.toString(lvl)));
	}

	// --------------
	
	public static void main(String[] args) throws Exception {
		new UserInterface();
	}
}
