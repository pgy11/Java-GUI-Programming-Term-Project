import java.util.*;

public class BookManage {
	
	public static boolean checkExistanceOfBook(){
		if(GlobalData.bookList.size() >0)
			return true;
		
		return false;
	}
	
	
	public static boolean checkDuplicationAddedSerialNumber(int snumber){
		int i;
		
		for(i=0; i<GlobalData.bookList.size();i++){
			if(snumber == GlobalData.bookList.get(i).getSerialNumber())
				return false;
		}
		
		return true;
	}
	
	public static void addBook(int snumber, String name, String writer, int amount, String publisher){
		Book book = new Book();
		book.setSerialNumber(snumber);
		book.setWriter(writer);
		book.setName(name);
		book.setAmount(amount);
		book.setPublisher(publisher);
		GlobalData.bookList.add(book);
		
	}
	
	public static int searchBookUsingSerialNumber(int snumber){
		int index;
		for(index = 0; index < GlobalData.bookList.size();index++){
			if(snumber == GlobalData.bookList.get(index).getSerialNumber()){
				return index;
			}
		}
		
		return -1;
	}
	
	public static ArrayList<Integer> searchBookUsingBookName(String name){
		ArrayList<Integer> indexList = new ArrayList<>();
		int i;
		for(i=0; i<GlobalData.bookList.size();i++){
			if(GlobalData.bookList.get(i).getName().equalsIgnoreCase(name)){
				indexList.add(Integer.valueOf(i));
			}
		}
		
		return indexList;
		
	}
	
	public static ArrayList<Integer> searchBookUsingWriter(String writer){
		ArrayList<Integer> indexList = new ArrayList<>();
		int i;
		for(i=0; i<GlobalData.bookList.size();i++){
			if(GlobalData.bookList.get(i).getWriter().equalsIgnoreCase(writer)){
				indexList.add(Integer.valueOf(i));
			}
		}
		
		return indexList;
	}
	
	public static ArrayList<Integer> searchBookUsingPublisher(String publisher){
		ArrayList<Integer> indexList = new ArrayList<>();
		int i;
		for(i=0; i<GlobalData.bookList.size();i++){
			if(GlobalData.bookList.get(i).getPublisher().equalsIgnoreCase(publisher)){
				indexList.add(Integer.valueOf(i));
			}
		}
		
		return indexList;
	}
	
	public static boolean checkDuplicationUpdatedSerialNumber(int id, int index){
		int i;
		for(i=0; i<GlobalData.bookList.size();i++){
			if(index != i)
				if(id == GlobalData.bookList.get(i).getSerialNumber())
					return false;
		}
		
		return true;
	}
	
	public static void updateBookSerialNumber(int snumber, int index){
		GlobalData.bookList.get(index).setSerialNumber(snumber);
	}
	
	public static void updateBookName(String name, int index){
		GlobalData.bookList.get(index).setName(name);
	}
	
	public static void updateBookWriter(String writer, int index){
		GlobalData.bookList.get(index).setWriter(writer);
	}
	
	public static void updateBookAmount(int amount,int index){
		GlobalData.bookList.get(index).setAmount(amount);
	}
	
	public static void updateBookPublisher(String publisher, int index){
		GlobalData.bookList.get(index).setPublisher(publisher);
	}
	
	public static int  SearchBookMemberBorrowedUsingSerialNumber(Member member,int id){
		for(int i=0; i<member.getBorrowedBook().size();i++){
			if(member.getBorrowedBook().get(i).getSerialNumber() == id){
				return i;
			}
		}
		return -1;
	}

}
