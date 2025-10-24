package utility;

import java.util.Locale;

import com.github.javafaker.Faker;

public class GenerateRandomData
{
	static Faker faker = new Faker(Locale.US);
	
	public static String getFirstName()
	{
		String firstName = faker.name().firstName();
        String cleanedfirstName = firstName.replaceAll("[^a-zA-Z0-9]", "");
		return cleanedfirstName;
	}
	
	public static String getLastName()
	{
		String lastName = faker.name().lastName();
        String cleanedlastName = lastName.replaceAll("[^a-zA-Z0-9]", "");
		return cleanedlastName;
	}
	
	public static String getMiddleName()
	{
		String middleName = faker.name().firstName();
        String cleanedmiddleName = middleName.replaceAll("[^a-zA-Z0-9]", "");
		return cleanedmiddleName;
	}
	
	public static String getPhoneNumber()
	{
		//return faker.phoneNumber().phoneNumber();
		return Util.generateRandomNumber(10);
	}
	
	public static String getEmailAddress()
	{
		return faker.internet().emailAddress();
	}
	
	public static String getAddress()
	{
		String address =  "Block No:"+Util.generateRandomNumber(2)+" "+"south corner "+Util.generateRandomNumber(3)+" City road";
		//address = address.replaceAll("[^a-zA-Z0-9 ]", "");
		return address;
	}
	
	public static String getCity()
	{
		String city = faker.address().city();
        String cleanedCity = city.replaceAll("[^a-zA-Z0-9]", "");
		return cleanedCity;
	}
	
	public static String getZipCode()
	{
		return Util.generateRandomNumber(5);
	}
	
	public static String getReason()
	{
		String reason = faker.lorem().characters(1, 50);
        String cleanedReason = reason.replaceAll("[^a-zA-Z0-9]", "");
		return cleanedReason;
	}
	
	public static void main(String[] args)
	{
		System.out.println(GenerateRandomData.getZipCode());
	}
}
