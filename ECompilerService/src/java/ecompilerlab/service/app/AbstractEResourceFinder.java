package ecompilerlab.service.app;

import ecompilerlab.service.impl.LibraryEntity;
import ecompilerlab.service.impl.ResourceLookUpEntry;
import ecompilerlab.service.impl.SuggestionText;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/14/13
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractEResourceFinder
{
  public abstract ResourceLookUpEntry[] lookUp(String className, List<LibraryEntity> libraryEntities);

  public abstract SuggestionText[] suggestResources(String[] resources,List<LibraryEntity> libraryEntities);
}
