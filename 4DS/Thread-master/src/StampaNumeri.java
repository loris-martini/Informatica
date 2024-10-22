import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class StampaNumeri implements Runnable{
    private Integer[] arr;

    private Boolean ordine;

    public StampaNumeri(int n1, int n2, int n3, Boolean ordine){
        arr= new Integer[]{n1, n2, n3};
        Arrays.sort(arr);
        this.ordine=ordine;
    }

    @Override
    public void run() {
        if(ordine){
            System.out.println(arr.toString());
        }else{
            Arrays.sort(arr, Comparator.reverseOrder() );
            System.out.println(arr.toString());
        }

    }

}
