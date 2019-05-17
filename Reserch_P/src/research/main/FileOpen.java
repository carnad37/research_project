package research.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileOpen
{
	public List<String> openSystem(String readFath)
	{
		File readFile = null;
		BufferedReader bReadFile = null;
		List<String> readDataList = new ArrayList<String>();
		try
		{
			readFile = new File(readFath);
			bReadFile = new BufferedReader(new FileReader(readFile));
			String line = "";
			while ((line = bReadFile.readLine()) != null)	//모든줄이 입력되면 null이 반환된다.
			{
				readDataList.add(line);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("대상(파일)을 찾을 수가 없습니다.");
		}
		catch (IOException e)
		{
			System.out.println("대상(파일)을 찾을 수가 없습니다.");
		}
		finally
		{
			try
			{
				if (bReadFile != null) bReadFile.close();
			}
			catch(IOException e)
			{
				System.out.println("대상(파일)을 찾을 수가 없습니다.");
			}
		}
		return readDataList;
	}	
}
