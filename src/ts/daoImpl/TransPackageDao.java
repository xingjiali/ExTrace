package ts.daoImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import ts.daoBase.BaseDao;
import ts.model.ExpressSheet;
import ts.model.TransPackage;
import ts.model.TransPackageContent;
/**
 * 
 * @author xingjiali
 *
 */
public class TransPackageDao extends BaseDao<TransPackage,String> {
	private RegionDao regionDao;
	public TransPackageDao(){
		super(TransPackage.class);
	}
	public RegionDao getRegionDao() {
		return regionDao;
	}
	public void setRegionDao(RegionDao dao) {
		this.regionDao = dao;
	}
	public String getDestination(String id){
		TransPackage tspack = get(id);
		String dest = regionDao.getRegionNameByID(tspack.getTargetNode());
		System.out.println(dest);
		return dest;
	}
	public void addTransPackage(TransPackage tp){
		save(tp);
	}
	public void changeStatus(TransPackage tp){
		update(tp);
	}
	/*public TransPackage getTransPackage(String PackageId){
		TransPackage tp=new TransPackage();
		tp=super.get(PackageId);
		System.out.print(tp.getID());
		return tp;
	}*/
	public List<TransPackage> sortTransPackage(List<TransPackage> transPackage,boolean isAsc){
		//System.out.println(transPackage);		
		Comparator<TransPackage> comparator = new Comparator<TransPackage>(){

			@Override
			public int compare(TransPackage tp1, TransPackage tp2) {
				// TODO Auto-generated method stub
				if(!tp1.getCreateTime().equals(tp2.getCreateTime())){
				      return tp1.getCreateTime().compareTo(tp2.getCreateTime());
				     }
				else
					return 1;
			}
			
		};
		Collections.sort(transPackage,comparator);
		/*System.out.println(transPackage);*/
		return transPackage;		
	}
	public void takeTransPackage(String transPackage1,String transPackage2){
		TransPackageContent tpc=new TransPackageContent();
		ExpressSheetDao esd=new ExpressSheetDao();
		TransPackageDao tpd=new TransPackageDao();
		TransPackageContentDao tpcd1= new TransPackageContentDao();
		TransPackageContentDao tpcd2= new TransPackageContentDao();
		List<String> list=new ArrayList<String>();
		list=tpcd1.getAllExpressSheet(transPackage1);
		System.out.println(transPackage1);
		System.out.println(list);
		for(String pc:list)
		{
			tpc.setExpress(esd.get(pc));
			tpc.setPkg(tpd.get(transPackage2));
			tpc.setStatus(3);
			tpcd2.addTransPackageContent(tpc);
			System.out.println(tpc);
		}
	}
}
