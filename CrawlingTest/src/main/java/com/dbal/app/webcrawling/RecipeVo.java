package com.dbal.app.webcrawling;

import java.sql.Date;

import lombok.Data;

@Data
public class RecipeVo {
	String R_ID;
	String R_TYPE;
	String R_TITLE;
	String R_CONTENT;
	String R_IMAGE;
	Date R_DATE;
	
	String MAT_ID;
	String MAT_NAME;
	String MAT_VOL;
	
	


}
