package fr.application.codingame.services;

import java.util.Arrays;

public class SecurityContext {

	private static String username = "";
	private static String password = "";
	private static String[] roles = {};

	public static void authentification(String u, String p, String[] r) {
		if (u.equals("root") && p.equals("123")) {
			username = u;
			password = p;
			roles = r;
		} else {
			throw new RuntimeException("Access Denied");
		}
	}

	public static boolean hasRole(String r) {

		return Arrays.asList(roles).contains(r);

	}

}
