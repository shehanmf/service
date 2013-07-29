package ecompilerlab.service.app.java;

import ecompilerlab.service.app.AbstractEResourceFinder;
import ecompilerlab.service.app.ApplicationSettings;
import ecompilerlab.service.impl.LibraryEntity;
import ecompilerlab.service.impl.ResourceLookUpEntry;
import ecompilerlab.service.impl.SuggestionText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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

  private Set<String> getIgnoreSet()
  {

    Set<String> ignoreSet = new HashSet<String>();

    ignoreSet.add("System");
    ignoreSet.add("String");
    ignoreSet.add("Double");
    ignoreSet.add("Integer");
    ignoreSet.add("Long");
    ignoreSet.add("Float");
    ignoreSet.add("Exception");
    return ignoreSet;
  }

  @Override
  public SuggestionText[] suggestResources(String[] resources, List<LibraryEntity> libraryEntities)
  {
    final Set<String> ignoreSet = getIgnoreSet();

    ArrayList<SuggestionText> list = new ArrayList<SuggestionText>();

    Set<String> tmpList = new HashSet<String>();


    //remove ignore list
    if (resources != null && resources.length > 0)
    {
      for (String resource : resources)
      {
        if (!ignoreSet.contains(resource))
        {
          tmpList.add(resource);
        }
      }
    }

    if (tmpList.size() > 0)
    {

      try
      {
        //(1) search java runtime
        JarFile rtJar = new JarFile("D:\\Java\\jre7\\lib\\rt.jar");

        final Enumeration<JarEntry> entries = rtJar.entries();
        while (entries.hasMoreElements())
        {
          final JarEntry element = entries.nextElement();

          Iterator<String> it = tmpList.iterator();

          while (it.hasNext())
          {
            final String className = it.next();
            if (!element.getName().contains("Exception"))  // Remove all exceptions
            {

              if (element.getName().endsWith("/" + className + ".class"))
              {
                //for JVM class search only class name

                SuggestionText suggestionText = new SuggestionText();
                suggestionText.setDisplayName(className);
//                suggestionText.setSuggestionString(className);
                suggestionText.setSuggestionString(element.getName().replaceAll("/", ".").replace(".class", ""));
                suggestionText.setLibraryName("Java RunTime");

                list.add(suggestionText);
              }
            }

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

                Iterator<String> it = tmpList.iterator();

                while (it.hasNext())
                {
                  final String className = it.next();

                  if (!element.getName().contains("Exception"))  // Remove all exceptions
                  {
                    if (element.getName().endsWith("/" + className + ".class"))
                    {
                      //for other lib search full class name

                      SuggestionText suggestionText = new SuggestionText();
                      suggestionText.setDisplayName(className);
                      suggestionText.setSuggestionString(element.getName().replaceAll("/", ".").replace(".class", ""));
                      suggestionText.setLibraryName(jarFile.getName());

                      list.add(suggestionText);
                    }
                  }

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
    }

    return list.toArray(new SuggestionText[]{});
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
