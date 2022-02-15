/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Image;
import model.Product;

/**
 *
 * @author PC
 */
public class ProductDBContext extends DBContext {
    public ArrayList<Product> getAll() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT [Product].ProID\n"
                    + "      ,[ProName]\n"
                    + "      ,[Image].[Image]\n"
                    + "	  ,[Image].[ImageID]\n"
                    + "      ,[ProDescription]\n"
                    + "      ,[ProPrice]\n"
                    + "      ,[Stock]\n"
                    + "	  ,[Categorie].[CateID]\n"
                    + "	  ,[Categorie].[CateName]\n"
                    + "	  ,[Categorie].[CateDiscription]\n"
                    + "	  \n"
                    + "	  FROM [Product] inner join [Categorie] on [Product].[ProCategorieID] = [Categorie].[CateID]\n"
                    + "	  inner join [Image] on [Product].ProID = [Image].[ProID]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();
                s.setProduct_id(rs.getInt("ProID"));
                s.setProduct_name(rs.getString("ProName"));

                s.setDescription(rs.getString("ProDescription"));
                s.setPrice(rs.getInt("ProPrice"));
                s.setStock(rs.getInt("Stock"));

                Category d = new Category();
                d.setId(rs.getInt("CateId"));
                d.setName(rs.getString("CateName"));
                d.setDescription(rs.getString("CateDiscription"));

                Image i = new Image();
                i.setImage_id(rs.getInt("ImageID"));
                i.setImage(rs.getString("Image"));
                s.setImg(i);
                s.setCate(d);

                products.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public Product getProduct(int ProID) {
        ArrayList<Product> products = new ArrayList<>();
        try {

            String sql = "SELECT ProID\n"
                    + "      ,ProName\n"
                    + "      ,ProDescription\n"
                    + "      ,ProPrice\n"
                    + "      ,Stock\n"
                    + "  FROM Product\n"
                    + " WHERE ProID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, ProID);
            ResultSet rs = stm.executeQuery();
            Product s = null;
            while (rs.next()) {

                if (s == null) {
                    s = new Product();
                    s.setProduct_id(rs.getInt("ProID"));
                    s.setProduct_name(rs.getString("ProName"));

                    s.setDescription(rs.getString("ProDescription"));
                    s.setPrice(rs.getInt("ProPrice"));
                    s.setStock(rs.getInt("Stock"));

                }

            }
            return s;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ProductDBContext db = new ProductDBContext();
        System.out.println(db.getProduct(2).getProduct_name());
        System.out.println(db.getProduct(2).getPrice());
        System.out.println(db.getAll().get(0).getCate().getName());
        System.out.println(db.getAll().get(0).getImg().getImage_id());
    }
}
