package de.rpfr.abt7.dms76.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class DMSUtil {
	
	public final static String PROP_TARGETDIR = "targetdirectory";
	
	private static DMSUtil myself;
	
	private Properties props;

	private DMSUtil(){
		super();
	}
	
	public static DMSUtil getInstance(String propfile) throws IOException{
		if(myself == null){
			myself = new DMSUtil();
			myself.readProperties(propfile);
		}
		return myself;
	}
	
	public void readProperties(String propfile) throws IOException{
		props = new Properties();
		Reader reader = new FileReader(propfile);
		props.load(reader);
	}
	
	public String getProperty(String key){
		String value = "";
		if(props != null){
			value = props.getProperty(key);
		}
		return value;
	}
	
	
}
