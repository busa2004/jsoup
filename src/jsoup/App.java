package jsoup;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;

public class App {
	public static void main(String[] args) throws IOException, URISyntaxException {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new BouncingBall());
		frame.pack();
		frame.setLocation(1450, 850);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}
}
