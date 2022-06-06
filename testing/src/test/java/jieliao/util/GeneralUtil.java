package jieliao.util;

import jieliao.data.Account;

public class GeneralUtil {
	
	public static Account generateFakeAccount() {
		NormalNameGenerator nameGenerator = new NormalNameGenerator();
		Account account = new Account();
		account.firstName = nameGenerator.generateFirstName();
		account.lastName = nameGenerator.generateLastName();
		account.email = account.firstName.toLowerCase() + "." + account.lastName.toLowerCase() + "@" + "test.com";
		account.password = "Abc$123%";
		
		return account;
	}

}
