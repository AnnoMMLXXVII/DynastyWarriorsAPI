/**
 * 
 */
package com.dw8xl.restdw8xl.temp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.model.character.Officer;
import com.dw8xl.restdw8xl.model.kingdom.Kingdom;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryDNE;
import com.dw8xl.restdw8xl.model.weapon.type.Type;
import com.dw8xl.restdw8xl.model.weapon.type.TypeI;

/**
 * @author Haku Wei
 *
 */
public class OfficerImplTemp {
	
	private List<CharacterI> officers, shu, wu, wei, jin, other;
	
	public OfficerImplTemp() throws FileNotFoundException{
		officers = getAllOfficerFiles();
		shu = getShuOfficers();
		wu = getWuOfficers();
		wei = getWeiOfficers();
		jin = getJinOfficers();
		other = getOtherOfficers();
	}

	public List<CharacterI> getAllOfficerFiles() {
		return parseThroughAllOfficers();
	}
	
	public List<CharacterI> getShuOfficers() throws FileNotFoundException {
		return parseThroughOfficerByKingdom(parseURLByKingdom(new Kingdom("Shu")),new ArrayList<CharacterI>());
	}
	
	public List<CharacterI> getWuOfficers() throws FileNotFoundException{
		return parseThroughOfficerByKingdom(parseURLByKingdom(new Kingdom("Wu")), new ArrayList<CharacterI>());
	}
	
	public List<CharacterI> getWeiOfficers() throws FileNotFoundException{
		return parseThroughOfficerByKingdom(parseURLByKingdom(new Kingdom("Wei")), new ArrayList<CharacterI>());
	}
	
	public List<CharacterI> getJinOfficers() throws FileNotFoundException {
		return parseThroughOfficerByKingdom(parseURLByKingdom(new Kingdom("Jin")), new ArrayList<CharacterI>());
	}
	
	public List<CharacterI> getOtherOfficers() throws FileNotFoundException {
		return parseThroughOfficerByKingdom(parseURLByKingdom(new Kingdom("Other")), new ArrayList<CharacterI>());
	}
	
	public List<CharacterI> findOfficerByWildCard(String name) {
		List<CharacterI> officers = parseThroughAllOfficers();
		if(officers == null) {
			throw new NullPointerException("Cannot execute findOfficerByWildCard: Null List");
		}
		return officers.stream().filter(o -> 
				o.getName().trim().contains(name.trim()))
				.collect(Collectors.toList());
	}
	
	public CharacterI findOfficer(CharacterI officer) {
		List<CharacterI> officers = parseThroughAllOfficers();
		for(CharacterI c: officers) {
			if(c.equals(officer)) {
				return c;
			}
		}
		return null;
	}
	
	public CharacterI findOfficerByName(String name) {
		List<CharacterI> officers = parseThroughAllOfficers();
		if(officers == null) {
			throw new NullPointerException("Cannot execute findOfficerByName: Null List");
		}
		for(CharacterI c: officers) {
			if(c.getName().equals(name)) {
				return c;
			}
		}
		return null;
//		return officers.stream().filter(o -> 
//				o.getName().trim().equals(name.trim()))
//				.findFirst().get();
	}
	
	public CharacterI findOfficerByType(TypeI type) {
		List<CharacterI> officers = parseThroughAllOfficers();
		if(officers == null) {
			throw new NullPointerException("Cannot execute findOfficerByType: Null List");
		}
		return officers.stream().filter(o -> o.getType().getType().equals(type.getType())).findFirst().get();
	}
	
	public String[] getAllOfficerURLs() {
		return new String[] {
				"Text-Files\\characters\\officer\\Officer-List-Jin.txt",
				"Text-Files\\characters\\officer\\Officer-List-Other.txt",
				"Text-Files\\characters\\officer\\Officer-List-Shu.txt",
				"Text-Files\\characters\\officer\\Officer-List-Wei.txt",
				"Text-Files\\characters\\officer\\Officer-List-Wu.txt"
			};
	}
	
	private String getShuOfficersURL() {
		return "Text-Files\\characters\\officer\\Officer-List-Shu.txt";
	}
	
	public String parseURLByKingdom(Kingdom kingdom) {
		String[] files = getAllOfficerURLs();
		List<String> paths = Arrays.asList(files);
		return paths.stream().filter(k -> 
			k.toLowerCase().trim()
			.contains(kingdom.getName().toLowerCase()))
			.findFirst().get();
	}
	
	private List<CharacterI> parseThroughOfficerByKingdom(String url, List<CharacterI> officers) throws FileNotFoundException {
		File file = new File(url.trim().toLowerCase());
		if(!file.exists()) {
			throw new FileNotFoundException("Cannot Locate File!");
		}
		CharacterI officerTemp;
		try {
			Scanner z = new Scanner(new FileReader(file));
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				officerTemp = new Officer(
						officerLine[0].trim(), 
						new Kingdom(officerLine[1].trim()), 
						new Type(officerLine[2].trim(), new CategoryDNE()));
				officers.add(officerTemp);
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return officers;
	}
	
	private List<CharacterI> parseThroughAllOfficers() {
		String[] files = getAllOfficerURLs();
		List<CharacterI> officers = new ArrayList<>();
		for(int i = 0 ; i < files.length; i++) {
			try {
				officers = parseThroughOfficerByKingdom(files[i], officers);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return officers;
	}

	/**
	 * @return the officers
	 */
	public List<CharacterI> getOfficers() {
		return officers;
	}

	/**
	 * @return the shu
	 */
	public List<CharacterI> getShu() {
		return shu;
	}

	/**
	 * @return the wu
	 */
	public List<CharacterI> getWu() {
		return wu;
	}

	/**
	 * @return the wei
	 */
	public List<CharacterI> getWei() {
		return wei;
	}

	/**
	 * @return the jin
	 */
	public List<CharacterI> getJin() {
		return jin;
	}

	/**
	 * @return the other
	 */
	public List<CharacterI> getOther() {
		return other;
	}
	
	
}
