package com.yaoyong.demo.base.handler;

/**
 *
 * @author： Fighter168
 *
 */

public interface BaseEnum<E extends Enum<?>, T> {

	public T getValue();

	public String getDisplayName();

}
