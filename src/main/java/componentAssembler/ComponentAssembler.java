package componentAssembler;

import laufzeitumgebung.Laufzeitumgebung;

import java.io.IOException;
import java.util.Scanner;




public class ComponentAssembler {

    Scanner scanner = new Scanner(System.in);
    Laufzeitumgebung lu = new Laufzeitumgebung();
    boolean luRunning = false;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ComponentAssembler ca = new ComponentAssembler();
        ca.menue();
    }

    public void startLU(){

        lu.startLU();
    }

    public void stopLU(){
        lu.stopLU();
    }

    public void addComponentMenu(){
        System.out.println("Choose between Components:" );
        System.out.println("[1]");
        System.out.println("[2]");
        System.out.println("[3]");
        int input = scanner.nextInt();
        switch (input){
            case 1:
                System.out.println("Component 1 ausgewaehlt");
                addComponent("Component 1");
                break;
            case 2:
                System.out.println("Component 2 ausgewaehlt");
                addComponent("Component 2");
                break;
            case 3:
                System.out.println("Component 3 ausgewaehlt");
                addComponent("Component 3");
                break;
            default:
                System.out.println("Keine bekannte Component");
                break;
        }
    }

    public void addComponent(String jarPath) {
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

    private int askId(){
        System.out.println("Welche Id?");
        return scanner.nextInt();
    }

    private void menue() throws IOException, ClassNotFoundException {


        int loop = 0;

        while(loop == 0){

            System.out.println("Start LU [1]");
            System.out.println("Stopp LU [2]");
            System.out.println("Add Component [3]");
            System.out.println("Start Component [4]");
            System.out.println("End Component [5]");
            System.out.println("Delete Component [6]");
            System.out.println("Status All Components [7]");
            System.out.println("Status 1 Component [8]");
            System.out.println("End Programm [9]");

            int input = scanner.nextInt();

            switch (input){
                case 1:
                    luRunning = true;
                    startLU();
                    break;
                case 2:
                    luRunning = false;
                    stopLU();

                    break;
                case 3:
                    if(luRunning){
                        addComponentMenu();
                    }else{
                        System.out.println("LU muss erst gestartet werden");
                    }

                 //   addComponent("F:\\Lena\\HBRS\\OOKA\\uebung\\git\\maventest\\out\\artifacts\\maventest_jar\\maventest.jar");
                    break;
                case 4:
                    if(luRunning){
                        int startId = askId();
                        startComponent(startId);
                    }else{
                        System.out.println("LU muss erst gestartet werden");
                    }

                    break;
                case 5:
                    if(luRunning){
                        int stopId = askId();
                        stopComponent(stopId);
                    }else{
                        System.out.println("LU muss erst gestartet werden");
                    }

                    break;
                case 6:
                    if(luRunning){
                        int deleteId = askId();
                        deleteComponent(deleteId);
                    }else{
                        System.out.println("LU muss erst gestartet werden");
                    }
                    break;
                case 7:
                    if(luRunning){
                        getStatus();
                    }else{
                        System.out.println("LU muss erst gestartet werden");
                    }

                    break;
                case 8:
                    if(luRunning){
                        int statusId = askId();
                        getStatusById(statusId);
                    }else{
                        System.out.println("LU muss erst gestartet werden");
                    }

                    break;
                case 9:
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
