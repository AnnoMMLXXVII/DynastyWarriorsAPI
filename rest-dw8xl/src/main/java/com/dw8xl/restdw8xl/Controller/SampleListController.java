/**
 * 
 */
package com.dw8xl.restdw8xl.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.model.character.Officer;
import com.dw8xl.restdw8xl.model.character.SubOfficer;
import com.dw8xl.restdw8xl.model.kingdom.Kingdom;
import com.dw8xl.restdw8xl.model.kingdom.KingdomI;
import com.dw8xl.restdw8xl.model.weapon.WeaponI;
import com.dw8xl.restdw8xl.model.weapon.affinity.Affinity;
import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeDNE;
import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;
import com.dw8xl.restdw8xl.model.weapon.attribute.Normal;
import com.dw8xl.restdw8xl.model.weapon.attribute.Special;
import com.dw8xl.restdw8xl.model.weapon.attribute.level.Level;
import com.dw8xl.restdw8xl.model.weapon.attribute.level.LevelI;
import com.dw8xl.restdw8xl.model.weapon.category.Category;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryDNE;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryI;
import com.dw8xl.restdw8xl.model.weapon.classifications.Legend;
import com.dw8xl.restdw8xl.model.weapon.classifications.Rare;
import com.dw8xl.restdw8xl.model.weapon.classifications.Unique;
import com.dw8xl.restdw8xl.model.weapon.length.Length;
import com.dw8xl.restdw8xl.model.weapon.type.Type;

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
	private CharacterI subOfficerTemp, officerTemp;
	private List<Type> types;
	private List<Affinity> affinities;
	private List<KingdomI> kingdoms;
	private List<WeaponI> weapons;
	private List<List<AttributeI>> attributes;

	public SampleListController() {
		subOfficers = new ArrayList<>();
		kingdoms = new ArrayList<>();
	}
	
	public List<CharacterI> parseThroughOfficerTextFileByKingdom(Kingdom kingdom) {
		List<CharacterI> officers = new ArrayList<>();
		File file = new File(getPath(kingdom));
		try {
			Scanner z = new Scanner(new FileReader(file));
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				officerTemp = new Officer(officerLine[0], new Kingdom(officerLine[1]), new Type(officerLine[2], new CategoryDNE()));
				officers.add(officerTemp);
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return officers;
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
	
	public Map<String,List<AttributeI>> parseThroughWeaponAttributeLevelTextFiles() {
		String path = "whirlwind\\WeaponAttributeLevel.txt";
		Map<String, List<AttributeI>> attLvlMap = parseThroughWeaponAttributeLevelTextFile(path);
		return attLvlMap;
	}
	
	public List<WeaponI> parseThroughMultipleWeaponTextFiles() {
		String[] weaponPaths = {
				"whirlwind\\NormalWeapons.txt",
				"whirlwind\\RareWeapons.txt",
				"whirlwind\\UniqueWeapons-5-Stars.txt",
				"whirlwind\\XLWeapons-6-Stars.txt"
		};
		
		for (int i = 0; i < weaponPaths.length; i++) {
			weapons = parseThroughWeaponTextFile(weaponPaths[i]);
		}
		
		return weapons;
	}
	
	
	
	private String[] getAllOfficerPaths() {
		return new String[] {
				"Text-Files\\characters\\officer\\Officer-List-Jin.txt",
				"Text-Files\\characters\\officer\\Officer-List-Other.txt",
				"Text-Files\\characters\\officer\\Officer-List-Shu.txt",
				"Text-Files\\characters\\officer\\Officer-List-Wei.txt",
				"Text-Files\\characters\\officer\\Officer-List-Wu.txt"
			};
	}
	
	public List<CharacterI> parseThroughMultipleSubOfficersTextFiles() {
		String[] characterPaths = {
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
		
		for (int i = 0 ; i < characterPaths.length; i++) {
			subOfficers = parseThroughSubOfficerTextFile(characterPaths[i], subOfficers, kingdoms[i]);
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
	
	private List<WeaponI> parseThroughNormalWeaponTextFile(String path) {
		File file = new File(path);
		List<WeaponI> weapons = new ArrayList<WeaponI>();
		WeaponI weapon;
		CategoryI whirl = new Category("Whirlwind Master");
		try {
			Scanner z = new Scanner(new FileReader(file));
			String[] weaponLine = null;
			while(z.hasNextLine()) {
				String line = z.nextLine();
				weaponLine = line.split(",");
				weapon = new com.dw8xl.restdw8xl.model.weapon.classifications.Normal(
						weaponLine[0],
						Integer.parseInt(weaponLine[1]),
						new Length(weaponLine[2]),
						Integer.parseInt(weaponLine[3]),
						new Type(weaponLine[4], whirl)
						);
				weapons.add(weapon);
			}
			z.close();
		}catch(Exception e) {
			e.getMessage();
		}
		return weapons;
	}
	
	public List<WeaponI> parseThroughRareWeaponTextFile(String path, Map<String, List<AttributeI>> mapped) {
		File file = new File(path);
		List<WeaponI> weapons = new ArrayList<WeaponI>();
		WeaponI weapon;
		CategoryI whirl = new Category("Whirlwind Master");
		try {
			Scanner z = new Scanner(new FileReader(file));
			String[] weaponLine = null;
			while(z.hasNextLine()) {
				String line = z.nextLine();
				weaponLine = line.split(",");
				List<AttributeI> attributes = mapped.get(weaponLine[0]);
				weapon = new Rare(
						weaponLine[0].trim(),
						Integer.parseInt(weaponLine[1].trim()),
						new Affinity(weaponLine[2].trim()),
						Integer.parseInt(weaponLine[3].trim()),
						new Type(weaponLine[4].trim(), whirl),
						attributes
						);
				weapons.add(weapon);
			}
			z.close();
		}catch(Exception e) {
			e.getMessage();
		}
		return weapons;
	}
	
	private List<WeaponI> parseThroughUniqueWeaponTextFile(String path, Map<String, List<AttributeI>> mapped) {
		File file = new File(path);
		List<WeaponI> weapons = new ArrayList<WeaponI>();
		WeaponI weapon;
		CategoryI whirl = new Category("Whirlwind Master");
		try {
			Scanner z = new Scanner(new FileReader(file));
			String[] weaponLine = null;
			while(z.hasNextLine()) {
				String line = z.nextLine();
				weaponLine = line.split(",");
				List<AttributeI> attributes = mapped.get(weaponLine[0]);
				weapon = new Unique(
						weaponLine[0].trim(),
						Integer.parseInt(weaponLine[1].trim()),
						new Affinity(weaponLine[2].trim()),
						Integer.parseInt(weaponLine[3].trim()),
						new Type(weaponLine[4].trim(), whirl),
						attributes
						);
				weapons.add(weapon);
			}
			z.close();
		}catch(Exception e) {
			e.getMessage();
		}
		return weapons;
	}
	
	private List<WeaponI> parseThroughLegendWeaponTextFile(String path, Map<String, List<AttributeI>> mapped) {
		File file = new File(path);
		List<WeaponI> weapons = new ArrayList<WeaponI>();
		WeaponI weapon;
		CategoryI whirl = new Category("Whirlwind Master");
		try {
			Scanner z = new Scanner(new FileReader(file));
			String[] weaponLine = null;
			while(z.hasNextLine()) {
				String line = z.nextLine();
				weaponLine = line.split(",");
				List<AttributeI> attributes = mapped.get(weaponLine[0]);
				weapon = new Legend(
						weaponLine[0].trim(),
						Integer.parseInt(weaponLine[1].trim()),
						new Affinity(weaponLine[2].trim()),
						Integer.parseInt(weaponLine[3].trim()),
						new Type(weaponLine[4].trim(), whirl),
						attributes
						);
				weapons.add(weapon);
			}
			z.close();
		}catch(Exception e) {
			e.getMessage();
		}
		return weapons;
	}
	
	
	private List<WeaponI> parseThroughWeaponTextFile(String path) {
		return null;
	}
	
	private Map<String, List<AttributeI>> parseThroughWeaponAttributeLevelTextFile(String path) {
		Map<String, List<AttributeI>> temp = new HashMap<String, List<AttributeI>>();
		Scanner z;
		String[] attributeLine = null;
		try {
			z = new Scanner(new FileReader(path));
			while(z.hasNextLine()) {
				String line = z.nextLine();
				attributeLine = line.split(",");
				temp.put(attributeLine[0], listifyAttributes(attributeLine));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	private List<AttributeI> listifyAttributes(String...attr) {
		List<AttributeI> temp = new ArrayList<>();
		for(int i = 1; i < attr.length; i++) {
			temp.add(mapThroughAttribute(attr[i]));
		}
		return temp;
	}
	
	private AttributeI mapThroughAttribute(String str) {
		LevelI lvl;
		AttributeI attribute = new AttributeDNE();
		Scanner z = new Scanner(str);
		String[] regex = null;
		while(z.hasNextLine()) {
			String line = z.nextLine().trim();
//			System.out.println(line);
			// Normal vs Special Attribute
			if(!line.contains(":")) {
				attribute = new Special(line.trim());
			}
			else {
				regex = line.split(":");
				lvl = new Level(Integer.parseInt(regex[1].trim()));
				attribute = new Normal(regex[0].trim(), lvl);
			}
		}
		z.close();
		return attribute; 
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
