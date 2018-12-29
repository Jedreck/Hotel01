package sample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class test {

    @Test
    public void test01() {
        try {
            System.out.println("test");
            String resource = "sample/SqlMapConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            //根据ID查询
            sample.mapper.Customer customer = session.selectOne("selectCustomerByID", "145154199909093333");

            System.out.println(customer);

            customer.setC_ID("145154199909093334");
            customer.setC_phone("13846533358");
            System.out.println("插入：\n"+customer);
            session.insert("insertCustomer",customer);

            session.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
