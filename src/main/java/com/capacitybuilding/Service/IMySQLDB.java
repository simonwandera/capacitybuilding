package com.capacitybuilding.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface IMySQLDB<T extends Entity, I extends Connection> {

    String createInsertQuery();
    String createUpdateQuery(Map<String, Object> entryMap);
    ResultSet fetchAll() throws SQLException;
    ResultSet fetchOne() throws SQLException;
    void update();
    String createSelectQuery();
    String createSelectWithWhereClauseQuery(Map<String, String> critetia);

    String createSelectOneQuery();
    boolean executeQuery(String query);
    void save();
    ResultSet executeReadQuery(String query) throws SQLException;

}
