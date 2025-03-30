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
public class UserDAO {

    private ArrayList<User> listUsers;

    public UserDAO() {
        this.listUsers = new ArrayList<>();
    }

    public ArrayList<User> getAll() {
        return this.listUsers;
    }

    public boolean save(User user) {
        return this.listUsers.add(user);
    }

    public boolean update(User userEdit) {
        for (int i = 0; i < this.listUsers.size(); i++) {
            if (userEdit.getId() == this.listUsers.get(i).getId()) {
                this.listUsers.set(i, userEdit);
                return true;
            }
        }
        return false;
    }

    public User findById(int id) {
        for (User user : listUsers) {
            if (user.getId() == id) {
                return user;
            }
        }
        return new User();
    }

    public boolean remove(int id) {
        return this.listUsers.remove(this.findById(id));
    }
}
