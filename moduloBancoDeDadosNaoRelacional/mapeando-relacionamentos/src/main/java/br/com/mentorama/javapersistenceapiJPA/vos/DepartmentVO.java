package br.com.mentorama.javapersistenceapiJPA.vos;
/*DepartamentDTO  data transfer object*/
public class DepartmentVO {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentVO() {
          }
}
