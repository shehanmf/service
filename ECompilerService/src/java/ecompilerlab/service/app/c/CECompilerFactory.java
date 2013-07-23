package ecompilerlab.service.app.c;

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
public class CECompilerFactory extends ECompilerAbstractFactory
{
  @Override
  public AbstractECodeFormatter createCodeFormatter()
  {
    return new CECodeFormatter();
  }

  @Override
  public AbstractECompiler createCodeCompiler()
  {
    return new CECompiler();
  }

  @Override
  public AbstractECodeRunner createCodeRunner()
  {
    return new CECodeRunner();
  }

  @Override
  public AbstractEResourceFinder createResourceFinder()
  {
    return new CEResourceFinder();
  }

  @Override
  public AbstractCleanUpResource createResourceCleaner()
  {
    return new CCleanUpResource();
  }

  @Override
  public PlatformsInfo getPlatformsInfo()
  {
    return CPlatformSupport.getPlatformsInfo();
  }
}
