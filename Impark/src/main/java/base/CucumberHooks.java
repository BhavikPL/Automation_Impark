package base;

import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import io.cucumber.java.Scenario;

public class CucumberHooks  extends Base implements io.cucumber.plugin.ConcurrentEventListener
{
	//Scenario scenario;
	//CucumberHooks(Scenario scenario)
	//{
		//this.scenario=scenario;
	//}
	
	@Override
    public void setEventPublisher(EventPublisher eventPublisher) 
	{
        eventPublisher.registerHandlerFor(TestRunStarted.class, beforeAll);
        eventPublisher.registerHandlerFor(TestRunFinished.class, afterAll);
    }

    private EventHandler<TestRunStarted> beforeAll = event ->
    {
    	System.out.println("Db connected");
    	//updateTCCount(scenario);
    };

    private EventHandler<TestRunFinished> afterAll = event -> 
    {
    	System.out.println("Db dis-connected");
    };
    
    private void updateTCCount(Scenario scenario)
    {
    	//scenario.log( String.valueOf("<B>TOTAL EXECUTED TESTCASES:= "+totalTestCases+"</B>") );
    }
}
