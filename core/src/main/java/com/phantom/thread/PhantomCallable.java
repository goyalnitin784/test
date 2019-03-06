package com.phantom.thread;

import java.util.concurrent.Callable;

public abstract class PhantomCallable<RES> extends PhantomThread implements Callable<RES> {
	
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
