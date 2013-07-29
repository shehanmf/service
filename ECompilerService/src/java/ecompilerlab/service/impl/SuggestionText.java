package ecompilerlab.service.impl;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/28/13
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class SuggestionText
{

  private String suggestionString;

  private String displayName;

  private String libraryName;


  public SuggestionText()
  {
  }

  public String getSuggestionString()
  {
    return suggestionString;
  }

  public void setSuggestionString(String suggestionString)
  {
    this.suggestionString = suggestionString;
  }

  public String getDisplayName()
  {
    return displayName;
  }

  public void setDisplayName(String displayName)
  {
    this.displayName = displayName;
  }

  public String getLibraryName()
  {
    return libraryName;
  }

  public void setLibraryName(String libraryName)
  {
    this.libraryName = libraryName;
  }
}
