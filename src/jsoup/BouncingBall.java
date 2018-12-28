package jsoup;

import java.awt.Button;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class BouncingBall extends JPanel {
	private static final int BOX_WIDTH = 200; // 전체 폭
	private static final int BOX_HEIGHT = 100; // 전체 높이
	Crawling stock = new Crawling();
	Crawling temp = new Crawling();
	Crawling search = new Crawling();
	JTextField tf = new JTextField(10);
	
	//Button bt = new Button("검색");
	public BouncingBall() throws IOException, URISyntaxException {
		this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT)); // 사이즈 지정
		String str = new String(tf.getText());
		tf.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

            	try {
					Desktop.getDesktop().browse(new URI("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query="+str));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

            }});
		this.add(tf);
		
		//this.add(bt);
		
		//Desktop.getDesktop().browse(new URI("http://mdago.tistory.com/"));
		
		
		class MyThread extends Thread {
			public void run() { // 수행하여야 하는 작업을 적어줌
				while (true) {
					stock.crawlingElement("https://finance.naver.com/item/main.nhn?code=012510", ".no_today", 6);
					temp.crawlingElement("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EB%B6%80%EC%82%B0+%EB%82%A0%EC%94%A8","span.todaytemp", 2);
					//search.crawlingElement("https://datalab.naver.com/keyword/realtimeList.naver?where=main", ".rank_list", 10);
					repaint(); // 그린다.
					try {
						Thread.sleep(1000); // 공의 속도 조절
					} catch (InterruptedException ex) {
					}
				}
			}
		}
		Thread t = new MyThread(); // 스레드 객체 생성
		t.start(); // 스레드 시작
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (stock.getStr() != null) {
			g.setFont(new Font("고딕체", Font.BOLD, 20));
			g.drawString(stock.getStr(), 30, 60);
		}

		if (temp.getStr() != null) {
			g.setFont(new Font("고딕체", Font.BOLD, 20));
			g.drawString("부산 기온 : " + temp.getStr() + "℃", 30, 90);
		}
		
		
		/*
		 * if (search.getStr() != null) { g.drawString( search.getStr(), 30, 90); }
		 */
		 

	}

}


