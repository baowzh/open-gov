package com.asiainfo.portal.view.modules.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asiainfo.ewebframe.ui.form.model.SelectResult;
import com.asiainfo.portal.modules.ui.Select;

@Controller
@RequestMapping(value = "ui")
public class UIController {
	@Autowired
	private Select select;

	@ResponseBody
	@RequestMapping("categorys")
	public List<SelectResult> getCategorys() {
		return select.getCategorys();
	}

	@ResponseBody
	@RequestMapping("subcategorys")
	public List<SelectResult> getSubCategorys(Integer catId) {
		return select.getSubCategorys(catId);
	}

	public List<SelectResult> getTowns() {
		return null;
	}

	public List<SelectResult> gethamlets(String townId) {
		return null;
	}

	public List<SelectResult> getDeparts() {
		return null;
	}
}
