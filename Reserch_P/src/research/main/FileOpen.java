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
			while ((line = bReadFile.readLine()) != null)	//������� �ԷµǸ� null�� ��ȯ�ȴ�.
			{
				readDataList.add(line);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("���(����)�� ã�� ���� �����ϴ�.");
		}
		catch (IOException e)
		{
			System.out.println("���(����)�� ã�� ���� �����ϴ�.");
		}
		finally
		{
			try
			{
				if (bReadFile != null) bReadFile.close();
			}
			catch(IOException e)
			{
				System.out.println("���(����)�� ã�� ���� �����ϴ�.");
			}
		}
		return readDataList;
	}	
}
