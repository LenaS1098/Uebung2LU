package componentAssembler;

import java.util.Scanner;

public class ComponentAssembler {

    public static void main(String[] args) {
        ComponentAssembler ca = new ComponentAssembler();
        ca.menue();
    }

    public void startLU(){
        // TODO: 27.04.2022 starten der Laufzeitumgebung; int als return zur Kontrolle
    }

    public void stopLU(){
        // TODO: 27.04.2022 stoppen der Laufzeitumgebung; int als return zur Kontrolle
    }

    public void addComponent(String jarPath){
        // TODO: 27.04.2022 add einer Komponente aus lokalem Verzeichnis
    }

    public void startComponent(int componentId){
        // TODO: 27.04.2022 Starten einer bestimmten Komponente; anhand ID
    }

    public void stopComponent(int componentId){
        // TODO: 27.04.2022 Stoppen einer bestimmten Komponente; anhand ID
    }

    public void deleteComponent(int componentId){
        // TODO: 27.04.2022 Entfernen einer bestimmten Komponente; anhand ID
    }

    public void getStatus(){
        // TODO: 27.04.2022 Status aller Komponenten wird ausgegeben
    }
    public void getStatusById(int componentId){
        // TODO: 27.04.2022 Status einer Komponente (byId) wird ausgegeben
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
