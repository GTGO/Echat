package Robot;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class tuling {
	
	private String question;
	private String APIKEY="381a12fed43c45ee902faebc81ed0a6c";
	private String INFO;
	private String getURL = "http://www.tuling123.com/openapi/api?key="+APIKEY+"&info";
	private URL getUrl;
	private HttpURLConnection connection;
	//private JSONObject jsonObject = new JSONObject();
	
	
	
	
	public String robotAnswer (String userquestion)
	{
		question = userquestion;
		//jsonObject.put("key", APIKEY);
		//jsonObject.put("info", question);
		//jsonObject.put("userid",APIKEY);
		try {
			INFO = URLEncoder.encode(question,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getURL = getURL+INFO;
		try {
			getUrl = new URL(getURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = (HttpURLConnection) getUrl.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer answer= new StringBuffer();
		String line="";
		try {
			while((line=reader.readLine())!=null)
			{
				answer.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.disconnect();
		//System.out.print("in the class!");
		String[] ss = new String[10];
        String s = answer.toString();
        String answer1;
        ss = s.split(":");
        answer1 = ss[ss.length-1];
        answer1 = answer1.substring(1,answer1.length()-2);
        return answer1;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public static void main(String[] args) throws IOException { 
		tuling t1 = new tuling();
		Scanner sc = new Scanner(System.in);
		while(true){
			String input = sc.nextLine();
			String Ranswer = t1.robotAnswer(input);
			System.out.println(Ranswer);
		}
		
	
	}
	
	
}
