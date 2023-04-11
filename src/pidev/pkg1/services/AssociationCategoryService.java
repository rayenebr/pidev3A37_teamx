package pidev.pkg1.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pidev.pkg1.entities.AssociationCategory;
import pidev.pkg1.interfaces.InterfaceAssociationCategory;
import pidev.pkg1.utils.DataBase;

public class AssociationCategoryService implements InterfaceAssociationCategory {

    private List<AssociationCategory> list;
    Connection connection = DataBase.getConnection();

    public AssociationCategoryService() {
    }

    @Override
    public List<AssociationCategory> getAllAssociationCategories() {
        list = new ArrayList<AssociationCategory>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM category_type");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new AssociationCategory(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public AssociationCategory getAssociationCategoryById(Integer id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM category_type WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new AssociationCategory(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addAssociationCategory(AssociationCategory associationCategory) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO category_type (id, type) VALUES (null, ?)");
            ps.setString(1, associationCategory.getType());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAssociationCategory(AssociationCategory associationCategory) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE category_type SET type = ? WHERE id = ?");
            ps.setString(1, associationCategory.getType());
            ps.setInt(2, associationCategory.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAssociationCategory(Integer id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM category_type WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
}