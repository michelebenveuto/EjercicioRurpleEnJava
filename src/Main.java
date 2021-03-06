import java.io.IOError;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        ArrayList<String> readMap = new ArrayList<>();
        ArrayList<String> instructions= new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Introdusca el nombre del archivo del mapa:");
        String mapfile = input.nextLine();
        try {
            Stream<String> lines = Files.lines(
                    Paths.get(mapfile),
                    StandardCharsets.UTF_8
            );
            lines.forEach(s ->{ readMap.add(s);});
        }catch (IOException exception){
            System.out.println("Error");
        }
        Map maptoSolve= new Map();
        maptoSolve.createMap(readMap);
        System.out.println(maptoSolve);

        System.out.print("Introdusca el nombre del archivo de las instrucciones:");
        String instructionFile= input.nextLine();
        try {
            Stream<String> lines = Files.lines(
                    Paths.get(instructionFile),
                    StandardCharsets.UTF_8
            );
            lines.forEach(s -> instructions.add(s));
        }catch (IOException exception){
            System.out.println("Error");
        }
        for(String instruction: instructions){
            if(instruction.equals("MOVE") ){
                maptoSolve.getRobot().moveRobot(maptoSolve);
                System.out.println(maptoSolve);
                System.out.println("EL robot tiene "+maptoSolve.getRobot().getCoinPurse()+" monedas");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                }catch (InterruptedException exception){}
            }
            else if(instruction.equals("ROTATE")){
                maptoSolve.getRobot().rotate();
                System.out.println(maptoSolve);
                System.out.println("EL robot tiene "+maptoSolve.getRobot().getCoinPurse()+" monedas");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                }catch (InterruptedException exception){}
            }
            else if (instruction.equals("PICK")){
                maptoSolve.getRobot().pickCoin(maptoSolve);
                System.out.println(maptoSolve);
                System.out.println("EL robot tiene "+maptoSolve.getRobot().getCoinPurse()+" monedas");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                }catch (InterruptedException exception){}
            }
        }

    }
}
