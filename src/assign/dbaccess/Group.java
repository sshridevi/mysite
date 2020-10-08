package assign.dbaccess;

import java.io.*;
 
/**
 * 
 * Group Bean
 *
 */

public class Group implements Serializable {
 
	private String groupID;
	private String gName;

	/**
	 * No Argument Constructor
	 */
	public Group() {
		super();
	}

	/**
	 * Argument Constructor
	 */

	public Group(String inGroupID, String inGName) {
		groupID = inGroupID;
		gName = inGName;
	}

// Getters

	public String getgroupID() {
		return groupID;
	}
 
	public String getgName() {
		return gName;
	}
 
// Setters

	public void setgroupID(String inGroupID) {
		groupID = inGroupID;
	}
 
 
	public void setgName(String inGName) {
		gName = inGName;
	} 
}
 
