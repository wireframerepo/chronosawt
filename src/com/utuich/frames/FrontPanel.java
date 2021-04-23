package com.utuich.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.utuich.main.Chronos;

public class FrontPanel extends JPanel implements ActionListener, MouseListener{

	/**
	 * frontpanel, the body of the chronometer
	 */
	private static final long serialVersionUID = 1L;
	private static JLabel chronoFace = new JLabel();
	private JButton starterButton = new JButton("Start");
	private JButton stopButton = new JButton("Stop");
	public static Chronos chrono = new Chronos(false);
	
	public FrontPanel() {
		this.setBackground(new Color(0,0,0));
		this.setSize(400, 200);
		this.setLayout(null);
		
		chronoFace.setForeground(new Color(0,255,0));
		chronoFace.setText("00:00:00");
		chronoFace.setOpaque(true);
		chronoFace.setFont(new Font("Courier",Font.BOLD,80));
		chronoFace.setBackground(new Color(0,0,0));
		chronoFace.setBounds(7, 60, 400, 60);
		
		starterButton.setBounds(80, 140, 100, 40);
		starterButton.setOpaque(true);
		starterButton.setBackground(new Color(0,0,0));
		starterButton.setForeground(new Color(0,255,0));
		starterButton.setActionCommand("_STARTER_");
		
		stopButton.setBounds(220, 140, 100, 40);
		stopButton.setOpaque(true);
		stopButton.setBackground(new Color(0,0,0));
		stopButton.setForeground(new Color(0,255,0));
		stopButton.setActionCommand("_STOPPER_");
		
		starterButton.addActionListener(this);
		stopButton.addActionListener(this);
		chronoFace.addMouseListener(this);
		this.add(starterButton);
		this.add(stopButton);
		
		
		this.add(chronoFace);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("make the changing form for this times");
		System.out.println(e.getComponent());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//when pressed and not released
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
