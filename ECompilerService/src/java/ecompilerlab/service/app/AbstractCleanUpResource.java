package ecompilerlab.service.app;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/22/13
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractCleanUpResource
{
    abstract public void cleanResources(String fileName);

    public String getTempFolderName(String path)
    {
        File theDir = new File(path);
        if (!theDir.exists())
        {
            theDir.mkdir();
        }
        return theDir.getAbsolutePath();

    }
}
