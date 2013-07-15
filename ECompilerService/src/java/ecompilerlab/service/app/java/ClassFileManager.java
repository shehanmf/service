package ecompilerlab.service.app.java;

import ecompilerlab.service.impl.LibraryEntity;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.SecureClassLoader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/7/13
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClassFileManager extends ForwardingJavaFileManager
{
  private JavaClassObject jclassObject;

  private ClassLoader classLoader;

  public ClassFileManager(StandardJavaFileManager
                            standardManager,final LibraryEntity[] libraryEntities)
  {
    super(standardManager);

    classLoader = new ECompilerDynamicClassLoader(Arrays.asList(libraryEntities))
    {
      @Override
      public Class handleGenaratedClass(String className)
      {
        if(className.equals("ECompilerTest"))
        {
          byte[] b = jclassObject.getBytes();
          return super.defineClass(className, jclassObject.getBytes(), 0, b.length);
        }
        return null;
      }
    };

  }


  @Override
  public ClassLoader getClassLoader(Location location)
  {

    return classLoader;
  }


  /**
   * Gives the compiler an instance of the JavaClassObject
   * so that the compiler can write the byte code into it.
   */
  @Override
  public JavaFileObject getJavaFileForOutput(Location location,
                                             String className, JavaFileObject.Kind kind, FileObject sibling)
    throws IOException
  {
    jclassObject = new JavaClassObject(className, kind);
    return jclassObject;
  }
}