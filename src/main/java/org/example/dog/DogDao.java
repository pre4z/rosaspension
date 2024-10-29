package org.example.dog;

public interface DogDao {
    void getDog(int id) throws Exception;
    void getAllDogs() throws Exception;
    void createDog(Dog dog) throws Exception;
}
