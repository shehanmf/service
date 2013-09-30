package ecompilerlab.service.app.cplus;

import ecompilerlab.service.app.AbstractECompiler;
import ecompilerlab.service.app.ApplicationSettings;
import ecompilerlab.service.app.CompileResult;
import ecompilerlab.service.impl.LibraryEntity;

import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/23/13
 * Time: 7:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class CPlusECompiler extends AbstractECompiler
{
  @Override
  public CompileResult compile(String className, String code, LibraryEntity[] classPathLibs)
  {


    try
    {
      //write temp file
      PrintWriter writer = new PrintWriter(ApplicationSettings.getInstance().getTempFolderPath() +
              "\\tmpcplus\\" + className + ".cpp", "UTF-8");
      writer.println(code);
      writer.close();

      return CPlusProcessExecuter.compile(className);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }


    return null;
  }
}
