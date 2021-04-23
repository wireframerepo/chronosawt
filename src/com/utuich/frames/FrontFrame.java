package com.utuich.frames;

import javax.swing.JFrame;

import com.utuich.main.Chronos;

public class FrontFrame extends JFrame{

	/**
	 * frame container;
	 * for the front chronometer face
	 */
	private static final long serialVersionUID = 1L;
	private static FrontPanel frontPanel = new FrontPanel();
	private Chronos chron;
	
	public FrontFrame() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		
		this.add(frontPanel);
	}
	
	

}
