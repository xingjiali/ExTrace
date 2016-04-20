package ts.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import ts.daoBase.BaseDao;
import ts.model.TransPackage;
import ts.model.TransPackageContent;
/**
 * 
 * @author xingjiali
 *
 */
public class TransPackageContentDao extends BaseDao<TransPackageContent,Integer> {
	public TransPackageContentDao(){
		super(TransPackageContent.class);
	}
	
	public TransPackageContent get(String expressId, String packageId){
		List<TransPackageContent> list  = new ArrayList<TransPackageContent>();
		list = super.findBy("SN", true, 
				Restrictions.sqlRestriction("ExpressID = '"+ expressId + "' and PackageID = '" + packageId +"'"));
		if(list.size() == 0)
			return null;
		return list.get(0);
	}
	public int getSn(String expressId, String packageId){
		TransPackageContent cn = get(expressId,packageId);
		if(cn == null){
			return 0;
		}
		return get(expressId,packageId).getSN();
	}

	public void delete(String expressId, String packageId){
		List<TransPackageContent> list  = new ArrayList<TransPackageContent>();
		list = super.findBy("SN", true, Restrictions.sqlRestriction("ExpressID = '"+ expressId + "'and PackageID = '" + packageId +"' "));
		for(TransPackageContent pc : list)
			super.remove(pc);
		return ;
	}
	public void addTransPackageContent(TransPackageContent transPackageContent){
		save(transPackageContent);
	}
	
	public List<String> getAllPackage(String expressId){		
		List<TransPackageContent> list1=new ArrayList<TransPackageContent>();
		List<String> li=new ArrayList<String>();
		List<TransPackage> list2=new ArrayList<TransPackage>();
		List<TransPackage> list3=new ArrayList<TransPackage>();
		TransPackageDao tpd=new TransPackageDao();
		list1=super.findBy("SN",true,Restrictions.sqlRestriction("ExpressID = '"+ expressId + "'"));
		//System.out.println(list1);
		for(TransPackageContent tp : list1)
			list2.add(tp.getPkg());
		//System.out.println(list2);
		list3=tpd.sortTransPackage(list2, true);
		//System.out.println(list3);
		for(TransPackage tp : list3)
			li.add(tp.getID());
		/*System.out.println(li);*/
		return li;		
	}
	public List<String> getAllExpressSheet(String packageId){
		System.out.println(packageId);
		List<String> li=new ArrayList<String>();
		List<TransPackageContent> list=new ArrayList<TransPackageContent>();
		list=super.findBy("SN",true,Restrictions.sqlRestriction("PackageID = '"+ packageId + "'"));
		System.out.println(li);
		for(TransPackageContent pc: list)
	       li.add(pc.getExpress().getID());
		System.out.println(li);
		return li;		
	}
}
