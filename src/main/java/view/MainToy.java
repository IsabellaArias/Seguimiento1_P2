package view;

import config.DatabaseConnection;
import model.Toy;
import repository.ToyStoreRepository;
import repository.ToysRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainToy {
    public static void main(String[] args) {
        try(Connection connection = DatabaseConnection.getInstance()){
            ToysRepository<Toy> repository= new ToyStoreRepository();
            Scanner s = new Scanner(System.in);

            System.out.println("**** List ****");
            repository.listToys().stream().forEach(System.out::println);

           /* System.out.println("Buscar por Id");
            System.out.println("Ingrese el id del juguete que desea: ");
            Integer bi= s.nextInt();*/

            System.out.println("Delete");
            System.out.println("Ingrese el id del juguete que desea eliminar: ");
            Integer bi2= s.nextInt();
            repository.delete(bi2);
            System.out.println("**** TOTAL TOYS ****");
            System.out.println(repository.totalToys());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
