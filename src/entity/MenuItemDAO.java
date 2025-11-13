/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import core.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *
 * @author Gokhan
 */
public class MenuItemDAO implements DAO<MenuItem>
{   
    public MenuItemDAO() {
        
    }
    List<MenuItem> menuItems;
    /**
     * Get a single customer entity as a customer object
     * @param id
     * @return 
     */
    @Override
    public Optional<MenuItem> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM OD_MenuItem WHERE MenuItem_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            MenuItem menuItem = null;
            while (rs.next()) {
                menuItem = new MenuItem(rs.getInt("MenuItem_ID"), rs.getString("Item_Name"), rs.getString("Category"), rs.getDouble("Unit_Price"));
            }
            return Optional.ofNullable(menuItem);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all customer entities as a List
     * @return 
     */
    @Override
    public List<MenuItem> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        menuItems = new ArrayList<>();
        try {
            String sql = "SELECT * FROM OD_MenuItem";
            rs = db.executeQuery(sql);
            MenuItem menuItem = null;
            while (rs.next()) {
                menuItem = new MenuItem(rs.getInt("MenuItem_ID"), rs.getString("Item_Name"), rs.getString("Category"), rs.getDouble("Unit_Price"));
                menuItems.add(menuItem);
            }
            return menuItems;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert a customer object into customer table
     * @param menuItem
     */
    @Override
    public void insert(MenuItem menuItem)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO OD_MenuItem(MenuItem_ID, Item_Name, Category, Unit_Price) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, menuItem.getID());
            stmt.setString(2, menuItem.getName());
            stmt.setString(3, menuItem.getCategory());
            stmt.setDouble(4, menuItem.getUnitPrice());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A menu item was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update a customer entity in database if it exists using a customer object
     * @param menuItem
     */
    @Override
    public void update(MenuItem menuItem) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE OD_MenuItem SET Item_Name=?, Category=?, Unit_Price=? WHERE MenuItem_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, menuItem.getName());
            stmt.setString(2, menuItem.getCategory());
            stmt.setDouble(3, menuItem.getUnitPrice());
            stmt.setInt(4, menuItem.getID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Menu Item was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete a customer from customer table if the entity exists
     * @param menuItem
     */
    @Override
    public void delete(MenuItem menuItem) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM OD_MenuItem WHERE MenuItem_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, menuItem.getID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Menu item deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Get all column names in a list array
     * @return 
     */
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM OD_MenuItem WHERE MenuItem_ID = -1";//We just need this sql query to get the column headers
            rs = db.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            //Get number of columns in the result set
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i));//Add column headers to the list
            }
            return headers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        } 
    }
}
