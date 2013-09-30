package ecompilerlab.service.app.c;

import ecompilerlab.service.app.ApplicationSettings;
import ecompilerlab.service.app.CompileResult;
import ecompilerlab.service.app.ExecuteResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/22/13
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class CProcessExecuter
{

  public static CCompileResult compile(String fileName)
  {
    String tmpfileDir = ApplicationSettings.getInstance().getTempFolderPath() + "\\tmpc\\" + fileName;

    try
    {
      String[] command = {"gcc", tmpfileDir + ".c", "-o", tmpfileDir + ".exe"};
      ProcessBuilder probuilder = new ProcessBuilder(command);
      probuilder.directory(new File(ApplicationSettings.getInstance().getMinGWHome() + "\\bin"));

      Process process = probuilder.start();

      final InputStream errorStream = process.getErrorStream();
      InputStreamReader errisr = new InputStreamReader(errorStream);
      BufferedReader errbr = new BufferedReader(errisr);

      process.waitFor();
      final int i = process.exitValue();
      if (i == 0)
      {
        return new CCompileResult(CompileResult.RESULT_SUCCESS, null);
      }
      else
      {
        String line;
        StringBuffer bf = new StringBuffer();
        while ((line = errbr.readLine()) != null)
        {
          bf.append("\n" + line);
        }

        String errorMsg = bf.toString().replace(tmpfileDir + ".c", "[CODE] ");

        return new CCompileResult(CompileResult.RESULT_COMPILE_ERROR, errorMsg);

      }

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }


  public static CExecuteResult runExe(String exePath)
  {

    try
    {

      String[] command = {exePath};
      ProcessBuilder probuilder = new ProcessBuilder(command);
      probuilder.directory(new File(ApplicationSettings.getInstance().getMinGWHome() + "\\bin"));

      Process process = probuilder.start();

      final InputStream is = process.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);


      final InputStream errorStream = process.getErrorStream();
      InputStreamReader errisr = new InputStreamReader(errorStream);
      BufferedReader errbr = new BufferedReader(errisr);

      process.waitFor();


      final int i = process.exitValue();
      if (i == 0)
      {

        String line;
        StringBuffer bf = new StringBuffer();
        while ((line = br.readLine()) != null)
        {
          bf.append("\n" + line);
        }

        return new CExecuteResult(ExecuteResult.RESULT_SUCCESS, null, bf.toString());
      }
      else
      {

        String line;
        StringBuffer bf = new StringBuffer();
        while ((line = errbr.readLine()) != null)
        {
          bf.append("\n" + line);

        }
        return new CExecuteResult(ExecuteResult.RESULT_RUNTIME_ERROR, bf.toString(), null);
      }

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    return null;

  }


  public static String getVersionInfo()
  {
    try
    {

      String[] command = {"gcc", "--version"};
      ProcessBuilder probuilder = new ProcessBuilder(command);
      probuilder.directory(new File(ApplicationSettings.getInstance().getMinGWHome() + "\\bin"));

      Process process = probuilder.start();

      //Read out dir output
      InputStream is = process.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);

      StringBuffer bf = new StringBuffer();
      process.waitFor();
      String line;
      while ((line = br.readLine()) != null)
      {
        bf.append("\n" + line);
      }
      return bf.toString();

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }


}
