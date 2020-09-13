/**
 * 
 */
package com.dw8xl.restdw8xl.Controller;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.model.character.SubOfficer;
import com.dw8xl.restdw8xl.model.kingdom.Kingdom;
import com.dw8xl.restdw8xl.model.kingdom.KingdomI;
import com.dw8xl.restdw8xl.model.weapon.Affinity;
import com.dw8xl.restdw8xl.model.weapon.Type;
import com.dw8xl.restdw8xl.model.weapon.Weapon;
import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;

/**
 * @author Haku Wei
 *
 */
/**
 * @author Haku Wei
 *
 */
public class SampleListController {

	private List<CharacterI> officers;
	private List<CharacterI> subOfficers;
	private CharacterI subOfficerTemp;
	private List<Type> types;
	private List<Affinity> affinities;
	private List<KingdomI> kingdoms;
	private List<Weapon> weapons;
	private List<List<AttributeI>> attributes;

	public SampleListController() {
		subOfficers = new ArrayList<>();
		kingdoms = new ArrayList<>();
	}
	
	public List<CharacterI> parseThroughSubOfficerTextFileByKingdom(Kingdom kingdom) {
		List<CharacterI> subOfficers = new ArrayList<>();
		File file = new File(getPath(kingdom));
		try {
			Scanner z = new Scanner(new FileReader(file));
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				subOfficerTemp = new SubOfficer(officerLine[0], kingdom);
				subOfficers.add(subOfficerTemp);
			}
			
		}
		catch(Exception e) {
			e.getMessage();
		}
		return subOfficers;
		
	}
	
	public List<CharacterI> parseThroughMultipleSubOfficersTextFiles() {
		String[] paths = {
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Jin.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Other.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Shu.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Wei.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Wu.txt"
		};
		Kingdom[] kingdoms = {
				new Kingdom("Jin"),
				new Kingdom("Other"),
				new Kingdom("Shu"),
				new Kingdom("Wei"),
				new Kingdom("Wu")
		};
		
		for (int i = 0 ; i < paths.length; i++) {
			subOfficers = parseThroughSubOfficerTextFile(paths[i], subOfficers, kingdoms[i]);
		};
		
		return subOfficers;
	}

	private List<CharacterI> parseThroughSubOfficerTextFile(String path, List<CharacterI> subOfficers, Kingdom kingdom) {
		File file = new File(path);
		try {
			Scanner z = new Scanner(new FileReader(file));
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				subOfficerTemp = new SubOfficer(officerLine[0], kingdom);
				subOfficers.add(subOfficerTemp);
			}
			
		}
		catch(Exception e) {
			e.getMessage();
		}
		return subOfficers;
	}
	
	public Integer getSubOfficerCount() {
		return subOfficers.size();
	}
	
	public CharacterI getSubOfficerByName(String name) {
		return subOfficers.stream().filter(c -> c.getName().equals(name)).collect(Collectors.toList()).get(0);
	}

	public List<CharacterI> getSubOfficersByWildCard(String wildStr) {
		return subOfficers.stream().filter(c -> c.getName().contains(wildStr)).collect(Collectors.toList());
	}
	
	public String getPath(Kingdom kingdom) {
		String path = "";
		if(kingdom.getName().equalsIgnoreCase("Other")) {
			path = "Text-Files\\characters\\sub-officer\\SubOfficer-List-Jin.txt";
		}
		else if(kingdom.getName().equalsIgnoreCase("Shu")) {
			path = "Text-Files\\characters\\sub-officer\\SubOfficer-List-Shu.txt";
		}
		else if(kingdom.getName().equalsIgnoreCase("Wei")) {
			path = "Text-Files\\characters\\sub-officer\\SubOfficer-List-Wei.txt";
		}
		else if(kingdom.getName().equalsIgnoreCase("wu")) {
			path = "Text-Files\\characters\\sub-officer\\SubOfficer-List-Wu.txt";
		}
		else {
			path = "Text-Files\\characters\\sub-officer\\SubOfficer-List-Other.txt";
		}
		return path;
	}
	
	

}
