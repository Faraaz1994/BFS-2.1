//https://leetcode.com/problems/employee-importance/
//Time complexity : O(N)
//Spaces complexity : O(N)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int result = 0;
        
        for(Employee e : employees)
            map.put(e.id,e);
        
        q.add(id);
        while(!q.isEmpty()){
            int boss = q.poll();
            Employee e = map.get(boss);
            result += e.importance;
            for(int subOrdinate : e.subordinates){
                q.add(subOrdinate);
            }
        }
        return result;
    }
}