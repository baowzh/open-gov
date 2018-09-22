package com.asiainfo.portal.modules.depart.service.defaults;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.eframe.util.StringUtil;
import com.asiainfo.eframe.util.UUIDGenerator;
import com.asiainfo.portal.modules.depart.model.Depart;
import com.asiainfo.portal.modules.depart.repository.DepartRepository;
import com.asiainfo.portal.modules.depart.service.OrgService;

@Service("orgService")
public class DefaultOrgService implements OrgService {
	@Autowired
	private DepartRepository departRepository;

	@Override
	public void save(Depart depart) throws Exception {
		if (StringUtil.isEmpty(depart.getId())) {
			depart.setId(UUIDGenerator.generate());
			departRepository.insert(depart);
		} else {
			departRepository.update(depart);
		}
	}

	@Override
	public List<Depart> getDeparts(String departid) {

		return this.departRepository.list(departid);
	}

	@Override
	public List<Depart> getDeparts(Integer type) {

		return this.departRepository.getDeparts(type);
	}

	@Override
	public Depart getDepart(String departId) {
		
		return this.departRepository.get(departId);
	}

	@Override
	public void del(String departId) {
		this.departRepository.del(departId);
		
	}

}
