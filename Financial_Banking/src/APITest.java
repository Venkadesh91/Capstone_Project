import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APITest {

    public static void main(String[] args) throws IOException {
        // Create an HTTP client
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // Create an HTTP GET request
        HttpGet request = new HttpGet("https://dummy.restapiexample.com/api/v1/employees");

        // Send the request and get the response
        HttpResponse response = httpClient.execute(request);

        // Read the response body
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder responseBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBody.append(line);
        }
        reader.close();

        // Verify the response status code
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Verify the response body
        String expectedResponseBody = "{\"users\": []}";
        Assert.assertEquals(responseBody.toString(), expectedResponseBody);

        // Close the HTTP client
        httpClient.close();
    }
}
