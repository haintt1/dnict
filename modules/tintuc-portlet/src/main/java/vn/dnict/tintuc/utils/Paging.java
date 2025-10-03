package vn.dnict.tintuc.utils;


public class Paging {
	
	public String paging(int currentpage,int pageview,int totalpage,String action){
		String html="<div id='pagination'>";
		action = action+"&p=";
		if(pageview>totalpage){
			pageview = totalpage;
		}
		//nut dau tien
//		if(currentpage>1 && pageview<totalpage){
//			
//		}
		//nut quay lui
		if( 1 < currentpage && currentpage <= totalpage ){
			html +="<a href=\""+action+1+"\"><<</a>";
			html +="<a href=\""+action+(currentpage-1)+"\"><</a>";
		}
		
		//Cac nut con lai
		int startPage = 1;
		int endPage = pageview;
		if(currentpage>=pageview){
			if(pageview%2==0){
				startPage = currentpage-((pageview/2)-1)==0?1:currentpage-((pageview/2)-1);
				endPage = currentpage+(pageview/2)>totalpage?totalpage:currentpage+(pageview/2);
				if(currentpage==totalpage || currentpage==(totalpage-1)){
					startPage = (totalpage-pageview)+1;
				}
			}else{
				startPage = currentpage-(pageview/2)==0?1:currentpage-(pageview/2);
				endPage = currentpage+(pageview/2)>totalpage?totalpage:currentpage+(pageview/2);
				if(currentpage==totalpage || currentpage==(totalpage-1)){
					startPage = totalpage-(pageview-1);
				}
			}
		}
		
				
		for (int i = startPage; i <=endPage; i++) {
			String klass="";
			if(currentpage==i){
				klass="active";
			}
			html +="<a href=\""+action+i+"\" class='"+klass+"'>"+i+"</a>";
		}
		//nut tiep theo
		if( 1 <= currentpage && currentpage < totalpage){
			html +="<a href=\""+action+(currentpage+1)+"\">></a>";
			html +="<a href=\""+action+totalpage+"\">>></a>";
		}
		
		//nut cuoi cung
//		if(currentpage<totalpage && pageview<totalpage){
//			
//		}
		html +=" Trang "+currentpage+" trong " + totalpage;
		html +="</div>";
		return html;
	}
}
