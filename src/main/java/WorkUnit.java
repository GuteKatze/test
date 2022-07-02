import org.yaml.snakeyaml.Yaml;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.*;


public class WorkUnit {
    public static final Logger logger = LoggerFactory.getLogger(WorkUnit.class);

    public static void main(String[] parArgs) throws IOException
    {
        logger.info("Информация");
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION)
        {
                File file = fileopen.getSelectedFile();
                FileInputStream fileInputStream = new FileInputStream(file);
                Yaml yamlread = new Yaml();
                Map<String, Object> data = yamlread.load(fileInputStream);

                if (data == null)
                {
                    JOptionPane.showMessageDialog(null, "Empty file selected");
                } else
                {
                    for (Map.Entry<String, Object> s : data.entrySet())
                    {
                        String key = s.getKey();
                        System.out.println(key);
                        List<Object> value = (List<Object>) s.getValue();
                        for (Object o : value )
                        {
                            System.out.println(o);
                        }
                    }
                }
        }
    }
}
