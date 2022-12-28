package projectpackage;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 This class will run the program, continuously taking user input until the user exits the program.
 The user will add, remove and sort the member database and or the gym class check in database.
 The class also will provide the user with appropriate error messages based upon their input.
 @author James Artuso
 */
public class GymManager {
    private MemberDatabase memberDatabaseObj = new MemberDatabase();
    private FitnessClass fitnessClassObj = new FitnessClass();

    private static final int ADDCOMMANDLENGTH = 6;
    private static final int CLASSCOMMANDLENGTH = 5;
    private static final int REMOVECOMMANDLENGTH = 4;

    private static final int FNAMEPOSITION = 1;
    private static final int LNAMEPOSITION = 2;
    private static final int DOBPOSITION = 3;
    private static final int EXPPOSITION = 4;
    private static final int LOCPOSITION = 5;

    private static final int CLASSFNAMEPOSITION = 2;
    private static final int CLASSLNAMEPOSITION = 3;
    private static final int CLASSDOBPOSITION = 4;
    private static final int CLASSNAMEPOSITION = 1;

    public static final String FAILCOMMAND = "F";

    public static final String ADD = "A";
    public static final String REMOVE = "R";
    public static final String PRINT = "P";
    public static final String PRINTCOUNTY = "PC";
    public static final String PRINTDATE = "PD";
    public static final String PRINTNAME = "PN";
    public static final String FITNESSDISPLAY = "S";
    public static final String CHECKIN = "C";
    public static final String DROP = "D";
    public static final String QUIT = "Q";


    /**
     This method is used to make sure the users date of birth and expiration date are valid as well as
     making sure that the person is at least 18 years or older. If so will return true.
     @param member that is to be added, performs error checking on this member.
     @return boolean, return true if errorChecking has passed, false if there is an error
     */
    private boolean hasValidDates(Member member){
        if (member.getDob().isValid()) {
            if (member.getExpirationDate().isValid()) {
                if (member.isEighteen()) {
                    return true;
                }else{
                    if (!member.isBorn()) {
                        System.out.println("DOB " + member.getDob() + ": cannot be today or a future date!");
                    }else{
                        System.out.println("DOB " + member.getDob() + ": must be 18 or older to join!");
                    }
                }
            }else{
                System.out.println("Expiration date " + member.getExpirationDate() + ": invalid calendar date!");
            }
        }else{
            System.out.println("DOB " + member.getDob() + ": invalid calendar date!");
        }
        return false;
    }

    /**
     This method is used to make sure a String input is in the correct Date format
     ##/##/##
     @param dateString, the string being tested.
     @return boolean, true if format is correct, false otherwise.
     */
    private boolean isValidDate(String dateString){
        StringTokenizer token = new StringTokenizer(dateString, "/", false);

        try{
            while(token.hasMoreTokens()){
                Integer.parseInt(token.nextToken());
            }
        }

        catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    /**
     Method to add members to the database, calls upon create member to
     process user input and create the member based on the input.
     Then will give a message to indicate whether the user was added or not.
     @param inputArray, takes the user input which is stored in this array.
     */
    private void addMember(String[] inputArray){
        Member member = inputMember(inputArray);
        if (member == null) {
            return;
        }

        if (hasValidDates(member)) {
            if (memberDatabaseObj.add(member)) {
                System.out.println(member.getFullName() + " added.");

            }else{
                System.out.println(member.getFullName() +
                        " is already in the database.");
            }
        }
    }

    /**
     Method will check for correct input length and if so will either remove the member
     or tell the user that the member is not in the database. Calls upon the remove method
     from the MemberDatabase class, determines print statement from the return value.
     @param inputArray, takes the user input which is stored in this array.
     */
    private void removeMember(String[] inputArray){

        Member member = inputMember(inputArray);

        if (memberDatabaseObj.remove(member)) {
            System.out.println(member.getFullName() + " removed.");

        }else{
            System.out.println(member.getFullName() + " is not in the database.");
        }
    }

    /**
     Method will either check the member into the corresponding class
     or return an error if the user inputted class is non-existent
     @param inputArray, takes the user input which is stored in this array.
     */
    private void fitnessClassAdd(String[] inputArray){
        String className = inputArray[CLASSNAMEPOSITION];
        Member searchMember = inputMember(inputArray);
        if(searchMember == null){
            return;
        }

        if (hasValidDates(searchMember)) {
            Member member = memberDatabaseObj.getMember(searchMember);
            if (member == null) {
                System.out.println(searchMember.getFullName() + " " + searchMember.getDob()
                        + " is not in the database.");
                return;
            }
            fitnessClassObj.checkIn(member, className);
        }
    }

    /**
     Method will call the dropClass method from fitness class.
     That method will print result based on user input.
     @param inputArray, takes the user input which is stored in this array.
     */
    private void fitnessClassDrop(String[] inputArray){
        Member searchMember = inputMember(inputArray);
        if(searchMember == null){
            return;
        }
        String className = inputArray[CLASSNAMEPOSITION];

        if(hasValidDates(searchMember)){
            Member member = memberDatabaseObj.getMember(searchMember);

            if(member == null) {
                fitnessClassObj.dropClass(searchMember, className);

            }else{
                fitnessClassObj.dropClass(member, className);
            }
        }
    }

    /**
     Helper method to process user input, check if location and dates are valid.
     Then will construct member with user input or give an error accordingly.
     @param inputArray, takes in the user input that is stored in the array
     @return member, will return the created member.
     */
    private Member inputMember(String[] inputArray){
        if(inputArray.length == ADDCOMMANDLENGTH) {
            if(Location.isValid(inputArray[LOCPOSITION].toUpperCase())) {
                if(!isValidDate(inputArray[DOBPOSITION]) || !isValidDate(inputArray[EXPPOSITION])){
                    System.out.println("Invalid Date format. Please use ##/##/##.");
                    return null;
                }
                return new Member(inputArray[FNAMEPOSITION], inputArray[LNAMEPOSITION],
                        inputArray[DOBPOSITION], inputArray[EXPPOSITION],
                        Location.valueOf(inputArray[LOCPOSITION].toUpperCase()));

            }else{
                System.out.println(inputArray[LOCPOSITION] + ": invalid location!");
                return null;
            }

        }else if(inputArray.length == CLASSCOMMANDLENGTH){
            return inputMember(new String[]
                    {"", inputArray[CLASSFNAMEPOSITION], inputArray[CLASSLNAMEPOSITION],
                            inputArray[CLASSDOBPOSITION], "1/1/9999", "PISCATAWAY"});
        }else{
            return inputMember(new String[]{"", inputArray[FNAMEPOSITION],
                    inputArray[LNAMEPOSITION], inputArray[DOBPOSITION],
                    "1/1/9999", "PISCATAWAY"});
        }
    }

    /**
     * Helper method to process user input, check if there are members in the database,
     * and choose correct print command.
     * @param command, Takes the command as a string
     */
    private void printController(String command){
        if(memberDatabaseObj.getSize()==0){
            System.out.println("Member database is empty!");
            return;
        }
        switch(command){
            case PRINT  -> memberDatabaseObj.print();
            case PRINTCOUNTY -> memberDatabaseObj.printByCounty();
            case PRINTNAME -> memberDatabaseObj.printByName();
            case PRINTDATE -> memberDatabaseObj.printByExpirationDate();
        }
    }

    /**
     * Helper method to check if the user input is of the correct length.
     * @param inputArray, user input stored as an array
     * @return returnBool, returns if the input has the correct number of tokens.
     */
    private boolean correctInputLength(String[] inputArray){
        String command = inputArray[0];
        boolean returnBool = true;
        switch(command){
            case ADD -> returnBool = inputArray.length == ADDCOMMANDLENGTH;
            case REMOVE -> returnBool = inputArray.length == REMOVECOMMANDLENGTH;
            case DROP, CHECKIN -> returnBool = inputArray.length == CLASSCOMMANDLENGTH;
        }
        return returnBool;
    }

    /**
     Method that will continuously take user input until the user exits the program.
     Scans in user input, splits and loads it into a string array called "inputArray"
     Has switch statements based upon which command the user inputted and will call
     upon the appropriate method from MemberDatabase class. Will let the user know
     if they attempted an invalid or non-existent command.
     */
    public void run (){
        System.out.println("Gym Manager running...\n");
        Scanner input = new Scanner(System.in);
        while(true) {
            String userInput = input.nextLine();
            String[] inputArray = userInput.split(" ");
            String command = inputArray[0];
            if(!correctInputLength(inputArray)){
                command = FAILCOMMAND;
            }

            switch (command) {
                case ADD  -> addMember(inputArray);
                case REMOVE  -> removeMember(inputArray);
                case PRINT, PRINTNAME, PRINTCOUNTY, PRINTDATE  -> printController(command);
                case FITNESSDISPLAY  -> fitnessClassObj.displaySchedule();
                case CHECKIN  -> fitnessClassAdd(inputArray);
                case DROP  -> fitnessClassDrop(inputArray);
                case QUIT  -> {
                    System.out.println("Gym Manager terminated.");
                    input.close();
                    System.exit(0);
                }
                case FAILCOMMAND -> {
                    System.out.println("Bad Input. Please follow correct format.");
                }
                default -> {
                    if(!command.isBlank()) {
                        System.out.println(command + " is an invalid command!");
                    }
                }
            }
        }
    }

}