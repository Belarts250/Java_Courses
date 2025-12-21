public class Shape {
    public  static void main(String[] args){
        Shape triangle = new Triangle(12, 15);
        System.out.println(triangle.color);
        triangle.Intro();
    }

    String color;
    int size;

     void Intro(){
        System.out.println("I am a shape");
    }

        Shape(String color, int size){
         this.color = color;
         this.size = size;
        }
}

class Triangle extends  Shape{
    int base;
    int height;

    Triangle(int base, int height){
        super("blue");
        this.base = base;
        this.height = height;
    }

}


