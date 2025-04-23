/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ricardo
 */
public class GenericDAO_JSON<T> {

    private String fileName;
    private Gson gson;
    private Type type;

    public GenericDAO_JSON(String fileName, Type type) {
        this.fileName = fileName;
        this.type = type;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

//    Leer el archivo y retorna los datos
    public ArrayList<T> getAll() {
        try (FileReader reader = new FileReader(fileName)) {
            T[] elements = this.gson.fromJson(reader, type);
            if (elements == null) {
                return new ArrayList<>();

            } else {
                return new ArrayList<>(Arrays.asList(elements));
            }
        } catch (IOException ioe) {
            return new ArrayList<>();

        }
    }

    public void addElements(ArrayList<T> elements) {
        try (FileWriter writer = new FileWriter(fileName)) {
            this.gson.toJson(elements.toArray(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int findById(T element) {
        ArrayList<T> elements = this.getAll();
        if (elements.size() >= 1) {
            if (element instanceof User) {
                return ((User) element).getId();
            } else if (element instanceof CreativeSpace) {
                return ((CreativeSpace) element).getId();
            }

        }
        return -1;
    }

    public boolean save(T element) {
        ArrayList<T> elements = this.getAll();
        
        for (int i = 0; i < elements.size(); i++) {
            T e = elements.get(i);
            
            if(this.findById(element)==this.findById(e)){
                return false;
            }
        }
        
        if (elements.add(element)) {
            addElements(elements);
            return true;
        }
        return false;
    }

    public boolean update(T element) {
        ArrayList<T> elements = this.getAll();
        for (int i = 0; i < elements.size(); i++) {
            T e = elements.get(i);
            if (findById(element) == findById(e)) {
                elements.set(i, element);
                this.addElements(elements);
                return true;
            }
        }
        return false;
    }

    public boolean remove(int id) {
        ArrayList<T> elements = this.getAll();
        for (int i = 0; i < elements.size(); i++) {
            T e = elements.get(i);
            if (findById(e) == id) {
                elements.remove(i);
                this.addElements(elements);
                return true;
            }
        }
        return false;
    }

    public T getElement(int id) {
        ArrayList<T> elements = this.getAll();
        for (int i = 0; i < elements.size(); i++) {
            T e = elements.get(i);
            if (findById(e) == id) {
                return elements.get(i);
            }
        }
        return null;
    }

}
