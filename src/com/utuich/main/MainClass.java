package com.utuich.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.utuich.frames.FrontFrame;

public class MainClass {

	public static void main(String[] args) {
		
		FrontFrame frame = new FrontFrame();
		
		//read file
		/*
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/doncotech1.jpg")); //succesful
			System.out.println(reader.readLine());
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		/*
		try {
			File myFile = new File("src/file.txt"); //right way to route, all starts in route, not source
			myFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		/*
		Chronos cron;
		try {
			cron = new Chronos(333,0,0,0);
			
			try {
				while(true) {
					System.out.println(cron.showTimer());
					cron.decrement();
					if(cron.isChronoStopSignal()) {
						break;
					}
				    Thread.sleep(1000);
				}
				System.out.println("time is up");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClockException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		

	}

}
