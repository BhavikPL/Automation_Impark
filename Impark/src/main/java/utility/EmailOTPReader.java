package utility;

import java.io.IOException;
import java.util.regex.Pattern;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Code;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageListResult;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import java.time.Duration;

public class EmailOTPReader 
{
	static String apiKey = "dgysbQ0o8cGxg5JGbgfvdCwDxSEkaiSZ";
	static String serverId = "4foczuhy";
	static String serverDomain = "4foczuhy.mailosaur.net";
	static String val = "527175";
	
	public static String getValOfCode()
	{
		return val;
	}
	public static String getOtp() throws IOException, MailosaurException
	{
		String emailId = "anything@" + serverDomain;
		MailosaurClient mailosaur = new MailosaurClient(apiKey);
		Message message = null;
		try 
		{
			message = waitForEmail(emailId , mailosaur);
		} 
		catch (MailosaurException e) 
		{
			e.printStackTrace();
		}
		

		/*MessageSearchParams params = new MessageSearchParams();
		params.withServer(serverId);

		SearchCriteria criteria = new SearchCriteria();
		criteria.withSentTo("himself-silk@" + serverDomain);

		Message message = mailosaur.messages().get(params, criteria);*/
		
		Code firstCode = message.html().codes().get(0);
		//System.out.println("Otp code is:="+firstCode.value());
		
		MessageListResult result = mailosaur.messages().list(serverId);
		String messageId = result.items().get(0).id();
		mailosaur.messages().delete(messageId);
		
		
		//return firstCode.value();
		return val;
	}
	
	public static String getOtp2() throws IOException, MailosaurException
	{
		String emailId = "anything@" + serverDomain;
		MailosaurClient mailosaur = new MailosaurClient(apiKey);
		Message message = null;
		try 
		{
			message = waitForEmail(emailId , mailosaur);
		} 
		catch (MailosaurException e) 
		{
			e.printStackTrace();
		}
		

		/*MessageSearchParams params = new MessageSearchParams();
		params.withServer(serverId);

		SearchCriteria criteria = new SearchCriteria();
		criteria.withSentTo("himself-silk@" + serverDomain);

		Message message = mailosaur.messages().get(params, criteria);*/
		
		Code firstCode = message.html().codes().get(0);
		//System.out.println("Otp code is:="+firstCode.value());
		
		MessageListResult result = mailosaur.messages().list(serverId);
		String messageId = result.items().get(0).id();
		mailosaur.messages().delete(messageId);
		
		
		return firstCode.value();
	}
	
	public static void removeEmail() throws IOException, MailosaurException
	{
		String emailId = "anything@" + serverDomain;
		MailosaurClient mailosaur = new MailosaurClient(apiKey);
		Message message = null;
		try 
		{
			message = waitForEmail(emailId , mailosaur);
		} 
		catch (MailosaurException e) 
		{
			e.printStackTrace();
		}
		MessageListResult result = mailosaur.messages().list(serverId);
		String messageId = result.items().get(0).id();
		mailosaur.messages().delete(messageId);
	}
	
	public static void main(String[] args) throws IOException, MailosaurException
	{
		String apiKey = "dgysbQ0o8cGxg5JGbgfvdCwDxSEkaiSZ";
		String serverId = "4foczuhy";
		String serverDomain = "anything@4foczuhy.mailosaur.net";

		MailosaurClient mailosaur = new MailosaurClient(apiKey);

		MessageSearchParams params = new MessageSearchParams();
		params.withServer(serverId);

		SearchCriteria criteria = new SearchCriteria();
		criteria.withSentTo("anything@" + serverDomain);

		Message message = mailosaur.messages().get(params, criteria);

		System.out.println("Whole message:="+message);
		System.out.println("To:="+message.to().get(0).email());
		System.out.println("From:="+message.from().get(0).email());
		System.out.println("Whole message:="+message);
		System.out.println("My email subject:="+ message.subject());
		System.out.println("Message subject verification:="+message.subject().contains("City of Danville Parking - Login OTP"));
		
		//body of email
		System.out.println("Email body is:="+message.text().body().toString());
		
		//links
		System.out.println("Total Links:="+message.html().links().size());
		
		//six digit code approach 1
		Code firstCode = message.html().codes().get(0);
		System.out.println("Otp code is:="+firstCode.value());
		
		//six digit code approach 2( api version 7 )
		//Pattern pattern = Pattern.compile(".*([0-9]{6}).*");
		//Matcher matcher = Pattern.matcher(message.text().body());
		
		MessageListResult result = mailosaur.messages().list(serverId);
		String messageId = result.items().get(0).id();
		mailosaur.messages().delete(messageId);
	}
	
	public static Message waitForEmail(String emailId, MailosaurClient mailosaur) throws MailosaurException 
	{
		Wait<MailosaurClient> wait = new FluentWait<>(mailosaur)
		.withTimeout(Duration.ofSeconds(60)) // Maximum wait 30 seconds
		.pollingEvery(Duration.ofMillis(100)) // Check every 100 milli seconds
		.ignoring(Exception.class); // Ignore Mailosaur exceptions

		return wait.until(mailosaurClient -> 
		{
			try
			{
				// Search for email
				MessageSearchParams params = new MessageSearchParams();
				params.withServer(serverId);

				SearchCriteria criteria = new SearchCriteria();
				criteria.withSentTo(emailId);

				Message message = mailosaurClient.messages().get(params, criteria);
				return message;
			} 
			catch (MailosaurException | IOException e)
			{
				// Return null if email not found
				return null;
			}
		});
	}
}
