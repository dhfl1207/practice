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

		while (recipelink.hasNext() && count <= 30) {
			System.out.println(recipelink.next().attr("href"));
			
		
				String linkin = "https://www.10000recipe.com" + recipelink.next().attr("href");
				System.out.println(linkin);
				Document docIn = null;
				int count2 = 1;
				try {
					docIn = Jsoup.connect(linkin).get();
					System.out.println(docIn.html());
				} catch (IOException e) {
					e.printStackTrace();
				}
//				Elements element2 = docIn.select("ul.case1 a");
//				Iterator<Element> ingredients = element2.select("li").iterator();
				
////				while (ingredients.hasNext() && count2 <= 10 ) {					
//					System.out.println();
//					count2++;
//				}

			count++;
		}

	}

}
