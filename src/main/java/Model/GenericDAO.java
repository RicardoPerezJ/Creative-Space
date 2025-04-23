/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public class GenericDAO<T> {

    private ArrayList<T> elements;

    public GenericDAO(ArrayList<T> elements) {
        this.elements = new ArrayList<>();
    }

    public ArrayList<T> getAll() {
        return this.elements;
    }

    public boolean save(T element) {
        return this.elements.add(element);
    }

    public boolean update(T element) {
        for (int i = 0; i < this.elements.size(); i++) {
            T e = elements.get(i);
            if (findById(element) == findById(e)) {
                this.elements.set(i, element);
                return true;
            }
        }
        return false;
    }

    public boolean remove(int id) {
        for (int i = 0; i < this.elements.size(); i++) {
            T e = this.elements.get(i);
            if (findById(e) == id) {
                this.elements.remove(i);
                return true;
            }
        }
        return false;
    }

    public int findById(T element) {
        if (elements.size() >= 1) {
            if (element instanceof User) {
                return ((User) element).getId();

            } else if (element instanceof CreativeSpace) {
                return ((CreativeSpace) element).getId();
            } else {
                return -1;
            }
        }
        return -1;
    }

    public T getElement(int id) {
        for (int i = 0; i < elements.size(); i++) {
            T e = this.elements.get(i);
            if (findById(e) == id) {
                return this.elements.get(i);
            }
        }
        return null;
    }

}//fin
