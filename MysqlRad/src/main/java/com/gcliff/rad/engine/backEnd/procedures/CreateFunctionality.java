package com.gcliff.rad.engine.backEnd.procedures;

import com.gcliff.rad.model.Column;

public class CreateFunctionality {

	public static String aliasingBasedonDatatype(Column column) {
		if (column.getDataType().equalsIgnoreCase("BINARY")) {
			return "HEX(" + column.getColumnName() + ") AS " + column.getColumnName();
		} else if (column.getDataType().equalsIgnoreCase("DATETIME") || column.getDataType().equalsIgnoreCase("TIMESTAMP")) {
			return "DATE_FORMAT(" + column.getColumnName() + ",'%d-%m-%Y') AS " + column.getColumnName();
		} else {
			return column.getColumnName();
		}
	}

	public static String procedureINitems(Column column) {
		if (column.getDataType().equalsIgnoreCase("BINARY")) {
			return "\tIN pIN_" + column.getColumnName() + " VARCHAR(32),";
		} else if (column.getDataType().equalsIgnoreCase("DATETIME") || column.getDataType().equalsIgnoreCase("TIMESTAMP")) {
			return "\tIN pIN_" + column.getColumnName() + " VARCHAR(32),";
		} else if (column.getDataType().equalsIgnoreCase("VARCHAR")) {
			return "\tIN pIN_" + column.getColumnName() + " " + column.getColumnType() + ",";
		} else {
			return "\tIN pIN_" + column.getColumnName() + " VARCHAR(200),";
		}
	}

	public static String addElements(Column column) {
		if (column.getDataType().equalsIgnoreCase("BINARY")) {
			return "\t\tUNHEX(pIN_" + column.getColumnName() + "),";
		} else if (column.getDataType().equalsIgnoreCase("DATETIME") || column.getDataType().equalsIgnoreCase("TIMESTAMP")) {
			return "\t\tSTR_TO_DATE(pIN_" + column.getColumnName() + ",'%d-%m-%Y'),";
		}else {
			return "\t\tpIN_" + column.getColumnName() + ",";
		}
	}

}
