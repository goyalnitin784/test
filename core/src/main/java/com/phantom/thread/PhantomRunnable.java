package com.phantom.thread;


public abstract class PhantomRunnable extends PhantomThread implements Runnable {

	@Override
	public void run(){
		threadPreProcess();
		myRun();
		threadPostProcess();
	}
	
	abstract public void myRun();

}
