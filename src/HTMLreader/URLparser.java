package HTMLreader;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class URLparser {
	private String url;
	private String priceParserTag = "span[itemprop=\"price\"]";
	
	public URLparser(String url){
		this.url = url;
	}
	
	public String priceParser() throws IOException{		
		Document doc = Jsoup.connect(url).get();
		Element span = doc.select(priceParserTag).first();
		String price = span.text();
		return price;
	}
	
	public String categoryParser() throws IOException{		
		Document doc = Jsoup.connect(url).get();		
		String s = doc.select("table.lr-prod-pricebox-meta-table a[href]").first().ownText();
		return s;
	}
	
	
	public static void main(String[] args) throws IOException {
		String url1 = "https://www.bax-shop.nl/externe-audio-interfaces/antelope-audio-orion-32-32-32-audio-interface";
		String url2 = "https://www.thomann.de/de/antelope_orion_studio.htm";
		String url3 = "https://www.woodbrass.com/interfaces-audio-thunderbolt-antelope-audio-orion-studio-p223615.html";
		//System.out.println(parser(URLreader.getHTML(url)));
		
		URLparser parser = new URLparser(url2);
		System.out.println(parser.priceParser());
		System.out.println(parser.categoryParser());
	}

}
