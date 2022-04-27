package componentAssembler;

import laufzeitumgebung.Laufzeitumgebung;

import java.util.Scanner;

public class ComponentAssembler {

    Laufzeitumgebung lu = new Laufzeitumgebung();

    public static void main(String[] args) {
        ComponentAssembler ca = new ComponentAssembler();
        ca.menue();
    }

    public void startLU(){

        lu.startLU();
    }

    public void stopLU(){
        lu.stopLU();
    }

    public void addComponent(String jarPath){
        lu.addComponent(jarPath);
    }

    public void startComponent(int componentId){
        lu.startComponent(componentId);
    }

    public void stopComponent(int componentId){
        lu.stopComponent(componentId);
    }

    public void deleteComponent(int componentId){
       lu.deleteComponent(componentId);
    }

    public void getStatus(){
       lu.getStatus();
    }
    public void getStatusById(int componentId){
        lu.getStatusById(componentId);
    }

    private void menue() {


        int loop = 0;
        Scanner scanner = new Scanner(System.in);
        while(loop == 0){

            System.out.println("Start LU [1]");
            System.out.println("Stopp LU [2]");
            System.out.println("Add Component [3]");
            System.out.println("Start Component [4]");
            System.out.println("Delete Component [5]");
            System.out.println("Status All Components [6]");
            System.out.println("Status 1 Component [7]");
            System.out.println("End Programm [8]");

            int input = scanner.nextInt();

            switch (input){
                case 1:
                    startLU();
                    break;
                case 2:
                    stopLU();
                    break;
                case 3:
                    addComponent("");
                    break;
                case 4:
                    startComponent(-1);
                    break;
                case 5:
                    deleteComponent(-1);
                    break;
                case 6:
                    getStatus();
                    break;
                case 7:
                    getStatusById(-1);
                    break;
                case 8:
                    System.out.println("ComponentAssembler done");
                    loop = -1;
                    break;
                default:
                    System.out.println("Keine gueltige Eingabe.");
                    break;
            }


        }
    }
}
