import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DataGenerator {

	/**
	 * Data generator
	 * @param args[0] fixed set file
	 * @param args[1] output file name
	 * @param args[2] number of adds
	 * @param args[3] number of removes
	 * @param args[4] number of searches 
	 * 
	 */
	public static void main(String[] args) {
		
		if(args.length < 3 || args.length > 5)
		{
			System.out.println("Not enough arguments!");
			System.out.println("[file name] [output file name] [number of adds] [number of removals] [number of searches]");
			return;
		}
		
		int adds = 0, removes = 0, searches = 0;
		
		if(args.length == 3)
		{
			adds = Integer.parseInt(args[2]);
			removes = 0;
			searches = 0;
		}
		if(args.length == 4)
		{
			adds = Integer.parseInt(args[2]);
			removes = Integer.parseInt(args[3]);
			searches = 0;
		}
		if(args.length == 5)
		{
			adds = Integer.parseInt(args[2]);
			removes = Integer.parseInt(args[3]);
			searches = Integer.parseInt(args[4]);
		}
		
		//read data from file and put it into an array
		String[] fixedSet = fixedArray(args[0]);
		
		if(fixedSet == null)
		{
			return;
		}
		
		//generate data
		try 
		{
			PrintWriter pw = new PrintWriter(args[1]);
			genData(pw, fixedSet, adds, removes, searches);
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println(e.getMessage());
		}
		
		System.out.println("Data file generated");
	}
	
	public static String[] fixedArray(String filename)
	{
		String[] array = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			ArrayList<String> fixed = new ArrayList<String>();
			String item = null; 
			while((item = br.readLine()) != null)
			{
				fixed.add(item);
			}
			
			array = fixed.toArray(new String[fixed.size()]);
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		
		return array;
	}

	public static void genData(PrintWriter pw, String[] dSet, int adds, int removes, int searches)
	{
		Random rand = new Random();
		int length = dSet.length;
		
		for(int i = 0; i < adds; i++)
		{
			int index = rand.nextInt(length);
			
			pw.println("A " + dSet[index]);
			pw.flush();
		}
		
		for(int i = 0; i < removes; i++)
		{
			int index = rand.nextInt(length);
			
			int all = rand.nextInt(2);
			if(all == 1)
			{
				pw.println("RO " + dSet[index]);
			}
			else
			{
				pw.println("RA " + dSet[index]);
			}
			
			pw.flush();
		}
		
		for(int i = 0; i < searches; i++)
		{
			int index = rand.nextInt(length);
			
			pw.println("S " + dSet[index]);
			
			pw.flush();
		}
		
	}
}
