// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package veriff.actions;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

public class Java_GetHMAC extends CustomJavaAction<java.lang.String>
{
	private java.lang.String apiKey;
	private java.lang.String payload;

	public Java_GetHMAC(IContext context, java.lang.String apiKey, java.lang.String payload)
	{
		super(context);
		this.apiKey = apiKey;
		this.payload = payload;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		String result = hmac("sha256", this.payload, this.apiKey);
		return result;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "Java_GetHMAC";
	}

	// BEGIN EXTRA CODE
	private static String hmac(String algorithm, String data, String key)
	  throws NoSuchAlgorithmException, InvalidKeyException {
	    SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
	    Mac mac = Mac.getInstance(algorithm);
	    mac.init(secretKeySpec);
	    return bytesToHex(mac.doFinal(data.getBytes()));
	}
	
	private static String bytesToHex(byte[] byteArray) {
        String hex = "";
  
        // Iterating through each byte in the array
        for (byte i : byteArray) {
            hex += String.format("%02X", i);
        }
  
        return hex;
    }

	// END EXTRA CODE
}
