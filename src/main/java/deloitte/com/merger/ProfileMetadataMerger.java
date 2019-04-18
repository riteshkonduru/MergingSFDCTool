package deloitte.com.merger;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

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
	
	public static final String tagSeparator = new String("@@@");
	public static final String seperator = new String("\\*SEPARATOR\\*");

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
			return "Exception when deseralization";
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
	public static HashMap<String, String> createMap(Profile objProfile) {
		
		HashMap<String, String> mapCompare = new HashMap<String, String>();
		
		//String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		//String defaultConfigPath = rootPath + "profileTags.properties";
		//Properties defaultProps = new Properties();
		//defaultProps.load(new FileInputStream(defaultConfigPath));
		//String classAccessesTags = defaultProps.getProperty("classAccessesTags");
		
		//Source map
		if(objProfile.getClassAccesses() != null){
			for(ClassAccesses tempClass: objProfile.getClassAccesses()) {
				mapCompare.put("classAccesses"+tagSeparator+tempClass.apexClass+tagSeparator+tempClass.enabled, 
															tempClass.apexClass+tagSeparator+tempClass.enabled);
			}
		}
		if(objProfile.getPageAccesses() != null) {
			for(PageAccesses tempPage: objProfile.getPageAccesses() ) {
				mapCompare.put("pageAccesses"+tagSeparator+tempPage.apexPage+tagSeparator+tempPage.enabled, 
															tempPage.apexPage+tagSeparator+tempPage.enabled);
			}
		}
		if( objProfile.getUserPermissions() != null) {
			for(UserPermissions tempUserP: objProfile.getUserPermissions()) {
				mapCompare.put("userPermissions"+tagSeparator+tempUserP.name+tempUserP.enabled, 
																tempUserP.name+tagSeparator+tempUserP.enabled);
			}
		}
		if( objProfile.getTabVisibilities() != null) {
			for(TabVisibilities temp: objProfile.getTabVisibilities()) {
				mapCompare.put("tabVisibilities"+tagSeparator+temp.tab+tagSeparator+temp.visibility, 
																temp.tab+tagSeparator+temp.visibility);
			}
		}
		if( objProfile.getRecordTypeVisibilities() != null) {
			for(RecordTypeVisibilities temp: objProfile.getRecordTypeVisibilities()) {
				mapCompare.put("recordTypeVisibilities"+tagSeparator+temp.recordType+tagSeparator+temp.personAccountDefault+tagSeparator+temp.visible+tagSeparator+temp.defaultRecordTypeVisibility, 
																	  temp.recordType+tagSeparator+temp.personAccountDefault+tagSeparator+temp.visible+tagSeparator+temp.defaultRecordTypeVisibility);
			}
		}
		if( objProfile.getObjectPermissions() != null) {
			for(ObjectPermissions temp: objProfile.getObjectPermissions()) {
				mapCompare.put("objectPermissions"+tagSeparator+temp.object+tagSeparator+temp.allowCreate+tagSeparator+temp.allowDelete +tagSeparator+temp.allowEdit +tagSeparator+temp.allowRead +tagSeparator+temp.modifyAllRecords +tagSeparator+temp.viewAllRecords, 
																 temp.object+tagSeparator+temp.allowCreate+tagSeparator+temp.allowDelete +tagSeparator+temp.allowEdit +tagSeparator+temp.allowRead +tagSeparator+temp.modifyAllRecords +tagSeparator+temp.viewAllRecords);
			}
		}
		if( objProfile.getLayoutAssignments() != null) {
			for(LayoutAssignments temp: objProfile.getLayoutAssignments()) {
				mapCompare.put("layoutAssignments"+tagSeparator+temp.layout+tagSeparator+temp.recordType, 
																 temp.layout+tagSeparator+temp.recordType);
			}
		}
		if( objProfile.getFieldPermissions() != null) {
			for(FieldPermissions temp: objProfile.getFieldPermissions()) {
				mapCompare.put("fieldPermissions"+tagSeparator+temp.field+tagSeparator+temp.editable+tagSeparator+temp.hidden+tagSeparator+temp.readable, 
																temp.field+tagSeparator+temp.editable+tagSeparator+temp.hidden+tagSeparator+temp.readable);
			}
		}
		if( objProfile.getFieldLevelSecurities() != null) {
			for(FieldLevelSecurities temp: objProfile.getFieldLevelSecurities()) {
				mapCompare.put("fieldLevelSecurities"+tagSeparator+temp.field+tagSeparator+temp.editable+tagSeparator+temp.hidden+tagSeparator+temp.readable, 
																	temp.field+tagSeparator+temp.editable+tagSeparator+temp.hidden+tagSeparator+temp.readable);
			}
		}
		if( objProfile.getCustomPermissions() != null) {
			for(CustomPermissions temp: objProfile.getCustomPermissions()) {
				mapCompare.put("customPermissions"+tagSeparator+temp.name+tagSeparator+temp.enabled, 
																 temp.name+tagSeparator+temp.enabled);
			}
		}

		return mapCompare;
	}



	public static String compareTags(Profile profileSource, Profile profileDest, boolean isDelete) {
		String xml ="";
		List<String> removeKeys = new ArrayList<String>();
		HashMap<String, String> destMap = createMap(profileDest);
		HashMap<String, String> sourceMap =createMap(profileSource);
		Profile profileDestFinal = new Profile();
		
		try {

			//This is to compare all the tags.
			if(destMap.size() >0 && destMap != null && sourceMap.size() >0 && sourceMap != null ) {//To compare and update

				for(String removeDest :destMap.keySet()) {
					System.out.println("removeDest " + removeDest + " " + !sourceMap.containsKey(removeDest) );
					if(!sourceMap.containsKey(removeDest)) {
						System.out.println("removeDest inside " + removeDest + " " + !sourceMap.containsKey(removeDest) );
						removeKeys.add(removeDest);
					}

				}
				if(removeKeys.size()>0 && removeKeys !=null) {
					for(String keys: removeKeys) {
						destMap.remove(keys);
					}
				}
				System.out.println("destMap " + destMap.size());

				if(isDelete) {//if the function call is not delete
					for(String tempkey :sourceMap.keySet()) {
						if(destMap.containsKey(tempkey) && (!destMap.get(tempkey).equals(sourceMap.get(tempkey)))) {//update the value if contains and add key/value if dosen't contains.
							destMap.put(tempkey, sourceMap.get(tempkey));
						}else if(!destMap.containsKey(tempkey)) {
							destMap.put(tempkey, sourceMap.get(tempkey));
						}
					}
				}
				System.out.println("destMap after update " + destMap.size() +" " + destMap);
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
			
			profileDestFinal.classAccesses = lstTempCA;
			profileDestFinal.pageAccesses = lstTempPA;
			profileDestFinal.userPermissions = lstTempUP;
			profileDestFinal.tabVisibilities = lstTempTV;
			profileDestFinal.recordTypeVisibilities = lstTempRTV;
			profileDestFinal.objectPermissions = lstTempOP;
			profileDestFinal.layoutAssignments = lstTempLA;
			profileDestFinal.fieldPermissions = lstTempFP;
			profileDestFinal.fieldLevelSecurities = lstTempFL;
			profileDestFinal.customPermissions = lstTempC;


			//Create and add
			for(String keysSourcemap: destMap.keySet()) {
				String[] arrOfStr = keysSourcemap.split(tagSeparator, 2); 

				if(arrOfStr[0].equals("classAccesses")) {

					ClassAccesses tempclass = new ClassAccesses();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					tempclass.apexClass =arrOfStrclassAccessesTag[0];
					tempclass.enabled =arrOfStrclassAccessesTag[1];
					if(isDelete) {
						System.out.println("In classaccess " + tempclass);
						profileDestFinal.classAccesses.add(tempclass);
					}else {
						System.out.println("In classaccess else " + tempclass);
						lstTempCA.add(tempclass);
						profileDestFinal.setClassAccesses(lstTempCA);

					}
				}
				if(arrOfStr[0].equals("pageAccesses")) {

					PageAccesses tempPage = new PageAccesses();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					tempPage.apexPage =arrOfStrclassAccessesTag[0];
					tempPage.enabled =arrOfStrclassAccessesTag[1];
					if(isDelete) {
						profileDestFinal.pageAccesses.add(tempPage);
					}else {
						lstTempPA.add(tempPage);
						profileDestFinal.setPageAccesses(lstTempPA);
					}
				}
				if(arrOfStr[0].equals("userPermissions")) {

					UserPermissions tempUser = new UserPermissions();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					tempUser.name =arrOfStrclassAccessesTag[0];
					tempUser.enabled =arrOfStrclassAccessesTag[1];
					if(isDelete) {
						profileDestFinal.userPermissions.add(tempUser);
					}else {
						lstTempUP.add(tempUser);
						profileDestFinal.setUserPermissions(lstTempUP);
					}
				}
				if(arrOfStr[0].equals("tabVisibilities")) {

					TabVisibilities temp = new TabVisibilities();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					temp.tab =arrOfStrclassAccessesTag[0];
					temp.visibility =arrOfStrclassAccessesTag[1];
					if(isDelete) {
						profileDestFinal.tabVisibilities.add(temp);
					}else {
						lstTempTV.add(temp);
						profileDestFinal.setTabVisibilities(lstTempTV);
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
						profileDestFinal.recordTypeVisibilities.add(temp);
					}else {
						lstTempRTV.add(temp);
						profileDestFinal.setRecordTypeVisibilities(lstTempRTV);
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
						profileDestFinal.objectPermissions.add(temp);
					}else {
						lstTempOP.add(temp);
						profileDestFinal.setObjectPermissions(lstTempOP);
					}
					System.out.println("profileDest " + profileDest.getObjectPermissions());
				}
				if(arrOfStr[0].equals("layoutAssignments")) {

					LayoutAssignments temp = new LayoutAssignments();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					temp.layout =arrOfStrclassAccessesTag[0];
					temp.recordType =arrOfStrclassAccessesTag[1];
					if(isDelete) {
						profileDestFinal.layoutAssignments.add(temp);
					}else {
						lstTempLA.add(temp);
						profileDestFinal.setLayoutAssignments(lstTempLA);
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
						profileDestFinal.fieldPermissions.add(temp);
					}else {
						lstTempFP.add(temp);
						profileDestFinal.setFieldPermissions(lstTempFP);
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
						profileDestFinal.fieldLevelSecurities.add(temp);
					}else {
						lstTempFL.add(temp);
						profileDestFinal.setFieldLevelSecurities(lstTempFL);
					}
				}
				if(arrOfStr[0].equals("customPermissions")) {

					CustomPermissions temp = new CustomPermissions();
					String[] arrOfStrclassAccessesTag = destMap.get(keysSourcemap).split(tagSeparator); 
					temp.name =arrOfStrclassAccessesTag[0];
					temp.enabled = arrOfStrclassAccessesTag[1].equals("true")?true:false;
					if(isDelete) {
						profileDestFinal.customPermissions.add(temp);
					}else {
						lstTempC.add(temp);
						profileDestFinal.setCustomPermissions(lstTempC);
					}
				}

			}

			XmlMapper xmlMapper = new XmlMapper();
			xml = convertStringToDocument(xmlMapper.writeValueAsString(profileDestFinal));
			System.out.println("xml  " + xml);
			
		}catch(Exception ex) {
			ex.printStackTrace(); 
			System.out.println(ex); 
		}
		return xml;
	}
	public static String convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try  
        {  
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
            return prettyPrint(doc);
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return null;
    }
	
	public static final String prettyPrint(Document xml) throws Exception {

		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		//System.out.println(out.toString());
		return out.toString();

	}
}

