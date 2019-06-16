package sdc.apigw.jwt;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

	// ---( server methods )---




	public static final void createMD5WithSalt (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createMD5WithSalt)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [i] field:0:required inputSalt
		// [o] field:0:required outputString
		// pipeline
		IDataCursor idcIn = pipeline.getCursor();
			String	inputString = IDataUtil.getString( idcIn, "inputString" );
			String	inputSalt = IDataUtil.getString( idcIn, "inputSalt" );
			String outputString = "";
			idcIn.destroy();
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] byteSalt = inputSalt.getBytes();
				md.update(byteSalt);
				byte[] bytes = md.digest(inputString.getBytes());
				StringBuilder sb = new StringBuilder();
		        for(int i=0; i< bytes.length ;i++)
		        {
		        	sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		        }
		        outputString = sb.toString();
		        
		        
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// pipeline
		IDataCursor idcOut = pipeline.getCursor();
		IDataUtil.put( idcOut, "outputString", outputString );
		idcOut.destroy();
		
			
		// --- <<IS-END>> ---

                
	}
}

