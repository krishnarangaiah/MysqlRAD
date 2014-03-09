package com.gcliff.rad.engine.frontEnd.beans;

public class CreateFunctionality {

	public static String javaFields(String column) {

		String javaField = "";
		boolean firstTime = false;
		for (String piece : column.split("_")) {
			piece = piece.toLowerCase();
			if (firstTime) {
				piece = piece.substring(0, 1).toUpperCase() + piece.substring(1);
			}
			firstTime = true;
			javaField = javaField + piece;

		}
		return ("private String " + javaField + ";");
	}
	
	public static String javaFile(String tableName) {

		String tableName_ = "";
		for (String piece : tableName.split("_")) {
			piece = piece.toLowerCase();
			piece = piece.substring(0, 1).toUpperCase() + piece.substring(1);
			tableName_ = tableName_ + piece;
		}
		return (tableName_);
	}
}
