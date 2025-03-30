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
public class UserRegister {

    private UserDAO userDAO;

    public UserRegister() {
        this.userDAO = new UserDAO();
    }

    public String getAll() {
        String out = "Users list:\n";
        for (User user : this.userDAO.getAll()) {
            out += user + "\n\n";
        }
        return out;
    }

    //Guardar usuario
    public String add(User user) {
        if (user.getId() == this.userDAO.findById(user.getId()).getId()) {
            return "This users id is already exist";
        } else {
            if (this.userDAO.save(user)) {
                return "User add successfully";
            }
            return "Error saving user";
        }
    }

    public String edit(User userEdit) {
        if (this.userDAO.update(userEdit)) {

            return "User edited successfully";
        }
        return "Error editing user";
    }

    public String delete(int id) {
        if (this.userDAO.remove(id)) {
            return "Successfully deleted user";
        }
        return "Error deleting user";
    }

    public User searchById(int id) {
        return this.userDAO.findById(id);
    }

    public String[][] getMatrix() {
        ArrayList<User> users = this.userDAO.getAll();
        if (users == null || users.isEmpty()) {
            return new String[0][6];
        } else {
            String[][] matrixUser = new String[users.size()][6];
            for (int row = 0; row < matrixUser.length; row++) {
//                matrixUser[row][0] = String.valueOf(users.get(row).getId());
//                matrixUser[row][1] = users.get(row).getName();
//                matrixUser[row][2] = String.valueOf(users.get(row).getAge());
//                matrixUser[row][3] = users.get(row).getEmail();
//                matrixUser[row][4] = users.get(row).getTelephone();
//                matrixUser[row][5] = users.get(row).getDepartment();
                for (int colum = 0; colum < matrixUser[0].length; colum++) {
                    matrixUser[row][colum] = users.get(row).setColumData(colum);
                }
            }
            return matrixUser;
        }
    }

}//fin
