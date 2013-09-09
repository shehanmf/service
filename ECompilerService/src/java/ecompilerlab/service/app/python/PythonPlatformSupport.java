package ecompilerlab.service.app.python;

import ecompilerlab.service.impl.Platforms;
import ecompilerlab.service.impl.PlatformsInfo;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 8/3/13
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class PythonPlatformSupport
{

  public static PlatformsInfo getPlatformsInfo()
  {

    return new PlatformsInfo(Platforms.PYTHON, PythonProcessExecuter.getVersionInfo());
  }
}
