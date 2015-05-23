package jonphase4db2working;

/**
 *
 * @author Jon Janet 7/5/2011
 * 
 */
public class Cities
{
    private String city;
    private String state;
    private int pop;

    /**
     *
     * @param city
     * @param state
     * @param pop
     */
    public Cities(String city, String state, int pop )
    {
        this.city = city;
        this.state = state;
        this.pop = pop;

    }

    @Override
    public String toString()
    {
        return "Cities{" + "city=" + city + "state=" + state + "pop=" + pop + '}';
    }

    /**
     *
     * @return
     */
    public String getCity()
    {
        return city;
    }

    /**
     *
     * @return
     */
    public int getPop()
    {
        return pop;
    }

    /**
     *
     * @return
     */
    public String getState()
    {
        return state;
    }

}// end class Cities
