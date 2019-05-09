package com.airtel.thread;


public abstract class MyRunnable extends MyThread implements Runnable {

	@Override
	public void run(){
		threadPreProcess();
		myRun();
		threadPostProcess();
	}
	
	abstract public void myRun();

}
