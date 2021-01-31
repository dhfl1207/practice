package com.dbal.app.webcrawling;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RestaurantCrawling {

	public static void main(String[] args) {
		String Seoul = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%84%9C%EC%9A%B8%EC%B1%84%EC%8B%9D";
		String Daejeon = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%8C%80%EC%A0%84%EC%B1%84%EC%8B%9D";
		String Deagu = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%8C%80%EA%B5%AC+%EC%B1%84%EC%8B%9D";
		String Busan = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%B6%80%EC%82%B0%EC%B1%84%EC%8B%9D";
		
		int count = 1;
		Document doc = null;
		try {
			doc = Jsoup.connect(Deagu).get();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements element = doc.select(".api_subject_bx");
		Iterator<Element> restaurantlink = element.select(".api_more_wrap a").iterator();
		String linkin = restaurantlink.next().attr("href");
		
		System.out.println(linkin);
		
		

	}

}
