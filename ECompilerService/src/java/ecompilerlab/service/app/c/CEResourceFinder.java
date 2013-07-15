package ecompilerlab.service.app.c;

import ecompilerlab.service.app.AbstractEResourceFinder;
import ecompilerlab.service.impl.LibraryEntity;
import ecompilerlab.service.impl.ResourceLookUpEntry;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/14/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class CEResourceFinder extends AbstractEResourceFinder
{
  @Override
  public ResourceLookUpEntry[] lookUp(String className, List<LibraryEntity> libraryEntities)
  {
    return null;
  }
}
