import ClassModels.Connection;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class WorkUnit {
    public static void main(String[] parArgs) throws IOException
    {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File file = fileopen.getSelectedFile();
                FileInputStream fileInputStream = new FileInputStream(file);

                {
                    Yaml yamlread = new Yaml();
                    Map<String, Object> data = yamlread.load(fileInputStream);
                    if (data == null)
                    {
                        JOptionPane.showMessageDialog(null, "Empty file selected");
                    }
                    else
                    {
                        for (Map.Entry<String, Object> s : data.entrySet())
                        {
                            System.out.println(data);
                        }
                    }
                }



            }
            catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }


    }
}
