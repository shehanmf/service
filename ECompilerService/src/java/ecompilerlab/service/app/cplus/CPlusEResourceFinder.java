package ecompilerlab.service.app.cplus;

import ecompilerlab.service.app.AbstractEResourceFinder;
import ecompilerlab.service.impl.LibraryEntity;
import ecompilerlab.service.impl.ResourceLookUpEntry;
import ecompilerlab.service.impl.SuggestionText;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/23/13
 * Time: 7:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class CPlusEResourceFinder extends AbstractEResourceFinder
{
  @Override
  public ResourceLookUpEntry[] lookUp(String className, List<LibraryEntity> libraryEntities)
  {
    return null;
  }

  @Override
  public SuggestionText[] suggestResources(String[] resources, List<LibraryEntity> libraryEntities)
  {
    return new SuggestionText[0];
  }
}
