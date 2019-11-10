import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC690_EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> eMap = new HashMap<>();
        for(Employee e: employees) {
            eMap.put(e.id, e);
        }

        return getImportance(eMap, id);
    }

    private int getImportance(Map<Integer, Employee> eMap, int id) {
        Employee cur = eMap.get(id);
        int imp = cur.importance;
        for(int eid: cur.subordinates) {
            imp += getImportance(eMap, eid);
        }

        return imp;
    }
}
