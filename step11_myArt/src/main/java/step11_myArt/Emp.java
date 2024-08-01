package step11_myArt;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Getter
@Setter
@ToString
@Entity
public class Emp {
	
	@Id
	@Column(name="EMPNO")
	private Long EMPNO;
	
	@NonNull
	@Column(name="ENAME", length=20)
	private String ENAME;
	
	@NonNull
	@Column(name="JOB", length=20)
	private String JOB;
	
	@NonNull
	@Column(name="MGR", length = 20)
	private Long MGR;
	
	@NonNull
	@Column(name="HIREDATE")
	private Date HIREDATE;
	
	@NonNull
	@Column(name="SAL")
	private Long SAL;
	
	@NonNull
	@Column(name="COMM")
	private Long COMM;
	
	@NonNull
	@OneToOne
	@JoinColumn(name="DEPTNO")
	private Dept DEPTNO;
}
