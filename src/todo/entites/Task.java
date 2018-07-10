package todo.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "id_list")
	private int idList;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = List.class)
	@JoinColumn(name = "id_list", insertable = false, updatable = false)
	private List list;
	
	public Task() { }

	public int getId() {
		return id;
	}

	public int getIdList() {
		return idList;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public List getList() {
		return list;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdList(int idList) {
		this.idList = idList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setList(List list) {
		this.list = list;
	}
	
}
