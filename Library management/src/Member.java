import java.util.*;

public class Member extends Personal{
	private String name;
	

	private long phoneNumber;
	private String address;
	private Date dateCreated;
	private ArrayList<Book> borrowedBook ;
	private ArrayList<String> message;
	private int memberOption;
	public Member(){
		dateCreated = new Date();
		message = new ArrayList<>();
		borrowedBook =  new ArrayList<>();
		
	}

	public int getMemberOption() {
		return memberOption;
	}

	public void setMemberOption(int memberOption) {
		this.memberOption = memberOption;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDateCreated(){
		return this.dateCreated.toString();
	}
	
	public void setBookToBorrow(Book book){
		this.borrowedBook.add(book);
	}
	
	public ArrayList<Book> getBorrowedBook(){
		return this.borrowedBook;
	}
	
	public void setMassage(String message){
		this.message.add(message);
	}
	
	public ArrayList<String> getMessage(){
		return this.message;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
