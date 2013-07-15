package ecompilerlab.service.app.java;

import ecompilerlab.service.app.AbstractEResourceFinder;
import ecompilerlab.service.app.ApplicationSettings;
import ecompilerlab.service.impl.LibraryEntity;
import ecompilerlab.service.impl.ResourceLookUpEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/14/13
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class JavaEResourceFinder extends AbstractEResourceFinder
{

  public static void main(String[] args)
  {
    new JavaEResourceFinder().lookUp("String", null);
  }

  @Override
  public ResourceLookUpEntry[] lookUp(String className, List<LibraryEntity> libraryEntities)
  {
    ArrayList<ResourceLookUpEntry> lookupList = new ArrayList<ResourceLookUpEntry>();


    try
    {
      //(1) search java runtime
      JarFile rtJar = new JarFile("D:\\Java\\jre7\\lib\\rt.jar");

      final Enumeration<JarEntry> entries = rtJar.entries();
      while (entries.hasMoreElements())
      {
        final JarEntry element = entries.nextElement();
        if (element.getName().endsWith("/" + className + ".class"))
        {
          String fullName = element.getName().replaceAll("/", ".").replace(".class", "");
          lookupList.add(new ResourceLookUpEntry("Java RunTime", fullName));
        }
      }


      //(2) search in given libraries
      if (libraryEntities != null && libraryEntities.size() > 0)
      {
        for (LibraryEntity jarFile : libraryEntities)
        {
          final String[] libNames = jarFile.getLibNames();
          for (String libName : libNames)
          {
            JarFile jar = new JarFile(ApplicationSettings.getInstance().getLibraryBasePath() + libName);

            final Enumeration<JarEntry> libEntries = jar.entries();
            while (libEntries.hasMoreElements())
            {
              final JarEntry element = libEntries.nextElement();
              if (element.getName().endsWith("/" + className + ".class"))
              {
                String fullName = element.getName().replaceAll("/", ".").replace(".class", "");
                lookupList.add(new ResourceLookUpEntry(jarFile.getName(), fullName));
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

    return lookupList.toArray(new ResourceLookUpEntry[]{});
  }
}
