import java.util.*;

public class MemberManage {
	
	public static boolean checkExistanceOfMember(){
		if(GlobalData.memberList.size()>0)
			return true;
		
		return false;
	}
	
	public static boolean logIn(int id,String password){
		int index = searchMemberUsingId(id);
		if(index!=-1){
			if(GlobalData.memberList.get(index).getPassword().equals(password)){
				GlobalData.memberLogInIndex = index;
				return true;
			}else{
				return false;
			}
			
			
		}else{
			return false;
		}
	}
	
	
	
	public static void signUpMember(int id, String password, String name, long phoneNumber, String address){
		Member member = new Member();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setPhoneNumber(phoneNumber);
		member.setAddress(address);
		GlobalData.memberList.add(member);
	}
	
	public static boolean checkDuplicationaddedId(int id){
		
		for(int i =0; i<GlobalData.memberList.size();i++){
			if(id == GlobalData.memberList.get(i).getId())
				return false;
		}
		
		return true;
	}
	
	
	public static boolean checkDuplicationaddedPhonenumber(long pn){
		
		for(int i =0; i<GlobalData.memberList.size();i++){
			if(pn == GlobalData.memberList.get(i).getPhoneNumber())
				return false;
		}
		
		return true;
	}
	
	public static int searchMemberUsingId(int id){
		int i;
		
		for(i=0;i<GlobalData.memberList.size();i++){
			if(GlobalData.memberList.get(i).getId() == id){
				return i;
			}
		}
		return -1;
	}
	
	public static int searchMemberUsingPhoneNumber(long pn){
		
		int i;
		
		for(i=0;i<GlobalData.memberList.size();i++){
			if(GlobalData.memberList.get(i).getPhoneNumber() == pn){
				return i;
			}
		}
		return -1;
	}
	
	public static int checkPassword(String password){
		
		for(int i=0; i< GlobalData.memberList.size();i++){
			if(password.equals(GlobalData.memberList.get(i).getPassword()))
				return i;
		}
		
		 return -1;
	}
	
	public static boolean checkDuplicationUpdatedId(int id){
		for(int i=0; i<GlobalData.memberList.size();i++){
			if(i!=GlobalData.memberLogInIndex)
				if(GlobalData.memberList.get(i).getId() == id)
					return false;
		}
		
		return true;
	}
	
	public static boolean checkDuplicationUpdatedPhonenumber(long pn){
		for(int i=0; i<GlobalData.memberList.size();i++){
			if(i!=GlobalData.memberLogInIndex)
				if(GlobalData.memberList.get(i).getPhoneNumber() == pn)
					return false;
		}
		
		return true;
	}
	
	public static ArrayList<Integer> searchInformationUsingName(String name){
		ArrayList<Integer> indexList = new ArrayList<>();
		for(int i=0; i<GlobalData.memberList.size();i++){
			if(name.equalsIgnoreCase(GlobalData.memberList.get(i).getName())){
				indexList.add(Integer.valueOf(i));
			}
		}
		
		return indexList;
	}

}
