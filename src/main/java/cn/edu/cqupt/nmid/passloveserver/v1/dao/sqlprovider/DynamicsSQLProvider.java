package cn.edu.cqupt.nmid.passloveserver.v1.dao.sqlprovider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class DynamicsSQLProvider {

    public String searchByPropertiesSql(@Param("keyword")final String keyword, @Param("losttype")final Integer losttype, @Param("typeid")final Integer typeid,
                                        @Param("placeid")final Integer placeid, @Param("start")final Integer start, @Param("end")final Integer end){
        return new SQL(){
            {
                SELECT("*");
                FROM("dynamics");
                if (keyword != null && !keyword.matches("^ \\S+ $")) {
                    WHERE("description like #{keyword}");
                }
                if (losttype != null && losttype > 0) {
                    WHERE("losttype=#{losttype}");
                }
                if (typeid != null && typeid > 0) {
                    WHERE("typeid=#{typeid}");
                }
                if (placeid != null && placeid > 0) {
                    WHERE("placeid=#{placeid}");
                }
            }
        }.toString() + " limit " + start + "," + end;
    }

}
