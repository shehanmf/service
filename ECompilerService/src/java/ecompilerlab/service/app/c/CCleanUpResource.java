package ecompilerlab.service.app.c;

import ecompilerlab.service.app.AbstractCleanUpResource;
import ecompilerlab.service.app.ApplicationSettings;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/22/13
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class CCleanUpResource extends AbstractCleanUpResource
{

  @Override
  public void cleanResources(String fileName)
  {

    String tempFolderName = getTempFolderName(ApplicationSettings.getInstance().getTempFolderPath() + "\\tmpc");
    String sourceName =  tempFolderName + fileName + ".c";
    String exeName =  tempFolderName + fileName + ".exe";

    File delete = new File(sourceName);
    delete.delete();

    delete = new File(exeName);
    delete.delete();
  }
}
