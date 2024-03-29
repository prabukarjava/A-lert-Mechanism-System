package springbootrestmechanismsystem.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.coding.springbootrestmechanismsystem.model.Mechanisamsystem;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SpringbootrestmechanismsystemTest {
	 @LocalServerPort
	    int randomServerPort;
	    
	    @Test
	    public void testGetmechanisamdetailsSuccess() throws URISyntaxException 
	    {
	        RestTemplate restTemplate = new RestTemplate();
	        
	        final String baseUrl = "http://localhost:"+randomServerPort+"/mechanisamdetails/";
	        URI uri = new URI(baseUrl);

	        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	        
	        //Verify request succeed
	        Assert.assertEquals(200, result.getStatusCodeValue());
	        Assert.assertEquals(true, result.getBody().contains("mechanisamdetails"));
	    }

	    @Test
	    public void testGetmechanisamdetailsSuccessWithHeaders() throws URISyntaxException 
	    {
	        RestTemplate restTemplate = new RestTemplate();
	        
	        final String baseUrl = "http://localhost:"+randomServerPort+"/mechanisamdetails/";
	        URI uri = new URI(baseUrl);
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-LOCATION", "USA");

	        HttpEntity<Mechanisamsystem> requestEntity = new HttpEntity<>(null, headers);

	        try 
	        {
	            restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
	            Assert.fail();
	        }
	        catch(HttpClientErrorException ex) 
	        {
	            //Verify bad request and missing header
	            Assert.assertEquals(400, ex.getRawStatusCode());
	            Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
	        }
}
