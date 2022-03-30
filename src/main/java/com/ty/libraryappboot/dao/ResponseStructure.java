package com.ty.libraryappboot.dao;

public class ResponseStructure<T> {
	private int staus;
	private String message;
	public int getSttaus() {
		return staus;
	}
	public String getMessage() {
		return message;
	}
	public T getData() {
		return data;
	}
	public void setSttaus(int sttaus) {
		this.staus = sttaus;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(T data) {
		this.data = data;
	}
	private T data;

}
