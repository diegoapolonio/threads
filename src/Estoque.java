import java.util.LinkedList;
import java.util.Queue;

public class Estoque {
    private static final int TAMANHO_ESTOQUE = 5;
    private Queue<String> estoque = new LinkedList<>();


    public synchronized void produzir (String intem) throws InterruptedException{
      while (estoque.size()==TAMANHO_ESTOQUE){
          wait();
      }
      estoque.add(intem);
        System.out.println("produzido:"+ intem);
        notifyAll();//notifica os consumidores que um item soi produzido

    }
    public synchronized void consumir() throws InterruptedException{
        //enquanto o estoque estiver vazio o consumidor espera

        while (estoque.isEmpty()){
            wait();
        }
        String item = estoque.poll();
        System.out.println("consumidor"+ item);
        notifyAll();//notifica os produtores que um itemfoi consumido
    }
}
