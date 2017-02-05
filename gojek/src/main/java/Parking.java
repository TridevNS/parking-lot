
import java.io.*;
import java.util.Scanner;

/**
 * Created by tns on 2/5/2017.
 *
 *
 */
public class Parking {

    Vehicle[] slots;


    public Parking(int numSlot) {
        slots = new Vehicle[numSlot];
        System.out.println("Created a parking lot with "+numSlot+ " slots");
    }

   /*
     @param  regNum
     @param  col
     @return
    */

    public int  entry(String regNum, String col){

        Car car = new Car(regNum, col);

        int slot = -1;
        for(int i=0; i<slots.length; i++){
            if(slots[i] == null){
                slot = i;
                break;
            }
        }
        if(slot == -1){
            System.out.println("Sorry, parking lot is full");
            return -1;
        }
        slots[slot] = car;

        System.out.println("Allocated slot number: "+(slot+1));
        return (slot+1);
    }

     /*
     @param  slot
     @return
    */

    public int  exit(int slot){

        if(slot < 1 || slot > slots.length){
            System.out.println("Only "+ slots.length + " available");
            return -1;
        }

        Car car = (Car)slots[slot-1];
        slots[slot-1] = null;

        System.out.println("Slot number "+ (slot) +" is free");
        return slot;
    }



    public void status(){
        System.out.println("Slot No."   +"\t"+    "Registration No    "+"\t"+"   Colour");

        for(int i= 0; i<slots.length; i++){
            if(slots[i] != null){
                Car car = (Car)slots[i];
                System.out.println(i+1  +"\t"+  car.regNumber +"\t"+  car.color);
            }
        }
    }

    public String slot_numbers_for_cars_with_colour(String color){
        StringBuilder str = new StringBuilder();
        for(int i=0; i<slots.length; i++){
            if(slots[i] != null){
                Car car = (Car)slots[i];
                if(car.color.equals(color)){
                    str.append(i+1).append(" ");
                }
            }
        }
        System.out.println(str.toString().trim());

        return str.toString().trim();
    }

    public String registration_numbers_for_cars_with_colour(String color){

        StringBuilder str = new StringBuilder();
        for(int i=0; i<slots.length; i++){
            if(slots[i] != null){
                Car car = (Car)slots[i];
                if(car.color.equals(color)){
                    str.append(car.regNumber).append(" ");
                }
            }
        }
        System.out.println(str.toString().trim());

        return str.toString().trim();
    }



    public int slot_number_for_registration_number(String number){
        int slot = -1;
        for(int i=0; i<slots.length; i++){
            if(slots[i] != null){
                Car car = (Car)slots[i];
                if(car.regNumber.equals(number)){
                    slot = i +1 ;
                    break;
                }
            }
        }

        if(slot != -1){
            System.out.println(slot);
            return slot;
        }else{
            System.out.println("Not found");
            return -1;
        }
    }

    public static void execute(Parking par, String input){
        String line = input;

        if(par != null && line.trim().split(" ")[0].toLowerCase().equals("park")){

            par.entry(line.trim().split(" ")[1].trim(),line.trim().split(" ")[2].trim());
        }

        if(par != null && line.trim().split(" ")[0].toLowerCase().equals("leave")){
            par.exit(Integer.parseInt(line.trim().split(" ")[1].trim()));
        }

        if(par != null && line.trim().split(" ")[0].toLowerCase().equals("status")){
            par.status();
        }

        if(par != null && line.trim().split(" ")[0].toLowerCase().equals("registration_numbers_for_cars_with_colour")){
            par.registration_numbers_for_cars_with_colour(line.trim().split(" ")[1].trim());
        }

        if(par != null && line.trim().split(" ")[0].toLowerCase().equals("slot_numbers_for_cars_with_colour")){
            par.slot_numbers_for_cars_with_colour(line.trim().split(" ")[1].trim());
        }

        if(par != null && line.trim().split(" ")[0].toLowerCase().equals("slot_number_for_registration_number")){
            par.slot_number_for_registration_number(line.trim().split(" ")[1].trim());
        }

    }
    public static void main(String[] args) {
       //E:\project_repository\parking-lot\data\input.txt
      if(args.length == 1){

            String filePath = args[0];

          BufferedReader br = null;
            try{
                br = new BufferedReader(new FileReader(filePath));

                String line;
                Parking par = null;
                while ((line = br.readLine()) != null) {

                    if(line.trim().split(" ")[0].toLowerCase().equals("create_parking_lot")){
                        par = new Parking(Integer.parseInt(line.trim().split(" ")[1].trim()));
                    }else{
                        execute(par, line);
                    }

                }

            }catch (FileNotFoundException ex){
                ex.printStackTrace();
            }catch (IOException ex){
                ex.printStackTrace();
            }finally {

                try {

                    if (br != null)
                        br.close();

                } catch (IOException ex) {

                    ex.printStackTrace();

                }

            }

        }else{
                 Scanner scanner = new Scanner(System.in);
                 Parking par = null;
                while (true){
                    System.out.println("Input: ");

                    String line = scanner.nextLine();

                    System.out.println("Output: ");

                    if(line.trim().split(" ")[0].toLowerCase().equals("create_parking_lot")){
                        par = new Parking(Integer.parseInt(line.trim().split(" ")[1].trim()));
                    }else{
                        execute(par, line);
                    }

                }

      }
    }
}
