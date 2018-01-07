package kr.hilu0318.calculation;

import java.util.ArrayList;
import java.util.List;

public class PageCal {
	private int numOfLine;		//View Number of Pagination
	private int currentPage;	
	private int beginPage;		//Pagination - start Number
	private int endPage;		//Pagination - end Number
	private boolean nextGroup;	//Exist Next Pagination
	private boolean prevGroup;	//Exist Prev Pagination
	public List<Integer> pagelist;	//Pagination Number List of this Page
	
	public PageCal(int currentPage, int numOfLine, int lineOfPage, int total) {
		int lastPage = total % lineOfPage > 0 ? total/lineOfPage + 1 : total/lineOfPage;
		int lastGroup = lastPage % numOfLine > 0 ? lastPage/numOfLine + 1 : lastPage/numOfLine;
		
		this.currentPage = currentPage;
		if(lastPage < currentPage || currentPage < 1)
			this.currentPage = 1;
		
		this.numOfLine = numOfLine;
		
		this.beginPage = (this.currentPage - 1) / numOfLine * numOfLine + 1;
		this.endPage = this.beginPage + numOfLine > lastPage ? lastPage : this.beginPage + numOfLine;
		
		int currentGroup = this.beginPage / numOfLine + 1;
		
		this.nextGroup = currentGroup < lastGroup ? true : false;
		this.prevGroup = currentGroup > 1 ? true : false;
		
		List<Integer> list = new ArrayList<>();
		for(int i = this.beginPage; i < this.endPage + 1; i++)
			list.add(i);
		this.pagelist = list;
	}
	
	public int getNumOfLine() { return this.numOfLine; }
	public int getCurrentPage() { return this.currentPage; }
	public int getBeginPage() { return this.beginPage; }
	public int getEndPage() { return this.endPage; }
	public boolean getNextGroup() { return this.nextGroup; }
	public boolean getPrevGroup() { return this.prevGroup; }
	public List<Integer> getPagelist(){	return this.pagelist;}
	
	public String toString() {
		return "PageCal [numOfLine="+this.numOfLine+", currentPage="+this.currentPage+", beginPage="+this.beginPage+
				", endPage="+this.endPage+", nextGroup="+this.nextGroup+", prevGroup="+this.prevGroup+", pagelist="+this.pagelist+"]";
	}
}
