class Program {
    public static void averageMark( int totalMarks, int numberOfStudents) {
        try {

            System.out.println(totalMarks / numberOfStudents);
            System.out.println("After displaying the average");

        } catch (ArithmeticException e) {
            System.out.println(  e.getMessage());
        }
        catch (Exception e){
            System.out.println("errorrrrrrrrrrrr");
        }
    }

    public static void main(String[] args) {
        averageMark(0,0);
        averageMark(30,3);
    }
} 