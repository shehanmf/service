package ecompilerlab.service.app.cplus;

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
 * Date: 7/23/13
 * Time: 7:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class CPlusECompilerFactory extends ECompilerAbstractFactory
{
  @Override
  public AbstractECodeFormatter createCodeFormatter()
  {
    return new CPlusECodeFormatter();
  }

  @Override
  public AbstractECompiler createCodeCompiler()
  {
    return new CPlusECompiler();
  }

  @Override
  public AbstractECodeRunner createCodeRunner()
  {
    return new CPlusECodeRunner();
  }

  @Override
  public AbstractEResourceFinder createResourceFinder()
  {
    return new CPlusEResourceFinder();
  }

  @Override
  public AbstractCleanUpResource createResourceCleaner()
  {
    return new CPlusCleanUpResource();
  }

  @Override
  public PlatformsInfo getPlatformsInfo()
  {
    return CPlusPlatformSupport.getPlatformsInfo();
  }
}
