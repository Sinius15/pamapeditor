package com.sinius15.pamapeditor.gui;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class FrameWait extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel dotLabel;
	private JTextPane txtpnIAmVerry;
	private JLabel statusLabel;
	
	public FrameWait() {
		setSize(382, 108);
		setResizable(false);
		setTitle("Wait...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		txtpnIAmVerry = new JTextPane();
		txtpnIAmVerry.setEditable(false);
		txtpnIAmVerry.setText("I am verry buisy now.\r\nI am going as fast as possible, but it is work to visualise a prison.\r\nIf you want me to stop working, press the red cross on the top of this screen.\r\nAt this moment i am working on the:");
		txtpnIAmVerry.setBounds(0, 0, 380, 62);
		getContentPane().add(txtpnIAmVerry);
		
		statusLabel = new JLabel("");
		statusLabel.setBounds(0, 61, 265, 20);
		getContentPane().add(statusLabel);
		
		dotLabel = new JLabel("...");
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(dotLabel.getText().equals("....."))
					dotLabel.setText(".");
				else
					dotLabel.setText(dotLabel.getText() + ".");
				
			}
		}, 0, 500);
		dotLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dotLabel.setBounds(330, 64, 36, 14);
		getContentPane().add(dotLabel);
		setVisible(true);
	}
	
	public JLabel getDotLabel() {
		return dotLabel;
	}
	public JTextPane getTxtpnIAmVerry() {
		return txtpnIAmVerry;
	}
	public JLabel getStatusLabel() {
		return statusLabel;
	}
	
	public void setStatus(String s){
		this.statusLabel.setText(" " +s);
	}
}
