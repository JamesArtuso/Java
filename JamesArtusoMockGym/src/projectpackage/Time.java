package projectpackage;
/**
 This Time enum class is for the time data type, gives time, instructor and name of the fitness classes.
 Time objects have class name, class instructor and time of the class.
 Class is used by another class the "FitnessClass" class to check members into classes.
 There is a constructor to create the time data type and a toString method to create a printable string.
 @author James Artuso
 */
public enum Time {
    PILATES      ("Pilates",    "JENNIFER",  930, 0),
    SPINNING     ("Spinning",   "DENISE",   1400, 1),
    CARDIO       ("Cardio",     "KIM",      1400, 2);
    private final String className;
    private final String instructor;
    private final int time;
    private final int index;

    /**
     Time constructor, has class name, instructor name, time and index.
     Will correctly create time data type and set attributes accordingly.
     @param className name of the class
     @param instructor name of the class instructor
     @param time, the time that the class begins at
     @param index the index of the class.
     */
    Time(String className, String instructor, int time, int index){
        this.className = className;
        this.instructor = instructor;
        this.time = time;
        this.index = index;
    }

    /**
     Override toString method, to print a better more readable string.
     @return string, returns the string which contains classname, instructor and time.
     */
    @Override
    public String toString(){
        return (String.format("%s - %s %d:%02d",className, instructor, time/100, time%100));
    }

    /**
     Method to return the time of a class.
     @param time, time, created time data type used to check time of the class.
     @return int, the fitness class time.
     */
    public static int getTime(Time time){
        return time.time;
    }

    /**
     Method to return the class name of a class.
     @param time, time, created time data type used to check class name.
     @return String, the name of the fitness class of time data type.
     */
    public static String getClassName(Time time){
        return time.className;
    }

    /**
     Method to return the index of a class.
     @param time, time variable
     @return int, the index of the time data type.
     */
    public static int getIndex(Time time){
        return time.index;
    }

    /**
     Method to check if class name is valid (if it is an actual class).
     @param className, user inputted class that they want to check into
     @return boolean, true if the class name is an actual class in time.
     */
    public static boolean isValid(String className){
        Time[] times = Time.values();
        for(int i = 0; i < times.length; i++){
            if(times[i].className.toUpperCase().equals(className)){
                return true;
            }
        }
        return false;
    }

}