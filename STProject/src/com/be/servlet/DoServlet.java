package com.be.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.be.model.City;
import com.be.model.County;
import com.be.model.Project;
import com.be.service.impl.CityServiceImpl;
import com.be.service.impl.CountyServiceImpl;
import com.be.service.impl.ProjectServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private List<City> citys = null; // 市集合
	private List<County> countys = null; // 县集合
	private Map<Integer, List<County>> cityCountys = null; // 对应市的县信息
	private JSONObject jsonObj = null; // JSON对象
	private JSONArray jsonArr = null; // JSON数组
	private List<Project> projects = null; // 项目集合

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		switch (type) {
		case "toIndex" : toIndex(request, response); break;
		case "addCounty" : addCounty(request, response); break;
		case "queryProjectByCityId" : queryProjectByCityId(request, response); break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 跳转到首页
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toIndex(HttpServletRequest request, HttpServletResponse response) {
		citys = new CityServiceImpl().queryAllCity();
		cityCountys = new HashMap<Integer, List<County>>();
		for (City city : citys) {
			countys = new CountyServiceImpl().queryCountyByCityId(city.getId());
			cityCountys.put(city.getId(), countys);
		}
		request.setAttribute("citys", citys);
		request.setAttribute("cityCountys", cityCountys);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/show.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加县信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void addCounty(HttpServletRequest request, HttpServletResponse response) {
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		String countyName = request.getParameter("countyName");
		String message = new CountyServiceImpl().insertCounty(countyName, cityId);
		String result = "{'message':'" + message + "'}";
		jsonObj = JSONObject.fromObject(result);
		try {
			response.getWriter().print(jsonObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void queryProjectByCityId(HttpServletRequest request, HttpServletResponse response) {
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		System.out.println(cityId);
		projects = new ProjectServiceImpl().queryProjectByCityId(cityId);
		if (projects != null && projects.size() > 0) {
			jsonArr = JSONArray.fromObject(projects);
			try {
				response.getWriter().print(jsonArr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
