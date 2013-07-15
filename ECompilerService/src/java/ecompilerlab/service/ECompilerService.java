/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ecompilerlab.service;

import ecompilerlab.service.app.CompileFacade;
import ecompilerlab.service.app.LibraryFacade;
import ecompilerlab.service.app.PlatformFacade;
import ecompilerlab.service.impl.CompileRequest;
import ecompilerlab.service.impl.CompileResponse;
import ecompilerlab.service.impl.LibraryEntity;
import ecompilerlab.service.impl.LibraryType;
import ecompilerlab.service.impl.Platforms;
import ecompilerlab.service.impl.PlatformsInfo;
import ecompilerlab.service.impl.ResourceLookUpEntry;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 * @author Shehan
 */
@WebService(serviceName = "ECompilerService")
@Stateless()
public class ECompilerService implements ECompiler
{

  @Override
  @WebMethod(operationName = "getSupportedPlatforms")
  public Platforms[] getSupportedPlatforms()
  {
    return Platforms.values();
  }

  @Override
  @WebMethod(operationName = "getSupportedLibraryTypes")
  public LibraryType[] getSupportedLibraryTypes()
  {
    return LibraryType.values();
  }


  @Override
  @WebMethod(operationName = "getAllAvailableLibraries")
  public LibraryEntity[] getAllAvailableLibraries()
  {

    return LibraryFacade.getInstance().getAllLibraries();
  }

  @Override
  @WebMethod(operationName = "doCompile")
  public CompileResponse doCompile(@WebParam(name = "request") CompileRequest request)
  {
    return CompileFacade.getInstance().doCompile(request);
  }

  @Override
  @WebMethod(operationName = "getInfoByPlatform")
  public PlatformsInfo getInfoByPlatform(@WebParam(name = "platforms") Platforms platforms)
  {
    return PlatformFacade.getInstance().getInfoByPlatform(platforms);
  }

  @Override
  @WebMethod(operationName = "getLibrariesByID")
  public LibraryEntity[] getLibrariesByID(@WebParam(name = "ids") String[] ids)
  {
    return LibraryFacade.getInstance().getLibrariesByID(ids);
  }

  @Override
  @WebMethod(operationName = "classLookUp")
  public ResourceLookUpEntry[] classLookUp(@WebParam(name = "className") String className,
                              @WebParam(name = "platforms") Platforms platforms,
                              @WebParam(name = "libraryIDs") String[] libraryIDs)
  {
    return LibraryFacade.getInstance().classLookUp(className, platforms, getLibrariesByID(libraryIDs));
  }
}
