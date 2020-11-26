package repo;
import org.springframework.jdbc.core.RowMapper;
import pckg.MyObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapping implements RowMapper<MyObject> {
    @Override
    public MyObject mapRow(ResultSet resultSet, int i) throws SQLException {
        MyObject myObject = new MyObject();
        myObject.setId(resultSet.getInt("id"));
        myObject.setTickedNum(resultSet.getString("tickedNum"));
        myObject.setGroup(resultSet.getString("gpoup"));
        myObject.setName(resultSet.getString("name"));
        myObject.setSecondName(resultSet.getString("secondName"));
        myObject.setLastName(resultSet.getString("lastName"));
        myObject.setMark1(resultSet.getInt("mark1"));
        myObject.setMark2(resultSet.getInt("mark2"));
        myObject.setMark3(resultSet.getInt("mark3"));
        myObject.setMark4(resultSet.getInt("mark4"));
        myObject.setAvarageMark();
        return myObject;
    }
}
