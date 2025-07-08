package me.schf.alert.engine.service;

public interface Converter<T> {

	public T convert(String message) throws Exception;

}
