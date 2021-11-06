package fog.faca.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {

	private FACAProjectConstants.Role roleName;
	
	private Date startDate;
	private Date endDate;


	public Role(FACAProjectConstants.Role roleName) {
		this.roleName = roleName;
	}

}
