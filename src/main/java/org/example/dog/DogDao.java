package org.example.dog;

public interface DogDao {
    void getDog(int dogID) throws Exception;
    void getAllDogs() throws Exception;
    void createDog(Dog dog) throws Exception;
    void updateDog(Dog dog) throws Exception;
    void deleteDog(int dogID) throws Exception;
}
