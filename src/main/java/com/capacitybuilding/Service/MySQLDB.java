package com.capacitybuilding.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Map;

public class MySQLDB<T extends Entity> implements IMySQLDB<T> {


    @Resource(lookup = "java:jboss/datasources/CapacityBuilding")
    DataSource dataSource;
    static ResultSet resultSet;
    private Statement statement;
    private T t;

    public void setEntity(T t){
        this.t = t;
    }

    @Override
    public String createSelectWithWhereClauseQuery(Map<String, String> criteria) {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM ");
        stringBuilder.append(t.getTableName()).append(" WHERE ");
        boolean isFirst = true;

        for (Map.Entry<String, String> entry: criteria.entrySet()){
            if (!isFirst)
                stringBuilder.append(" AND ");
            stringBuilder.append(entry.getKey()).append("=").append("\"").append(entry.getValue()).append("\"");
            isFirst = false;
        }

        System.out.println("?>>>>>: " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    @Override
    public String createSelectOneQuery() {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM ");
        stringBuilder.append(t.getTableName()).append(" WHERE ").append("id = ").append(t.getEntitiesMap().get("id"));
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public String createSelectQuery() {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM ");
        stringBuilder.append(this.t.getTableName());
        return stringBuilder.toString();
    }

    @Override
    public String createInsertQuery() {
        StringBuilder stringBuilder = new StringBuilder("INSERT INTO "); // insert into
        stringBuilder.append(t.getTableName()); // tbl_students or tbl_patients
        stringBuilder.append("(");
        boolean isFirstColumn = true;
        for (String key : t.getEntitiesMap().keySet())
        {
            if (!isFirstColumn)
                stringBuilder.append(",");
            stringBuilder.append("`").append(key).append("`");
            isFirstColumn = false;
        }
        stringBuilder.append(")").append("values").append("(");

        isFirstColumn = true;
        for (Object object: t.getEntitiesMap().values()){
            if (!isFirstColumn)
                stringBuilder.append(",");
            if (object != null)
                stringBuilder.append("\"").append(object).append("\"");
            else
                stringBuilder.append((Object) null);
            isFirstColumn = false;
        }
        stringBuilder.append(")");

        return stringBuilder.toString();
    }

    public String createDeleteQuery(){
        StringBuilder stringBuilder = new StringBuilder("DELETE FROM ");
        stringBuilder.append(t.getTableName()).append(" WHERE id =").append(t.getEntitiesMap().get("Id"));
        return stringBuilder.toString();
    }

    public String createUpdateQuery(Map <String, Object> entryMap) {
        StringBuilder updateQuery = new StringBuilder("UPDATE ");
        updateQuery.append(t.getTableName()).append(" SET ");
        boolean isFirst = true;
        for (Map.Entry<String, Object> entry: entryMap.entrySet()){
            if (!isFirst)
                updateQuery.append(",");
            updateQuery.append(entry.getKey()).append("=").append("\"").append(entry.getValue()).append("\"");
            isFirst = false;
        }

        updateQuery.append(" WHERE ").append("id =").append(entryMap.get("Id"));

        return updateQuery.toString();
    }

    @Override
    public boolean executeQuery(String query) {
        try {
            Statement statement = dataSource.getConnection().createStatement();
            statement.execute(query);
            System.out.println("Executed Successfully. ");
            return true;
        }catch (SQLException e){
            System.out.println("Failed to execute");
            return false;
        }
    }

    @Override
    public void save() {
        String insertQuery = this.createInsertQuery();
        System.out.println("Insert query>>>: " +insertQuery);
        this.executeQuery(insertQuery);
    }

    @Override
    public void delete() {
        String deleteQuery = this.createDeleteQuery();
        System.out.println("Delete query>>>: " +deleteQuery);
        this.executeQuery(deleteQuery);
    }

    @Override
    public ResultSet fetchAll() throws SQLException {
        String selectQuery = this.createSelectQuery();
        resultSet = this.executeReadQuery(selectQuery);
        return resultSet;
    }

    @Override
    public ResultSet fetchOne() throws SQLException {
        String selectQuery = this.createSelectOneQuery();
        resultSet = this.executeReadQuery(selectQuery);
        return resultSet;
    }

    @Override
    public void update() {
        String updateQuery = this.createUpdateQuery(t.getEntitiesMap());
        System.out.println("Mysql query >>>>>>> "+ updateQuery);
        this.executeQuery(updateQuery);
    }

    @Override
    public ResultSet executeReadQuery(String query) throws SQLException {
        statement = dataSource.getConnection().createStatement();
        resultSet = statement.executeQuery(query);
        return resultSet;
    }
}
