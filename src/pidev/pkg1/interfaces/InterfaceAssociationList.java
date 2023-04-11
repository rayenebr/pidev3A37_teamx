/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.pkg1.interfaces;

import java.util.List;
import pidev.pkg1.entities.Association;

public interface InterfaceAssociationList {
    public List<Association> getAllAssociationList();
    public Association getAssociationById(Integer id);
    public void addAssociation(Association association);
    public void updateAssociation(Association association);
    public void deleteAssociation(Integer id);
}
