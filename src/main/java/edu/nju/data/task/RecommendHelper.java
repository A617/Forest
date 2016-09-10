package edu.nju.data.task;

import edu.nju.data.Impl.RepoDaoImpl;
import edu.nju.data.dao.IRepoDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tjDu on 2016/9/10.
 */
public class RecommendHelper {
    private RepoDaoImpl repoDao;

    public RecommendHelper(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        repoDao =(RepoDaoImpl) context.getBean("repoDao");
    }
    public static void main(String[] args) {
        RecommendHelper helper = new RecommendHelper();
        System.out.println(helper.repoDao);
    }
}
