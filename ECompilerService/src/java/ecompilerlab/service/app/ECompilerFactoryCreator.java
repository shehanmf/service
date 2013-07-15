package ecompilerlab.service.app;

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
    }
    return null;


  }
}
