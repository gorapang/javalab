package step02.onetoonejoin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

@Getter
@Setter
@ToString

// 해당 entity에 적용되는 sequence를 생성 및 적용 의미
@SequenceGenerator(name = "team_seq", sequenceName = "team_seq_id",
				   initialValue = 1, allocationSize = 50)
//@Entity
public class Team2 {

	//strategy = GenerationType.SEQUENCE : oracle seq
	//strategy = GenerationType.IDENTITY : mysql auto increment
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
	@Column(name = "team_id")
	private long teamId;
	
	@NonNull
	@Column(name="team_name", length = 20)
	private String teamName;
	
}
