package junit5.model;

public final class ImmutableDemo {

        final String studentName;
        final int rollNumber;
        public ImmutableDemo  (String studentName, int rollNumber) {
            this.studentName = studentName;
            this.rollNumber = rollNumber;
        }
        public String getStudentName() {
            return studentName;
        }
        public int getRollNumber() {
            return rollNumber;
        }
        public static void main(String[] args) {
            ImmutableDemo obj = new ImmutableDemo  ("John" , 100);
            // Since no setters are available contents cannot be modified.
            // Also as variables are declared final they cannot be modified
            System.out.println("Name is " + obj.getStudentName());
            System.out.println("Roll Number is " + obj.getRollNumber());
        }
}
