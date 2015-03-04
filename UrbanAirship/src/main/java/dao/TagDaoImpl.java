package dao;

import java.util.List;

import model.DeviceList;
import model.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@SuppressWarnings("deprecation")
@Repository("tagDao")
public class TagDaoImpl implements TagDao {
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
 
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	@SuppressWarnings("unchecked")
	public List<DeviceList> selectDeviceList(Target target) {
		return sqlMapClientTemplate.queryForList("tag.selectDeviceList", target);
	}

	@SuppressWarnings("unchecked")
	public List<Target> selectCamp() {
		return sqlMapClientTemplate.queryForList("tag.selectCamp", "");
	}


}