package mdalcode;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity //for Hibernate
@Table
public class Customer {
	@Id
	@SequenceGenerator(
			name = "customer_sequence",
			sequenceName = "customer_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "customer_sequence"
			)
	
    private Long id;
    private String name;
    private String email;
    private String complaint;
    private int totalAmount;
    private int paidAmount;
    private LocalDate dob;
    @Transient
    private int age;

    public Customer() {
        // Default no-args constructor required by JPA
    }

    public Customer(long id, String name, String email, String complaint, int totalAmount, int paidAmount, LocalDate dob) {
    	this.id = id;
        this.name = name;
        this.email = email;
        this.complaint = complaint;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.dob = dob;
    }

    // Getter methods
    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    public String getComplaint() 
    {
    	return complaint;
    }
    public void setComplaint(String complaint) 
    {
    	this.complaint = complaint;
    }
    public int getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
    public int getPaidAmount() {
        return paidAmount;
    }
    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }
    
    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
    
    public void setdob(LocalDate dob) 
    {
    	this.dob = dob;
    }
    // Setter methods (if needed)

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email);
    }
}