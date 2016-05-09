import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.catalina.webresources.AbstractArchiveResource;
import org.apache.cxf.jaxrs.provider.json.utils.JSONUtils;
import org.apache.cxf.service.invoker.SessionFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ts.daoBase.BaseDao;
import ts.daoImpl.CustomerInfoDao;
import ts.daoImpl.PackageRouteDao;
import ts.daoImpl.RegionDao;
import ts.daoImpl.TransPackageContentDao;
import ts.daoImpl.TransPackageDao;
import ts.daoImpl.UserInfoDao;
import ts.model.CustomerInfo;
import ts.model.ExpressSheet;
import ts.model.PackageRoute;
import ts.model.TransPackage;
import ts.model.TransPackageContent;
import ts.model.UserInfo;
import ts.serviceImpl.DomainService;

/**|
 * 
 * @author Zongzan
 *1.openSession和getCurrentSession的区别？
   *openSession必须关闭，currentSession在事务结束后自动关闭
   *openSession没有和当前线程绑定，currentSession和当前线程绑定
2.如果使用currentSession需要在hibernate.cfg.xml文件中进行配置：
   *如果是本地事务（jdbc事务）
     <propertyname="hibernate.current_session_context_class">thread</property>
   *如果是全局事务（jta事务）
   <propertyname="hibernate.current_session_context_class">jta</property>
全局事务：资源管理器管理和协调的事务，可以跨越多个数据库和进程。资源管理器一般使用XA 二阶段提交协议与“企业信息系统”(EIS) 或数据库进行交互。 
本地事务：在单个 EIS或数据库的本地并且限制在单个进程内的事务。本地事务不涉及多个数据来源。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AddTest {

	/*@Resource
	private SessionFactory sessionFactory;
	public SessionFactory setSessionFactory(){
		return sessionFactory;
	}
	@Test 
	public void fun2(){
		Configuration configuration = new Configuration() ;
		configuration.configure("ExTrace.cfg.xml");
		try{
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			System.out.println(sessionFactory);
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	
/*	@Resource
	SessionFactory sessionFactory;
	
	@Test
	public void fun1(){
		System.out.println(sessionFactory);
	}*/
	
	
	@Resource
	RegionDao    regionDao;
	@Resource
	CustomerInfoDao customerInfoDao;		
	@Resource
	PackageRouteDao pkgRouteDao;
	@Resource
	TransPackageDao transPackageDao;
	@Resource
	TransPackageContentDao transPackageContentDao;
	@Resource
	UserInfoDao userInfoDao;

	@Test
	public void fun(){
		/*PackageRoute pr = new PackageRoute();
		TransPackage tp = new TransPackage();
		TransPackageContent transPkgCont = new TransPackageContent();
		ExpressSheet es = new ExpressSheet();
		es.setID("10000001");
		es.setPackageFee((float)20);
		es.setSender(new CustomerInfo());
		es.setRecever(new CustomerInfo());
		es.setStatus(2);
		
		tp.setSourceNode("1000");
		tp.setStatus(2);
		tp.setTargetNode("1001");

		transPkgCont.setPkg(tp);
		transPkgCont.setExpress(es);
		Set<TransPackageContent> s = new HashSet<TransPackageContent>();
		s.add(transPkgCont);
		tp.setContent(s);
		transPkgCont.setPkg(tp);
		
		pr.setPkg(tp);
		pr.setX((float)21.3213);
		pr.setY((float)42.2312);
		packageRD.addPackageRoute(pr);
		
		List<PackageRoute> pkgRouteList =  pkgRouteDao.findPkgRoute("1");
		System.out.println(pkgRouteList.size());
		
		System.out.println(transPackageDao.getDestination("1111112222"));
		
		CustomerInfo cus = customerInfoDao.get(1);
		System.out.println(cus.getName());
		
		CustomerInfo customer = new CustomerInfo();
		customer.setAddress("郑州市高新区科学大道100号郑州大学新校区松园");
		customer.setDepartment("#19-"
				+ "");
		customer.setName("zongzan");
		customer.setPostCode(450001);
		customerInfoDao.save(customer);*/
		
		/**
		 * UserInfoDao
		 */
		//System.out.println(userInfoDao.checkUserByID(11, "user11"));
		/*UserInfo ui=new UserInfo();
		ui.setName("lili");
		ui.setPWD("123");
		ui.setTelCode("13523839302");
		ui.setStatus(0);
		ui.setTransPackageID("1111112234");
		ui.setReceivePackageID("1111112235");
		ui.setDelivePackageID("1111112236");
		ui.setDptID("11232322");
		ui.setURull(0);
		userInfoDao.addUser(ui);*/
		//userInfoDao.getReceivePackageId(11);
		//userInfoDao.getDelivePackageId(11);
		//userInfoDao.getTransPackageId(11);
		//userInfoDao.getDptId(11);
		//userInfoDao.getTel(11);
		/*UserInfo ui=new UserInfo();
		ui.setUID(14);
		ui.setName("jiajia");
		ui.setPWD("123456");
		ui.setTelCode("13523839302");
		ui.setStatus(0);
		ui.setTransPackageID("1111112234");
		ui.setReceivePackageID("1111112235");
		ui.setDelivePackageID("1111112236");
		ui.setDptID("11232322");
		ui.setURull(0);
		userInfoDao.updateUser(ui);*/
		//userInfoDao.getUserByDPid("1111113331");
		
		
		/**
		 * TransPackageDao
		 */
		//System.out .println(transPackageDao.getRegionDao());
		//transPackageDao.setRegionDao(regionDao);
		//transPackageDao.getDestination("1111112222");
		//transPackageDao.getTransPackage("1111112222");
		//transPackageDao.getAllPackageId("2");
		//System.out.println(transPackageDao.getAllPackage("2"));
		//System.out.println(transPackageDao.getAllPackageId("2"));
		//transPackageDao.takeTransPackage("1111112233","1111115555");
		transPackageDao.unpackTransPackage("1111115555");
		
		/**
		 * TransPackageContentDao
		 */
		//transPackageContentDao.get("1", "1111112233");
		//transPackageContentDao.getSn("2", "1111112222");
		//transPackageContentDao.delete("1", "1111112222");
		//transPackageContentDao.getListPackageContent("1");
		//transPackageContentDao.getAllExpressSheetId("1111112233");
		//transPackageContentDao.getAllExpressSheet("1111112233");
		
		
	}
	/*@Test
	public void fun(){
		HttpClient a = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://localhost:8080/Extrace/REST/Domain/deliveExpress");
//		post.setHeader("User-Agent", "Mozilla/4.5");
//		post.addHeader("Content-type","application/json");
//		post.setHeader("Accept","application/json");
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
//		StringEntity entity1 = null;
//
//		StringEntity entity2 = null;
//		try {
//			entity1 = new StringEntity(JsonUtils.toJson(list),"UTF-8");
//			entity2 = new StringEntity(JsonUtils.toJson("1111115555"));
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
//		entity1.setContentType("application/json");
//		entity2.setContentType("application/json");
//		post.setEntity(entity1);
//		post.setEntity(entity2);
		HttpParams para = post.getParams();
		para.setParameter("list", list);
		para.setParameter("PackId", "1111115555");
		post.setParams(para);
		try{
			HttpResponse res = a.execute(post);
			System.out.println(EntityUtils.toString(res.getEntity()));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}*/
}
