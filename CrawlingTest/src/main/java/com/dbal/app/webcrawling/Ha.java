package com.dbal.app.webcrawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ha {
	public static void main(String[] args) {
//		ArrayList<RecipeVo> list = new ArrayList<RecipeVo>();
//		crawl(list);//???????
//	}
//
//	public static void setList(ArrayList<RecipeVo> list) {
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

		while (recipelink.hasNext() && count <= 200) {

			String linkin = "https://www.10000recipe.com" + recipelink.next().attr("href");

			// 제목
			Document docIn = null;
			int count2 = 1;
			try {
				docIn = Jsoup.connect(linkin).get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			Elements ele = docIn.select("div.view2_summary h3");
			System.out.println(ele.text());

			// 재료
			Elements element2 = docIn.select("ul.case1 a");
			Iterator<Element> ingredients = element2.select("li").iterator();
//				String ingredients = element2.select("li").text();
//				String cut = ingredients.substring(ingredients.indexOf(" ")+1);

			while (ingredients.hasNext() && count2 <= 10) {
				System.out.println(ingredients.next().text()); // 열기
//				System.out.println(cut);
				count2++;
			}

			// 요리순서
			for (int i = 1; i <= 20; i++) {
				Elements element3 = docIn.select("#stepdescr" + i);
				Iterator<Element> step = element3.iterator();

				while (step.hasNext() && count2 <= 20) {
					System.out.println(step.next().text()); //열기
					count2++;
				}
			}

			// 요리사진
			Elements element4 = docIn.select("div.centeredcrop img");
				System.out.println(element4.attr("src"));

			count++;
		}
	}

}