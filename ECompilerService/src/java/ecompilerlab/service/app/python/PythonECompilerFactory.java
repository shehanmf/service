package ecompilerlab.service.app.python;

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
 * Date: 8/3/13
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class PythonECompilerFactory extends ECompilerAbstractFactory
{
  @Override
  public AbstractECodeFormatter createCodeFormatter()
  {
    return new PythonECodeFormatter();
  }

  @Override
  public AbstractECompiler createCodeCompiler()
  {
    return new PythonECompiler();
  }

  @Override
  public AbstractECodeRunner createCodeRunner()
  {
    return new PythonECodeRunner();
  }

  @Override
  public AbstractEResourceFinder createResourceFinder()
  {
    return new PythonEResourceFinder();
  }

  @Override
  public AbstractCleanUpResource createResourceCleaner()
  {
    return new PythonCleanUpResource();
  }

  @Override
  public PlatformsInfo getPlatformsInfo()
  {
    return PythonPlatformSupport.getPlatformsInfo();
  }
}
