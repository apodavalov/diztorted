package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import play.*;
import play.api.templates.Html;
import play.mvc.*;

import views.html.*;

public class SiteInfo extends Controller {
	public static Html summaryInfo()
	{
		String hostName = String.format("http://%1$s",request().host());
		String year = new SimpleDateFormat("yyyy").format(new Date());
		String lastUpdated = new SimpleDateFormat("yyyy-MM-dd HH:mm Z z").format(new Date());
		
		return siteSummaryInfo.render(hostName,year,lastUpdated);
	}
	
	public static Html noveltyInfo()
	{
		// TODO: информация о новинках сайта
		return Html.empty();
	}
	
	public static Html lastReviews()
	{
		// TODO: последние рецензии (сменить тип на модель Review)
		return Html.empty();
	}
	
	public static Html lastAnnounces()
	{
		// TODO: последние афиши (сменить тип на модель Announce)
		return Html.empty();
	}
	
	public static Html friends()
	{
		// TODO: баннеры друзей (сменить тип на модель Banner)
		return Html.empty();
	}
}
