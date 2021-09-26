package com.anno.warriors.dw8.manager.images;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.images.model.DynastyWarriors8Image;
import com.anno.warriors.dw8.images.model.Encoded64Image;
import com.anno.warriors.dw8.images.model.WeaponImage;
import com.anno.warriors.dw8.keys.OfficerKingdomKey;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.MappingObjectsWithReference;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.shared.DW8Constants.UpdatedHyphenKey;
import com.anno.warriors.dw8.shared.DW8StaticObjects;
import com.anno.warriors.shared.ApplicationConstants;

@SuppressWarnings("unused")
public class ParsingImages implements DynastyWarriors8Object<ParsingImages> {

	private static Logger logger = LoggerFactory.getLogger(ParsingImages.class);
	private static DynastyWarriors8Object<ParsingImages> instance;
	private static Map<String, List<String>> officerImages = new HashMap<>();
	private static Map<String, String> weaponNamePathMap = new HashMap<>();
	private static Map<OfficerKingdomKey, List<String>> weaponImages = new HashMap<>();
	private static Map<OfficerKingdomKey, Map<String, String>> officerNameToWeaponName = new HashMap<>();
	private static Map<Kingdom, List<CharacterInterface<Character>>> mappedCharsByKingom;
	private String weaponName;
	private String key;

	private static DynastyWarriors8Image weaponImage = null;
	private static List<String> weaponEncoded64Strings = new ArrayList<>();
	private static List<DynastyWarriors8Image> weaponImagesList = new ArrayList<>();
	private static Map<String, List<DynastyWarriors8Image>> mappedWeaponImages = new HashMap<>();
	private static List<?> weaponByteImages = new ArrayList<>();
	private static Map<String, Integer> weaponImageCount = new HashMap<>();
	@SuppressWarnings("unchecked")
	private static MappingObjectsWithReference<String, List<DynastyWarriors8Image>, DynastyWarriors8Image> imageMappingObject = new MappingObjectsWithReference(
			mappedWeaponImages);

	public static DynastyWarriors8Object<ParsingImages> getInstance() {
		if (instance == null) {
			synchronized (ParsingImages.class) {
				if (instance == null) {
					logger.info("ParsingImages instantiated");
					return new ParsingImages();
				}
			}
		}
		return instance;
	}

//	public static void main(String args[]) {
////		CharacterParseManager.getInstance();
////		mappedCharsByKingom = CharacterParseManager.getKingdomCharacterMap();
//		new ParsingImages();
//	}

	private ParsingImages() {
//		readOfficerImageFolder();
//		logger.info("finished reading OfficerImageFolder");
		readWeaponImagesFolder();
//		logger.info("finished reading WeaponImagesFolder");
	}

	public static Map<String, List<String>> getOfficerImages() {
		return officerImages;
	}

	public static Map<OfficerKingdomKey, List<String>> getWeaponImages() {
		return weaponImages;
	}

	public static Map<String, String> getWeaponNamePathMap() {
		return weaponNamePathMap;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	private void readOfficerImageFolder() {
		File folder = new File(DW8Constants.OFFICER_IMAGES_PATH);
		File[] file = folder.listFiles();
		String shortName = DW8Constants.Split.EMPTY.getValue();
		MappingObjectsWithReference<String, List<String>, String> mappingObject = new MappingObjectsWithReference<>(
				officerImages);
		byte[] encoded64List = null;
		for (int i = 0; i < file.length; i++) {
			if (file[i].isDirectory()) {
				continue;
			}
//			file[i].setWritable(true, true);
//			file[i].setReadable(true, true);
//			file[i].setExecutable(true, true);
//			try {
//				String encoded64 = convertImageToBase64(file[i].getPath());
//				Encoded64Image ecd64 = new Encoded64Image(encoded64);
//				encoded64List = ecd64.getImageBytes();
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			file[i].setWritable(false, true);
//			file[i].setReadable(false, true);
//			file[i].setExecutable(false, true);
//			shortName = formatOfficerImageFileNameForKey(file[i].getName());
//			mappingObject.mapKeyValueWithList(shortName, file[i].getPath());
		}
		logger.info("Officer Images mapped");
	}

	private String formatOfficerImageFileNameForKey(String fileName) {
		String[] firstParse = fileName.split(DW8Constants.Split.PERIOD.getValue());
		String removeLastChar = firstParse[0].substring(0, firstParse[0].length() - 2);
		String replaceUnderScore = removeLastChar.replace(DW8Constants.Split.HYPHEN.getValue(),
				DW8Constants.Split.WHITE_SPACE.getValue());
		return replaceUnderScore.trim();
	}

	private void readWeaponImagesFolder() {
		readWeaponsImagesByPath(DW8StaticObjects.getOneStarPathWeaponImageList());
		readWeaponsImagesByPath(DW8StaticObjects.getTwoStarPathWeaponImageList());
		readWeaponsImagesByPath(DW8StaticObjects.getThreeStarPathWeaponImageList());
		readWeaponsImagesByPath(DW8StaticObjects.getFourStarPathWeaponImageList());
		readWeaponsImagesByPath(DW8StaticObjects.getFiveStarPathWeaponImageList());
		readWeaponsImagesByPath(DW8StaticObjects.getSixStarPathWeaponImageList());
		hyphenateKeys();

		System.out.println("{");
		mappedWeaponImages.forEach((k, v) -> {
			System.out.printf("Key : %s\n\tValues : ", k);
			v.stream().forEach(e -> {
				System.out.printf("[%s], ", e.getName());
			});
			System.out.println();
		});
		System.out.println("}");
	}

	private void readWeaponsImagesByPath(String[] paths) {
		File folder = null;
		File[] file = null;
		Kingdom kingdom;
//		MappingObjects<OfficerKingdomKey, Map<String, String>, String> officerWeaponNameMappingObject = new MappingObjects<>(
//				officerNameToWeaponName);

		String key = "";
		String fileLastName = "";
		for (String s : paths) {
			kingdom = getKingdomFromPath(s);

//			List<CharacterInterface<Character>> characters = mappedCharsByKingom.get(kingdom);
//			Optional<CharacterInterface<Character>> opt = null;
//			CharacterInterface<Character> character = null;
			folder = new File(s);
			file = folder.listFiles();
			for (int i = 0; i < file.length; i++) {
				file[i].setWritable(true, true);
				file[i].setReadable(true, true);
				file[i].setExecutable(true, true);
				try {
					weaponName = formatWeaponImageFileName(file[i].getName());
					fileLastName = formatWeaponImageFileNameToGetLastName(file[i].getName());
					key = fileLastName + "_" + kingdom.getValue();
					String encoded64 = convertImageToBase64(file[i].getPath());
					Encoded64Image ecd64 = new Encoded64Image(encoded64, false);
					weaponEncoded64Strings.add(ecd64.getBase64Encoded());
					weaponImage = new WeaponImage(weaponName + " => " + file[i].getName(), weaponEncoded64Strings);
					if(!verifyIfDuplicate(key, weaponImage)) {
						imageMappingObject.mapKeyValueWithList(key.trim().toUpperCase(), weaponImage);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
//				file[i].setWritable(false, true);
//				file[i].setReadable(false, true);
//				file[i].setExecutable(false, true);
//				officerWeaponNameMappingObject.mapKeyValueWithMap(new OfficerKingdomKey(key, kingdom), weaponName,
////						file[i].getPath());
//				weaponNamePathMap.put(weaponName, file[i].getPath());
				mappedWeaponImages = imageMappingObject.getMapObject();
				weaponEncoded64Strings.clear();
//				TODO: Test w/ HTTP REQUEST
			}

//			weaponByteImages.clear();
//			weaponImages = imageMappingObject.getMapObject();
////			officerNameToWeaponName = officerWeaponNameMappingObject.getMapObject();
//			logger.info("Parsed Images from " + s);
		}

	}

	private void hyphenateKeys() {
		addHyphenToKey(DW8Constants.NINE_LAYERED_HEAVEN_FORMAL,
				DW8Constants.UpdatedHyphenKey.NINE_LAYERED_HEAVEN.getValue());
		addHyphenToKey(DW8Constants.BRONZE_STUDDED_STAFF_FORMAL, UpdatedHyphenKey.BRONZE_STUDDED_STAFF.getValue());
		addHyphenToKey(DW8Constants.LIGHT_BREAKING_STAFF_FORMAL,
				DW8Constants.UpdatedHyphenKey.LIGHT_BREAKING_STAFF.getValue());
	}

	private String getCharactersLastName(String lastName) {
		return (lastName.contains(DW8Constants.Split.WHITE_SPACE.getValue()))
				? lastName.split(DW8Constants.Split.WHITE_SPACE.getValue())[1].trim()
				: lastName.trim();
	}

	private String formatWeaponImageFileName(String fileName) {
		String[] splitByPeriod = fileName.split(DW8Constants.Split.PERIOD.getValue());
		String[] splitByHyphen = splitByPeriod[0].split(DW8Constants.Split.HYPHEN.getValue());
		key = splitByHyphen[splitByHyphen.length - 1];
		return formatWeaponNameConditionally(splitByHyphen[0]).trim();
	}

	private String formatWeaponImageFileNameToGetLastName(String fileName) {
		String[] splitByPeriod = fileName.split(DW8Constants.Split.PERIOD.getValue());
		String[] splitByHyphen = splitByPeriod[0].split(DW8Constants.Split.HYPHEN.getValue());
		return splitByHyphen[splitByHyphen.length - 1].trim();
	}

	private String formatWeaponNameConditionally(String preFormattedName) {
		return preFormattedName.contains(DW8Constants.Split.UNDER_SCORE.getValue()) ? preFormattedName
				.replace(DW8Constants.Split.UNDER_SCORE.getValue(), DW8Constants.Split.WHITE_SPACE.getValue())
				: preFormattedName;
	}

	private void addHyphenToKey(String original, String key) {
		String temp = weaponNamePathMap.get(original);
		if (temp == null) {
			return;
		}
		weaponNamePathMap.remove(original);
		weaponNamePathMap.put(key, temp);
	}

	private Kingdom getKingdomFromPath(String path) {
		String[] splitByForwardSlash = path.split(DW8Constants.Split.FWD_SLASH.getValue());
		String str = splitByForwardSlash[splitByForwardSlash.length - 1];
		String caseKingdom = str.substring(0, 1).toUpperCase() + str.substring(1);
		return Kingdom.returnCorrectEnum(caseKingdom.trim());
	}

	private void prepareImageForHttpRequest(String file) {
		HttpURLConnection urlConnection = null;
		DataOutputStream dos = null;
		String lineEnd = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		int bytesRead, bytesAvailable, bufferSize;
		byte[] buffer;
		int maxBufferSize = 1 * 1024 * 1024;
		File sourceFile = new File(file);
		final String uploadFilePath = ApplicationConstants.RESOURCE_PATH + "uploadedImages/officer/";
		try {
			System.out.printf("File : %s", sourceFile.getName());
			// open a URL connection to the Servlet
			FileInputStream fileInputStream = new FileInputStream(sourceFile);
			URL url = new URL("http://localhost:4200/");

			// Open a HTTP connection to the URL
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setDoInput(true); // Allow Inputs
			urlConnection.setDoOutput(true); // Allow Outputs
			urlConnection.setUseCaches(false); // Don't use a Cached Copy
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Connection", "Keep-Alive");
			urlConnection.setRequestProperty("ENCTYPE", "multipart/form-data");
			urlConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			urlConnection.setRequestProperty("uploaded_file", file);
			urlConnection.connect();
			dos = new DataOutputStream(urlConnection.getOutputStream());

//			dos.writeBytes(twoHyphens + boundary + lineEnd);
			// dos.writeBytes("Content-Disposition: form-data;
			// name=\"uploaded_file\";filename=\""
			// + fileName + "\"" + lineEnd);
			dos.writeBytes("Content-Disposition: post-data; name=uploadedfile;filename="
					+ URLEncoder.encode(file, "UTF-8") + lineEnd);
			dos.writeBytes(lineEnd);

			// create a buffer of maximum size
			bytesAvailable = fileInputStream.available();

			bufferSize = Math.min(bytesAvailable, maxBufferSize);
			buffer = new byte[bufferSize];

			// read file and write it into form...
			bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			List<Byte> bytes = new ArrayList<>();
			while (bytesRead > 0) {
				dos.write(buffer, 0, bufferSize);
				bytesAvailable = fileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			}
			System.out.printf("\n%s\n", bytesRead);
//			ImageBytes ib = new ImageBytes(bytes);
//			ib.addByteToList(bytesRead);

			// send multipart form data necesssary after file data...
			dos.writeBytes("\r\n");
			dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

			// Responses from the server (code and message)
			int serverResponseCode = urlConnection.getResponseCode();
			String serverResponseMessage = urlConnection.getResponseMessage();

//			Log.i("uploadFile", "HTTP Response is : " + serverResponseMessage + ": " + serverResponseCode);

			if (serverResponseCode == 200) {

//				runOnUiThread(new Runnable() {
//					public void run() {
//
//						String msg = "File Upload Completed.\n\n See uploaded file here : \n\n"
//								+ " http://www.androidexample.com/media/uploads/" + uploadFileName;
//
//						messageText.setText(msg);
//						Toast.makeText(UploadToServer.this, "File Upload Complete.", Toast.LENGTH_SHORT).show();
//					}
//				});
			}

			// close the streams //
			fileInputStream.close();
			dos.flush();
			dos.close();

		} catch (MalformedURLException ex) {

//			dialog.dismiss();
			ex.printStackTrace();

//			runOnUiThread(new Runnable() {
//				public void run() {
//					messageText.setText("MalformedURLException Exception : check script url.");
//					Toast.makeText(UploadToServer.this, "MalformedURLException", Toast.LENGTH_SHORT).show();
//				}
//			});
//
//			Log.e("Upload file to server", "error: " + ex.getMessage(), ex);
		} catch (Exception e) {
			e.printStackTrace();
//			dialog.dismiss();
//			e.printStackTrace();
//
//			runOnUiThread(new Runnable() {
//				public void run() {
//					messageText.setText("Got Exception : see logcat ");
//					Toast.makeText(Par.this, "Got Exception : see logcat ", Toast.LENGTH_SHORT).show();
//				}
//			});
//			Log.e("Upload file to server Exception", "Exception : " + e.getMessage(), e);
//		}
//		dialog.dismiss();

		}
	}

	private static boolean verifyIfDuplicate(String key, DynastyWarriors8Image value) {
		WeaponImage temp = null;
		if (mappedWeaponImages.containsKey(key)) {
			for (DynastyWarriors8Image i : mappedWeaponImages.get(key))
				if (i.equals(value)) {
					return true;
				}
		}
		return false;
	}

	private String convertImageToBase64(String file) throws IOException {
		byte[] fileContent = FileUtils.readFileToByteArray(new File(file));
		return Base64.getEncoder().encodeToString(fileContent);
	}
}
