package ecompilerlab.service.app.java;

import ecompilerlab.service.impl.Platforms;
import ecompilerlab.service.impl.PlatformsInfo;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/22/13
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class JavaPlatformSupport
{

  public static PlatformsInfo getPlatformsInfo()
  {
    return new PlatformsInfo(Platforms.JAVA,
      "java version \"" + System.getProperty("java.version") + "\" \nJava(TM) SE Runtime Environment (build " +
        System.getProperty("java.runtime.version") + ") \n" + System.getProperty("java.vm.name") + " (build " +
        System.getProperty("java.vm.version") + ", " + System.getProperty("java.vm.info") + ")");
  }

}
