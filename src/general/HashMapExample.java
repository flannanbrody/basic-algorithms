package general;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapExample {

	public static void main(String[] args) {
		try {
			 
			Map<String, String> mMap = new HashMap<>();
			mMap.put("PostgreSQL", "Free Open Source Enterprise Database");
			mMap.put("DB2", "Enterprise Database , It's expensive");
			mMap.put("Oracle", "Enterprise Database , It's expensive");
			mMap.put("MySQL", "Free Open SourceDatabase");
 
			Iterator<Entry<String, String>> iter = mMap.entrySet().iterator();
 
			while (iter.hasNext()) {
				Map.Entry<String, String> mEntry = (Map.Entry<String, String>) iter.next();
				System.out.println(mEntry.getKey() + " : " + mEntry.getValue());
			}
 
			mMap.put("Oracle", "Enterprise Database , It's free now ! (hope)");
 
			System.out.println("One day Oracle.. : " + mMap.get("Oracle"));
			
			System.out.println("Does HashMap contains 21 as key: " + mMap.containsKey("Oracle"));
			
			//Iterate keySet
			System.out.println();
			System.out.println("Iterate over the keySet");
			for (String key : mMap.keySet()) {
				System.out.println("The key are: " + key);
			}
			
			//Iterate values
			System.out.println();
			System.out.println("Iterate over the values: ");
			for (String value : mMap.values()) {
				System.out.println("The values are: " + value);
			}
			
			//Iterate entrySet
			System.out.println();
			System.out.println("Iterate over the entrySet: ");
			for (Map.Entry<String, String> entry : mMap.entrySet()) {
			    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			}
 
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
