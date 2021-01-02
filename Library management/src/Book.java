import java.time.*;
import java.util.*;

public class Book {
	
	private int serialNumber; // Unique number
	private String name;
	private String writer;
	private int amount; // Number of the book
	private String publisher; // Company which publishes the book
	
	
	
	private Date dateCreated; // Date of the book added
	private LocalDateTime dateBorrowed;
	private LocalDateTime dateReturned;
	private ArrayList<Member> memberWhoBorrowsBook;
	
	
	public Book(){
		dateCreated = new Date();
		memberWhoBorrowsBook = new ArrayList<>();
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getDateCreated(){
		return this.dateCreated.toString();
	}
	
	public void setDateBorrowed(){
		
		this.dateBorrowed = LocalDateTime.now();
		
	}
	
	public String getDateBorrowed(){
		return this.dateBorrowed.toString();
	}
	
	public void setDateReturned(){
		this.dateReturned = this.dateBorrowed.plusDays(14);
	}
	
	public String getDateRetuend(){
		return this.dateReturned.toString();
	}
	
	public void setMemberWhoBoorowsBook(Member member){
		memberWhoBorrowsBook.add(member);
	}
	
	public ArrayList<Member> getMemberWhoBorrowsBook(){
		
		return this.memberWhoBorrowsBook; 
	}
	
	public void incrementAmount(){
		this.amount++;
	}
	
	public void decrementAmount(){
		this.amount--;
	}
	
	public void prolongReturnDate(){
		this.dateReturned = this.dateBorrowed.plusDays(28);
	}

}
