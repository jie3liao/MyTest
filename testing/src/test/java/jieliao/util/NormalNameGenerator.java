package jieliao.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class NormalNameGenerator {
	
	public static final String PROP_SERENITY_DATA_DIR = "serenity.data.dir";
	public static final String NAME_FILES_DIR = "names";
	public static final String LAST_NAMES_FILE = "last_names.txt";
	public static final String FEMALE_FIRST_NAMES = "female_first_names.txt";
	public static final String MALE_FIRST_NAMES = "male_first_names.txt";
	
	private List<String> lastNames;
	private List<String> femaleFirstNames;
	private List<String> maleFirstNames;
	private Random random;
	
	public NormalNameGenerator() {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String nameFilesPath = variables.getProperty(PROP_SERENITY_DATA_DIR).toString() + File.separator + NAME_FILES_DIR;
		try {
		    lastNames = Files.readAllLines(Paths.get(nameFilesPath + File.separator + LAST_NAMES_FILE));
		    femaleFirstNames = Files.readAllLines(Paths.get(nameFilesPath + File.separator + FEMALE_FIRST_NAMES));
		    maleFirstNames = Files.readAllLines(Paths.get(nameFilesPath + File.separator + MALE_FIRST_NAMES));
		    
		    random = new Random();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String generateLastName() {
		int index = random.nextInt(lastNames.size());
		return lastNames.get(index);
	}

	public String generateFemaleFirstName() {
		int index = random.nextInt(femaleFirstNames.size());
		return femaleFirstNames.get(index);
	}
	
	public String generateMaleFirstName() {
		int index = random.nextInt(maleFirstNames.size());
		return maleFirstNames.get(index);
	}
	
	public String generateFirstName() {
		int selector = random.nextInt(2);
		if (selector == 0) {
		    int index = random.nextInt(femaleFirstNames.size());	
		    return femaleFirstNames.get(index);
		} else {
			int index = random.nextInt(maleFirstNames.size());
			return maleFirstNames.get(index);
		}
	}
}
