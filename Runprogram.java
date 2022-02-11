package casestudy;

public class Runprogram {
	
	public static void main(String[] args) {

        Book book1 = new Book(14, "The Alchemist", 5, "Paulo Coelho");
        System.out.println(book1);
        
        book1.checkOut();
        System.out.println("\nAfter the book was checked-out, the number of copies changed. The new info is: ");
        
        System.out.println("\n"+book1);
        
        book1.checkIn();
        System.out.println("\nAfter a new copy of this book was added, the number of copies changed. The new info is: ");
        
        System.out.println("\n"+book1);
        
        System.out.println("-----------------------------------------------------");
        
        Video video1 = new Video(23, "Money Heist", 3, 215, "Issac Newton ", "drama", 1981);
        System.out.println(video1);
        
        video1.checkIn();
        System.out.println("\nAfter the video was checked-in, the number of copies changed. The new info is:");
        System.out.println("\n"+video1);
        
}

}
//---------------------------------Super Class  Item---------------------------------------------//
abstract class Item {
private int idNum;
private String title;
private int numCopies;

public Item() {
        idNum = 0;
        title = " ";
        numCopies = 0;
}

public Item(int idNum, String title, int numCopies) {
        this.idNum = idNum;
        this.title = title;
        this.numCopies = numCopies;
}

public int setidNum(int id) {
        idNum = id;
        return id;
}

public String setTitle(String str) {
        title = str;
        return str;
}

public int setNumCopies(int n) {
        numCopies = n;
        return n;
}

public int getidNum() {
        return idNum;
}

public String getTitle() {
        return title;
}

public int getCopies() {
        return numCopies;
}

public void checkIn() {
        numCopies = numCopies + 1;
}

public void checkOut() {
        numCopies = numCopies - 1;
}

public void addItem(int idNum, String str, int n) {
        setidNum(idNum);
        setTitle(str);
        setNumCopies(n);
}

public String toString() {
        return "ID: " + idNum + " \nTitle: " + title + " \nNumber of Copies: " + numCopies;
}

public void print() {
        System.out.println("Title: " + title);
        System.out.println("ID: " + idNum);
        System.out.println("Number of copies: " + numCopies);
}

public boolean equals(Object obj) {
        if (obj == null)
                return false;
        Item otherItem = (Item) obj;
        return idNum == otherItem.idNum && title == otherItem.title && numCopies == otherItem.numCopies;
}

public void addItem() {
        numCopies++;
}
}

//--------------------------------Written-Item Class---------------------------------------------//

abstract class WrittenItem extends Item {
private String author;

public WrittenItem(int id, String title, int numCopies) {
        super(id, title, numCopies);
}

public WrittenItem() {
        super();
}

public WrittenItem(int id, String title, int numCopies, String author) {
        this(id, title, numCopies);
        this.author = author;
}

void setAuthor(String str) {
        author = str;
}

String getAuthor() {
        return author;
}

public int getIdNum() {
        return super.getidNum();
}

public String getTitle() {
        return super.getTitle();
}

public int getNumCopies() {
        return super.getCopies();
}

public boolean equals(Object obj) {
        if (obj == null)
                return false;
        WrittenItem otherWrittenItem = (WrittenItem) obj;
        return super.equals(otherWrittenItem) && author == otherWrittenItem.author;
}

@Override
public String toString() {
        return super.toString() + "\nAuthor: "+author;
}
}

//--------------------------------------Book Class----------------------------------------------//

class Book extends WrittenItem {
public Book() {
        super();
}

public Book(int id, String str, int numCopies) {
        super(id, str, numCopies);
}

public Book(int id, String str, int numCopies, String author) {
        super(id, str, numCopies, author);
}

public boolean equals(Object obj) {
        if (obj == null)
                return false;
        Book otherBook = (Book) obj;
        return super.equals(otherBook);
}

public String toString() {
        return "Display info about a book:\n"+super.toString();
}

public int getIdNum() {
        return super.getIdNum();
}

public String getTitle() {
        return super.getTitle();
}

public int getNumCopies() {
        return super.getNumCopies();
}

public String getAuthor() {
        return super.getAuthor();
}

public void print() {
        System.out.println("Display info about a book: ");
        super.print();
}

public void checkIn() {
        super.checkIn();
}

public void checkOut() {
        super.checkOut();
}

public void addItem() {
        super.addItem();
}
}

//------------------------------------JournalPaper Class-----------------------------------------//

class JournalPaper extends WrittenItem {
private int pubYear;

JournalPaper() {
        super();

}

public JournalPaper(int idNum, String str, int n, String author, int y) {
        super(idNum, str, n, author);
        pubYear = y;
}

public String toString() {
        return super.toString() + " Year published: " + pubYear;
}

public int getIdNum() {
        return super.getIdNum();
}

public String title() {
        return super.getTitle();
}

public int numCopies() {
        return super.getNumCopies();
}

public String getAuthor() {
        return super.getAuthor();
}

public int yearPub() {
        return this.pubYear;
}

public void print() {
        super.print();
        System.out.println("Year published: " + pubYear);
}

public void checkIn() {

}

public void checkOut() {

}

public void addItem() {
        super.addItem();
}
}

//-------------------------------------Media-Item Class------------------------------------------//

abstract class MediaItem extends Item{
private int runTime;

public MediaItem(int idNum, String title, int numCopies, int runTime) {
        super(idNum, title, numCopies);
        this.runTime = runTime;
}

public int getRunTime() {
        return runTime;
}

public boolean equals(Object obj) {
        if (obj == null)
                return false;
        MediaItem otherMediaItem = (MediaItem) obj;
        return super.equals(otherMediaItem) && runTime == otherMediaItem.runTime;
}
}

//-------------------------------------Video Class-----------------------------------------------//

class Video extends MediaItem {
private String directior;
private String genre;
private int year;

public Video(int idNum, String title, int numCopies, int runTime, String directior, String genre, int year) {
        super(idNum, title, numCopies, runTime);
        this.directior = directior;
        this.genre = genre;
        this.year = year;
}

@Override
public String toString() {
        return "Display info about a video:\n"+super.toString()+"\nrunTime: "+super.getRunTime()+""
                        + "\n director: "+directior+"\ngenre: "+genre+"\nyear: "+year;
}
}

//---------------------------------------CD Class------------------------------------------------//

class CD extends MediaItem {
private String artist;
private String genre;

public CD(int idNum, String title, int numCopies, int runTime, String artist, String genre) {
        super(idNum, title, numCopies, runTime);
        this.artist = artist;
        this.genre = genre;
}


}





