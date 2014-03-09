package com.gcliff.rad.engine.reverseEngineering;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gcliff.rad.engine.backEnd.procedures.CreateProcedures;
import com.gcliff.rad.engine.frontEnd.beans.CreateJavaBean;
import com.gcliff.rad.model.Column;

public class CreateEntities {

	private static final Log log = LogFactory.getLog(CreateEntities.class);

	public static List<Column> columns = new ArrayList<Column>();
	public String tableSchema;
	public static String tableName;
	private Connection conn;

	public CreateEntities(String a, String b) {
		tableSchema = a.toUpperCase();
		tableName = b.toUpperCase();
		readTableMetaData();
	}

	public void readTableMetaData() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/information_schema?user=root&password=SYSTEM");

			String sql = "SELECT * FROM COLUMNS WHERE TABLE_SCHEMA = '" + tableSchema + "' AND TABLE_NAME = '" + tableName + "'";
			log.info("Executing: [" + sql + "]");
			ResultSet resultSet = conn.createStatement().executeQuery(sql);
			while (resultSet.next()) {
				Column column = new Column();
				column.setTableName(tableName);
				column.setColumnName(resultSet.getString("COLUMN_NAME"));
				column.setDataType(resultSet.getString("DATA_TYPE"));
				column.setColumnType(resultSet.getString("COLUMN_TYPE"));
				columns.add(column);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		CreateProcedures createProcedures = new CreateProcedures();
		createProcedures.excute();
		CreateJavaBean createJavaBean = new CreateJavaBean();
		createJavaBean.excute();
	}
}
