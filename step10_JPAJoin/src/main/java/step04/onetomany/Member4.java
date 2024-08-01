package step04.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

@SequenceGenerator(name = "member4_seq", sequenceName = "member4_seq_id", 
				   allocationSize = 50, initialValue = 1)

@Table(name = "ce_member") //실제 생성되는 table 이름
@Entity
public class Member4 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member4_seq") 
	@Column(name="member_id")
	private long memberId;
	
	@NonNull
	@Column(length = 20, nullable = false)
	private String name;
	
	@NonNull
	//@ManyToOne //member 하나는 하나의 팀에 소속 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="team_id") //Team4의 pk 변수에 선언된 매핑된 테이블 컬럼명, fk 설정
	private Team4 teamId;
	
}
