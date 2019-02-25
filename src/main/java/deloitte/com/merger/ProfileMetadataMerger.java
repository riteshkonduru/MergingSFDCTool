package deloitte.com.merger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import deloitte.com.wrap.ClassAccesses;
import deloitte.com.wrap.CustomPermissions;
import deloitte.com.wrap.FieldLevelSecurities;
import deloitte.com.wrap.FieldPermissions;
import deloitte.com.wrap.LayoutAssignments;
import deloitte.com.wrap.ObjectPermissions;
import deloitte.com.wrap.PageAccesses;
import deloitte.com.wrap.Profile;
import deloitte.com.wrap.RecordTypeVisibilities;
import deloitte.com.wrap.TabVisibilities;
import deloitte.com.wrap.UserPermissions;

@RestController
public class ProfileMetadataMerger {

	/*
	 * This method contains Merging/Adding elements to destination xml.
	 * 
	 * */
	@PostMapping("/update")

	public static String updateXmlElements(@RequestBody String compareContent) {
		String readReturn = "";
		Profile profileSource = new Profile();
		Profile profileDest= new Profile();
		final String seperator = new String("\\*SEPARATOR\\*");
		String[] compareContentStr;

		try { 

			if( !compareContent.isEmpty() && compareContent != null) {
				compareContentStr = compareContent.split(seperator);
				System.out.println("Length " + compareContentStr.length);

				if(compareContentStr.length >0) {

					if(compareContentStr[0] != null && !compareContentStr[0].isEmpty()) {

						ObjectMapper objectMapper = new XmlMapper();
						profileSource = objectMapper.readValue(compareContentStr[0], Profile.class);

					}
					if(compareContentStr[1] != null && !compareContentStr[1].isEmpty()) {

						ObjectMapper objectMapperDest = new XmlMapper();
						profileDest = objectMapperDest.readValue(compareContentStr[1].trim(), Profile.class);

					}
				}
				System.out.println("profileDest " + profileDest.toString());
				readReturn = compareTags(profileSource ,profileDest, true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Return");
		return readReturn;

	}

	/*
	 * This method contains delete elements in destination xml.
	 * 
	 * */
	@PostMapping("/delete")

	public static String deleteXmlElements(@RequestBody String compareContent) {
		String readReturn = "";
		Profile profileSource = new Profile();
		Profile profileDest= new Profile();
		final String seperator = new String("\\*SEPARATOR\\*");
		String[] compareContentStr;

		try { 

			if( !compareContent.isEmpty() && compareContent != null) {
				compareContentStr = compareContent.split(seperator);
				System.out.println("Length " + compareContentStr.length);

				if(compareContentStr.length >0) {

					if(compareContentStr[0] != null && !compareContentStr[0].isEmpty()) {

						ObjectMapper objectMapper = new XmlMapper();
						profileSource = objectMapper.readValue(compareContentStr[0], Profile.class);

					}
					if(compareContentStr[1] != null && !compareContentStr[1].isEmpty()) {

						ObjectMapper objectMapperDest = new XmlMapper();
						profileDest = objectMapperDest.readValue(compareContentStr[1].trim(), Profile.class);

					}
				}
				System.out.println("profileDest " + profileDest.toString());
				readReturn = compareTags(profileSource ,profileDest, false);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Return");
		return readReturn;

	}



	public static String compareTags(Profile profileSource, Profile profileDest, boolean isDelete) {
		String xml ="";
		final String tagSeparator = new String("@@@");
		HashMap<String, String> destMap = new HashMap<String, String>();
		HashMap<String, String> sourceMap = new HashMap<String, String>();


		try {
			//String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			//String defaultConfigPath = rootPath + "profileTags.properties";
			//Properties defaultProps = new Properties();
			//defaultProps.load(new FileInputStream(defaultConfigPath));
			//String classAccessesTags = defaultProps.getProperty("classAccessesTags");

			//Source map
			if(profileSource.getClassAccesses() != null){
				for(ClassAccesses tempClass: profileSource.getClassAccesses()) {
					sourceMap.put("classAccesses"+tagSeparator+tempClass.apexClass, tempClass.apexClass+tagSeparator+tempClass.enabled);
				}
			}
			if(profileSource.getPageAccesses() != null) {
				for(PageAccesses tempPage: profileSource.getPageAccesses() ) {
					sourceMap.put("pageAccesses"+tagSeparator+tempPage.apexPage, tempPage.apexPage+tagSeparator+tempPage.enabled);
				}
			}
			if( profileSource.getUserPermissions() != null) {
				for(UserPermissions tempUserP: profileSource.getUserPermissions()) {
					sourceMap.put("userPermissions"+tagSeparator+tempUserP.name, tempUserP.name+tagSeparator+tempUserP.enabled);
				}
			}
			if( profileSource.getTabVisibilities() != null) {
				for(TabVisibilities temp: profileSource.getTabVisibilities()) {
					sourceMap.put("tabVisibilities"+tagSeparator+temp.tab, temp.tab+tagSeparator+temp.visibility);
				}
			}
			if( profileSource.getRecordTypeVisibilities() != null) {
				for(RecordTypeVisibilities temp: profileSource.getRecordTypeVisibilities()) {
					sourceMap.put("recordTypeVisibilities"+tagSeparator+temp.recordType, temp.recordType+tagSeparator+temp.personAccountDefault+tagSeparator+temp.visible+tagSeparator+temp.defaultRecordTypeVisibility);
				}
			}
			if( profileSource.getObjectPermissions() != null) {
				for(ObjectPermissions temp: profileSource.getObjectPermissions()) {
					sourceMap.put("objectPermissions"+tagSeparator+temp.object, temp.object+tagSeparator+temp.allowCreate+tagSeparator+temp.allowDelete +tagSeparator+temp.allowEdit +tagSeparator+temp.allowRead +tagSeparator+temp.modifyAllRecords +tagSeparator+temp.viewAllRecords);
				}
			}
			if( profileSource.getLayoutAssignments() != null) {
				for(LayoutAssignments temp: profileSource.getLayoutAssignments()) {
					sourceMap.put("layoutAssignments"+tagSeparator+temp.layout, temp.layout+tagSeparator+temp.recordType);
				}
			}
			if( profileSource.getFieldPermissions() != null) {
				for(FieldPermissions temp: profileSource.getFieldPermissions()) {
					sourceMap.put("fieldPermissions"+tagSeparator+temp.field, temp.field+tagSeparator+temp.editable+tagSeparator+temp.hidden+tagSeparator+temp.readable);
				}
			}
			if( profileSource.getFieldLevelSecurities() != null) {
				for(FieldLevelSecurities temp: profileSource.getFieldLevelSecurities()) {
					sourceMap.put("fieldLevelSecurities"+tagSeparator+temp.field, temp.field+tagSeparator+temp.editable+tagSeparator+temp.hidden+tagSeparator+temp.readable);
				}
			}
			if( profileSource.getCustomPermissions() != null) {
				for(CustomPermissions temp: profileSource.getCustomPermissions()) {
					sourceMap.put("customPermissions"+tagSeparator+temp.name, temp.name+tagSeparator+temp.enabled);
				}
			}

			//Destination map
			if(profileDest.getClassAccesses() != null) {
				for(ClassAccesses tempClassDest: profileDest.getClassAccesses()) {
					destMap.put("classAccesses"+tagSeparator+tempClassDest.apexClass, tempClassDest.apexClass+tagSeparator+tempClassDest.enabled);
				}
			}
			if(profileDest.getPageAccesses() != null) {
				for(PageAccesses tempPageDest: profileDest.getPageAccesses()) {
					destMap.put("pageAccesses"+tagSeparator+tempPageDest.apexPage, tempPageDest.apexPage+tagSeparator+tempPageDest.enabled);
				}
			}
			if(profileDest.getUserPermissions() != null) {
				for(UserPermissions tempUserPDest: profileDest.getUserPermissions()) {
					destMap.put("userPermissions"+tagSeparator+tempUserPDest.name, tempUserPDest.name+tagSeparator+tempUserPDest.enabled);
				}
			}
			if( profileDest.getTabVisibilities() != null) {
				for(TabVisibilities temp: profileDest.getTabVisibilities()) {
					destMap.put("tabVisibilities"+tagSeparator+temp.tab, temp.tab+tagSeparator+temp.visibility);
				}
			}
			if( profileDest.getRecordTypeVisibilities() != null) {
				for(RecordTypeVisibilities temp: profileDest.getRecordTypeVisibilities()) {
					destMap.put("recordTypeVisibilities"+tagSeparator+temp.recordType, temp.recordType+tagSeparator+temp.personAccountDefault+tagSeparator+temp.visible+tagSeparator+temp.defaultRecordTypeVisibility);
				}
			}
			if( profileDest.getObjectPermissions() != null) {
				for(ObjectPermissions temp: profileDest.getObjectPermissions()) {
					destMap.put("objectPermissions"+tagSeparator+temp.object, temp.object+tagSeparator+temp.allowCreate+tagSeparator+temp.allowDelete +tagSeparator+temp.allowEdit +tagSeparator+temp.allowRead +tagSeparator+temp.modifyAllRecords +tagSeparator+temp.viewAllRecords);
				}
			}
			if( profileDest.getLayoutAssignments() != null) {
				for(LayoutAssignments temp: profileDest.getLayoutAssignments()) {
					destMap.put("layoutAssignments"+tagSeparator+temp.layout, temp.layout+tagSeparator+temp.recordType);
				}
			}
			if( profileDest.getFieldPermissions() != null) {
				for(FieldPermissions temp: profileDest.getFieldPermissions()) {
					destMap.put("fieldPermissions"+tagSeparator+temp.field, temp.field+tagSeparator+temp.editable+tagSeparator+temp.hidden+tagSeparator+temp.readable);
				}
			}
			if( profileDest.getFieldLevelSecurities() != null) {
				for(FieldLevelSecurities temp: profileDest.getFieldLevelSecurities()) {
					destMap.put("fieldLevelSecurities"+tagSeparator+temp.field, temp.field+tagSeparator+temp.editable+tagSeparator+temp.hidden+tagSeparator+temp.readable);
				}
			}
			if( profileDest.getCustomPermissions() != null) {
				for(CustomPermissions temp: profileDest.getCustomPermissions()) {
					destMap.put("customPermissions"+tagSeparator+temp.name, temp.name+tagSeparator+temp.enabled);
				}
			}
			List<String> removeKeys = new ArrayList<String>();

			//This is to compare all the tags.
			if(destMap.size() >0 && destMap != null && sourceMap.size() >0 && sourceMap != null ) {//To compare and update

				for(String removeDest :destMap.keySet()) {
					if(!sourceMap.containsKey(removeDest)) {
						removeKeys.add(removeDest);
					}

				}
				if(removeKeys.size()>0 && removeKeys !=null) {
					for(String keys: removeKeys) {
						destMap.remove(keys);
					}
				}

				if(isDelete) {//if the function call is not delete
					for(String tempkey :sourceMap.keySet()) {
						if(destMap.containsKey(tempkey) && (!destMap.get(tempkey).equals(sourceMap.get(tempkey)))) {//update the value if contains and add key/value if dosen't contains.
							destMap.put(tempkey, sourceMap.get(tempkey));
						}else if(!destMap.containsKey(tempkey)) {
							destMap.put(tempkey, sourceMap.get(tempkey));
						}
					}
				}
			}

			List<ClassAccesses> lstTempCA = new ArrayList<>();
			List<PageAccesses> lstTempPA = new ArrayList<>();
			List<UserPermissions> lstTempUP = new ArrayList<>();
			List<TabVisibilities> lstTempTV = new ArrayList<>();
			List<RecordTypeVisibilities> lstTempRTV = new ArrayList<>();
			List<ObjectPermissions> lstTempOP = new ArrayList<>();
			List<LayoutAssignments> lstTempLA = new ArrayList<>();
			List<FieldPermissions> lstTempFP = new ArrayList<>();
			List<FieldLevelSecurities> lstTempFL = new ArrayList<>();
			List<CustomPermissions> lstTempC = new ArrayList<>();


			//Create and add
			for(String keysSourcemap: destMap.keySet()) {
				String[] arrOfStr = keysSourcemap.split(tagSeparator, 2); 

				if(arrOfStr[0].equals("classAccesses")) {

					ClassAccesses tempclass = new ClassAccesses();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					tempclass.apexClass =arrOfStrclassAccessesTag[0];
					tempclass.enabled =arrOfStrclassAccessesTag[1];
					if(isDelete) {
						profileDest.classAccesses.add(tempclass);
					}else {
						lstTempCA.add(tempclass);
						profileDest.setClassAccesses(lstTempCA);

					}
				}
				if(arrOfStr[0].equals("pageAccesses")) {

					PageAccesses tempPage = new PageAccesses();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					tempPage.apexPage =arrOfStrclassAccessesTag[0];
					tempPage.enabled =arrOfStrclassAccessesTag[1];
					if(isDelete) {
						profileDest.pageAccesses.add(tempPage);
					}else {
						lstTempPA.add(tempPage);
						profileDest.setPageAccesses(lstTempPA);
					}
				}
				if(arrOfStr[0].equals("userPermissions")) {

					UserPermissions tempUser = new UserPermissions();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					tempUser.name =arrOfStrclassAccessesTag[0];
					tempUser.enabled =arrOfStrclassAccessesTag[1];
					if(isDelete) {
						profileDest.userPermissions.add(tempUser);
					}else {
						lstTempUP.add(tempUser);
						profileDest.setUserPermissions(lstTempUP);
					}
				}
				if(arrOfStr[0].equals("tabVisibilities")) {

					TabVisibilities temp = new TabVisibilities();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					temp.tab =arrOfStrclassAccessesTag[0];
					temp.visibility =arrOfStrclassAccessesTag[1];
					if(isDelete) {
						profileDest.tabVisibilities.add(temp);
					}else {
						lstTempTV.add(temp);
						profileDest.setTabVisibilities(lstTempTV);
					}
				}
				if(arrOfStr[0].equals("recordTypeVisibilities")) {

					RecordTypeVisibilities temp = new RecordTypeVisibilities();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					temp.recordType =arrOfStrclassAccessesTag[0];
					temp.personAccountDefault =arrOfStrclassAccessesTag[1].equals("true")?true:false;
					temp.visible =arrOfStrclassAccessesTag[1].equals("true")?true:false;
					temp.defaultRecordTypeVisibility =arrOfStrclassAccessesTag[1].equals("true")?true:false;
					if(isDelete) {
						profileDest.recordTypeVisibilities.add(temp);
					}else {
						lstTempRTV.add(temp);
						profileDest.setRecordTypeVisibilities(lstTempRTV);
					}

				}
				if(arrOfStr[0].equals("objectPermissions")) {

					ObjectPermissions temp = new ObjectPermissions();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					temp.object =arrOfStrclassAccessesTag[0];
					temp.allowCreate =arrOfStrclassAccessesTag[1].equals("true")?true:false;
					temp.allowDelete =arrOfStrclassAccessesTag[2].equals("true")?true:false;
					temp.allowEdit =arrOfStrclassAccessesTag[3].equals("true")?true:false;
					temp.allowRead =arrOfStrclassAccessesTag[4].equals("true")?true:false;
					temp.modifyAllRecords =arrOfStrclassAccessesTag[5].equals("true")?true:false;
					temp.viewAllRecords =arrOfStrclassAccessesTag[6].equals("true")?true:false;
					if(isDelete) {
						profileDest.objectPermissions.add(temp);
					}else {
						lstTempOP.add(temp);
						profileDest.setObjectPermissions(lstTempOP);
					}
					System.out.println("profileDest " + profileDest.getObjectPermissions());
				}
				if(arrOfStr[0].equals("layoutAssignments")) {

					LayoutAssignments temp = new LayoutAssignments();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					temp.layout =arrOfStrclassAccessesTag[0];
					temp.recordType =arrOfStrclassAccessesTag[1];
					if(isDelete) {
						profileDest.layoutAssignments.add(temp);
					}else {
						lstTempLA.add(temp);
						profileDest.setLayoutAssignments(lstTempLA);
					}
				}
				if(arrOfStr[0].equals("fieldPermissions")) {

					FieldPermissions temp = new FieldPermissions();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					temp.field =arrOfStrclassAccessesTag[0];
					temp.editable =arrOfStrclassAccessesTag[1].equals("true")?true:false;
					temp.hidden =arrOfStrclassAccessesTag[2].equals("true")?true:false;
					temp.readable =arrOfStrclassAccessesTag[3].equals("true")?true:false;
					if(isDelete) {
						profileDest.fieldPermissions.add(temp);
					}else {
						lstTempFP.add(temp);
						profileDest.setFieldPermissions(lstTempFP);
					}
				}
				if(arrOfStr[0].equals("fieldLevelSecurities")) {

					FieldLevelSecurities temp = new FieldLevelSecurities();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					temp.field =arrOfStrclassAccessesTag[0];
					temp.editable =arrOfStrclassAccessesTag[1].equals("true")?true:false;
					temp.hidden =arrOfStrclassAccessesTag[2].equals("true")?true:false;
					temp.readable =arrOfStrclassAccessesTag[3].equals("true")?true:false;
					if(isDelete) {
						profileDest.fieldLevelSecurities.add(temp);
					}else {
						lstTempFL.add(temp);
						profileDest.setFieldLevelSecurities(lstTempFL);
					}
				}
				if(arrOfStr[0].equals("customPermissions")) {

					CustomPermissions temp = new CustomPermissions();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					temp.name =arrOfStrclassAccessesTag[0];
					temp.enabled = arrOfStrclassAccessesTag[1].equals("true")?true:false;
					if(isDelete) {
						profileDest.customPermissions.add(temp);
					}else {
						lstTempC.add(temp);
						profileDest.setCustomPermissions(lstTempC);
					}
				}

			}

			XmlMapper xmlMapper = new XmlMapper();
			xml = xmlMapper.writeValueAsString(profileDest);
			System.out.println("xml  " + xml);
		}catch(Exception ex) {
			ex.printStackTrace(); 
			System.out.println(ex); 
		}
		return xml;
	}
}

