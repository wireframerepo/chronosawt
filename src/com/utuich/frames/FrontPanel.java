package com.utuich.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
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
	private static JLabel logoImage = new JLabel();
	private JButton starterButton = new JButton("Start");
	private JButton stopButton = new JButton("Stop");
	private URL url;
	public static Chronos chrono = new Chronos(false);
	
	public FrontPanel() {
		this.setBackground(new Color(0,0,0));
		this.setSize(415, 250);
		this.setLayout(null);
		
		logoImage.setBackground(new Color(255,255,255));
		logoImage.setOpaque(true);
		logoImage.setBounds(150,20,85,40);
		URL url = getClass().getResource("/images/doncotech1.jpg");
		logoImage.setIcon(new ImageIcon(url));
		
		chronoFace.setForeground(new Color(0,255,0));
		chronoFace.setText("00:00:00");
		chronoFace.setOpaque(true);
		chronoFace.setFont(new Font("Courier",Font.BOLD,80));
		chronoFace.setBackground(new Color(0,0,0));
		chronoFace.setBounds(7, 60, 400, 60);
		
		starterButton.setBounds(80, 160, 100, 40);
		starterButton.setOpaque(true);
		starterButton.setBackground(new Color(0,0,0));
		starterButton.setForeground(new Color(0,255,0));
		starterButton.setActionCommand("_STARTER_");
		starterButton.setEnabled(true);
		
		stopButton.setBounds(220, 160, 100, 40);
		stopButton.setOpaque(true);
		stopButton.setBackground(new Color(0,0,0));
		stopButton.setForeground(new Color(0,255,0));
		stopButton.setActionCommand("_STOPPER_");
		stopButton.setEnabled(false);
		
		starterButton.addActionListener(this);
		stopButton.addActionListener(this);
		chronoFace.addMouseListener(this);
		this.add(starterButton);
		this.add(stopButton);
		
		this.add(logoImage);
		this.add(chronoFace);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//for the time being a chronos action will be here for up time
		//System.out.println(e.getActionCommand());
		
		final String command = e.getActionCommand();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// ALL HAIL KING MARMOTH!
				//this is a super jank setup, expect to improve the chronos execution chain
				
				if(command.equalsIgnoreCase("_STARTER_")) {
					chrono.setChronoStopSignal(false);
					stopButton.setEnabled(true);
					starterButton.setEnabled(false);
				}
				
				if(command.equalsIgnoreCase("_STOPPER_")) {
					chrono.setChronoStopSignal(true);
					stopButton.setEnabled(false);
					starterButton.setEnabled(true);
				}
				
				while(!chrono.isChronoStopSignal()) {

					try {
						chrono.increment();
						chronoFace.setText(chrono.showTimer());
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		

		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// YOU HAVE BEEN TOUCHED BY AN ANGEL!
		// System.out.println("make the changing form for this times");
		// System.out.println(e.getComponent());
		if(chrono.isChronoStopSignal()) {
		    chronoFace.setText(chrono.resetTimer());
		}
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
