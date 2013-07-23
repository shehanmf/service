package ecompilerlab.service.app.java;

import ecompilerlab.service.app.AbstractCleanUpResource;
import ecompilerlab.service.app.AbstractECodeFormatter;
import ecompilerlab.service.app.AbstractECodeRunner;
import ecompilerlab.service.app.AbstractECompiler;
import ecompilerlab.service.app.AbstractEResourceFinder;
import ecompilerlab.service.app.ECompilerAbstractFactory;
import ecompilerlab.service.impl.PlatformsInfo;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/7/13
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class JavaECompilerFactory extends ECompilerAbstractFactory
{
  @Override
  public AbstractECodeFormatter createCodeFormatter()
  {
    return new JavaECodeFormatter();
  }

  @Override
  public AbstractECompiler createCodeCompiler()
  {
    return new JavaECompiler();
  }

  @Override
  public AbstractECodeRunner createCodeRunner()
  {
    return new JavaECodeRunner();
  }

  @Override
  public AbstractEResourceFinder createResourceFinder()
  {
    return new JavaEResourceFinder();
  }

  @Override
  public AbstractCleanUpResource createResourceCleaner()
  {
    return new AbstractCleanUpResource()
    {
      @Override
      public void cleanResources(String fileName)
      {
        //do nothing
      }
    };
  }

  @Override
  public PlatformsInfo getPlatformsInfo()
  {
    return JavaPlatformSupport.getPlatformsInfo();
  }
}
