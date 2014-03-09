package com.gcliff.rad.engine.frontEnd.beans;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gcliff.rad.engine.frontEnd.beans.CreateFunctionality;
import com.gcliff.rad.engine.reverseEngineering.CreateEntities;
import com.gcliff.rad.model.Column;

public class CreateJavaBean {
	private static final Log log = LogFactory.getLog(CreateJavaBean.class);

	private void createJavaBean() {
		System.out.println("public class " + CreateFunctionality.javaFile(CreateEntities.tableName) + " implements Serializable{");
		System.out.println("\nprivate static final long serialVersionUID = 1L;\n");
		for (Column column : CreateEntities.columns) {
			System.out.println(CreateFunctionality.javaFields(column.getColumnName()));
		}

		System.out.println("\n}");
	}

	private void createDAOfields() {
		for (Column column : CreateEntities.columns) {
			System.out.println("setterOBJ.set" + CreateFunctionality.javaFile(column.getColumnName()) + "(resultSetOBJ.getString(\"" + column.getColumnName() + "\"));");
		}
	}

	public void excute() {
		createJavaBean();
		createDAOfields();
	}

}
