package com.bsl.sonar.model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class ReadYamlUtil {

    // File file = new
    // File("/appdata/sf/Devops/SonarQube/config/sonar_custom_java_allowed_objects.yaml");

    File file = new File("/appbin/install/Sonar/sonarqube-8.0/sonar_custom_java_allowed_objects.yaml");

    // Instantiating a new ObjectMapper as a YAMLFactory
    ObjectMapper om = new ObjectMapper(new YAMLFactory());

    public AllowedVariablesVO readFromYaml() {

	// Mapping the employee from the YAML file to the Employee class
	AllowedVariablesVO whiteListVo = null;
	try {
	    whiteListVo = om.readValue(file, AllowedVariablesVO.class);
	} catch (JsonParseException e) {

	    e.printStackTrace();
	} catch (JsonMappingException e) {

	    e.printStackTrace();
	} catch (IOException e) {

	    e.printStackTrace();
	}

	return whiteListVo;
    }

    public String readFromYaml(String prop) {
	try {

	    String val = om.readValue(file, String.class);

	    return val;
	} catch (Exception e) {
	    System.out.println("Exception on reading property");
	    return null;
	}
    }

}
