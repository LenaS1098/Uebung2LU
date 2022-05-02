package classLoader;

import component.iComponent;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Component implements iComponent, Runnable {

    private int id;
    private Thread thread;

    String className;
    URLClassLoader classLoader;
    String jarName ="";

    public Component(int id, String pathToJar) {
        this.id = id;
        jarName = pathToJar;
        try{
            loadComponent(pathToJar);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        System.out.println(jarName +" is running in background");
        while(!thread.isInterrupted()){

        }

        System.out.println(jarName + " has ended");
    }

    public void loadComponent(String pathToJar) throws IOException, ClassNotFoundException {

        System.out.println("Component Loaded");
    }


    @Override
    public void start() {
            thread = new Thread(this,"jarName");
            thread.start();
    }

    @Override
    public void end() {
        thread.interrupt();
    }

    @Override
    public String getState() {
        if(thread!=null){
            if(thread.isAlive()){
                return "RUNNING";
            }
            else{
                return "ASLEEP";
            }
        }else{
            return "LOADED";
        }

    }

    @Override
    public String getName() {
        return jarName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }


    //Code mit ClassLoader, noch nicht lauffaehig
   /* //Quelle: https://stackoverflow.com/questions/11016092/how-to-load-classes-at-runtime-from-a-folder-or-jar
     public void loadComponent(String pathToJar) throws IOException, ClassNotFoundException {
        JarFile jarFile = new JarFile(pathToJar);
        Enumeration<JarEntry> e = jarFile.entries();

        jarName = jarFile.getName();

        URL[] urls = { new URL("jar:" + pathToJar+"!/") };
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        classLoader = cl;


        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            if (je.isDirectory() || !je.getName().endsWith(".class")) {
                continue;
            }
            // -6 because of .class
            String className = je.getName().substring(0, je.getName().length() - 6);
            className = className.replace('/', '.');
            Class<?> c = cl.loadClass(className);
            try{
                c.getMethod("start");
                this.className = className;
            } catch (final NoSuchMethodException ex){
                ex.printStackTrace();
            }
        }
    }

    private void runMethod(String method){
        if(className!= null){
            try{
                Class<?> c = classLoader.loadClass(className);
                Object instance = c.getConstructor().newInstance();
                c.getMethod(method).invoke(instance);
            } catch (final ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex){
                ex.printStackTrace();
            }

        }
    }

    @Override
    public void start() {
      runMethod("start");
      isRunning = true;
    }

    @Override
    public void end() {
        runMethod("end");
        isRunning = false;
    }

    @Override
    public String getState() {
        if(isRunning){
            return "RUNNING";
        }else{
            return "ASLEEP";
        }

    }

    @Override
    public String getName() {
        return jarName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }*/
}
