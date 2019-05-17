package research.main;

import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
	
	
	public void writeSystem(List<String> list, String writeFath)
	{
		File writeFile = null;
		BufferedWriter bWriteFile = null;
		try
		{
			writeFile = new File(writeFath);
			bWriteFile = new BufferedWriter(new FileWriter(writeFile));
			
			for(String value : list)
			{
				bWriteFile.write(value);
				bWriteFile.newLine();
			}						
		}
		catch(FileNotFoundException e)
		{
			System.out.println("대상(파일)을 찾을 수가 없습니다.");
		}
		catch(IOException e)
		{
			System.out.println("대상(파일)을 찾을 수가 없습니다.");
		}
		finally
		{
			try
			{
				if(bWriteFile!=null)bWriteFile.close();
			}
			catch(IOException e)
			{
				System.out.println("대상(파일)을 찾을 수가 없습니다.");
			}
		}	
	}

}