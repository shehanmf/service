package ecompilerlab.service.app.python;

import ecompilerlab.service.app.AbstractECompiler;
import ecompilerlab.service.app.ApplicationSettings;
import ecompilerlab.service.app.CompileResult;
import ecompilerlab.service.impl.LibraryEntity;

import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 8/3/13
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class PythonECompiler extends AbstractECompiler
{
  @Override
  public CompileResult compile(String className, String code, LibraryEntity[] classPathLibs)
  {
    try
    {
      //write temp file
      PrintWriter writer = new PrintWriter(ApplicationSettings.getInstance().getTempFolderPath() + "\\tmppython\\" + className + ".py", "UTF-8");
      writer.println(code);
      writer.close();

      return PythonProcessExecuter.compile(className);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }


    return null;
  }
}
