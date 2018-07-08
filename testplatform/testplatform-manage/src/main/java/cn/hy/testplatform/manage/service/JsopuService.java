package cn.hy.testplatform.manage.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class JsopuService {
	FileOutputStream fo = null;
	//获取html
	public String getHtml(String url,String saveLocation) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements e = doc.getAllElements();
		byte[] byteArray = e.toString().getBytes();
		try {
			File f = new File(saveLocation);
			if (f.exists()) {
				f.delete();
				f.createNewFile();
			}
			fo = new FileOutputStream(saveLocation+"\\"+"html.txt");
			fo.write(byteArray);
		}catch(Exception ee) {
			ee.toString();
			return "";
		}finally {
			try {
				fo.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return "";
			}finally {
				fo=null;
			}
		}
		return "ok";
	}
	
	public String getImg(String url,String saveLocation) throws Exception {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements e = doc.getElementsByTag("img");
		Iterator<Element> imgEle =e.iterator();
		int js = 1;
		while (imgEle.hasNext()) {
			String imgsurl = imgEle.next().attr("src");
			File file = new File(saveLocation);
			file.mkdir();
			URL imgurl = new URL(imgsurl);
			URLConnection connection = imgurl.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
			connection.setRequestProperty("Referer", url);
			connection.setConnectTimeout(10 * 1000);
			
			
			InputStream in = connection.getInputStream();
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(saveLocation+"\\"+js+".jpg"));
			byte[] buf = new byte[1024];
			int size;
			while (-1 != (size = in.read(buf))) {
				out.write(buf, 0, size);
			}
			try {
				out.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			} finally {
				out = null;
			}
			try {
				in.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			} finally {
				in = null;
			}
			js++;
		}
		
		return "ok";
	}
	
}
