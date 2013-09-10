package ecompilerlab.service.app;

import ecompilerlab.service.impl.TagSupportData;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 9/10/13
 * Time: 7:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class SolutionFacade
{

  private static SolutionFacade instance = new SolutionFacade();



  public static SolutionFacade getInstance()
  {
    return instance;
  }


  public void saveTag(TagSupportData tagSupportData)
  {
    TmpDb.saveTag(tagSupportData);
  }
}

