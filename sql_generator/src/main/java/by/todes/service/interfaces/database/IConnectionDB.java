package by.todes.service.interfaces.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionDB {

    Connection connect() throws ClassNotFoundException, SQLException;


}
