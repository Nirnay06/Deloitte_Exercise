package exercise;


//this is the super class Item
abstract class Item {
private int uin;
private String title;
private int numberOfCopies;

public Item(int uin, String title, int numberOfCopies) {
	super();
	this.uin = uin;
	this.title = title;
	this.numberOfCopies = numberOfCopies;
}

public int getUin() {
	return uin;
}
public void setUin(int uin) {
	this.uin = uin;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getNumberOfCopies() {
	return numberOfCopies;
}
public void setNumberOfCopies(int numberOfCopies) {
	this.numberOfCopies = numberOfCopies;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Item other = (Item) obj;
	if (numberOfCopies != other.numberOfCopies)
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	if (uin != other.uin)
		return false;
	return true;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Item[ uin = "+uin+",title = "+title+", no of copies = "+numberOfCopies+"]";
}

}



// this is the sub class writtenItem

abstract class WrittenItem extends Item{
	private String author;

	public WrittenItem(int uin, String title, int numberOfCopies,String author) {
		super(uin, title, numberOfCopies);
		this.author=author;
		// TODO Auto-generated constructor stub
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}


 class Book extends WrittenItem{

	public Book(int uin, String title, int numberOfCopies, String author) {
		super(uin, title, numberOfCopies, author);
	}

	@Override
	public String toString() {
		return "Book [ Author =" + getAuthor() + ", Uin =" + getUin() + ", Title =" + getTitle()
				+ ", NumberOfCopies =" + getNumberOfCopies() +  "]";
	}
		
}
 
 class JournalPaper extends WrittenItem{
	private int yearPublished;

	public JournalPaper(int uin, String title, int numberOfCopies, String author, int yearPublished) {
		super(uin, title, numberOfCopies, author);
		this.yearPublished = yearPublished;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	@Override
	public String toString() {
		return "JournalPaper [yearPublished=" + yearPublished + ", Author " + getAuthor() + ", Uin ="
				+ getUin() + ", Title =" + getTitle() + ", NumberOfCopies =" + getNumberOfCopies() + "]";
	}
 }
 
 
 class MediaItem extends Item{
	 private int runtime;

	public MediaItem(int uin, String title, int numberOfCopies, int runtime) {
		super(uin, title, numberOfCopies);
		this.runtime = runtime;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	 
 }
 
 
 class Video extends MediaItem{
	 private String director;
	 private String genre;
	 private int yearReleased;
	
	public Video(int uin, String title, int numberOfCopies, int runtime, String director, String genre,
			int yearReleased) {
		super(uin, title, numberOfCopies, runtime);
		this.director = director;
		this.genre = genre;
		this.yearReleased = yearReleased;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getYearReleased() {
		return yearReleased;
	}
	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}
	@Override
	public String toString() {
		return "Video [director=" + director + ", genre=" + genre + ", yearReleased=" + yearReleased + ", Runtime ="
				+ getRuntime() + ",Uin =" + getUin() + ", Title =" + getTitle() + ", NumberOfCopies ="
				+ getNumberOfCopies() + "]";
	}
 }
 
 
class CD extends MediaItem{
	private String artist;
	private String genre;
	public CD(int uin, String title, int numberOfCopies, int runtime, String artist, String genre) {
		super(uin, title, numberOfCopies, runtime);
		this.artist = artist;
		this.genre = genre;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "CD [artist=" + artist + ", genre=" + genre + ", Runtime =" + getRuntime() + ", Uin =" + getUin()
				+ ", Title =" + getTitle() + ", NumberOfCopies =" + getNumberOfCopies() + "]";
	}
}


public class LAB2{
	public static void main(String args[])
	{
		Item[] items=new Item[4];
		items[0]=new Book(12,"Alchemist", 200, "paul coleo");
		items[1]=new JournalPaper(81, "The need for cyber security", 300, "Nirnay", 2017);
		items[2]=new Video(21, "java", 250, 50, "sumit", "learning", 2018);
		items[3]=new CD(41, "win Xp BOOT", 40, 0, "Microsoft", "operating systems");
		
		Item j;
		for(int i=0;i<4;i++)
		{
			j=items[i];
			System.out.println(j.toString()+"\n");
		}
		
	}
}