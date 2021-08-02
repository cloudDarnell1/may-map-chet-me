package thaovan.lab8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Students", schema = "dbo", catalog = "J6Store")
public class StudentsEntity {

    @Id
    private String email;
    private String fullname;
    private double marks;
    private boolean gender;
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsEntity that = (StudentsEntity) o;

        if (Double.compare(that.marks, marks) != 0) return false;
        if (gender != that.gender) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fullname != null ? !fullname.equals(that.fullname) : that.fullname != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = email != null ? email.hashCode() : 0;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        temp = Double.doubleToLongBits(marks);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (gender ? 1 : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
