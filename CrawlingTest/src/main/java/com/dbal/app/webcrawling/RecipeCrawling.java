package com.dbal.app.webcrawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RecipeCrawling {
	public static void main(String[] args) {
		ArrayList<RecipeVo> list = new ArrayList<RecipeVo>();
		ArrayList<MaterialVo> mlist = new ArrayList<MaterialVo>();
		setList(list);
		setList2(mlist);
		craw(list, mlist);
	}

	public static ArrayList<RecipeVo> craw(ArrayList<RecipeVo> list, ArrayList<MaterialVo> mlist) {
		RecipeDao dao = new RecipeDao();
		dao.InsertRecipe(list, mlist);
//		dao.InsertRecipe(mlist);
		return list;
	}

	public static void setList(ArrayList<RecipeVo> list) {
		RecipeVo vo = new RecipeVo();
//		MaterialVo mvo = new MaterialVo();
		
		int n = 1;
		for (n = 1; n <= 4; n++) {
			String url = "https://www.10000recipe.com/recipe/list.html?q=%EC%B1%84%EC%8B%9D&order=reco&page=" + n;

			int count = 1;
			Document doc = null;
			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			Elements element = doc.select("li.common_sp_list_li");
			Iterator<Element> recipelink = element.select(".common_sp_thumb a").iterator();

			// 각 레시피별 세부 내용 크롤링
			//
			while (recipelink.hasNext() && count <= 10) {
				String linkin = "https://www.10000recipe.com" + recipelink.next().attr("href");

				// 제목
				Document docIn = null;
				try {
					docIn = Jsoup.connect(linkin).get();
				} catch (IOException e) {
					e.printStackTrace();
				}

				Elements title = docIn.select("div.view2_summary h3");
				System.out.println(title.text());
				vo.setR_title(title.text());

				// 요리순서
				for (int i = 1; i <= 20; i++) {
					Elements element3 = docIn.select("#stepdescr" + i);
					Iterator<Element> step = element3.iterator();

					if (step.hasNext()) {
						//System.out.println(step.next().text()); // 열기
						vo.setR_content(step.next().text());
					}else {
						
					}
					
				}
				
				// 요리사진
				Elements element4 = docIn.select("div.centeredcrop img");
				System.out.println(element4.attr("src"));
				vo.setR_image(element4.attr("src"));
			}
			list.add(vo);
			count++;
		}	
//			System.out.println(list);
	}
		
		
		/////////2222222222
		public static void setList2(ArrayList<MaterialVo> mlist) {
			MaterialVo mvo = new MaterialVo();
			
			int n = 1;
			for (n = 1; n <= 4; n++) {
				String url = "https://www.10000recipe.com/recipe/list.html?q=%EC%B1%84%EC%8B%9D&order=reco&page=" + n;

				int count = 1;
				Document doc = null;
				try {
					doc = Jsoup.connect(url).get();
				} catch (IOException e) {
					e.printStackTrace();
				}

				Elements element = doc.select("li.common_sp_list_li");
				Iterator<Element> recipelink = element.select(".common_sp_thumb a").iterator();

				// 각 레시피별 세부 내용 크롤링
				while (recipelink.hasNext() && count <= 10) {
					String linkin = "https://www.10000recipe.com" + recipelink.next().attr("href");

					//
					Document docIn = null;
					int count2 = 1;
					try {
						docIn = Jsoup.connect(linkin).get();
					} catch (IOException e) {
						e.printStackTrace();
					}

					// 재료
					Elements element2 = docIn.select("ul.case1 a");
					Iterator<Element> ingredients = element2.select("li").iterator();

					while (ingredients.hasNext() && count2 <= 10) {
						String iningredient = ingredients.next().text();
						String[] cut = iningredient.split(" ");

						int length = cut.length;
						String material = "";
						String volume = "";
						for (int i = 0; i < length; i++) {
							if (i < length - 1) {
								material += cut[i];
							} else {
								volume = cut[length - 1];
							}
						}
						if (material.equals(""))
							material = cut[0];

					System.out.println(material);
					System.out.println(volume);
					mvo.setMat_name(material);
					mvo.setMat_vol(volume);
						count2++;
					}
					
				}
				mlist.add(mvo);
				count++;
			}	
			
	}
}
