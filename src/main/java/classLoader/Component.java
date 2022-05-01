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

public class Component implements iComponent {

    private int id;

    String className;
    URLClassLoader classLoader;
    String jarName ="";
    Boolean isRunning = false;

    public Component(int id, String pathToJar) {
        this.id = id;
        jarName = pathToJar;
    }


    public void loadComponent(String pathToJar) throws IOException, ClassNotFoundException {
        System.out.println("Component Loaded");
    }


    @Override
    public void start() {
        isRunning = true;
        System.out.println("Component Started");
    }

    @Override
    public void end() {
        isRunning = false;
        System.out.println("Component Ended");
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
    }

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
