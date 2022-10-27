package utilities;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to assist in sharing states between step definitions
 */
public class ScenarioContext
{
    /**
     * Map between the Context variables and Object values set during the execution of a Scenario
     */
    private Map<Context, Object> scenarioContext;

    /**
     * Container to which scenario context data is stored
     */
    public interface Context
    {
        /**
         * Context relating to General data
         */
        enum GENERAL implements Context
        {
            MENU_NAME, VIDEO_SIZE, TEAM_NAME
        }
    }

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Hash map the scenario context
     */
    public ScenarioContext()
    {
        scenarioContext = new HashMap<>();
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Maps a value of type Object to a context key of type String
     * <p>
     * @param key Context enum of type String
     * @param value Object type
     */
    public void setContext(Context key, Object value)
    {
        scenarioContext.put(key, value);
    }

    /**
     * Used to get the context of the enum context
     * <p>
     * @param key Takes key context enum as a parameter
     * @return context Returns the object which matches the key
     */
    public Object getContext(Context key)
    {
        return scenarioContext.get(key);
    }

    /**
     * Gets the scenario context as a String
     * <p>
     * @param key Takes key context enum as a parameter
     * @return string Returns a String
     */
    public String getScenarioContextAsString(Context key)
    {
        Object value = this.getContext(key);
        if (!(value instanceof String))
        {
            fail();
        }
        return (String) value;
    }
}