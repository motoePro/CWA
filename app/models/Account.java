package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
@PersistenceUnit(name = "default")
@Table(name = "accounts")
public class Account extends Model{
	@Id
	public Long Id;
	@Constraints.Required
	public String username;
	@Constraints.Required
	public String password;
	
	
	public static Finder<Long, Account> find = new Finder<Long, Account>(Long.class, Account.class);
}
