
class Book{
    private String title;
    private String author;
    boolean isAvailable = true;

    Book(String title, String author, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }

    void  setTitle(String title){
        this.title = title;
    }

    void setAuthor(String author){
        this.author = author;
    }
}

class Person{
    public String name;
    public int id;
}

class Student extends Person{
    public  String department;

    public void borrowBook(){
        System.out.println("The book is borrowed!");
    }
}

class Staff extends Person{

}

public class Main {
    public static void main(String[] args){
        Book newBook = new Book("Eng", "Bbe", false);
        System.out.println("The book is " + newBook.getTitle());
//        newBook.borrowBook("hi");
    }
}
