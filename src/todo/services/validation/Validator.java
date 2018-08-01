package todo.services.validation;

public interface Validator<T> {
	
	public boolean validateBeforeCreate(T object);
	public boolean validateBeforeUpdate(T object);
	public boolean validateBeforeRemove(int id);
	
}
