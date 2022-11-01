package com.capacitybuilding.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface IMySQLDB<T extends Entity> {

    String createInsertQuery();
    String createDeleteQuery();
    String createUpdateQuery(Map<String, Object> entryMap);
    ResultSet fetchAll() throws SQLException;
    ResultSet fetchOne() throws SQLException;
    void update();
    void delete();
    String createSelectQuery();
    String createSelectWithWhereClauseQuery(Map<String, String> critetia);

    String createSelectOneQuery();
    boolean executeQuery(String query);
    void save();
    ResultSet executeReadQuery(String query) throws SQLException;

    void setEntity(T t);

}
