package laufzeitumgebung;

import classLoader.Component;
import component.iComponent;


import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class Laufzeitumgebung {


    private ArrayList<Component> componentList = new ArrayList<Component>();


    public void startLU(){
        System.out.println("LU started");
        if(!componentList.isEmpty()){
            for(iComponent component: componentList){
               component.start();
            }
        }else{
            System.out.println("Keine Komponenten in LU");
        }

        //todo: start Thread
        // TODO: 27.04.2022 starten der Laufzeitumgebung; int als return zur Kontrolle
    }

    //stoppen der Laufzeitumgebung
    public void stopLU(){
        System.out.println("LU stopped");
        if(!componentList.isEmpty()){
            for(iComponent component: componentList){
                component.end();
            }
        }else{
            System.out.println("Keine Komponenten in LU");
        }
        // TODO: 27.04.2022 ; int als return zur Kontrolle
    }


    //add einer Komponente aus lokalem Verzeichnis
    public void addComponent(String pathToJar) {


        Component c = new Component(componentList.size()+1,pathToJar);
        try{
            c.loadComponent(pathToJar);
            componentList.add(c);
            System.out.println("Component Added");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    //Component aus LU wird gestartet
    public void startComponent(int componentId){
        iComponent component = getComponentById(componentId);
        component.start();

    }

    //Component (by ID) wird aus LU entfernt
    public void stopComponent(int componentId){
        iComponent component = getComponentById(componentId);
        component.end();
    }

    // Component wird aus LU entfernt
    public void deleteComponent(int componentId){
        iComponent component = getComponentById(componentId);
        componentList.remove(component);

    }

    //Status aller Compenents in LU
    public void getStatus(){
        for(iComponent component: componentList){
            stateOutput(component.getId(),component.getName(), component.getState());
        }
    }

    //Status einer Komponente (byId) wird ausgegeben
    public void getStatusById(int componentId){
        iComponent component = getComponentById(componentId);
        stateOutput(componentId,component.getName(), component.getState());
    }

    private iComponent getComponentById(int id){
        for( iComponent component: componentList){
            if(component.getId()==id){
                return component;
            }
        }
        throw new NoSuchElementException();
    }



    private void stateOutput(int id, String name, String state){
        System.out.println("Component: " +id+ " Name: " + name+ " State: "+state);
    }
}
