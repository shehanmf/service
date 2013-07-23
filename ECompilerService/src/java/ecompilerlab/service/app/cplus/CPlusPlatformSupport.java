package ecompilerlab.service.app.cplus;

import ecompilerlab.service.impl.Platforms;
import ecompilerlab.service.impl.PlatformsInfo;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/23/13
 * Time: 7:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class CPlusPlatformSupport
{
  public static PlatformsInfo getPlatformsInfo()
  {

    return new PlatformsInfo(Platforms.C_PLUS, CPlusProcessExecuter.getVersionInfo());
  }
}
