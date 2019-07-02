import com.bean.District;
import com.bean.HouseOther;
import com.github.pagehelper.PageInfo;
import com.mapper.DistrictMapper;
import com.mapper.HouseMapper;
import com.mapper.UsersMapper;
import com.service.DistrictService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    @org.junit.Test
    public void test() {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        /*DistrictService service = (DistrictService)ctx.getBean("districtServiceImp");
        PageInfo<District> page = service.selectByExample(1,3);
        for (District dis : page.getList()) {
            System.out.println(dis);
        }*/
        UserService service = (UserService)ctx.getBean("userServiceImp");
        boolean num = service.yanZheng("admin","1234");
        System.out.println(num);
        boolean flag = service.getIdentity("admin");
        System.out.println(flag);

    }
}
