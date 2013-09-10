package ecompilerlab.service.impl;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 9/10/13
 * Time: 7:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class TagSupportData implements Serializable
{

  private String name;

  private String []tags;

  private Platforms platforms;

  private String code;

  private int rating;


  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String[] getTags()
  {
    return tags;
  }

  public void setTags(String[] tags)
  {
    this.tags = tags;
  }

  public Platforms getPlatforms()
  {
    return platforms;
  }

  public void setPlatforms(Platforms platforms)
  {
    this.platforms = platforms;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public int getRating()
  {
    return rating;
  }

  public void setRating(int rating)
  {
    this.rating = rating;
  }
}
