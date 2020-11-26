package repo;

import org.springframework.jdbc.core.JdbcTemplate;
import pckg.MyObject;

import java.util.ArrayList;
import java.util.List;

public class Reposit {
    private static JdbcTemplate jdbcTemplate = BDconfig.getJdbcTemplate();
    private static List<MyObject> teachers = new ArrayList<MyObject>();

    public static List<MyObject> readAll() {
        String sql = "SELECT * FROM laba4";
        return (jdbcTemplate.query(sql, new Mapping()));
    }

    public static MyObject readById(Integer id) {
        String sql = "select * from laba4 where id = " + id.toString();
        return jdbcTemplate.query(sql, new Mapping()).get(0);
    }

    public static void create(MyObject myObject) {
        jdbcTemplate.update(
                "INSERT INTO public.laba4 (\"tickedNum\", gpoup, name,\n" +
                        "                              \"secondName\", \"lastName\", mark1, mark2, mark3, mark4,\n" +
                        "                              \"avarageMark\") " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)",
                myObject.getTickedNum(), myObject.getGroup(), myObject.getName(), myObject.getSecondName(),
                myObject.getLastName(), myObject.getMark1(), myObject.getMark2(), myObject.getMark3(), myObject.getMark4(),
                myObject.getAvarageMark()
        );
    }

    public static void update(MyObject myObject) {

        jdbcTemplate.update("update public.laba4 set \"tickedNum\" = ?, gpoup = ?, name = ? , \"secondName\" = ?, \"lastName\" = ?," +
                        " mark1 = ?, mark2 = ?, mark3 = ?, mark4 = ?, \"avarageMark\"= ?" +
                        " where id = ?",  myObject.getTickedNum(), myObject.getGroup(), myObject.getName(), myObject.getSecondName(),
                myObject.getLastName(), myObject.getMark1(), myObject.getMark2(), myObject.getMark3(), myObject.getMark4(),
                myObject.getAvarageMark(), myObject.getId());
    }



    public static void delete(Integer id) {
        jdbcTemplate.update("delete from public.laba4 where id = ?", id);
    }

}
