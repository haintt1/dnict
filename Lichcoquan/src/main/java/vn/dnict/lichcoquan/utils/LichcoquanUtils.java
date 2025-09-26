package vn.dnict.lichcoquan.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import lichcoquan.service.model.Lichcoquan;
import lichcoquan.service.service.LichcoquanLocalServiceUtil;


public class LichcoquanUtils {
	public static long daysBetween2Dates(String dateBegin, String dateEnd) throws java.text.ParseException {
		   DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		   Date now = new Date();
		 	Calendar c1 = Calendar.getInstance();
		 	c1.setTime(df.parse(dateBegin));
	        Calendar c2 = Calendar.getInstance();
	        if(dateEnd.equals("")){
	        	c2.setTime(now);
	        }else{
	        	c2.setTime(df.parse(dateEnd));
	        }
	        long noDay = (c2.getTime().getTime() - c1.getTime().getTime())
	                / (24 * 3600 * 1000);
	        return noDay;
	    }	
	public static int ConvertDateTuan(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		return week;
	}
	
	public static String getContent(String url, String macoquan, String ngaybatdau) throws Exception {
		String myURL = url+"?maCoQuan="+macoquan+"&ngayBatDau="+ngaybatdau;
		Document doc = Jsoup.connect(myURL).userAgent("Mozilla").get();
		String content = doc.getElementsByClass("egov-container").toString();
		return content;
	}
	
	public static List<Lichcoquan> listCoquan(String tungay, String denngay, int start, int end) throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		DynamicQuery query = LichcoquanLocalServiceUtil.dynamicQuery();
		
		if(Validator.isNotNull(tungay) && !tungay.equals("")){
			tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("createDate").ge(df.parse(tungay)));
		}
		if(Validator.isNotNull(denngay) && !denngay.equals("")){
			denngay +=  " 23:59:59";
			query.add(PropertyFactoryUtil.forName("createDate").le(df.parse(denngay)));
		}
		
		
		query.add(PropertyFactoryUtil.forName("trangthai").eq(0));
		query.addOrder(OrderFactoryUtil.desc("nam"));
		query.addOrder(OrderFactoryUtil.desc("tuan"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<Lichcoquan> listlichcoquan = LichcoquanLocalServiceUtil.dynamicQuery(query);
		return listlichcoquan;
	}
	
	public static int DaybyDate(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		return day;
	}
	
	public static String getTuesDateOfWeek(Date date) throws Exception{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int check = DaybyDate(date);
		if(check == 2){
			return df.format(date);
		}else{
			cal.add(Calendar.DATE, -(check-2));
			return df.format(cal.getTime());
		}
	}
	
	public static List<String> getlisttuesday(Date date) throws Exception {
		List<String> result = new ArrayList<String>();
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date_now = new Date();
		Calendar cal = Calendar.getInstance();
		boolean check_loop = false;
			while (!check_loop){
				String rs1 = getTuesDateOfWeek(date);
				String rs2 = getTuesDateOfWeek(date_now);
				if(rs1.equals(rs2)){
					check_loop =true;
					int check = result.indexOf(rs1);
					if(check == -1){
						result.add(rs1);
					}
				}else{
					cal.setTime(date);
					cal.add(Calendar.DATE, 1);
					date = cal.getTime();
					int check = result.indexOf(rs1);
					if(check == -1){
						result.add(rs1);
					}
				}
			}
		return result;
	}
	
	public static void saveLichCoQuan(String Content, int tuan, int nam, Date tungay) throws Exception {
		long lichcoquanId = CounterLocalServiceUtil.increment(Lichcoquan.class.getName());
		Lichcoquan lcq = LichcoquanLocalServiceUtil.createLichcoquan(lichcoquanId);
		lcq.setLichCongtacId(lichcoquanId);
		lcq.setContent(Content);
		if(tuan>0){
			lcq.setTuan(tuan);
		}
		if(nam>0){
			lcq.setNam(nam);
		}
		lcq.setBanhanh(0);
		lcq.setTrangthai(0);
		lcq.setCreateDate(new Date());
		if(Validator.isNotNull(tungay)){
			lcq.setTungay(tungay);
		}
		LichcoquanLocalServiceUtil.addLichcoquan(lcq);
	}
	
	public static Lichcoquan getLichCoquanfromRequest(ActionRequest request) throws Exception {
		long id = ParamUtil.getLong(request, "id");
		Lichcoquan object = LichcoquanLocalServiceUtil.createLichcoquan(id);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		if(Validator.isNotNull(ParamUtil.getString(request, "tungay"))){
			object.setTungay(ParamUtil.getDate(request, "tungay", df));
		}
		if(Validator.isNotNull(ParamUtil.getString(request, "denngay"))){
			object.setDenngay(ParamUtil.getDate(request, "denngay", df));
		}
		if(Validator.isNotNull(ParamUtil.getString(request, "content"))){
			object.setContent(ParamUtil.getString(request, "content"));
		}
		if(Validator.isNotNull(ParamUtil.getString(request, "tuan"))){
			object.setTuan(Integer.valueOf(ParamUtil.getString(request, "tuan")));
		}
		if(Validator.isNotNull(ParamUtil.getString(request, "nam"))){
			object.setNam(Integer.valueOf(ParamUtil.getString(request, "nam")));
		}
		object.setCreateDate(new Date());
		return object;
	}
	
	@SuppressWarnings("deprecation")
	public static Lichcoquan getLichCoquanNew() throws Exception{
		DynamicQuery query = LichcoquanLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("trangthai").eq(0));
		query.addOrder(OrderFactoryUtil.desc("lichCongtacId"));
			query.setLimit(0, 5);
		@SuppressWarnings("unchecked")
		List<Lichcoquan> listlichcoquan = LichcoquanLocalServiceUtil.dynamicQuery(query);
		if(listlichcoquan.size() > 0){
			return listlichcoquan.get(0);
		}else{
			return LichcoquanLocalServiceUtil.createLichcoquan(1);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static boolean checktuan(int tuan, int nam) throws Exception {
		DynamicQuery query = LichcoquanLocalServiceUtil.dynamicQuery();
		if (Validator.isNotNull(nam)){
			query.add(RestrictionsFactoryUtil.eq("nam",nam));
		}
		if (Validator.isNotNull(nam)){
			query.add(RestrictionsFactoryUtil.eq("tuan",tuan));
		}
		query.add(RestrictionsFactoryUtil.eq("trangthai", 0));
		
		query.addOrder(OrderFactoryUtil.desc("tuan"));
		List<Lichcoquan> list = LichcoquanLocalServiceUtil.dynamicQuery(query);
		if(list.size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void checkDongbo(String maCQ) throws Exception{
		DateFormat dfnam  = new SimpleDateFormat("yyyy");
		DateFormat df   = new SimpleDateFormat("dd/MM/yyyy");
		String maCoquan = "00006";
		if(!maCQ.equals("")){
			maCoquan = maCQ;
		}
		Date dateNow   	= new Date();
		int dayNow 		= LichcoquanUtils.DaybyDate(dateNow);
		try {
			if(dayNow > 3){
				Lichcoquan lcqmax = LichcoquanUtils.getLichCoquanNew();
				List<String> arrDate = new ArrayList<String>(); 
				if(Validator.isNotNull(lcqmax) && Validator.isNotNull(lcqmax.getTungay())){
					arrDate = LichcoquanUtils.getlisttuesday(lcqmax.getTungay());
				}else {
					arrDate = LichcoquanUtils.getlisttuesday(dateNow);
				}
				String url = "https://egov.danang.gov.vn/widget/web/guest/ttqlvbdh/-/thongtinlichcoquanmanagement_WAR_qlvbdhappportlet";
				
				for(String date_batdau : arrDate){
					String result = LichcoquanUtils.getContent(url, maCQ, date_batdau);
					int Week   = LichcoquanUtils.ConvertDateTuan(df.parse(date_batdau));
					String nam = dfnam.format(df.parse(date_batdau));
					boolean flag = LichcoquanUtils.checktuan(Week, Integer.valueOf(nam));
					if(flag == false && !result.equals("")){
							LichcoquanUtils.saveLichCoQuan(result, Week, Integer.valueOf(nam), df.parse(date_batdau));
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Lichcoquan getLastLichcoquanBanHanh(int banhanh_status) throws Exception {
		DynamicQuery query = LichcoquanLocalServiceUtil.dynamicQuery();
		Lichcoquan lichcoquan = LichcoquanLocalServiceUtil.createLichcoquan(0);
		if (Validator.isNotNull(banhanh_status)){
			query.add(RestrictionsFactoryUtil.eq("banhanh",banhanh_status));
		}
		query.add(RestrictionsFactoryUtil.eq("trangthai", 0));
		query.addOrder(OrderFactoryUtil.desc("lichCongtacId"));
		List<Lichcoquan> list = LichcoquanLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNotNull(list) && list.size()>0){
			lichcoquan = list.get(0);
		}
		query.setLimit(0, 1);
		return lichcoquan;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Lichcoquan> listLichLienQuan(long idCurrentWeek, int start, int end) throws Exception{
		DynamicQuery query = LichcoquanLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("lichCongtacId").gt(idCurrentWeek));
		query.add(PropertyFactoryUtil.forName("trangthai").eq(0));
		query.addOrder(OrderFactoryUtil.desc("lichCongtacId"));
		if(end!=0){
			query.setLimit(0, end);
		}
		DynamicQuery query1 = LichcoquanLocalServiceUtil.dynamicQuery();
		query1.add(PropertyFactoryUtil.forName("lichCongtacId").lt(idCurrentWeek));
		query1.add(PropertyFactoryUtil.forName("trangthai").eq(0));
		query1.addOrder(OrderFactoryUtil.desc("lichCongtacId"));
		if(end!=0){
			query1.setLimit(0, end);
		}
		List<Lichcoquan> listLichLienQuan = LichcoquanLocalServiceUtil.dynamicQuery(query);
		List<Lichcoquan> listLichLienQuan1 = LichcoquanLocalServiceUtil.dynamicQuery(query1);
		if(Validator.isNull(listLichLienQuan1)){
			listLichLienQuan1 = new ArrayList<Lichcoquan>();
		}
		if(Validator.isNull(listLichLienQuan)){
			listLichLienQuan = new ArrayList<Lichcoquan>();
		}
		List<Lichcoquan> newList = new ArrayList<Lichcoquan>();
		newList.addAll(listLichLienQuan);
		newList.addAll(listLichLienQuan1);
		return newList;
	}
	
}
