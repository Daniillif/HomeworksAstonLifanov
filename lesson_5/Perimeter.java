package lesson_5;

public interface Perimeter {
    public default double calculatePerimeter(int ... num){
        if(num.length==1){
             return 2 * Math.PI * num[0];
        }else if(num.length==2){
            return (num[0]+num[1]) * 2;
        }else
            return num[0]+num[1] + num[2];
    }
}
