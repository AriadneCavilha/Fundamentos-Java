import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        List<Veiculo> lista = new ArrayList<>() {{
            add(new Veiculo("Chevrolet", "Cinza", 25000, 1988, 160));
            add(new Veiculo("Corolla", "Prata", 70000, 2020, 200));
            add(new Veiculo("Corolla", "Prata", 100000, 2025, 210));
            add(new Veiculo("X1", "Branco", 250000, 2023, 250));
            add(new Veiculo("GLA200", "Prata", 300000, 2025, 280));
        }};
        
//        lista.stream().forEach(v -> {
//            System.out.println(v);
//        }); aqui consigo usar lambda também
        
        List<Veiculo> ordenada = lista.stream()
                        .sorted(Comparator.comparing(Veiculo::getMarca).reversed())
                        .toList();
        System.out.println(ordenada);
        
        List<Veiculo> corolas = lista.stream()
                                .filter(v -> v.getMarca().equalsIgnoreCase("corolla"))
                                .toList();
        
        System.out.println(corolas);
        
        
        double precoMedio = lista.stream().mapToDouble(Veiculo::getPreco).average().orElse(0);
        System.out.println("Preço Médio = " + precoMedio);
        
        double maximo = lista.stream().mapToDouble(Veiculo::getPreco).max().orElse(0.0);
        System.out.println("Preço Máximo = " + maximo);
        
        double minimo = lista.stream().mapToDouble(Veiculo::getPreco).min().getAsDouble();
        System.out.println("Preço Mínimo = " + minimo);
        
        double mediaDosCorolas = lista.stream()
                                 .filter(v -> v.getMarca().equalsIgnoreCase("corolla"))
                                 .mapToDouble(Veiculo::getPreco)
                                 .average()
                                 .orElse(0.0);
        
        System.out.println("Média dos corollas = " + mediaDosCorolas);
        
        
    }
}
