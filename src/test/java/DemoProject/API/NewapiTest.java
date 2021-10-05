package DemoProject.API;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import resources.TestDataBuild;
import resources.Utils;

public class NewapiTest extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	public String Stationid;
	public String newStaionid;

	@Test(dataProvider = "getApiData")
	public void CreateStation (String Username, String Password, double lat, double lng) throws IOException 
	{
		
		TestDataBuild dataj = new TestDataBuild();
		String postResponse = given().spec(requestSpecification()).body(dataj.addPlacePayLoad(Username,Password,lat,lng)).when()
				.post("data/3.0/stations").then().assertThat().statusCode(201).extract().asString();
		// System.out.println(Response);
		JsonPath postobj = new JsonPath(postResponse);
		Stationid = postobj.get("ID");
		System.out.println(Stationid);
	}
	@Test(dataProvider = "getApiData")
	
	public void NoAcessKey(String Username, String Password, double lat, double lng) 
	{
		TestDataBuild dataj = new TestDataBuild();
		RestAssured.baseURI = "http://api.openweathermap.org";
		given().log().all().header("Content-Type", "application/json").body(dataj.addPlacePayLoad(Username,Password,lat,lng)).when()
				.post("data/3.0/stations").then().assertThat().statusCode(401).extract().asString();

	}

	@Test
	public void XGetStation() {
		System.out.println(Stationid);
		RestAssured.baseURI = "http://api.openweathermap.org";
		String getResponse = RestAssured.given().log().all().pathParam("key", Stationid)
				.queryParam("appid", "44b79e3698567f31d4fa5ccb8c16a7a9").when().get("/data/3.0/stations/{key}").then()
				.assertThat().statusCode(200).extract().asString();
		JsonPath getobj = new JsonPath(getResponse);
		newStaionid = getobj.get("id");
		System.out.println(newStaionid);
		System.out.println(getResponse);
		Assert.assertEquals(Stationid, newStaionid);
	}

	@Test
	public void YDelStation() {
		System.out.println(Stationid);
		RestAssured.baseURI = "http://api.openweathermap.org";
		String delResponse = RestAssured.given().log().all().pathParam("key", Stationid)
				.queryParam("appid", "44b79e3698567f31d4fa5ccb8c16a7a9").when().delete("/data/3.0/stations/{key}")
				.then().assertThat().statusCode(204).extract().asString();
		// JsonPath jspd= new JsonPath(esp);
		// newStaiond=jspd.get("id");
		// System.out.println(newStaiond);
		System.out.println(delResponse);
		//Assert.assertEquals(Stationid, newStaionid);
	}

	@Test
	public void ZRepDel() {
		System.out.println(Stationid);
		RestAssured.baseURI = "http://api.openweathermap.org";
		String delResponse = RestAssured.given().log().all().pathParam("key", Stationid)
				.queryParam("appid", "44b79e3698567f31d4fa5ccb8c16a7a9").when().delete("/data/3.0/stations/{key}")
				.then().assertThat().statusCode(404).extract().asString();
		JsonPath delobj = new JsonPath(delResponse);
		String delMsg = delobj.get("message");
		// System.out.println(newStaiond);
		System.out.println(delMsg);
		Assert.assertEquals(delMsg , "Station not found");
	}
	
	@DataProvider
	public Object[][] getApiData() {
		// Row stands for how many different data types test should run
		// coloumn stands for how many values per each test

		// Array size is 2
		// 0,1
		Object[][] data = new Object[1][4];
		// 0th row
		data[0][0] = "ddxcxd";
		data[0][1] = "ssdhd";
		data[0][2] = 224.33;
		data[0][3] = 224.33;
		return data;

	}
}
