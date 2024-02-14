package view;

import mapping.dtos.ToyDto;
import model.TypeToy;
import services.ToyStoreImpl;
import services.impl.ToyServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ToyStore {
    public static void main(String[] args) throws Exception {
        String op="1";
        ToyStoreImpl impl= new ToyServiceImpl();

        do {
            Scanner s = new Scanner(System.in);
            System.out.println("----MENU----");
            System.out.println("1.List toys \n2.Add toy  \n3.Max toy \n4.Min toy \n5.Sort toys \n6.Search \n7.Increase" +
                    "\n8.Decrease \n9.Show by Types \n10.Show larger than \n11.Verify Exist \n12.Show total amount of Toys"+
                    "\n13.Exit");
            op = s.next();
            switch (op) {
                case "1" -> {
                    System.out.println("----LIST TOYS----");
                    List<ToyDto> toyList = impl.listToys();
                    if (!toyList.isEmpty()) {
                        for (ToyDto toy : toyList) {
                            System.out.println(toy);
                        }
                    } else {
                        System.out.println("There are no toys on the list yet");
                    }
                }
                case "2" -> {
                    System.out.println("----ADD TOY----");
                    System.out.println("Enter the name: ");
                    String name = s.next();
                    System.out.println("Choose the type: \n0 is Female\n1 is Male\n2 is Unisex: ");
                    TypeToy type = TypeToy.getTypeByValue(Integer.parseInt(s.next()));
                    System.out.println("Enter the price: ");
                    Integer price = Integer.valueOf(s.next());
                    impl.addToy(new ToyDto(name,type,price,+1));
                }
                case "3" -> {
                    System.out.println("----MAX TOY----");
                    System.out.println(impl.maxToy());
                }
                case "4" -> {
                    System.out.println("----MIN TOY----");
                    System.out.println(impl.minToy());
                }
                case "5" -> {
                    System.out.println("----SORT TOYS----");
                    System.out.println(impl.sort());

                }
                case "6" -> {
                    System.out.println("----SEARCH----");
                    System.out.println("Enter the toy name: ");
                    String name = s.next();
                    System.out.println(impl.search(name));
                }
                case "7" -> {
                    System.out.println("----INCREASE----");
                    System.out.println("Enter the toy name: ");
                    String name = s.next();
                    System.out.println("Enter the amount: ");
                    int amount = Integer.parseInt(s.next());
                    ToyDto toyDto = impl.search(name);
                    System.out.println(impl.increase(toyDto, amount));
                }
                case "8" -> {
                    System.out.println("----DECREASE----");
                    System.out.println("Enter the toy name: ");
                    String name = s.next();
                    System.out.println("Enter the amount: ");
                    int amount = Integer.parseInt(s.next());
                    ToyDto toyDto = impl.search(name);
                    System.out.println(impl.decrease(toyDto,amount));
                }
               case "9" -> {
                   System.out.println("----SHOW BY TYPES----");
                   System.out.println(impl.showByType());
               }
                case "10"->{
                    System.out.println("----SHOW LARGER THAN----");
                    System.out.println("Enter the number: ");
                    double number = Integer.parseInt(s.next());
                    System.out.println(impl.showLargerThan(number));
                }
                case "11"->{
                    System.out.println("----VERIFY EXIST----");
                    System.out.println("Enter the toy name: ");
                    String name = s.next();
                    if (impl.verifyExist(name)) {
                        System.out.println("The toy "+ name + " exists in the list");
                    } else {
                        System.out.println("The toy does not exist in the list");
                    }
                }
                case "12"->{
                    System.out.println("----SHOW TOTAL AMOUNT OF TOYS----");
                    System.out.println("In the store are "+impl.totalToys());
                }
            }
        } while (!op.equals("13")) ;
    }
}