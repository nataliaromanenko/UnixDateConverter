package ru.romanenko.main;

import java.awt.EventQueue;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				System.out.println("Hello");
				try {
					ApplicationFrame frame = new ApplicationFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
