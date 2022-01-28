package primaryKeyGenerators.custom;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentPKGenerator extends IdentityGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) {
        String PREFIX = "AZ";
        int i = 0;
        Connection c = s.connection();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select EMPLOYEE_IDS.nextval from dual");
            if (rs.next()) {
                i = rs.getInt("NEXTVAL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                if (c != null) {
//                    c.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        return PREFIX + i;
    }
}
