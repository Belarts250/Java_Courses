public class Student implements Comparable<Student> {
    int id;
    String fname;
    String lname;
    double grade;

    public Student (int id, String fname, String lname, double grade){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
    }
    @override
    public int compareTo( Student k){
        return Integer.compare(this.id, k.id);

    }

    public boolean equals (Object o){
        if(this == o) return true;
        
    }

}
