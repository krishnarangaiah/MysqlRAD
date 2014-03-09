package com.gcliff.rad.engine.execute;

import com.gcliff.rad.engine.reverseEngineering.CreateEntities;

public class Rad {

	// private static final Log log = LogFactory.getLog(Rad.class);

	public static void main(String[] args) {
		try {
			CreateEntities c = new CreateEntities("bug_tracking", "SUTB_PROCESSING_DAYS");
			c.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
