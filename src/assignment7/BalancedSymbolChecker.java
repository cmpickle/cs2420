package assignment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Gage Glenn
 * @author Cameron Pickle
 */
public class BalancedSymbolChecker
{

	/**
	 * Returns a message indicating whether the input file has unmatched
	 * symbols. (Use the methods below for constructing messages.) Throws
	 * FileNotFoundException if the file does not exist.
	 */
	@SuppressWarnings({ "unchecked", "resource", "rawtypes" })
	public static String checkFile(String filename) throws FileNotFoundException
	{
		MyStack balanceChecker = new MyStack();

		File scanMe = new File(filename);

		int lineNum = 0;
		int ColNum = 0;
		Scanner s = new Scanner(scanMe);

		boolean commentFlag = false;
		boolean simpleCommentFlag = false;
		boolean stringFlag = false;
		boolean charFlag = false;

		while (s.hasNextLine())
		{

			ColNum = 0;
			lineNum++;
			simpleCommentFlag = false;

			String curLine = s.nextLine();

			for (int i = 0; i < curLine.length(); i++)
			{

				char curChar = curLine.charAt(i);
				ColNum++;

				// Check if Scanner is in a /* */ comment
				if (i < curLine.length() - 1)
				{
					if (curChar == '/' && curLine.charAt(i + 1) == '*')
					{
						commentFlag = true;
					}

					if (curChar == '*' && curLine.charAt(i + 1) == '/')
					{
						commentFlag = false;
					}

					// Check if Scanner is in a // comment

					if (curChar == '/' && curLine.charAt(i + 1) == '/')
					{
						simpleCommentFlag = true;
					}

					// Check if Scanner is in a String

					if (curChar == '"' && !stringFlag && !simpleCommentFlag && !commentFlag && (curLine.charAt(i - 1) != '\\'))
					{
						stringFlag = true;
					} else if (curChar == '"' && stringFlag && !simpleCommentFlag && !commentFlag && (curLine.charAt(i - 1) != '\\'))
					{
						stringFlag = false;
					}

					// Check if Scanner is in a Char

					if (curChar == '\'' && !charFlag && !stringFlag && !simpleCommentFlag && !commentFlag)
					{
						charFlag = true;
					} else if (curChar == '\'' && charFlag && !stringFlag && !simpleCommentFlag && !commentFlag)
					{
						charFlag = false;
					}
				}

				// If the scanner is not in a comment check characters to
				// pop
				// and push

				if (!commentFlag && !simpleCommentFlag && !stringFlag && !charFlag)
				{
					// check if a new balancer is opened, closed early, or
					// left
					// unclosed

					if (curChar == '{' || curChar == '[' || curChar == '(')
					{
						balanceChecker.push(curChar);
					} else if ((curChar == '}' || curChar == ']' || curChar == ')') && balanceChecker.size() != 0)
					{
						char compChar = (char) balanceChecker.pop();

						switch (compChar)
						{
						case ('{'):
							if (curChar != '}')
							{
								return unmatchedSymbol(lineNum, ColNum, curChar, '}');
							}
							break;
						case ('['):
							if (curChar != ']')
							{
								return unmatchedSymbol(lineNum, ColNum, curChar, ']');
							}
							break;
						case ('('):
							if (curChar != ')')
							{
								return unmatchedSymbol(lineNum, ColNum, curChar, ')');
							}
							break;
						}
					} else if (curChar == '}' || curChar == ']' || curChar == ')' && balanceChecker.isEmpty())
					{
						if (curChar == '}')
						{
							return unmatchedSymbol(lineNum, ColNum, curChar, ' ');
						} else if (curChar == ']')
						{
							return unmatchedSymbol(lineNum, ColNum, curChar, ' ');
						} else
						{
							return unmatchedSymbol(lineNum, ColNum, curChar, ' ');
						}

					}
				}
			}
		}
		
		// If comment hasn't ended, send error
		
		if (commentFlag)
		{
			return unfinishedComment();
		}
		
		// If values remain

		if (!balanceChecker.isEmpty())
		{
			char finalChar = (char) balanceChecker.pop();

			switch (finalChar)
			{
			case ('{'):
				if (finalChar != '}')
				{
					return unmatchedSymbolAtEOF('}');
				}
				break;
			case ('['):
				if (finalChar != ']')
				{
					return unmatchedSymbolAtEOF(']');
				}
				break;
			case ('('):
				if (finalChar != ')')
				{
					return unmatchedSymbolAtEOF(')');
				}
				break;
			}

			return unmatchedSymbolAtEOF(finalChar);

		}

		s.close();

		return allSymbolsMatch();
	}

	/**
	 * Returns an error message for unmatched symbol at the input line and
	 * column numbers. Indicates the symbol match that was expected and the
	 * symbol that was read.
	 */
	private static String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected)
	{
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected " + symbolExpected + ", but read " + symbolRead
				+ " instead.";
	}

	/**
	 * Returns an error message for unmatched symbol at the end of file.
	 * Indicates the symbol match that was expected.
	 */
	private static String unmatchedSymbolAtEOF(char symbolExpected)
	{
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Returns an error message for a file that ends with an open /* comment.
	 */
	private static String unfinishedComment()
	{
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Returns a message for a file in which all symbols match.
	 */
	private static String allSymbolsMatch()
	{
		return "No errors found. All symbols match.";
	}
}
