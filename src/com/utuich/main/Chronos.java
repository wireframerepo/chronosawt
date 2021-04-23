package com.utuich.main;

public class Chronos {
	private int secs;
	private int mins;
	private int hours;
	private int days;
	private boolean takeDays = false;
	private boolean chronoStopSignal = false; //use to carry on or break the cycle
	
	public Chronos(boolean takeDays) {
		secs=0;
		mins=0;
		hours=0;
		days=0;
		this.takeDays = takeDays;
	}
	
	
	
	public Chronos(int secs, int mins, int hours, int days) throws ClockException {
		
		if(secs > 59 || secs < 0) {
			throw new ClockException("SECONDS ARE NOT BIGGER THAN 59 NOR SMALLER THAN 0");
		}
		
		if(mins > 59 || mins < 0) {
			throw new ClockException("MINUTES ARE NOT BIGGER THAN 59 NOR SMALLER THAN 0");
		}
		
		if(hours > 24 || hours < 0) {
			throw new ClockException("HOURS ARE NOT BIGGER THAN 23 NOR SMALLER THAN 0");
		}
		
		this.secs = secs;
		this.mins = mins;
		this.hours = hours;
		this.days = days;
		this.takeDays = true;
	}
	
	public Chronos(int secs, int mins, int hours) throws ClockException {
		
		if(secs > 59 || secs < 0) {
			throw new ClockException("SECONDS ARE NOT BIGGER THAN 59 NOR SMALLER THAN 0");
		}
		
		if(mins > 59 || mins < 0) {
			throw new ClockException("MINUTES ARE NOT BIGGER THAN 59 NOR SMALLER THAN 0");
		}
		
		this.secs = secs;
		this.mins = mins;
		this.hours = hours;
		this.takeDays = false;
	}



	public void increment() {
		
		this.secs = this.secs + 1;
		
		
		if(secs==60) {
			secs=0;
			mins=mins+1;
		}
		
		if(mins==60) {
			mins=0;
			hours=hours+1;		
		}
		
		if(this.takeDays) {
			if(hours==24) {
				hours=0;
				days=days+1;
			}
		}
	}
	
	public void decrement() {
		
		if(this.takeDays) {
			if(this.days == 0 && this.hours == 0 && this.mins == 0 && this.secs == 0) {
			    this.chronoStopSignal = true;
				return;	
			}
		}else {
			if(this.hours == 0 && this.mins == 0 && this.secs == 0) {
				this.chronoStopSignal = true;
				return;	
			}
		}
		
		this.secs = this.secs - 1;
		
		if(secs<0) {
			secs=59;
			mins=mins-1;
		}
		
		if(mins<0) {
			mins=59;
			hours=hours-1;		
		}
		
		if(this.takeDays) {
			if(hours<0) {
				hours=23;
				if(days>0) {
				    days=days-1;
				}
			}
		}else {
			if(hours<0) {
				hours=23;
			}
		}
		
		
	}
	
	public String showTimer() {
		if(this.takeDays) {
			return  days+" "+processString(hours)+":"+processString(mins)+":"+processString(secs);
		}else {
			return processString(hours)+":"+processString(mins)+":"+processString(secs);
		}
	}
	
	private String processString(int number) {
		if(number<10) {
			return "0"+number;
		}else {
			return ""+number;
		}
	}



	public boolean isChronoStopSignal() {
		return chronoStopSignal;
	}



	public void setChronoStopSignal(boolean chronoStopSignal) {
		this.chronoStopSignal = chronoStopSignal;
	}
	
}
