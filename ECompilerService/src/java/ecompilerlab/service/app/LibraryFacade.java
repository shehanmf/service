package ecompilerlab.service.app;

import ecompilerlab.service.impl.LibraryEntity;
import ecompilerlab.service.impl.Platforms;
import ecompilerlab.service.impl.ResourceLookUpEntry;
import ecompilerlab.service.impl.SuggestionText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/7/13
 * Time: 6:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class LibraryFacade
{
  private static LibraryFacade instance = new LibraryFacade();

  public static LibraryFacade getInstance()
  {
    return instance;
  }

  private LibraryFacade()
  {
    ApplicationSettingsManager.readApplicationSettings();
  }

  public LibraryEntity[] getLibrariesByID(String[] ids)
  {
    return TmpDb.getLibrariesByID(ids).toArray(new LibraryEntity[]{});
  }

  public LibraryEntity[] getAllLibraries()
  {
    return TmpDb.getAllLibraries().toArray(new LibraryEntity[]{});
  }

  public ResourceLookUpEntry[] classLookUp(String className, Platforms platforms, final LibraryEntity[] allLibraries)
  {
    List<LibraryEntity> platformLibs = new ArrayList<LibraryEntity>();
    for (LibraryEntity libraryEntity : allLibraries)
    {
      if (libraryEntity.getPlatform().equals(platforms))
      {
        platformLibs.add(libraryEntity);
      }
    }
    final ECompilerAbstractFactory eCompiler = ECompilerFactoryCreator.getECompiler(platforms);
    final AbstractEResourceFinder resourceFinder = eCompiler.createResourceFinder();
    return resourceFinder.lookUp(className, platformLibs);

  }

  public SuggestionText[] getValidSuggestedStrings(Platforms platforms, String[] availableStrings,
                                           final LibraryEntity[] allLibraries)
  {
      
    List<LibraryEntity> platformLibs = new ArrayList<LibraryEntity>();
    for (LibraryEntity libraryEntity : allLibraries)
    {
      if (libraryEntity.getPlatform().equals(platforms))
      {
        platformLibs.add(libraryEntity);
      }
    }

    final ECompilerAbstractFactory eCompiler = ECompilerFactoryCreator.getECompiler(platforms);
    final AbstractEResourceFinder resourceFinder = eCompiler.createResourceFinder();

    return resourceFinder.suggestResources(availableStrings,platformLibs);
  }
}
