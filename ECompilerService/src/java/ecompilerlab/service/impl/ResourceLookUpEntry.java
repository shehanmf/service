package ecompilerlab.service.impl;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/14/13
 * Time: 7:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResourceLookUpEntry implements Serializable
{
  private String libraryName;

  private String fullClassName;


  public ResourceLookUpEntry()
  {
  }

  public ResourceLookUpEntry(String libraryName, String fullClassName)
  {
    this.libraryName = libraryName;
    this.fullClassName = fullClassName;
  }

  public String getLibraryName()
  {
    return libraryName;
  }

  public void setLibraryName(String libraryName)
  {
    this.libraryName = libraryName;
  }

  public String getFullClassName()
  {
    return fullClassName;
  }

  public void setFullClassName(String fullClassName)
  {
    this.fullClassName = fullClassName;
  }
}
