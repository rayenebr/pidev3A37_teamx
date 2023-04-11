/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.pkg1.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pidev.pkg1.interfaces.InterfaceAssociationList;
import pidev.pkg1.utils.DataBase;
import pidev.pkg1.entities.Association;

public class AssociationListController implements InterfaceAssociationList{

    private List<Association> list;
    Connection connection = DataBase.getConnection();

    public AssociationListController() {
    }

    @Override
    public List<Association> getAllAssociationList() {
        list = new ArrayList<Association>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM association");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Association(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Association getAssociationById(Integer id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM association WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Association(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addAssociation(Association association) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO association (id, nom, adresse, num_tel, mail, description, category_type_id, image, view_count ) VALUES (null, ?, ?, ?, ?, ?, ?, ?, 0)");
            ps.setString(1, association.getNom());
            ps.setString(2, association.getAdresse());
            ps.setString(3, association.getNum_tel());
            ps.setString(4, association.getMail());
            ps.setString(5, association.getDescription());
            ps.setInt(6, association.getCategory_type_id());
            ps.setString(7, association.getImage());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAssociation(Association association) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE association SET nom = ?, adresse = ?, num_tel = ?, mail = ?, description = ?, category_type_id = ?, image = ? WHERE id = ?");
            ps.setString(1, association.getNom());
            ps.setString(2, association.getAdresse());
            ps.setString(3, association.getNum_tel());
            ps.setString(4, association.getMail());
            ps.setString(5, association.getDescription());
            ps.setInt(6, association.getCategory_type_id());
            ps.setString(7, association.getImage());
            ps.setInt(8, association.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAssociation(Integer id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM association WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
