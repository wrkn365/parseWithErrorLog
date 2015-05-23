package jonphase4db2working;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Jon Janet 7/5/2011
 */
public class CityWriter
{
    private BufferedWriter output;

    /**
     *
     * @param to
     */
    public CityWriter(Writer to)
    {
        output = new BufferedWriter(to);
    }

    /**
     * 
     * @param info
     * @throws IOException
     */
    public void write(Cities info) throws IOException
    {
        output.write(info.getCity());
        output.write(" ");
        output.write(info.getState());
        output.write(" ");
        output.write("" + info.getPop());
        output.newLine();
    }

    /**
     *
     * @throws IOException
     */
    public void close() throws IOException
    {
        output.close();
    }
}
