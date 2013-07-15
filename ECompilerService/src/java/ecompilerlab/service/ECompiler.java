/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ecompilerlab.service;

import ecompilerlab.service.impl.CompileRequest;
import ecompilerlab.service.impl.CompileResponse;
import ecompilerlab.service.impl.LibraryEntity;
import ecompilerlab.service.impl.LibraryType;
import ecompilerlab.service.impl.Platforms;
import ecompilerlab.service.impl.PlatformsInfo;
import ecompilerlab.service.impl.ResourceLookUpEntry;

/**
 * @author Shehan
 */
public interface ECompiler
{

  public Platforms[] getSupportedPlatforms();

  public LibraryEntity[] getAllAvailableLibraries();

  public CompileResponse doCompile(CompileRequest request);

  public PlatformsInfo getInfoByPlatform(Platforms platforms);

  public LibraryEntity[] getLibrariesByID(String[] ids);

  public LibraryType[] getSupportedLibraryTypes();

  public ResourceLookUpEntry[] classLookUp(String className,Platforms platforms,String[] libIds);
}
