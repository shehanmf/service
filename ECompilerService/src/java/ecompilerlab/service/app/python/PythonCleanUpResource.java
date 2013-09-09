package ecompilerlab.service.app.python;

import ecompilerlab.service.app.AbstractCleanUpResource;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 8/3/13
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class PythonCleanUpResource extends AbstractCleanUpResource
{
  @Override
  public void cleanResources(String fileName)
  {
    String sourceName = "H:\\Project\\service\\tmpdir\\tmppython\\" + fileName + ".py";

    File delete = new File(sourceName);
    delete.delete();


  }
}
