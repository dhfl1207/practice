package com.dbal.app.webcrawling;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RecipeCrawling {
	public static void main(String[] args) {

		String url = "https://www.10000recipe.com/recipe/list.html?q=%EC%B1%84%EC%8B%9D";
		Document doc = null;
		int count = 1;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements element = doc.select("li.common_sp_list_li");

		Iterator<Element> recipelink = element.select(".common_sp_thumb a").iterator();

		while (recipelink.hasNext() && count <= 10) {
//			System.out.println(recipelink.next().attr("href"));
			
			
				String linkin = "https://www.10000recipe.com" + recipelink.next().attr("href");
//				System.out.println(linkin);
				
				//제목
				Document docIn = null;
				int count2 = 1;
				try {
					docIn = Jsoup.connect(linkin).get();
				} catch (IOException e) {
					e.printStackTrace();
				}

//				Elements element5 = docIn.select(".view2_summary st3");
				Elements ele = docIn.select("div.view2_summary st3");
				for (Element e : ele.select("h3")) {
					if(e.tagName().equals("h3")) {
						continue;
					}
					System.out.println(e.text());
				}
				
//				Iterator<Element> title = element5.iterator();
//				
//				while (title.hasNext() && count2 <= 2) {
//					System.out.println(title.next());
//					count2++;
//				}
				
				
				// 재료가져오는 부분
//				Document docIn = null;
//				int count2 = 1;
				try {
					docIn = Jsoup.connect(linkin).get();
//					System.out.println(docIn);
				} catch (IOException e) {
					e.printStackTrace();
				}
			
				Elements element2 = docIn.select("ul.case1 a");
				Iterator<Element> ingredients = element2.select("li").iterator();
				
				while (ingredients.hasNext() && count2 <= 10 ) {					
//					System.out.println(ingredients.next().text()); //열기
					count2++;
				}
				
//				.attr("src");
				
			// 요리순서
				Document docStep = null;
				try {
					docStep = Jsoup.connect(linkin).get();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				for(int i = 1; i <= 20; i++) {
					Elements element3 = docStep.select("#stepdescr"+i);
					Iterator<Element> step = element3.iterator();
					
					while (step.hasNext() && count2 <= 20) {
//						System.out.println(step.next().text()); //열기
						count2++;
					}
				}
				
				
			//요리사진
				Document docpic = null;
				try {
					docpic = Jsoup.connect(linkin).get();
				} catch (IOException e) {
					e.printStackTrace();
				}
//				System.out.println(docpic);
				
				Elements element4 = docpic.select("div.centeredcrop");
				Iterator<Element> pic = element4.iterator();
				
				while (pic.hasNext() && count2 <= 5) {
					System.out.println(pic.next().attr("src"));
				
					count2++;
				}

			count++;
		}

	}

}
