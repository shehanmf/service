package ecompilerlab.service.app.python;

import ecompilerlab.service.app.AbstractEResourceFinder;
import ecompilerlab.service.impl.LibraryEntity;
import ecompilerlab.service.impl.ResourceLookUpEntry;
import ecompilerlab.service.impl.SuggestionText;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 8/3/13
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class PythonEResourceFinder extends AbstractEResourceFinder
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
