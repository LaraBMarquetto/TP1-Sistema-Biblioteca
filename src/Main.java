import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int livrosDisponiveis = 9;
        int limiteEmprestimo = 3;
        int livrosEmprestados;

        boolean continuar = true;

        System.out.println("Bem-vindo à Biblioteca!");
        System.out.println("Quantos livros você já tem emprestados?");

        livrosEmprestados = scanner.nextInt();

        if (livrosEmprestados < 0 || livrosEmprestados > limiteEmprestimo) {
            System.out.println("Quantidade inválida!");
            scanner.close();
            return;
        }

        while (continuar) {
            System.out.println("\nNo momento você possui " + livrosEmprestados + " livros emprestados.");
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Solicitar empréstimo");
            System.out.println("2 - Devolver livro");
            System.out.println("3 - Sair");

            int opcao = scanner.nextInt();

            if (opcao == 1) {

                if (livrosEmprestados < 0) {
                    System.out.println("Valor inválido!");

                } else if (livrosEmprestados < limiteEmprestimo) {
                    System.out.println("Livros disponíveis -- " + livrosDisponiveis);
                    System.out.println("Quantos livros deseja emprestar?");
                    int livrosSolicitados = scanner.nextInt();

                    if (livrosSolicitados < 1) {
                        System.out.println("É necessário uma quantidade maior que 0.");
                    } else if (livrosSolicitados + livrosEmprestados > limiteEmprestimo) {
                        System.out.println("Apenas " + limiteEmprestimo + " livros podem ser emprestados por vez!");
                    } else if (livrosSolicitados <= livrosDisponiveis) {

                        System.out.println("Livros solicitados -- " + livrosSolicitados);
                        System.out.println("Há exemplares disponíveis para o empréstimo!");
                        livrosDisponiveis = livrosDisponiveis - livrosSolicitados;
                        livrosEmprestados = livrosEmprestados + livrosSolicitados;
                    } else {
                        System.out.println("Não há exemplares disponíveis para o empréstimo!");
                    }
                } else {
                    System.out.println("Apenas " + limiteEmprestimo + " livros podem ser emprestados por vez!");
                }

            } else if (opcao == 2 ) {
                if(livrosEmprestados <1) {
                    System.out.println("Você não tem livros para devolver!");
                    break;
                } else {
                    System.out.println("Quantos livros deseja devolver?");
                    int livrosDevolucao = scanner.nextInt();

                    if (livrosDevolucao < 1) {
                        System.out.println("Quantidade inválida!");
                    } else if (livrosDevolucao > livrosEmprestados) {
                        System.out.println("Você não possui essa quantidade de livros emprestados!");
                    } else {
                        livrosEmprestados = livrosEmprestados - livrosDevolucao;
                        livrosDisponiveis = livrosDisponiveis + livrosDevolucao;
                        System.out.println("Devolução concluida com sucesso! Agradecemos seu comprometimento.");
                    }
                }
            } else if (opcao == 3) {
                break;
            } else {
               System.out.println("Opção inválida!");
            }

        }
        System.out.println("No momento você possui " + livrosEmprestados + " livros emprestados.");
        System.out.println("Programa encerrado!");
        scanner.close();
    }
}