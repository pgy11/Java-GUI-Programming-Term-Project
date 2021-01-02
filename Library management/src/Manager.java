import java.util.*;
public class Manager extends Personal{
	
	private int managerOption;
	private ArrayList<String> message = new ArrayList<>();

	public Manager(){
		super(2014,"0000");
	}
	
	public int getManagerOption() {
		return managerOption;
	}

	public void setManagerOption(int managerOption) {
		this.managerOption = managerOption;
	}
	
	public void setMessage(String message){
		this.message.add(message);
	}

	public ArrayList<String> getMessage(){
		return this.message;
	}
	
	public boolean checkLogIn(int id, String password){
		if(getId() == id){
			if(getPassword().equals(password)){
				return true;
			}
		}
		
		return false;
		
	}

}
