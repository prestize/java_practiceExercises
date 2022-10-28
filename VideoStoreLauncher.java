import java.util.ArrayList;
import java.util.Scanner;

class Video{
	private String vidTitle;
	private boolean isCheckedOut = false;
	private float avgUserRating=0;
	private int ratingCount;
	private int ratingSum;
	
	public void checkOut() {
		isCheckedOut = true;
	}
	
	public void returnVid() {
		isCheckedOut = false;
	}
	
	public void setVidTitle(String title) {
		vidTitle = title;
	}
	
	public String getVidTitle() {
		return vidTitle;
	}
	
	public boolean getVidStatus() {
		return isCheckedOut;
	}
	
	public void addRating(int newRating){
		ratingCount++;
		ratingSum = ratingSum + newRating;
		avgUserRating = ratingSum/ratingCount;
	}
	
	public float getAvgRating() {
		return avgUserRating;
	}
	
}

class VideoStore{
	private Video[] catalogue = new Video[10];
	private int videoCount;
	
	public void addVideo(String title) {
		if(videoCount>10) {
			System.out.println("Sorry, the shelves are full");
		}
		else {
		catalogue[videoCount] = new Video();
		catalogue[videoCount].setVidTitle(title);
		videoCount++;
		System.out.println("Successfully added.");
		}
	}
	
	public void checkout(int videoIndex) {
		catalogue[videoIndex].checkOut();
		System.out.println("Successful checkout.");
	}
	
	public void returnVideo(int videoIndex) {
		catalogue[videoIndex].returnVid();
		System.out.println("Successfully returned.");
	}
	
	public void receiveRating(int videoIndex, int rating) {
		if(rating<1 || rating>5) {
			System.out.println("Wrong Input.");
		}
		else {
			catalogue[videoIndex].addRating(rating);
			System.out.println("Successfully rated.");
		}
	}
	
	public void displayStatus(int videoIndex){
		boolean status;
		status = catalogue[videoIndex].getVidStatus();
		
		if(status==true) {
			System.out.println("The video \""+ catalogue[videoIndex].getVidTitle() + "\" is checked out and not available.");
		}
		else if(status==false){
			System.out.println("The video \""+ catalogue[videoIndex].getVidTitle() + "\" is not checked out and available.");
		}
		
	}
	
	public void listInventory() {
		int index = videoCount-1;
		System.out.println("Videostore's Inventory");
		
		while(index >= 0) {
			if(catalogue[index].getVidStatus()==true) {
				System.out.println(index + "\t" + catalogue[index].getVidTitle() + "\tRented" + "\t" + catalogue[index].getAvgRating());
			}
			else if(catalogue[index].getVidStatus()==false) {
				System.out.println(index + "\t" + catalogue[index].getVidTitle() + "\tAvailable" + "\t" + catalogue[index].getAvgRating());
			}
		index  = index - 1;
		}
	}
}



public class VideoStoreLauncher {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		VideoStore shop = new VideoStore();
		shop.addVideo("The Game");
		shop.addVideo("The Conjuring");
		//Home
		System.out.println("Welcome to the Video Store");
		System.out.println("Are you an admin(1) or a user(0)?:");
		System.out.print("Input:");
		int ans = reader.nextInt();
		String newVideoTitle;
		
		if(ans == 1) {
			System.out.println("Add a new video(0)");
			System.out.println("Display Inventory(1)");
			System.out.print("Input:");
			ans = reader.nextInt();
			
			if(ans == 1) {
				shop.listInventory();
			}
			else if (ans == 0) {
				System.out.print("\nEnter New Video Title:");
				newVideoTitle = reader.next();
				shop.addVideo(newVideoTitle);
				shop.listInventory();
			}
			else {
				System.out.println("Wrong Input.");
			}
			
		}
		else if (ans == 0) {
			System.out.println("Check Masterlist(0)");
			System.out.println("Rent a Video(1)");
			System.out.print("Return a Video(2)");
			System.out.print("\nInput:");
			ans = reader.nextInt();
			

			if(ans == 0) {
				shop.listInventory();
			}
			else if (ans == 1) {
				shop.listInventory();
				System.out.println("-Rent a Video-");
				System.out.print("\nEnter Video Title Index:");
				ans = reader.nextInt();
				shop.checkout(ans);
				shop.listInventory();
			}
			else if (ans == 2) {
				shop.listInventory();
				System.out.println("-Return a Video-");
				System.out.print("\nEnter Video Title Index:");
				ans = reader.nextInt();
				shop.returnVideo(ans);
				System.out.print("\nEnter Video Rating (1-5):");
				int ansRating = reader.nextInt();
				shop.receiveRating(ans, ansRating);
				shop.listInventory();
			}
			else {
				System.out.println("Wrong Input.");
			}
			
		}
		else {
			System.out.println("Wrong Input.");
		}
		
		
	}

}

