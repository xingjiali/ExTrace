package ts.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Remove;
import org.hibernate.criterion.Restrictions;

import ts.daoBase.BaseDao;
import ts.model.TransPackage;
import ts.model.UserInfo;
/**
 * 
 * @author xingjiali
 *
 */

public class UserInfoDao extends BaseDao<UserInfo, Integer> {
	public UserInfoDao(){
		super(UserInfo.class);
	}
	public boolean checkUserByID(Integer uID, String psw){
		UserInfo userInfo = get(uID);
		/*System.out.println("name " + userInfo.getName()+"\npsw " + userInfo.getPWD()+"zong\n");
		System.out.println(userInfo.getPWD().equals(psw));*/
		return userInfo.getPWD().equals(psw);
	}
	public void addUser(UserInfo userInfo){
		save(userInfo);
	}
	public void deleteUser(UserInfo userInfo){
		remove(userInfo);
	}
	public void deleteUserById(int uid){
		removeById(uid);
	}
	public String getReceivePackage(int uid){
		String receivePackageId = null;
		List<UserInfo> list=new ArrayList<UserInfo>();
		UserInfo ui=new UserInfo();
		list=super.findBy("UID", true, Restrictions.sqlRestriction("UID= '"+ uid + "'"));
		ui=list.get(0);
		receivePackageId=ui.getReceivePackageID();
		System.out.println(receivePackageId);
		return receivePackageId;		
	}
	public String getDelivePackage(int uid){
		String delivePackageId = null;
		List<UserInfo> list=new ArrayList<UserInfo>();
		UserInfo ui=new UserInfo();
		list=super.findBy("UID", true, Restrictions.sqlRestriction("UID= '"+ uid + "'"));
		ui=list.get(0);
		delivePackageId=ui.getDelivePackageID();
		System.out.println(delivePackageId);
		return delivePackageId;		
	}
	public String getTransPackage(int uid){
		String transPackageId = null;
		List<UserInfo> list=new ArrayList<UserInfo>();
		UserInfo ui=new UserInfo();
		list=super.findBy("UID", true, Restrictions.sqlRestriction("UID= '"+ uid + "'"));
		ui=list.get(0);
		transPackageId=ui.getTransPackageID();
		System.out.println(transPackageId);
		return transPackageId;		
	}
}
