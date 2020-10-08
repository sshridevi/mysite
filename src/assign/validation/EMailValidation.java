package assign.validation;

import java.io.*;
import assign.interfaces.ErrorMessageCodes;

 
/**
 * 
 * EMailValidation
 *
 */

public class EMailValidation {
	
 
	/**
	 * No Argument Constructor
	 */
	public EMailValidation() {
		super();
	}

	private boolean isValidEmail(String inEMailId) {
		return (inEMailId.indexOf(".") > 2) && (inEMailId.indexOf("@") > 0);
	}

	public String validateEmailAddress(String inEMailId){
	// takes care of a@B. It won't take a@a.c mainly it won't take care after . com
		if (inEMailId.equals("")){
			return ErrorMessageCodes.EMAIL_ID_NULL;
		} else {
			if (!isValidEmail(inEMailId)) {
				return ErrorMessageCodes.EMAIL_ID_INVALID;
			}
		}
	   return "";
	}
	
	public String validateFirstName(String firstName){
		if (isFieldBlankOrNull(firstName)){
			return ErrorMessageCodes.FIRST_NAME_IS_BLANK;
		}	
		return "";
	}
	
	private boolean isFieldBlankOrNull(String field){
		if (field == null || field.trim().equals("")){
			return true;
		}
		return false;
	}
}
 
