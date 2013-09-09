package ecompilerlab.service.app;

import ecompilerlab.service.app.c.CECompilerFactory;
import ecompilerlab.service.app.cplus.CPlusECompilerFactory;
import ecompilerlab.service.app.java.JavaECompilerFactory;
import ecompilerlab.service.app.python.PythonECompilerFactory;
import ecompilerlab.service.impl.Platforms;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/14/13
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ECompilerFactoryCreator
{

  public static ECompilerAbstractFactory getECompiler(Platforms platform)
  {
    switch (platform)
    {
      case JAVA:
        return new JavaECompilerFactory();

      case C:
        return new CECompilerFactory();

      case C_PLUS:
        return new CPlusECompilerFactory();

      case PYTHON:
        return new PythonECompilerFactory();


    }
    return null;


  }
}
