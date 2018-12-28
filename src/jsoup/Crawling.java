package jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawling {
	 private String URL;
	 private Document doc;
	 private Elements elem;
	 public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public Document getDoc() {
		return doc;
	}
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	public Elements getElem() {
		return elem;
	}
	public void setElem(Elements elem) {
		this.elem = elem;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	private String str;
	
	
	void crawlingElement(String url, String location, int sub) {
		setURL(url);
    	//temp.setURL("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EB%B6%80%EC%82%B0+%EB%82%A0%EC%94%A8");
    	  try {
			setDoc(Jsoup.connect(getURL()).get());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  setElem(getDoc().select(location));
    	  //todaytemp
    	  setStr(getElem().text().substring(0,sub));
    	 // a = new JLabel(str);
		
	}
}
