package ibatis.config;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * @class : SqlMapConfig.java
 * @title : 
 * @author : Yoon
 * @desciption : SQLMapConfig ����
 */
public class SqlMapConfig {
	
	private static final SqlMapClient sqlMap; 
	
	static{
		
		try {
			//SqlMapConfig.xml �� �о�鿩�� sqlMap �� �����.
			String resource = "ibatis/config/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error sqlMap �ʱ�ȭ ����");
		}
	}
	
	public static SqlMapClient getSqlMapInstance(){
		return sqlMap;
	}

}
