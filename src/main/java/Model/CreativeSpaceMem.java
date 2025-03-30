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
public class CreativeSpaceMem {
    
    private ArrayList<CreativeSpace> list;

    public CreativeSpaceMem() {
        
        this.list = new ArrayList<>();
    }
    
    public ArrayList<CreativeSpace> getAll(){
        return this.list;
    }
    
    public boolean save(CreativeSpace creativeSpace){
        return this.list.add(creativeSpace);
    }
    
    public boolean update(CreativeSpace creativeSpace){
        for (int i = 0; i < this.list.size(); i++) {
            if (creativeSpace.getId() == this.list.get(i).getId()) {
                this.list.set(i, creativeSpace);
                return true;
            }
        }
        return false;
    }
    public CreativeSpace findByID(int id){
        for(CreativeSpace creativeSpace : list){
            if (creativeSpace.getId()==id) {
                return creativeSpace;
                
            }
        }
        return new CreativeSpace();
    }
    
    public boolean remove(int id){
        return this.list.remove(this.findByID(id));
    }
}
