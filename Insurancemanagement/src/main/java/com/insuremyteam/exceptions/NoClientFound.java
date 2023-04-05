package com.insuremyteam.exceptions;

public class NoClientFound extends RuntimeException{
	
	public NoClientFound() {
		
	}
	
	public NoClientFound(String msg) {
		super(msg);
	}
}
