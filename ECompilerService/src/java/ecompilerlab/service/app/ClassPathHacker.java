package ecompilerlab.service.app;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/14/13
 * Time: 12:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClassPathHacker
{

  private static final Class[] parameters = new Class[]{URL.class};

  public static void addFile(String s) throws IOException
  {
    File f = new File(s);
    addFile(f);
  }//end method

  public static void addFile(File f) throws IOException
  {
    addURL(f.toURI().toURL());
  }//end method


  public static void addURL(URL u, ClassLoader classLoader) throws IOException
  {
    URLClassLoader sysloader = (URLClassLoader) classLoader;
    Class sysclass = URLClassLoader.class;

    try
    {
      Method method = sysclass.getDeclaredMethod("addURL", parameters);
      method.setAccessible(true);
      method.invoke(sysloader, new Object[]{u});
    }
    catch (Throwable t)
    {
      t.printStackTrace();
      throw new IOException("Error, could not add URL to system classloader");
    }
  }

  public static void addURL(URL u) throws IOException
  {

    addURL(u,ClassLoader.getSystemClassLoader());

  }//end method

}