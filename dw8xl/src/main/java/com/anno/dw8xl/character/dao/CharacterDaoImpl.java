/**
 * 
 */
package com.anno.dw8xl.character.dao;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.character.model.SubOfficer;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.kingdom.model.Kingdoms;

/**
 * @author Haku Wei
 *
 */
@Service("characterDaoImpl")
public class CharacterDaoImpl {
	
	private List<CharacterI> subOfficers, shuSubs;
	
	public CharacterDaoImpl() {
		subOfficers = new ArrayList<>();
		shuSubs = new ArrayList<>();
	}

	public List<CharacterI> executeAllSubOfficers() {
		subOfficers = parseThroughMultipleSubOfficersTextFiles();
		return subOfficers;
	}
	public List<CharacterI> executeShuSubOfficers() {
		shuSubs = parseThroughShuSubOfficer();
		return shuSubs;
	}
	public List<CharacterI> executeWuSubOfficers() {
		return new ArrayList<>();
	}
	public List<CharacterI> executeWeiSubOfficers() {
		return new ArrayList<>();
	}
	public List<CharacterI> executeJinSubOfficers() {
		return new ArrayList<>();
	}
	public List<CharacterI> executeOtherSubOfficers() {
		return new ArrayList<>();
	}
	
	private List<CharacterI> parseThroughMultipleSubOfficersTextFiles() {
		List<CharacterI> subOfficers = new ArrayList<>();
		List<KingdomI> kingdoms = new ArrayList<>(EnumSet.allOf(Kingdoms.class)); 
		String[] characterPaths = getAllSubOfficerTextFiles();
		
		for (int i = 0 ; i < characterPaths.length; i++) {
			try {
				subOfficers = parseThroughSubOfficerTextFile(characterPaths[i], subOfficers, kingdoms.get(i));
			}
			catch(Exception e) {
				e.getStackTrace();
			}
		};
		return subOfficers;
	}
	
	private List<CharacterI> parseThroughSubOfficerTextFile(String path, List<CharacterI> subOfficers, KingdomI kingdom) {
		CharacterI subOfficerTemp;
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
	
	public String[] getAllSubOfficerTextFiles() {
		return new String[] {
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Shu.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Wu.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Wei.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Jin.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Other.txt",
		};
	}
	
	private List<CharacterI> parseThroughShuSubOfficer() {
		String path = "Text-Files\\characters\\sub-officer\\SubOfficer-List-Shu.txt";
		List<CharacterI> temps = new ArrayList<>();
		KingdomI shu = Kingdoms.SHU;
		File file = new File(path);
		try {
			CharacterI subTemp;
			Scanner z = new Scanner(new FileReader(file));
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				subTemp = new SubOfficer(officerLine[0], shu);
				System.out.println(subTemp.getName().toString());
				temps.add(subTemp);
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return temps;
	}
	
	private List<CharacterI> parseThroughWuSubOfficer() {
		String path = "Text-Files\\characters\\sub-officer\\SubOfficer-List-Wu.txt";
		List<CharacterI> temps = new ArrayList<>();
		KingdomI wu = Kingdoms.WU;
		File file = new File(path);
		try {
			CharacterI subTemp;
			Scanner z = new Scanner(new FileReader(file));
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				subTemp = new SubOfficer(officerLine[0], wu);
				temps.add(subTemp);
			}			
		}
		catch(Exception e) {
			e.getMessage();
		}
		return temps;
	}
	
	private List<CharacterI> parseThroughWeiSubOfficer() {
		String path = "Text-Files\\characters\\sub-officer\\SubOfficer-List-Wei.txt";
		List<CharacterI> temps = new ArrayList<>();
		KingdomI wei = Kingdoms.WEI;
		File file = new File(path);
		try {
			CharacterI subTemp;
			Scanner z = new Scanner(new FileReader(file));
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				subTemp = new SubOfficer(officerLine[0], wei);
				temps.add(subTemp);
			}	
		}
		catch(Exception e) {
			e.getMessage();
		}
		return temps;
	}

	private List<CharacterI> parseThroughJinSubOfficer() {
		String path = "Text-Files\\characters\\sub-officer\\SubOfficer-List-Jin.txt";
		List<CharacterI> temps = new ArrayList<>();
		KingdomI jin = Kingdoms.JIN;
		File file = new File(path);
		try {
			CharacterI subTemp;
			Scanner z = new Scanner(new FileReader(file));
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				subTemp = new SubOfficer(officerLine[0], jin);
				temps.add(subTemp);
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return temps;
	}
	
	private List<CharacterI> parseThroughOtherSubOfficer() {
		String path = "Text-Files\\characters\\sub-officer\\SubOfficer-List-Other.txt";
		List<CharacterI> temps = new ArrayList<>();
		KingdomI other = Kingdoms.OTHER;
		File file = new File(path);
		try {
			CharacterI subTemp;
			Scanner z = new Scanner(new FileReader(file));
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				subTemp = new SubOfficer(officerLine[0], other);
				temps.add(subTemp);
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return temps;
	}

}
