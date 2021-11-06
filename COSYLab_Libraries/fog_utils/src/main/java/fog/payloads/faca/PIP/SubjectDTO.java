package fog.payloads.faca.PIP;

import fog.faca.utils.FACAProjectConstants;
import fog.faca.utils.JSONUtilFunctions;
import fog.faca.enums.ATTRIBUTE;
import fog.faca.utils.Profession;
import fog.faca.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDTO {

	private String id;
	private String userName;

	private String password;
	private String name;
	private Role role;

	private Date birthdate;
	
	private List<String> handicaps;
	private List<Profession> professions;

    private String userProxyId;

	private boolean isActive;

	private int passwordFails;

	public SubjectDTO(String userName, String password, String name, Date birthdate, String userProxyId) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.birthdate = birthdate;
		this.handicaps = new ArrayList<>();
		this.professions = new ArrayList<>();
        this.role = new Role(FACAProjectConstants.Role.UNDEFINED);
		this.isActive = false;
		this.passwordFails = 0;
        this.userProxyId = userProxyId;
	}

	public boolean addHandicap(String handicap) {
		handicaps.add(handicap);
		return true;
	}
	
	public boolean removeHandicap(String handicap) {
		handicaps.remove(handicap);
		return true;
	}
	
	public boolean addProfession(String organisation, String position) {
		Profession professionToAdd = new Profession(organisation, position);
		if (professions.contains(professionToAdd)) {
			return false;
		}
		professions.add(professionToAdd);
		return true;
	}
	
	public boolean removeProfession(String organisation, String position) {
		for (int i = 0; i < professions.size(); i++) {
			Profession profession = professions.get(i);
			if(profession.getOrganization().equals(organisation) && profession.getPosition().equals(position)) {
				professions.remove(i);
				break;
			}
		}
		return true;
	}
	
	public boolean hasProfession(Profession proffessionToCheck) {
		for (Profession profession : professions) {
			if (profession.equals(proffessionToCheck)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPosition(String position) {
		for (Profession profession : professions) {
			if (profession.getPosition().equals(position)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean worksFor(String organization) {
		for (Profession profession : professions) {
			if (profession.getOrganization().equals(organization)) {
				return true;
			}
		}
		return false;
	}

    public boolean userIsOwner() {
        if (this.role.getRoleName().toString().toLowerCase().equals(FACAProjectConstants.Role.OWNER.toString())) {
				return true;
			}

		return false;
	}

    public boolean hasRole(FACAProjectConstants.Role[] roles) {
		return Arrays.asList(roles).contains(this.role.getRoleName());
	}

	public HashMap<String, String> toMap() {
		HashMap<String, String> map = new HashMap<String, String>();

		String[] positions = new String[professions.size()];
		String[] organizations = new String[professions.size()];

		LocalDate today = LocalDate.now();

        map.put(ATTRIBUTE.AGE.toString(), String.valueOf(Period.between(today.minusDays((new Date().getTime() - birthdate.getTime()) / 1000 / 60 / 60 / 24), today).getYears()));

        map.put(ATTRIBUTE.HANDICAP.toString(), JSONUtilFunctions.convertListStringToJSON(handicaps));

		for (int i = 0; i < professions.size(); i++) {
			positions[i] = professions.get(i).getPosition();
			organizations[i] = professions.get(i).getOrganization();
		}
        map.put(ATTRIBUTE.ORGANIZATION.toString(), JSONUtilFunctions.convertListStringToJSON(Arrays.asList(organizations)));
        map.put(ATTRIBUTE.POSITION.toString(), JSONUtilFunctions.convertListStringToJSON(Arrays.asList(positions)));

        map.put(ATTRIBUTE.ROLE.toString(), String.valueOf(this.getRole().getRoleName()));
        map.put(ATTRIBUTE.USERNAME.toString(), userName);
        map.put(FACAProjectConstants.USER_PROXY_ID, this.userProxyId);

		return map;
	}

}
