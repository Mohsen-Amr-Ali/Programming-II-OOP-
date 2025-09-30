import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.out;

class CustomSet{
    //-------- members --------//
    private int size;
    private int[] data;

    //------ constructors ------//

    CustomSet(int[] data){
        Arrays.sort(data);
        int[] temp = new int[data.length];
        int j = 0;
        for (int i = 0; i < data.length; i++) {
            if (i == 0 || data[i] != data[i - 1]) {
                temp[j++] = data[i];
            }
        }
        this.size = j;
        this.data = new int[j];
        System.arraycopy(temp, 0, this.data, 0, j);
    }

    //----- getters & setters ----//
    public int getSize(){
        return this.size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public int[] getData(){
        return this.data;
    }

    public int getDataInPos(int n){
        return this.data[n];
    }

    public void setData(int[] data){
        System.arraycopy(data, 0, this.data, 0, data.length);
    }

    //------- methods -------//
    public boolean contains(int x){
        for (int i = 0; i < this.size; i++) {
            if(this.data[i] == x) return true;
        }
        return false;
    }

    public CustomSet union(CustomSet s) {
        int union_size = this.size + s.size;
        int[] arr = new int[union_size];

        int i=0, j=0, k=0;
        while(k < s.size && j < this.size) {
            if (this.data[j] < s.data[k])
                arr[i++] = this.data[j++];
            else if (this.data[j] == s.data[k]) {
                arr[i++] = this.data[j++];
                k++;
            } else arr[i++] = s.data[k++];
        }
        while(k < s.size) arr[i++] = s.data[k++];
        while(j < this.size) arr[i++] = this.data[j++];
        //note tp self: could be done using something called streams

        return new CustomSet(Arrays.copyOf(arr, i));
    }
}

public class L2Q2 {
    public static void main(String[] args) {

        CustomSet set1 = new CustomSet(inputSet("first"));
        CustomSet set2 = new CustomSet(inputSet("second"));

        // Print Set 1
        out.print("Set 1 is: [");
        for (int i = 0; i < set1.getSize(); i++) {
            out.print(set1.getDataInPos(i));
            if (i + 1 == set1.getSize()) out.print(".]");
            else out.print(", ");
        }
        out.println();

// Print Set 2
        out.print("Set 2 is: [");
        for (int i = 0; i < set2.getSize(); i++) {
            out.print(set2.getDataInPos(i));
            if (i + 1 == set2.getSize()) out.print(".]");
            else out.print(", ");
        }
        out.println();


        CustomSet union_set = set1.union(set2);
        out.print("The union of the two sets is: [");
        for (int i = 0; i < union_set.getSize(); i++){
            out.print(union_set.getDataInPos(i));
            if(i+1 == union_set.getSize()) out.print(".]");
            else out.print(", ");
        }


    }

    boolean isPrime(int n){
        if(n < 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;

        for (int i = 3; i*i < n; i++){
            if(n % i == 0) return false;
        }

        return true;
    }

    static int[] inputSet(String set_order){
        Scanner scanner = new Scanner(System.in);
        out.print("Enter the members of the " + set_order +" set separated by a comma: ");
        String input = scanner.nextLine();

        String[] str_set = input.trim().split("[,\\s]+");

        //research lists later, could've been a lot easier using lists instead of arrays
        int count = 0;
        for (String s : str_set) {
            try {
                Integer.parseInt(s);
                count++;
            } catch (NumberFormatException e) {

            }
        }

        int[] arr = new int[count];
        int i = 0;
        for (String s : str_set){
            try {
                arr[i] = Integer.parseInt(s);
                i++;
            } catch (NumberFormatException e) {

            }
        }
        return arr;
    }
}