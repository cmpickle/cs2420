package assignment12;

import java.io.File;

/**
 * A class to compress our experimental files in order to compare compression ratios in different circumstances
 * 
 * @author Cameron Pickle
 * @author Daniel Avery
 */
public class CompressionExperiment {
	
	static int i = 0;

	public static void compressFile(String infile, String outfile)
	{
		HuffmanTree t = new HuffmanTree();

		t.compressFile(new File(infile), new File(outfile));
	}

	public static void decompressFile(String infile, String outfile)
	{
		HuffmanTree t = new HuffmanTree();

		t.decompressFile(new File(infile), new File(outfile));
	}

	//Compress and decompress each of the files we wrote in the TextCreator class
	public static void main(String[] args)
	{
		for (int i = 0; i < 16; i++)
		{
			compressFile((i + "TestFile.txt"), (i + "TestCompressed.txt"));
			decompressFile((i + "TestCompressed.txt"), (i + "TestDecompressed.txt"));
		}
	}
}