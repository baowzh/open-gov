package com.asiainfo.portal.view.modules.org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asiainfo.ewebframe.ui.form.model.SelectResult;
import com.asiainfo.portal.modules.depart.model.Depart;
import com.asiainfo.portal.modules.depart.service.OrgService;
import com.asiainfo.portal.view.modules.FileUploadControler;
import com.asiainfo.portal.view.modules.system.bean.BasicTree;

@Controller
@RequestMapping(value = "org")
public class OrgController extends FileUploadControler {
	@Autowired
	private OrgService orgService;
	@RequestMapping("index")
	public ModelAndView index(ModelMap modelMap) {
		return new ModelAndView("gov/org/index", modelMap);
	}

	@RequestMapping("info")
	public ModelAndView info(ModelMap modelMap, String id) {
		Depart depart = this.orgService.getDepart(id);
		modelMap.put("depart", depart);
		return new ModelAndView("gov/org/info", modelMap);
	}

	@ResponseBody
	@RequestMapping("del")
	public Map<String, Object> del(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.orgService.del(id);
			map.put("success", true);
		} catch (Exception ex) {
			ex.printStackTrace();
			map.put("success", false);
			map.put("mess", ex.getMessage());
		}
		return map;
	}

	@RequestMapping("edit")
	public ModelAndView add(ModelMap modelMap, String id) {
		Depart depart = this.orgService.getDepart(id);
		List<SelectResult> results = new ArrayList<SelectResult>();
		if (depart != null && depart.getType() == 3) {
			List<Depart> departs = orgService.getDeparts(2);
			for (int i = 0; i < departs.size(); i++) {
				Depart departi = departs.get(i);
				SelectResult result = new SelectResult();
				result.setId(departi.getId());
				result.setText(departi.getName());
				results.add(result);
			}

		}
		if (depart != null && depart.getParentId() != null) {
			Depart parent = this.orgService.getDepart(depart.getParentId());
			modelMap.put("parent", parent);
		}

		modelMap.put("parents", results);

		modelMap.put("depart", depart);
		return new ModelAndView("gov/org/edit", modelMap);
	}

	@RequestMapping("save")
	public ModelAndView save(HttpServletRequest request, ModelMap modelMap) {

		try {
			String name = request.getParameter("name");
			String code = request.getParameter("code");
			String id = request.getParameter("id");
			String parentId = request.getParameter("parentId");
			String type = request.getParameter("type");
			Depart depart = new Depart();
			depart.setCode(code);
			depart.setName(name);
			depart.setType(Integer.parseInt(type));
			depart.setParentId(parentId);
			if (parentId == null) {
				depart.setLevel(0);
			}
			depart.setId(id);
			String saveUrl = this.wiredFile(request);
			depart.setImg(saveUrl);
			this.orgService.save(depart);
			modelMap.put("mess", "保存数据成功。");
		} catch (Exception ex) {
			ex.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("mess", ex.getMessage());
			return new ModelAndView("gov/org/index", modelMap);
		}
		return new ModelAndView("gov/org/index", modelMap);
	}

	@RequestMapping("treeInfo")
	@ResponseBody
	public List<BasicTree> menuTree(String departId, ModelMap modelMap) {
		List<Depart> departs = this.orgService.getDeparts(departId);
		List<BasicTree> basicTrees = new ArrayList<BasicTree>();
		List<BasicTree> toDel = new ArrayList<BasicTree>();
		for (int i = 0; i < departs.size(); i++) {
			Depart depart = departs.get(i);
			List<Depart> childs = this.getChilds(depart, departs);
			BasicTree tree = new BasicTree();
			tree.setId(depart.getId());
			tree.setText(depart.getName());
			tree.setSelected(false);
			basicTrees.add(tree);
			List<BasicTree> allChilds = new ArrayList<BasicTree>();
			for (int j = 0; j < childs.size(); j++) {
				Depart departj = childs.get(j);
				BasicTree treei = new BasicTree();
				treei.setId(departj.getId());
				treei.setText(departj.getName());
				treei.setSelected(false);
				allChilds.add(treei);
			}
			tree.setChildren(allChilds);
			toDel.addAll(allChilds);
		}
		List<BasicTree> delEle = new ArrayList<BasicTree>();
		for (int i = 0; i < toDel.size(); i++) {
			BasicTree treei = toDel.get(i);
			for (int j = 0; j < basicTrees.size(); j++) {
				if (treei.getId().equalsIgnoreCase(basicTrees.get(j).getId())) {
					delEle.add(basicTrees.get(j));
				}
			}
		}
		for (int i = 0; i < delEle.size(); i++) {
			basicTrees.remove(delEle.get(i));
		}
		return basicTrees;

	}

	private List<Depart> getChilds(Depart depart, List<Depart> departs) {
		List<Depart> childs = new ArrayList<Depart>();
		for (int i = 0; i < departs.size(); i++) {
			Depart departi = departs.get(i);
			if (depart.getId().equalsIgnoreCase(departi.getParentId())) {
				childs.add(departi);
			}

		}
		return childs;
	}

}
