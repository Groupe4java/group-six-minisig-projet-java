package com.minisig.userinterfacelayer;

import java.awt.EventQueue;

public class ProgramConsultation {

	// Fonction main
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MyJFrame frame = new MyJFrame();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
