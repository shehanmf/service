package ecompilerlab.service.app.cplus;

import ecompilerlab.service.app.CompileResult;
import ecompilerlab.service.app.ExecuteResult;
import ecompilerlab.service.app.c.CCompileResult;
import ecompilerlab.service.app.c.CExecuteResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/23/13
 * Time: 7:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class CPlusProcessExecuter
{

  public static CCompileResult compile(String fileName)
  {
    String tmpfileDir = "H:\\Project\\service\\tmpdir\\tmpcplus\\" + fileName;

    try
    {
      String[] command = {"g++", tmpfileDir + ".cpp", "-o", tmpfileDir + ".exe"};
      ProcessBuilder probuilder = new ProcessBuilder(command);
      probuilder.directory(new File("H:\\MinGW\\bin"));

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

        String errorMsg = bf.toString().replace(tmpfileDir + ".cpp", "[CODE] ");

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
      probuilder.directory(new File("H:\\MinGW\\bin"));

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

      String[] command = {"g++", "--version"};
      ProcessBuilder probuilder = new ProcessBuilder(command);
      probuilder.directory(new File("H:\\MinGW\\bin"));

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
