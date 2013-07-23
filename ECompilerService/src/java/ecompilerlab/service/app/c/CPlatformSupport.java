package ecompilerlab.service.app.c;

import ecompilerlab.service.impl.Platforms;
import ecompilerlab.service.impl.PlatformsInfo;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/22/13
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class CPlatformSupport
{
  public static PlatformsInfo getPlatformsInfo()
  {

    return new PlatformsInfo(Platforms.C,CProcessExecuter.getVersionInfo());
  }
}
