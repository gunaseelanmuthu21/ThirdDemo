//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
import com.experitest.client.*;
import org.junit.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
*/
public class fb1 {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "/Users/mcc1/workspace/project12";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "11");
    }

    @Test
    public void test_11() throws FileNotFoundException{
        client.setDevice("ios_app:iris’s iPhone");
        String csvUserName = null;
        String csvPassword = null;
        Scanner inputStream = new Scanner(new File("/Users/mcc1/Desktop/demo.csv"));
        inputStream.nextLine(); //ignore the first line - Headlines
        
        String data = inputStream.nextLine(); // Read line
        String[] values =data.split(","); // Split the line to an array
        csvUserName=values[0];
        csvPassword=values[1];
        
        System.out.println(csvUserName);
        System.out.println(csvPassword);
        
        client.launch("com.zzff.fb.md", true, true);
        if(client.waitForElement("default", "element 0", 0, 30000)){
            // If statement
        }
        client.click("default", "subdirectorate", 0, 1);
        if(client.waitForElement("default", "element 0", 0, 30000)){
            // If statement
        }
        client.click("default", "Asset Management", 0, 1);
        client.click("default", "Done", 0, 1);
        client.click("default", "Sydney Trains", 0, 1);
        if(client.waitForElement("default", "element 3", 0, 10000)){
            // If statement
        }
        client.click("NATIVE", "xpath=//*[@text='Return to MD Flight Bag']", 0, 1);
        client.click("default", "element 8", 0, 1);
        if(client.waitForElement("default", "element 3", 0, 10000)){
            // If statement
        }
        client.click("NATIVE", "xpath=//*[@text='Return to MD Flight Bag']", 0, 1);
        if(client.waitForElement("default", "element 3", 0, 10000)){
            // If statement
        }
        client.click("default", "Mobility Help", 0, 1);
        client.click("NATIVE", "//*[@placeholder='Username']", 0, 1);
        if(client.waitForElement("NATIVE", "xpath=//*[@placeholder='Username']", 0, 10000)){
            // If statement
        }
        client.elementSendText("NATIVE", "xpath=//*[@placeholder='Username']", 0, csvUserName);
        client.click("NATIVE", "//*[@placeholder='Password']", 0, 1);
        if(client.waitForElement("NATIVE", "xpath=//*[@placeholder='Password']", 0, 10000)){
            // If statement
        }
        client.elementSendText("NATIVE", "xpath=//*[@placeholder='Password']", 0, csvPassword);
        client.click("NATIVE", "xpath=//*[@text='Log In']", 0, 1);
        if(client.waitForElement("NATIVE", "xpath=//*[@text='Return to MD Flight Bag']", 0, 90000)){
            // If statement
        }
        client.click("NATIVE", "xpath=//*[@text='Return to MD Flight Bag']", 0, 1);
    }

    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future. 
        client.releaseClient();
    }
}
