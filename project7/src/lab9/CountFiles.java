package lab9;

import java.io.File;

public class CountFiles 
{
    public static void main(String[] args) 
    {
        File rootDirectory = new File(".");

        System.out.println(countFile(rootDirectory));
    }

    public static int countFile(File f) 
    {
        int count = 0;

        if (!f.isDirectory()) {
            count = 1;
        }
        
        else 
        {
            File[] files = f.listFiles();
            
            for (int i = 0; i < files.length; ++i) 
            {
                count += countFile(files[i]);
            }
        }

        return (count);
    }
}