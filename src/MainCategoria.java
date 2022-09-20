public class MainCategoria {
    public static void main(String[] args) {
        String outS = "Categoria %s (%s - %s)";
        Categoria cat1 = new Categoria("INFORMÁTICA");
        Categoria cat2 = new Categoria("MÓVEIS", "INATIVA");
        Categoria cat3 = new Categoria("LIVROS");

        System.out.println(String.format(outS, cat1.getNome(), cat1.getId(), cat1.getStatus()));
        System.out.println(String.format(outS, cat2.getNome(), cat2.getId(), cat2.getStatus()));
        System.out.println(String.format(outS, cat3.getNome(), cat3.getId(), cat3.getStatus()));
    }
}
