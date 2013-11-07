/**
 * Dianping.com Inc.
 * Copyright (c) 2003-2013 All Rights Reserved.
 */
package com.dianping.pigeon.component.invocation;

import java.io.Serializable;
import java.util.Map;

public interface InvocationContext {

	InvocationRequest getRequest();

	void setRequest(InvocationRequest request);

	InvocationResponse getResponse();

	void setResponse(InvocationResponse response);

	/**
	 * 在整个调用流程中公用，会随着调用被传播，如被修改，会随着调用流被同步
	 * 
	 * @param key
	 * @param value
	 */
	void putContextValue(String key, Serializable value);

	/**
	 * 在整个调用流程中公用，会随着调用被传播，如被修改，会随着调用流被同步
	 * 
	 * @param key
	 * @return
	 */
	Serializable getContextValue(String key);

	/**
	 * 在整个调用流程中公用，会随着调用被传播，如被修改，会随着调用流被同步
	 * 
	 * @return
	 */
	Map<String, Serializable> getContextValues();

	/**
	 * 仅在当前进程生效，不垮进程共享
	 * 
	 * @param key
	 * @param value
	 */
	void putTransientContextValue(String key, Object value);

	/**
	 * 仅在当前进程生效，不垮进程共享
	 * 
	 * @param key
	 * @return
	 */
	Object getTransientContextValue(String key);
}