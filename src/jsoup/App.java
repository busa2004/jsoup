package jsoup;

import java.io.IOException;

import javax.swing.JFrame;

public class App {
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new BouncingBall());
		frame.pack();
		frame.setLocation(1450, 850);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}
}
