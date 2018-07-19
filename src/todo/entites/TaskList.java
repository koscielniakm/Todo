package todo.entites;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tasklist")
public class TaskList implements DbEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "list", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Task> tasks;
	
	public TaskList() { }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}
