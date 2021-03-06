package tests;

import mu.utils.IniFile;

import java.io.File;

public class IniFileTest extends junit.framework.TestCase {

    public void testOkay() {

        {//=============================================================================================================
            String data = null;
            IniFile config = new IniFile();
            config.loadFromString(data);

            String s = config.getString("CAPACITY", "PACSMaxImageCount", "");
            assertEquals("", s);

        }//=============================================================================================================

        {//=============================================================================================================
            String data = "";
            IniFile config = new IniFile();
            config.loadFromString(data);

            String s = config.getString("CAPACITY", "PACSMaxImageCount", "");
            assertEquals("", s);

        }//=============================================================================================================

        {//=============================================================================================================
            String data = "The quick brown fox jumps over the lazy dog";
            IniFile config = new IniFile();
            config.loadFromString(data);

            String s = config.getString("CAPACITY", "PACSMaxImageCount", "");
            assertEquals("", s);

        }//=============================================================================================================

        {//=============================================================================================================
            String data = "[ONE]\none=1";
            IniFile config = new IniFile();
            config.loadFromString(data);

            String s = config.getString("CAPACITY", "PACSMaxImageCount", "");
            assertEquals("", s);

        }//=============================================================================================================

        {//=============================================================================================================
            String data = "[ONE]\none=1\n\n[TWO]\ntwo=2\n";
            IniFile config = new IniFile();
            config.loadFromString(data);

            String s = config.getString("ONE", "one", "");
            assertEquals("1", s);

            s = config.getString("TWO", "two", "");
            assertEquals("2", s);

        }//=============================================================================================================

        {//=============================================================================================================
            String data = "[ONE]\none=1";
            IniFile config = new IniFile("cf/fileutils.txt");

            String s = config.getString("CAPACITY", "PACSMaxImageCount", "");
            assertEquals("", s);

        }//=============================================================================================================

        {//=============================================================================================================
            String licenseFile = "/opt/OMTCmm/cf/license.dat";
            File file = new File(licenseFile);
            boolean bLicense = file.exists();
            if(bLicense)    {
                IniFile config = new IniFile(licenseFile);
                String s = config.getString("CAPACITY", "PACSMaxImageCount", "");
                assertNotNull(s);
                assertNotSame("", s);
            }
        }//=============================================================================================================
    }
}
