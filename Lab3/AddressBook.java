import java.util.HashSet;
import java.util.Set;

public class AddressBook {
	private static Set<BuddyInfo> book = new HashSet<BuddyInfo>();
	
	public static void main(String[] args) {
		System.out.println("Address Book");
		BuddyInfo buddy = new BuddyInfo("bud", 78, 89);
		addBuddy(buddy);
		removeBuddy(buddy);
	}
	public static boolean addBuddy(BuddyInfo buddy) {
		if(book.contains(buddy)) {
			return false;
		}
		else {
			book.add(buddy);
			return true;
		}
	}
	public static boolean removeBuddy(BuddyInfo buddy) {
		if(book.contains(buddy)) {
			book.remove(buddy);
			return true;
		}
		else {
			return false;
		}
	}
}
