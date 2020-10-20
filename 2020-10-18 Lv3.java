import java.sql.Array;
import java.util.Arrays;

public class Lv3 {
    public static void main(String[] args) {
        MutableArrayList list = new MutableArrayList();

        list. add("红岩网校Android");
        list.remove(0);
        list.add(0, "加油冲冲冲！");
        System.out.println(list.get(0));
        System.out.println("list拥有：" + list.size() + "个元素");
    }
}

 class MutableArrayList {
    private Object[] elementDate;
    private int size;

    public MutableArrayList() {
        this.elementDate = new Object[] {};
        this.size = 0;
    }

    public void add(Object obj) {
        size++;
        elementDate = Arrays.copyOf(elementDate, size);
        elementDate[size - 1] = obj;
    }

    public void add(int index, Object obj) {
        if (index > size - 1) {
            elementDate = Arrays.copyOf(elementDate, index + 1);
            size = index + 1;
        }
        elementDate[index] = obj;
    }
    
    //TODO: judge index
    public Object get(int index) {
        return elementDate[index];
    }

    public void remove(int index) {
        if (index < size) {
            for (int i = index; i < size - 1; i++) {
                elementDate[i] = elementDate[i + 1];
            }
            size--;
            elementDate = Arrays.copyOf(elementDate, size);
        }
    }

    public void remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (elementDate[i] == obj) {
                remove(i);
            }
        }
    }

     public int size() {
         return size;
     }
 }
