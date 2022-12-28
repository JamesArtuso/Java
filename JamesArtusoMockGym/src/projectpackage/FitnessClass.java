package projectpackage;
/**
 The "fitness class" class is for managing the fitness classes at the gym.
 Members can check into and drop out of classes. The only restriction is if
 the member attempts to check into two classes that run at the same time
 or a class that does not exist. Additionally, they will not be able to check
 into classes if they have already checked into them. They also will not
 be able to drop classes they are not participating in.
 @author James Artuso
 */
public class FitnessClass {
    private MemberDatabase[] classDatabases;
    private Time[] classTypes; //These should line up

    /**
     Fitness class constructor which has its own database of members that
     are associated with the class types array. Class databases is an array
     containing member databases for each class.
     */
    public FitnessClass(){
        classDatabases = new MemberDatabase[3];
        for(int i = 0; i < classDatabases.length;i++){
            classDatabases[i] = new MemberDatabase();
        }
        classTypes = new Time[]{Time.PILATES, Time.SPINNING, Time.CARDIO};
    }

    /**
     Check in method will make sure that members can only check into
     classes that actually exist as well as making sure that they
     can only check into classes if their memberships are valid.
     They also cannot check into multiple fitness classes that
     run at the same exact time. Will give appropriate error messages.
     @param member, the member that is to be checked into a class.
     @param className, the name of the class they would like to attend.
     */
    public void checkIn(Member member, String className) {
        Time classTime = null;
        if(Time.isValid(className.toUpperCase())) {
            classTime = Time.valueOf(className.toUpperCase());
        }else{
            System.out.println(className + " class does not exists.");
            return;
        }

        if(member.isExpired()) {
            System.out.println(member.getFirstName() + " " + member.getLastName() + " " + member.getDob() + " membership expired.");
            return;
        }

        for(int i = 0; i < classDatabases.length; i++){
            if(classTypes[i] != classTime && Time.getTime(classTypes[i]) == Time.getTime(classTime) && classDatabases[i].contains(member)){
                System.out.println(Time.getClassName(classTime) + " time conflict -- " + member.getFirstName() + " " +
                        member.getLastName() + " has already checked in " + Time.getClassName(classTypes[i]) + ".");
                return;
            }
        }

        if(classDatabases[Time.getIndex(classTime)].add(member)) {
            System.out.println(member.getFirstName() + " " + member.getLastName() + " checked in " + className + ".");
        }else{
            System.out.println(member.getFirstName() + " " + member.getLastName() + " has already checked in " + className + ".");
        }
    }

    /**
     Drop class method will remove a member from the corresponding class.
     Conditions are that they must attempt to drop a class that
     exists and that they can only drop classes that they
     have first checked into. Will give appropriate error messages.
     @param member, the member that is to be checked into a class.
     @param className, the name of the class they would like to attend.
     */
    public void dropClass(Member member, String className){
        Time classTime = null;

        if(Time.isValid(className.toUpperCase())) {
            classTime = Time.valueOf(className.toUpperCase());
        }else{
            System.out.println(className + " class does not exists.");
            return;
        }

        if(classDatabases[Time.getIndex(classTime)].remove(member)){
            System.out.println(member.getFirstName() + " " + member.getLastName() + " dropped " + Time.getClassName(classTime) + ".");
        }else{
            System.out.println(member.getFirstName() + " " + member.getLastName() + " is not a participant in " + Time.getClassName(classTime) + ".");
        }
    }

    /**
     Method to display the name and time of the currently offered fitness classes.
     Will also display the instructor of the class and the classes current
     participants. Meaning the currently checked in members.
     */
    public void displaySchedule(){
        System.out.println("-Fitness Classes-");
        for(int i = 0; i < classTypes.length; i++){
            System.out.println(classTypes[i]);
            if(classDatabases[i].getSize() != 0) {
                MemberDatabase currentClass = classDatabases[i];
                System.out.println("\t** participants **");
                System.out.println(classDatabases[i].fitnessClassList() + "\n");
            }
        }
    }
}