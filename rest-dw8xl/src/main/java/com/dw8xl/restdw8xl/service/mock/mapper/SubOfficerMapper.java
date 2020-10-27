/**
 * 
 */
package com.dw8xl.restdw8xl.service.mock.mapper;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.model.character.SubOfficer;
import com.dw8xl.restdw8xl.model.kingdom.Kingdom;

/**
 * @author Haku Wei
 *
 */
@Service
//@Qualifier("subMapper")
public class SubOfficerMapper implements SubOfficerMapperI {
	
	public List<CharacterI> queryAllSubOfficers() {
		return parseThroughMultipleSubOfficersTextFiles();
	}
	
	public List<CharacterI> queryShuSubOfficers() {
		return parseThroughShuSubOfficer();
	}
	public List<CharacterI> queryWuSubOfficers() {
		return parseThroughWuSubOfficer();
	}
	public List<CharacterI> queryWeiSubOfficers() {
		return parseThroughWeiSubOfficer();
	}
	public List<CharacterI> queryJinSubOfficers() {
		return parseThroughJinSubOfficer();
	}
	public List<CharacterI> queryOtherSubOfficers() {
		return parseThroughOtherSubOfficer();
	}
	
	private List<CharacterI> parseThroughMultipleSubOfficersTextFiles() {
		List<CharacterI> subOfficers = new ArrayList<>();
		Kingdom[] kingdoms = generateKingdoms();
		String[] characterPaths = getAllSubOfficerTextFiles();
		
		for (int i = 0 ; i < characterPaths.length; i++) {
			try {
				subOfficers = parseThroughSubOfficerTextFile(characterPaths[i], subOfficers, kingdoms[i]);				
			}
			catch(Exception e) {
				e.getStackTrace();
			}
		};
		
		return subOfficers;
	}
	
	private String[] getAllSubOfficerTextFiles() {
		return new String[] {
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Jin.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Other.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Shu.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Wei.txt",
				"Text-Files\\characters\\sub-officer\\SubOfficer-List-Wu.txt"
		};
	}
	
	private Kingdom[] generateKingdoms() {
		return new Kingdom[]
				{
					new Kingdom("Jin"),
					new Kingdom("Other"),
					new Kingdom("Shu"),
					new Kingdom("Wei"),
					new Kingdom("Wu") 
				};
	}
	
	private List<CharacterI> parseThroughSubOfficerTextFile(String path, List<CharacterI> subOfficers, Kingdom kingdom) {
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
	
	private List<CharacterI> parseThroughShuSubOfficer() {
		String path = "Text-Files\\characters\\sub-officer\\SubOfficer-List-Shu.txt";
		List<CharacterI> temps = new ArrayList<>();
		Kingdom shu = new Kingdom("Shu");
		File file = new File(path);
		try {
			CharacterI subTemp;
			Scanner z = new Scanner(new FileReader(file));
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				subTemp = new SubOfficer(officerLine[0], shu);
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
		Kingdom wu = new Kingdom("Wu");
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
		Kingdom wei = new Kingdom("Wei");
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
		Kingdom jin = new Kingdom("Jin");
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
		Kingdom other = new Kingdom("Other");
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
