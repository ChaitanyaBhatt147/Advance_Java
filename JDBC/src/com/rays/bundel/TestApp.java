package com.rays.bundel;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestApp {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundel.app");
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
		ResourceBundle rb1 = ResourceBundle.getBundle("com.rays.bundel.app", new Locale("en"));
		System.out.println("English: "+rb1.getString("greeting"));
		ResourceBundle rb2 = ResourceBundle.getBundle("com.rays.bundel.app", new Locale("hi"));
		System.out.println("Hindi: "+rb2.getString("greeting"));
		ResourceBundle rb3 = ResourceBundle.getBundle("com.rays.bundel.app", new Locale("mi"));
		System.out.println("Marathi: "+rb3.getString("greeting"));
		ResourceBundle rb4 = ResourceBundle.getBundle("com.rays.bundel.app", new Locale("tm"));
		System.out.println("Tamil: "+rb4.getString("greeting"));
		ResourceBundle rb5 = ResourceBundle.getBundle("com.rays.bundel.app", new Locale("sp"));
		System.out.println("Spanish: "+rb5.getString("greeting"));
		ResourceBundle rb6 = ResourceBundle.getBundle("com.rays.bundel.app", new Locale("jp"));
		System.out.println("Japanese: "+rb6.getString("greeting"));
		ResourceBundle rb7 = ResourceBundle.getBundle("com.rays.bundel.app", new Locale("ru"));
		System.out.println("Russian: "+rb7.getString("greeting"));
		ResourceBundle rb8 = ResourceBundle.getBundle("com.rays.bundel.app", new Locale("fr"));
		System.out.println("French: "+rb8.getString("greeting"));
	}
}
