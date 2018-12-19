package ss.week6.dictionaryattack;

import org.apache.commons.codec.binary.Hex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;


public class DictionaryAttack {
	private static final String PATH = "";

	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	public DictionaryAttack () {
		this.passwordMap = new HashMap<>();
		this.hashDictionary = new HashMap<>();
	}

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public void readPasswords(String filename) throws Exception {
			BufferedReader fileReader = new BufferedReader(new FileReader(filename));
			fileReader.lines().forEach(line -> {
				this.passwordMap.put(line.split(": ")[0], line.split(": ")[1]);
			});
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		try {
			MessageDigest MD5 = MessageDigest.getInstance("MD5");
			MD5.update(password.getBytes());
			byte[] MD5Bytes = MD5.digest();

			return Hex.encodeHexString(MD5Bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        return this.passwordMap.get(user).equals(this.getPasswordHash(password));
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
	 * the original password.
	 * @param filename filename of the dictionary.
	 */
	public void addToHashDictionary(String filename) throws Exception {
		BufferedReader fileReader = new BufferedReader(new FileReader(filename));
		fileReader.lines().forEach(password -> {
			hashDictionary.put(this.getPasswordHash(password), password);
		});
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		this.passwordMap.keySet().forEach(user -> {
			if(this.hashDictionary.containsKey(this.passwordMap.get(user))){
				System.out.println(user + ": " + this.hashDictionary.get(this.passwordMap.get(user)));
			}
		});
	}

	/**
	 * Bruteforce for numbers and lowercase letters
	 */
	public void doBruteForceAttack(String hash) {
		int i = 0;
		while(!hash.equals(this.getPasswordHash(Integer.toString(i,36)))){
			i++;
		}
	}

	public static void main(String[] args) throws Exception {
		DictionaryAttack da = new DictionaryAttack();

//		da.readPasswords("LeakedPasswords.txt");
//		da.addToHashDictionary("PasswordSet.txt");

		long mili = System.currentTimeMillis();
		da.doBruteForceAttack(da.getPasswordHash("hondje"));
		System.out.println(-1 * (mili - System.currentTimeMillis()));
	}

}
