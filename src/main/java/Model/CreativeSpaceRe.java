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
public class CreativeSpaceRe {
    
    private CreativeSpaceMem creativeSpaceMem;

    public CreativeSpaceRe() {
        creativeSpaceMem = new CreativeSpaceMem();
        
    }
    
    public String add(CreativeSpace creativeSpace){
        if (creativeSpace.getId() == this.creativeSpaceMem.findByID(creativeSpace.getId()).getId()) {
            return "This Creative Space Already Exist";
            
        }else{
            if(this.creativeSpaceMem.save(creativeSpace)){
            return "Creative Space add Successfully";
            }
        }
        return "Error saving creative space";
    }
    
    public String edit (CreativeSpace creativeSpace){
        if (this.creativeSpaceMem.update(creativeSpace)) {
            return "Creative space edited";
            
        }
        return "Error Editing";
    }
    
    public String delete(int id){
        if (creativeSpaceMem.remove(id)) {
            return "Creative Space Removed";
        }
        return "Error Removing";
    }
    
    public CreativeSpace searchById(int id){
        return this.creativeSpaceMem.findByID(id);
    }
    
    public String[][] getMatrix (){
        ArrayList<CreativeSpace> creativeSpaces = this.creativeSpaceMem.getAll();
        if (creativeSpaces == null || creativeSpaces.isEmpty()) {
            return new String[0][6];
            
        }else{
            String[][] matrix = new String[creativeSpaces.size()][6];
            
            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[0].length; column++) {
                    matrix[row][column] = creativeSpaces.get(row).setColumData(column);
                }
            }
            return matrix;
        }
    }
}
