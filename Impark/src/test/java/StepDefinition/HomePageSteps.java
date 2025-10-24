package StepDefinition;

import base.Base;
import base.BasePage;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps extends Base
{	
	
	BasePage CurrentPage;

	@When("user extends ticket management menu")
	public void open_Processing_pro_application()
	{
		CurrentPage.getInstance(HomePage.class).extendsTicketManagement();
	}
	
	@When("user extends manual tickets menu")
	public void user_extends_manual_tickets_menu()
	{
		CurrentPage.getInstance(HomePage.class).extendsManualTickets();
	}
	
	@When("user extends revenue reports menu")
	public void user_extends_revenue_reports_menu()
	{
		CurrentPage.getInstance(HomePage.class).extendsRevenueReport();
	}
	
	@When("user extends hearing management menu")
	public void user_extends_hearing_management_menu()
	{
		CurrentPage.getInstance(HomePage.class).extendsHearingManagement();
	}
	
	@When("user extends appeal management menu")
	public void user_extends_appeal_management_menu()
	{
		CurrentPage.getInstance(HomePage.class).extendsAppealManagement();
	}
	
	@When("user extends RO management menu")
	public void user_extends_RO_management_menu()
	{
		CurrentPage.getInstance(HomePage.class).extendsROManagement();
	}
	
	@When("user extends administration menu")
	public void user_extends_administration_menu()
	{
		CurrentPage.getInstance(HomePage.class).extendsAdministrationMenu();
	}
	
	@When("user clicks on to the site configuration option")
	public void user_clicks_on_to_the_site_configuration_option()
	{
		CurrentPage.getInstance(HomePage.class).navigateToSiteConfiguration();
	}
	
	@When("user extends permits administration menu")
	public void user_extends_permits_administration_menu()
	{
	    CurrentPage.getInstance(HomePage.class).extendsPermitsAdministration();
	}
}
