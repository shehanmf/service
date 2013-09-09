package ecompilerlab.service.app.java;

import ecompilerlab.service.app.ApplicationSettings;
import ecompilerlab.service.impl.LibraryEntity;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/14/13
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ECompilerDynamicClassLoader extends ClassLoader
{
  private List<LibraryEntity> jarFiles;

  private Hashtable classes = new Hashtable();

  public ECompilerDynamicClassLoader(List<LibraryEntity> jarFiles)
  {
    super(ECompilerDynamicClassLoader.class.getClassLoader());
    this.jarFiles = jarFiles;

  }

  public Class loadClass(String className) throws ClassNotFoundException
  {
    return findClass(className);
  }


  public abstract Class handleGenaratedClass(String className);

  public Class findClass(String className)
  {

    final Class aClass = handleGenaratedClass(className);
    if (aClass != null)
    {
      return aClass;
    }
    byte classByte[];
    Class result = null;

    result = (Class) classes.get(className);
    if (result != null)
    {
      return result;
    }

    try
    {
      return findSystemClass(className);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    try
    {
      if (jarFiles.size() > 0)
      {
        for (LibraryEntity jarFile : jarFiles)
        {
          final String[] libNames = jarFile.getLibNames();
          for (String libName : libNames)
          {
            JarFile jar = new JarFile(ApplicationSettings.getInstance().getLibraryBasePath() + libName);

            final Enumeration<JarEntry> entries = jar.entries();

            while (entries.hasMoreElements())
            {
              JarEntry element = entries.nextElement();
//              System.out.println(element.getName());
              final String accClassName = element.getName().replaceAll("/", ".");

              if ((className + ".class").equals(accClassName))
              {
                InputStream is = jar.getInputStream(element);
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                int nextValue = is.read();
                while (-1 != nextValue)
                {
                  byteStream.write(nextValue);
                  nextValue = is.read();
                }

                classByte = byteStream.toByteArray();
                result = defineClass(className, classByte, 0, classByte.length, null);
                classes.put(className, result);
                return result;

              }
            }

          }
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return null;
  }
}
