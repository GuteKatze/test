import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class WorkUnit {
    private static final Logger logger = LogManager.getLogger(WorkUnit.class);
    public static void main(String[] parArgs) throws IOException
    {
        chooseAction(null);
    }
    public static void chooseAction (String[] args) throws IOException
    {
        String[] options = {"Read YAML", "Connect to DB"};
        int chosen = JOptionPane.showOptionDialog(null, "Choose action.", "Click needed action",
                JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);
        logger.debug("Chosen action option ID: "+chosen);
        if (chosen == 0)
        {
            logger.info("Chosen 'Read YAML' option");
            readYaml(null);
        } else if (chosen == 1)
        {
            JOptionPane.showMessageDialog(null, "Feature not implemented yet.");
            //dbConnection(null);
            returnDialog(null);
        }
    }
    public static void returnDialog(String[] args) throws IOException
    {
        int result = JOptionPane.showConfirmDialog(null,"Action completed. Return to start?","Return dialog", JOptionPane.YES_NO_OPTION);
        logger.debug("Result: "+result);
        if (result == JOptionPane.YES_OPTION)
        {
            logger.info("Restart approved. Returning to main.");
            main(null);
        }
        else if (result == JOptionPane.NO_OPTION)
        {
            logger.info("Restart canceled. Exiting.");
        }
    }
    public static void readYaml(String[] parArgs) throws IOException
    {
        logger.info("Logging works fine (?)");
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Open file");
        logger.debug("File selection response: "+ret);
        if (ret == JFileChooser.APPROVE_OPTION)
        {
            File file = fileopen.getSelectedFile();
            logger.debug("Getting file on selected path: "+file);
            FileInputStream fileInputStream = new FileInputStream(file);
            Yaml yamlread = new Yaml();
            Map<String, Object> data = yamlread.load(fileInputStream);
            if (data == null)
            {
                logger.info("Empty file selected.");
                JOptionPane.showMessageDialog(null, "Empty file selected");
            }
            else try
            {
                logger.info("File is not empty. Proceeding to read as YAML.");
                for (Map.Entry<String, Object> s : data.entrySet())
                {
                    logger.debug("Got in map: "+s);
                    String key = s.getKey();
                    System.out.println(key);
                    List<Object> value = (List<Object>) s.getValue();
                    for (Object o : value )
                    {
                        System.out.println(o);
                    }
                }
            }
            catch (NullPointerException n)
            {
                logger.fatal("File can't be read: "+n);
                JOptionPane.showMessageDialog(null, "Something gone wrong.");
            }
        }
        else if (ret == JFileChooser.CANCEL_OPTION)
        {
            logger.info("File selection canceled. Returning to main.");
            main(null);
        }
    }

    public static void dbConnection(String[] parArgs) throws IOException
    {

    }


}
