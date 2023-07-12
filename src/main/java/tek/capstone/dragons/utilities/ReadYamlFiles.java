package tek.capstone.dragons.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {
	private static ReadYamlFiles readYamlFiles;
	private HashMap propertyType;
	
	// we create a constructor to load our yaml file
	private ReadYamlFiles(String filePath) throws FileNotFoundException {
	FileInputStream fileInputStream = FileUtility.getFileInputStream(filePath);
	Yaml yaml = new Yaml();
	this.propertyType = yaml.load(fileInputStream);
	}
	// we are return an instance of ReadYamlFiles
	public static  ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
		if (readYamlFiles == null)
			return new ReadYamlFiles(filePath);
		return readYamlFiles;
	}
	// we get property from the Yaml file and store in a HashMap so that when we call the method 
	//getYamlProperty we pass the key and this method will return the value
	public HashMap getYamlProperty(String key) {
		return (HashMap)this.propertyType.get(key);
	}
	

}
