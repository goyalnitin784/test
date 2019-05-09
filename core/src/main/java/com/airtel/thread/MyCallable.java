package com.airtel.thread;

import java.util.concurrent.Callable;

public abstract class MyCallable<RES> extends MyThread implements Callable<RES> {
	
	@Override
	public RES call() throws Exception {
		
		RES res;
		threadPreProcess();
		res = myCall();
		threadPostProcess();
		return res;
	}
	
	abstract public RES myCall()  throws Exception;
}
