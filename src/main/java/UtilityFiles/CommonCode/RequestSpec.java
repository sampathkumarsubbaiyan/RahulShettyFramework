package UtilityFiles.CommonCode;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class RequestSpec {
    static RequestSpecification requestSpecification;

    public RequestSpecification requestSpec() throws IOException {
        if (requestSpecification == null) {
            FileOutputStream fileOutputStream = new FileOutputStream("LogFile.txt");
            PrintStream printStream = new PrintStream(fileOutputStream);
            requestSpecification = new RequestSpecBuilder().setBaseUri(getPropertyFileValues("baseURI")).addQueryParam("key", "qaclick123").addHeader("Content-Type", "application/json").
                    addFilter(RequestLoggingFilter.logRequestTo(printStream)).
                    addFilter(ResponseLoggingFilter.logResponseTo(printStream)).build();
            return requestSpecification;
        }
        return requestSpecification;

    }

    public String getPropertyFileValues(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/sampathkumar/Desktop/RahulShettyFramework/src/main/java/UtilityFiles/PropertyFile/PropertyFile.property");
        properties.load(fileInputStream);
        return (String) properties.get(key);
    }


}
