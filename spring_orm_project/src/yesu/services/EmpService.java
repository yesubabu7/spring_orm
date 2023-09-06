package yesu.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import yesu.daos.EmpDAO;
import yesu.model.Employee;

@Component
public class EmpService {

	private EmpDAO edao;

	@Autowired
	public EmpService(EmpDAO empdao) {
		edao = empdao;
	}

	@Transactional
	public void add(Employee emp) {
		edao.persist(emp);
	}

	@Transactional
	public void addAll(Collection<Employee> empList) {
		for (Employee emp : empList) {
			edao.persist(emp);
		}
	}

	@Transactional(readOnly = true)
	public List<Employee> listAll() {
		return edao.getAllEmployees();

	}

}
