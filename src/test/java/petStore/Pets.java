package petStore;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.*;
import jdk.jfr.Description;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Pets extends TestListenerAdapter {

    private static ExtentReports extent;
    private static ExtentTest test;
    static String baseUrl = "https://petstore.swagger.io/v2/pet";

    @BeforeSuite
    public void setUp() {
        // Initialize ExtentReports with the HTML report path
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/RestAssuredReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    @Description("Find pets by status")
    public void findPetsByStatus() {
        // Create a new test in the ExtentReports
        test = extent.createTest("Find pets by status", "Test to validate GET request of Pets table");

        given()
                .queryParam("status","available")
                .when()
                .get(baseUrl+"/findByStatus")
                .then()
                .log()
                .body().statusCode(200)
                .body("name[0]", equalTo("fish"))
                .headers("Content-Type", equalTo("application/json"));

    }

    @AfterSuite
    public void tearDown() {
        // Flush the report and close ExtentReports
        extent.flush();
    }
}


