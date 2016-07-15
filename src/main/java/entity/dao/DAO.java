/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

/**
 *
 * @author ai
 */
public interface DAO<T>{
    void insert(T v)throws java.sql.SQLException;
    void delete(T w)throws java.sql.SQLException;
    void update(T a,T b)throws java.sql.SQLException;
    java.util.ArrayList<T>getData()throws java.sql.SQLException;
}