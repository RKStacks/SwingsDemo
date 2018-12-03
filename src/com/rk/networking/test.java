
package com.rk.networking;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.mashape.unirest.request.body.MultipartBody;

public class test {

	private static final String	API_KEY	= "s2jEpQqn9tmshPehuA6FBUePqKtWp1lhrw5jsnvNNr4sCA0DWt";

	public static void main(String[] args) throws UnirestException {
		String url = "https://xkubist-random-word-v1.p.mashape.com/run.cgi";
		String key = "txt";
		String data = "very bad";

		Post(url, key, data);
		
	}

	private static void Post(String url, String key, String data) {
		try
		{
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(url);
			request.addHeader("X-Mashape-Key", API_KEY);
			request.addHeader("Content-Type", "application/x-www-form-urlencoded");
			request.addHeader("Accept", "application/json");
			request.addHeader(key, data);

			org.apache.http.HttpResponse response = client.execute(request);

			HttpEntity entity = response.getEntity();
			String responseString = EntityUtils.toString(entity, "UTF-8");
			System.out.println("Post Response :" + responseString);
			System.out.println("Status :" + response.getStatusLine());

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
	}

	private static void Get(String url, String key, String data) {

		try
		{

			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);
			request.addHeader("X-Mashape-Key", API_KEY);
			request.addHeader("Content-Type", "application/x-www-form-urlencoded");
			request.addHeader("Accept", "application/json");
			request.addHeader(key, data);

			org.apache.http.HttpResponse response = client.execute(request);

			HttpEntity entity = response.getEntity();
			String responseString = EntityUtils.toString(entity, "UTF-8");
			System.out.println("Get Response :" + responseString);
			System.out.println("Status :" + response.getStatusLine());

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
	}

	private static void universalRequset(String url, String key, String data) {
		try
		{	
			HttpRequestWithBody httpRequestWithBody = Unirest.post(url);
			httpRequestWithBody.header("X-Mashape-Key", API_KEY);
			httpRequestWithBody.header("Content-Type", "application/x-www-form-urlencoded");
			httpRequestWithBody.header("Accept", "application/json");
			MultipartBody multipartBody = httpRequestWithBody.field(key, data);
			
			
			
			HttpResponse<JsonNode> httpResponse = multipartBody.asJson();
			
//			HttpResponse<JsonNode> response = Unirest.post(url).header("X-Mashape-Key", API_KEY).header("Content-Type", "application/x-www-form-urlencoded")
//					.header("Accept", "application/json").field(key, data).asJson();

			System.out.println("Status text :" + httpResponse.getStatusText());
			System.out.println("Status Body " + httpResponse.getBody());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
