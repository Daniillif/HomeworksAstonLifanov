package lesson_10;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    private List<T> box = new ArrayList<>();

    public Box(List<T> box) {
        this.box = box;
    }

    public List<T> getBox() {
        return box;
    }

    public void setBox(List<T> box) {
        this.box = box;
    }
    public void addFruit(T fruit){
        this.box.add(fruit);
    }

    public double getWeight(){
        if(this.box.isEmpty()){
            return 0.0;
        }else{
            T fruit = this.box.get(0);
            float weight = fruit.getWeight();
            return this.box.size()*weight;
        }
    }
    public boolean compare(Box<?> compairingBox){
        if(this.getWeight()<compairingBox.getWeight()){
            System.out.println("Передаваемая коробка больше нашей");
            return false;
        }else if(this.getWeight()>compairingBox.getWeight()){
            System.out.println("Передаваемая коробка меньше нашей");
            return false;
        }else
            System.out.println("Коробки равны");
        return true;
    }
    public void sprinkleToBox(Box<T> box){
        box.getBox().addAll(this.getBox());
        this.getBox().clear();
        System.out.println("Теперь в коробке " + box.getWeight() + " вес и колво " + box.getBox().size());
    }

}
