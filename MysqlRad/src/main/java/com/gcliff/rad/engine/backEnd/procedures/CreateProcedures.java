package com.gcliff.rad.engine.backEnd.procedures;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gcliff.rad.engine.reverseEngineering.CreateEntities;
import com.gcliff.rad.model.Column;

public class CreateProcedures {

	private static final Log log = LogFactory.getLog(CreateProcedures.class);
	
	private void createListProcedure() {

		System.out.println("DELIMITER $$");
		System.out.println("DROP PROCEDURE IF EXISTS " + CreateEntities.tableName.replace("TB", "PR") + "_LIST $$");
		System.out.println("CREATE PROCEDURE " + CreateEntities.tableName.replace("TB", "PR") + "_LIST (" + "\n\tOUT pOUT_ACTION_MSG VARCHAR(1000)," + "\n\tOUT pOUT_ERROR_MSG VARCHAR(1000)\n)");
		System.out.println(CreateEntities.tableName.replace("TB", "PR") + "_LIST:\n BEGIN");
		System.out.println("\tSELECT");
		for (Column column : CreateEntities.columns) {
			System.out.println("\t\t" + CreateFunctionality.aliasingBasedonDatatype(column) + ",");
		}
		System.out.println("\tFROM " + CreateEntities.tableName + ";");
		System.out.println("END\n" + CreateEntities.tableName.replace("TB", "PR") + "_LIST $$");
		System.out.println("DELIMITER ;\n\n");

	}

	private void createAddProcedure() {
		System.out.println("DELIMITER $$");
		System.out.println("DROP PROCEDURE IF EXISTS " + CreateEntities.tableName.replace("TB", "PR") + "_ADD $$");
		System.out.println("CREATE PROCEDURE " + CreateEntities.tableName.replace("TB", "PR") + "_ADD (");
		for (Column column : CreateEntities.columns) {
			System.out.println(CreateFunctionality.procedureINitems(column));
		}
		System.out.println("\n\tOUT pOUT_ACTION_MSG VARCHAR(1000)," + "\n\tOUT pOUT_ERROR_MSG VARCHAR(1000)\n)");
		System.out.println(CreateEntities.tableName.replace("TB", "PR") + "_ADD:\n BEGIN");

		System.out.println("\n\tINSERT INTO " + CreateEntities.tableName + " (");
		for (Column column : CreateEntities.columns) {
			System.out.println("\t\t" + column.getColumnName() + ", ");
		}
		System.out.println("\t\t)\n\tVALUES (");
		for (Column column : CreateEntities.columns) {
			System.out.println(CreateFunctionality.addElements(column));
		}
		System.out.println("\t\t);");

		System.out.println("END\n" + CreateEntities.tableName.replace("TB", "PR") + "_ADD $$");
		System.out.println("DELIMITER ;\n\n");
	}

	private void createDeleteProcedure() {
		System.out.println("DELIMITER $$");
		System.out.println("DROP PROCEDURE IF EXISTS " + CreateEntities.tableName.replace("TB", "PR") + "_DELETE $$");
		System.out.println("CREATE PROCEDURE " + CreateEntities.tableName.replace("TB", "PR") + "_DELETE (" + "\n\tIN pIN_" + CreateEntities.tableName + "_ID VARCHAR(32)," + "\n\tOUT pOUT_ACTION_MSG VARCHAR(1000)," + "\n\tOUT pOUT_ERROR_MSG VARCHAR(1000)\n)");
		System.out.println(CreateEntities.tableName.replace("TB", "PR") + "_DELETE:\n BEGIN");
		System.out.println("\tDELETE");
		System.out.println("\tFROM " + CreateEntities.tableName);
		System.out.println("\tWHERE " + CreateEntities.tableName + "_ID = UNHEX(pIN_" + CreateEntities.tableName + "_ID);");
		System.out.println("END\n" + CreateEntities.tableName.replace("TB", "PR") + "_DELETE $$");
		System.out.println("DELIMITER ;\n\n");
	}

	private void createUpdateProcedure() {
		System.out.println("DELIMITER $$");
		System.out.println("DROP PROCEDURE IF EXISTS " + CreateEntities.tableName.replace("TB", "PR") + "_UPDATE $$");
		System.out.println("CREATE PROCEDURE " + CreateEntities.tableName.replace("TB", "PR") + "_UPDATE (");
		for (Column column : CreateEntities.columns) {
			System.out.println(CreateFunctionality.procedureINitems(column));
		}
		System.out.println("\n\tOUT pOUT_ACTION_MSG VARCHAR(1000)," + "\n\tOUT pOUT_ERROR_MSG VARCHAR(1000)\n)");
		System.out.println(CreateEntities.tableName.replace("TB", "PR") + "_UPDATE:\n BEGIN");

		System.out.println("\n\tUPDATE " + CreateEntities.tableName + " SET");
		for (Column column : CreateEntities.columns) {
			System.out.println("\t\t" + column.getColumnName() + "\t= " + CreateFunctionality.addElements(column));
		}
		System.out.println("\t\t;");

		System.out.println("END\n" + CreateEntities.tableName.replace("TB", "PR") + "_UPDATE $$");
		System.out.println("DELIMITER ;\n\n");
	}

	private void createFindByIdProcedure() {
		System.out.println("DELIMITER $$");
		System.out.println("DROP PROCEDURE IF EXISTS " + CreateEntities.tableName.replace("TB", "PR") + "_FIND_BY_ID $$");
		System.out.println("CREATE PROCEDURE " + CreateEntities.tableName.replace("TB", "PR") + "_FIND_BY_ID (" + "\n\tIN pIN_" + CreateEntities.tableName + "_ID VARCHAR(32)," + "\n\tOUT pOUT_ACTION_MSG VARCHAR(1000)," + "\n\tOUT pOUT_ERROR_MSG VARCHAR(1000)\n)");
		System.out.println(CreateEntities.tableName.replace("TB", "PR") + "_FIND_BY_ID:\n BEGIN");
		System.out.println("\tSELECT");
		for (Column column : CreateEntities.columns) {
			System.out.println("\t\t" + CreateFunctionality.aliasingBasedonDatatype(column) + ",");
		}
		System.out.println("\tFROM " + CreateEntities.tableName);
		System.out.println("\tWHERE " + CreateEntities.tableName + "_ID = UNHEX(pIN_" + CreateEntities.tableName + "_ID);");
		System.out.println("END\n" + CreateEntities.tableName.replace("TB", "PR") + "_FIND_BY_ID $$");
		System.out.println("DELIMITER ;\n\n");
	}
	
	public void excute(){
		
		log.info("About to create Procedures");
		createListProcedure();
		log.info("About to create Procedures");
		createDeleteProcedure();
		createAddProcedure();
		createUpdateProcedure();
		createFindByIdProcedure();
	}
	
}
