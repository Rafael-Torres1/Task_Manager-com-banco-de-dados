import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DaoTask novatask = new DaoTask();
        Scanner enter = new Scanner(System.in);
        int option;

        do {

            System.out.println("MENU DE TASKS");
            System.out.println("1 - criar task");
            System.out.println("2 - listar tasks");
            System.out.println("3 - atualizar status da task");
            System.out.println("4 - deletar tasks");
            System.out.println("5 - sair do menu");
            System.out.print("digite sua opção: ");
            option = enter.nextInt();

            enter.nextLine();



            switch (option){

                case 1 -> {
                    System.out.print("nome: ");
                    String name = enter.nextLine();

                    System.out.print("descrição: ");
                    String description = enter.nextLine();

                    System.out.print("status: ");
                    String stats = enter.nextLine();

                    novatask.insert(new Task(name, description, stats));
                    System.out.println("task adicionada");
                }

                case 2 -> {
                    System.out.println("lista de tasks");
                    novatask.taskList().forEach(System.out::println);
                }

                case 3 -> {
                    System.out.print("id do usuarios para atualizar status: ");
                    int id = enter.nextInt();

                    enter.nextLine();
                    System.out.print("novo status: ");
                    String novoStats = enter.nextLine();

                    novatask.update(id, novoStats);
                    System.out.println("status atualizado");
                }

                case 4 -> {
                    System.out.print("id da task que desejea deletar: ");
                    int del = enter.nextInt();

                    novatask.delete(del);
                }

                case 5 -> System.out.println("fechando programa");
                default -> System.out.println("opção invalida");

            }
        }while (option != 5);
    }
}
