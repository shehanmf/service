package ecompilerlab.service.app;

import ecompilerlab.service.impl.PlatformsInfo;

/**
 * Created with IntelliJ IDEA.
 * User: shehan.fernando
 * Date: 7/6/13
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ECompilerAbstractFactory
{
  public abstract AbstractECodeFormatter createCodeFormatter();

  public abstract AbstractECompiler createCodeCompiler();

  public abstract AbstractECodeRunner createCodeRunner();

  public abstract AbstractEResourceFinder createResourceFinder();

  public abstract AbstractCleanUpResource createResourceCleaner();

  public abstract PlatformsInfo getPlatformsInfo();
}
