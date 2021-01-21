package com.dbal.app.webcrawling;

import java.sql.Date;

import lombok.Data;

@Data
public class RecipeVo {
	String r_id;
	String r_type;
	String r_title;
	String r_content;
	String r_image;
	Date R_date;
	
	//본 프로젝트에 합칠 때 rId 처럼 바꾸기

}
