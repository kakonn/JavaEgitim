package com.kadir.SampleJson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException
    {	
    	// json-->pojo
       ObjectMapper mapper = new ObjectMapper();
       
       Employee emp = mapper.readValue(new File("data/sample.json"), Employee.class);
       
       System.out.println(emp);
       
       
       //pojo-->json 
       mapper.enable(SerializationFeature.INDENT_OUTPUT);
       mapper.writeValue(new File("data/target.json"), emp);
       
       
       
    }
}
