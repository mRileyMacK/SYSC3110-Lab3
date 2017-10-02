
public class BuddyInfo {
	private String name;
	private int heightInCentimetres;
	private int gradeInPercentage;
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuddyInfo homer = new BuddyInfo();
		homer.setName("Homer");
		System.out.println("Hello " + homer.getName() + "!");
		homer.setHeightInCentimetres(67);
		System.out.println("I'd say you're, " + homer.getHeightInCentimetres() + " inches tall. But who knows, it's in fucking imperial");
		homer.setGradeInPercentage(95);
		System.out.println("Your grade is a " + homer.getGradeInPercentage() + ", so like a C+");
	}*/
	BuddyInfo(String name, int height, int grade){
		this.name = name;
		heightInCentimetres = height;
		gradeInPercentage = grade;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the heightInCentimetres
	 */
	public int getHeightInCentimetres() {
		return heightInCentimetres;
	}

	/**
	 * @param heightInCentimetres the heightInCentimetres to set
	 */
	public void setHeightInCentimetres(int heightInCentimetres) {
		this.heightInCentimetres = heightInCentimetres;
	}

	/**
	 * @return the gradeInPercentage
	 */
	public int getGradeInPercentage() {
		return gradeInPercentage;
	}

	/**
	 * @param gradeInPercentage the gradeInPercentage to set
	 */
	public void setGradeInPercentage(int gradeInPercentage) {
		this.gradeInPercentage = gradeInPercentage;
	}

}
