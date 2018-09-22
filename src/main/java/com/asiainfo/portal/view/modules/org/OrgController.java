package com.asiainfo.portal.view.modules.org;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.asiainfo.ewebframe.config.WebSysConfig;
import com.asiainfo.ewebframe.ui.form.model.SelectResult;
import com.asiainfo.portal.modules.depart.model.Depart;
import com.asiainfo.portal.modules.depart.service.OrgService;
import com.asiainfo.portal.view.modules.system.bean.BasicTree;

@Controller
@RequestMapping(value = "org")
public class OrgController {
	@Autowired
	private OrgService orgService;
	@Autowired
	private WebSysConfig config;
	@Value("${file.maxSize}")
	private Integer maxSize;

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
		if (depart.getType() == 3) {
			List<Depart> departs = orgService.getDeparts(2);
			for (int i = 0; i < departs.size(); i++) {
				Depart departi = departs.get(i);
				SelectResult result = new SelectResult();
				result.setId(departi.getId());
				result.setText(departi.getName());
				results.add(result);
			}

		}
		if (depart.getParentId() != null) {
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
			Depart depart = new Depart();
			depart.setCode(code);
			depart.setName(name);
			depart.setParentId(parentId);
			if (parentId == null) {
				depart.setLevel(0);
			}
			depart.setId(id);
			if (!ServletFileUpload.isMultipartContent(request)) {
				modelMap.put("success", false);
				modelMap.put("mess", "上传文件大小超过限制。");
				return new ModelAndView("gov/org/edit", modelMap);

			}
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> filenames = multipartRequest.getFileNames();
			MultipartFile file = null;
			while (filenames.hasNext()) {
				String filename = filenames.next();
				List<MultipartFile> fileList = multipartRequest.getFiles(filename);
				file = fileList.get(0);
			}

			if (file.getSize() > maxSize) {

				modelMap.put("success", false);
				modelMap.put("mess", "上传文件大小超过限制。");
				return new ModelAndView("gov/org/edit", modelMap);

			}
			String separator = File.separator;
			String savePath = request.getSession().getServletContext().getRealPath(separator);
			if (!savePath.endsWith(separator)) {
				savePath = savePath + separator;
			}
			savePath = savePath + "attached" + separator;
			// 定义允许上传的文件扩展名
			Map<String, String> extMap = new HashMap<String, String>();
			extMap.put("image", config.getFileimage());
			extMap.put("flash", config.getFileflash());
			extMap.put("media", config.getFilemedia());
			extMap.put("file", config.getFilefile());
			String saveUrl = "/" + "attached" + "/";
			File saveDirFile = new File(savePath);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String ymd = sdf.format(new Date());
			savePath += ymd + separator;
			saveUrl += ymd + "/";
			File dirFile = new File(savePath);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			//
			// 附件要上传到的目录
			extMap.put("attached", config.getFileattached());

			String fileName = file.getOriginalFilename();
			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
			if (!Arrays.<String> asList(extMap.get("image").split(",")).contains(fileExt)) {
				// return getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName)
				// + "格式。");
				modelMap.put("success", false);
				modelMap.put("mess", "上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get("image") + "格式。");
				return new ModelAndView("gov/org/edit", modelMap);

			}
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
			try {
				File uploadedFile = new File(savePath, newFileName);
				OutputStream stram = new FileOutputStream(uploadedFile);
				stram.write(file.getBytes());
				stram.close();
				saveUrl = saveUrl + "/" + newFileName;

			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("mess", "上传文件失败。");
				return new ModelAndView("gov/org/edit", modelMap);

			}
			depart.setImg(saveUrl);
			this.orgService.save(depart);
		} catch (Exception ex) {
			ex.printStackTrace();
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
