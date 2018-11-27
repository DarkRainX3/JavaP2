
public class Word {
	private String originalWord;
	private String abcWord;
	private Word next;
	
	public Word(String word) {
		setOriginalWord(word);
		sortWord(word);
	}
	
	private void sortWord(String word) {
		char temp[] = word.toCharArray();
		for (int i = 1, j; i<temp.length;i++) {
			char current = temp[i];
			for (j = i; j>0 && current <temp[j-1]; j--)
				temp[j]=temp[j-1];
			temp[j]=current;
		}
		setAbcWord(new String(temp));
	}

	public Word getNext() {
		return next;
	}

	public void setNext(Word next) {
		this.next = next;
	}

	public String getAbcWord() {
		return abcWord;
	}

	public void setAbcWord(String abcWord) {
		this.abcWord = abcWord;
	}

	public String getOriginalWord() {
		return originalWord;
	}

	public void setOriginalWord(String originalWord) {
		this.originalWord = originalWord;
	}
	
	@Override
	public String toString() {
		return originalWord + " Sorted Word = "+abcWord;
	}

}
