package ru.sbrf.emoAuth.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "view_on",
            joinColumns = @JoinColumn(name="view_id"),
            inverseJoinColumns = @JoinColumn(name="component_id"))
    private Set<Component> onComponents;




//
//    public void addOnComponent(Component component) {
//        onComponents.add(component);
//        component.getOnViews().add(this);
//    }
//
//    public void removeOnComponent(Component component) {
//        onComponents.remove(component);
//        component.getOnViews().remove(this);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof View)) return false;
        return id != null && id.equals(((View) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
