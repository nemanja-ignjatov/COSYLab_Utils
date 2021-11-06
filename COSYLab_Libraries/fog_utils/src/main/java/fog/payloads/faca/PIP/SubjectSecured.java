package fog.payloads.faca.PIP;

import fog.faca.utils.Profession;
import fog.faca.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectSecured {

    private String id;
    private String userName;
    private String name;
    private Date birthdate;

    private List<String> handicaps;
    private List<Profession> professions;

    private Role role;
    private boolean isActive;

    public SubjectSecured(SubjectDTO subjectDTO) {
        this.id = subjectDTO.getId();
        this.userName = subjectDTO.getUserName();
        this.name = subjectDTO.getName();
        this.birthdate = subjectDTO.getBirthdate();
        this.handicaps = subjectDTO.getHandicaps();
        this.professions = subjectDTO.getProfessions();
        this.isActive = subjectDTO.isActive();
        this.role = subjectDTO.getRole();
    }
}
