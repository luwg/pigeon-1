/**
 * Dianping.com Inc.
 * Copyright (c) 2003-2013 All Rights Reserved.
 */
package com.dianping.pigeon.demo.typical;

import com.dianping.avatar.tracker.ExecutionContextHolder;
import com.dianping.avatar.tracker.TrackerContext;
import com.dianping.phoenix.environment.PhoenixContext;
import com.dianping.pigeon.container.SpringContainer;
import com.dianping.pigeon.demo.EchoService;
import com.dianping.pigeon.demo.UserService;
import com.dianping.pigeon.demo.UserService.User;

public class Client {

	private static SpringContainer CLIENT_CONTAINER = new SpringContainer(
			"classpath*:META-INF/spring/typical/invoker.xml");

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		CLIENT_CONTAINER.start();
		// KryoSerializer.registerClass(EchoService.class, 10001);
		// KryoSerializer.registerClass(UserService.class, 10002);
		// KryoSerializer.registerClass(User.class, 10003);
		// KryoSerializer.registerClass(Role.class, 10004);

		EchoService echoService = (EchoService) CLIENT_CONTAINER.getBean("echoService");
		EchoService echoServiceWithCallback = (EchoService) CLIENT_CONTAINER.getBean("echoServiceWithCallback");
		EchoService echoServiceWithFuture = (EchoService) CLIENT_CONTAINER.getBean("echoServiceWithFuture");

		UserService userService = (UserService) CLIENT_CONTAINER.getBean("userService");

		User user = new User();
		user.setUsername("jason");
		User[] users = new User[] { user };
		//while (true) {
			try {
				PhoenixContext.getInstance().setRequestId("aaaa1111111");
				ExecutionContextHolder.setTrackerContext(new TrackerContext());

				System.out.println(echoService.now());
				//System.out.println(userService.getUserDetail(users, false));
				//System.out.println(echoService.echo("hi"));
				//echoServiceWithFuture.echo("future");
				//ServiceFuture f = ServiceFutureFactory.getFuture();
				//System.out.println(f._get());
			} catch (Exception e) {
				System.out.println("");
			}
		//}
	}

}
