//Honor Code: I have neither given nor received unauthorized aid on this assignment.

import java.util.ArrayList;

public class Word implements Comparable <Word> {

	private String word;
	private ArrayList <String> fileList = new ArrayList <String>();
	
	public Word (String w) {
		this.word = w;
	}
	
	public void setFileList (ArrayList<String> f) { //sets array of files with the word
		this.fileList = f;
	}
	
	public ArrayList <String> getFileList() { //returns array of files with the word
		return this.fileList;
	}
	
	public void setWord (String w) { //sets the wanted word
		this.word = w;
	}
	
	public String getWord () { //gets the wanted word 
		return this.word;
	}
	
	public void add(String f) { //adds a file to the list of files
		this.fileList.add(f);
	}

	public String toString() {
		return "File containing " + this.word + ": " + this.getFileList();
	}

	@Override
	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		return this.word.compareTo(o.word); //compares the wanted word to the word object o
	}
	
}
