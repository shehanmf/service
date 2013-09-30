package ecompilerlab.service.app.c;

import ecompilerlab.service.app.AbstractECompiler;
import ecompilerlab.service.app.ApplicationSettings;
import ecompilerlab.service.app.CompileResult;
import ecompilerlab.service.impl.LibraryEntity;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/7/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class CECompiler extends AbstractECompiler
{
  @Override
  public CompileResult compile(String className, String code, LibraryEntity[] classPathLibs)
  {


    try
    {
      //write temp file
      PrintWriter writer = new PrintWriter(ApplicationSettings.getInstance().getTempFolderPath() +
              "\\tmpc\\" + className + ".c", "UTF-8");
      writer.println(code);
      writer.close();

      return CProcessExecuter.compile(className);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }


    return null;
  }
}
