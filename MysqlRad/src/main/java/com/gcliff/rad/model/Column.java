package com.gcliff.rad.model;

import java.io.Serializable;

public class Column implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String tableCatalog;
	private String tableSchema;
	private String tableName;
	private String columnName;
	private String ordinalPosition;
	private String columnDefault;
	private String isNullable;
	private String dataType;
	private String characterMaximumLength;
	private String characterOctetLength;
	private String numericPrecision;
	private String numericScale;
	private String characterSetName;
	private String collationName;
	private String columnType;
	private String columnKey;
	private String extra;
	private String privileges;
	private String columnComment;

	public String getTableCatalog() {
		return tableCatalog;
	}

	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getOrdinalPosition() {
		return ordinalPosition;
	}

	public void setOrdinalPosition(String ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	public String getColumnDefault() {
		return columnDefault;
	}

	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	public String getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getCharacterMaximumLength() {
		return characterMaximumLength;
	}

	public void setCharacterMaximumLength(String characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}

	public String getCharacterOctetLength() {
		return characterOctetLength;
	}

	public void setCharacterOctetLength(String characterOctetLength) {
		this.characterOctetLength = characterOctetLength;
	}

	public String getNumericPrecision() {
		return numericPrecision;
	}

	public void setNumericPrecision(String numericPrecision) {
		this.numericPrecision = numericPrecision;
	}

	public String getNumericScale() {
		return numericScale;
	}

	public void setNumericScale(String numericScale) {
		this.numericScale = numericScale;
	}

	public String getCharacterSetName() {
		return characterSetName;
	}

	public void setCharacterSetName(String characterSetName) {
		this.characterSetName = characterSetName;
	}

	public String getCollationName() {
		return collationName;
	}

	public void setCollationName(String collationName) {
		this.collationName = collationName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

}
