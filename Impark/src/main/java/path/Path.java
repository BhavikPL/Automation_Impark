package path;

import java.io.File;

public class Path 
{
	public static final String rootPath = System.getProperty("user.dir");
	public static final String danvilleConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Danville.properties";
	public static final String southLakeTaohConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"SouthLakeTahoe.properties";
	public static final String camdenConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Camden.properties";
	public static final String rutgersConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Rutgers.properties";
	public static final String HPAConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"HPA.properties";
	public static final String LAZConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"LAZ.properties";
	public static final String ChattanoogaConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Chattanooga.properties";
	public static final String FayettevilleConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Fayetteville.properties";
	public static final String JacksonvilleConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Jacksonville.properties";
	public static final String WinparkConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Winpark.properties";
	public static final String VolusiaConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Volusia.properties";
	public static final String CasperConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Casper.properties";
	public static final String ManhattanConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Manhattan.properties";
	public static final String IslandRailRoadConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"IslandRailRoad.properties";
	public static final String WaterlooConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Waterloo.properties";
	public static final String envConfigFilePath=rootPath+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"config"+File.separator+"Environment.properties";
	public static final String tempconfigFilePath=rootPath+File.separator+"temp.properties";
	public static final String tempconfigDir=rootPath+File.separator+"tempproperties";
	public static final String dataProperty=rootPath+File.separator+"tempproperties"+File.separator+"Data.properties";
	public static final String downloadPath =rootPath+File.separator+"downloads";
	public static final String sparkConfig =rootPath+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"extent.properties";
	
	
	public static final String prayerImagePath =rootPath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"Untitled.png";
	public static final String gif =rootPath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"sampleGIFFile.gif";
	public static final String bmp =rootPath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"SampleBMP.bmp";
	public static final String pdf =rootPath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"SamplePDF.pdf";
	public static final String mp4 =rootPath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"SampleMP4.mp4";
	public static final String mp3 =rootPath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"sampleMP3File.mp3";
	public static final String jpeg =rootPath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"sampleJPEGFile.jpeg";
	public static final String jpg =rootPath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"sampleJPGFile.jpg";
	public static final String docx =rootPath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"sampleDOCXFile.docx";
	public static final String doc =rootPath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"sampleDOCFile.doc";
	
	public static final String usersFile =rootPath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"users"+File.separator+"Users.xlsx";
	public static final String danvilleApp =rootPath+File.separator+"Apps"+File.separator+"DanvilleVA.apk";
	public static final String rutgersApp =rootPath+File.separator+"Apps"+File.separator+"Rutgers.apk";
	public static void main(String[] args)
	{
		//System.out.println("QA File path is:="+Path.qaConfigFilePath);
		
		/*String p = "file:///C:/Infoviewer_Automation_By_Me/MyCucumber_1/src/test/resources/Features/Groups.feature:1091589";
		String id = p.split(":")[3];
		System.out.println(id);
		
		
		
		String text ="1111 (856)";
		text = text.replaceAll("\\)", "");
		text = text.replaceAll("\\(", "");
		String count = text.split(" ")[1];
		System.out.println(count);
		System.out.println(Path.goldenStoneImagePath);*/
	}
}
