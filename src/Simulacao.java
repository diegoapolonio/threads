import java.util.Scanner;

public class Simulacao {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner leitor = new Scanner(System.in);

        System.out.println("digite a quantidade de itens a serem produzidos");
        int quantidadeProduzir = leitor.nextInt();

        System.out.println("agora digite o nome de cada iten a ser produzido");
        for (int i = 1; i <= quantidadeProduzir; i++) {
            leitor.nextLine();//limpar o buffer do scanner
            System.out.println("item" + 1 + ":");
            String nomeItem = leitor.next();
            try {
                estoque.produzir(nomeItem);
                Thread.sleep(5000);//tempo para producao de um item
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //thread de consumidor
        Thread consumidor = new Thread(() -> {
            for (int i = 1; i <= quantidadeProduzir; i++) {
                try {
                    estoque.consumir();
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        consumidor.start();
        leitor.close();
    }
}
