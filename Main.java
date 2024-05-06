import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// Model
class Livro {
    private String titulo;
    private boolean emprestado;

    public Livro(String titulo) {
        this.titulo = titulo;
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void emprestar() {
        this.emprestado = true;
    }

    public void devolver() {
        this.emprestado = false;
    }
}

// Controller
class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void cadastrarLivro(String titulo) {
        this.livros.add(new Livro(titulo));
    }

    public List<Livro> listarLivros() {
        return this.livros;
    }

    public void emprestarLivro(String titulo) {
        for (Livro livro : this.livros) {
            if (livro.getTitulo().equals(titulo)) {
                livro.emprestar();
                break;
            }
        }
    }

    public void devolverLivro(String titulo) {
        for (Livro livro : this.livros) {
            if (livro.getTitulo().equals(titulo)) {
                livro.devolver();
                break;
            }
        }
    }
}

// View
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Emprestar livro");
            System.out.println("4. Devolver livro");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consome a linha restante

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();
                    biblioteca.cadastrarLivro(titulo);
                    break;
                case 2:
                    for (Livro livro : biblioteca.listarLivros()) {
                        System.out.println(livro.getTitulo() + " - " + (livro.isEmprestado() ? "Emprestado" : "Disponível"));
                    }
                    break;
                case 3:
                    System.out.println("Digite o título do livro que deseja emprestar:");
                    String tituloEmprestimo = scanner.nextLine();
                    biblioteca.emprestarLivro(tituloEmprestimo);
                    break;
                case 4:
                    System.out.println("Digite o título do livro que deseja devolver:");
                    String tituloDevolucao = scanner.nextLine();
                    biblioteca.devolverLivro(tituloDevolucao);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}