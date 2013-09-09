package ecompilerlab.service.app.cplus;

import ecompilerlab.service.app.AbstractCleanUpResource;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/23/13
 * Time: 7:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class CPlusCleanUpResource  extends AbstractCleanUpResource
{

  @Override
  public void cleanResources(String fileName)
  {
    String sourceName =  "H:\\Project\\service\\tmpdir\\tmpcplus\\" + fileName + ".cpp";
    String exeName =  "H:\\Project\\service\\tmpdir\\tmpcplus\\" + fileName + ".exe";

    File delete = new File(sourceName);
    delete.delete();

    delete = new File(exeName);
    delete.delete();
  }
}
